package handler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import auth.service.ArticleData;
import auth.service.ArticleNotFoundException;
import auth.service.ModifyArticleService;
import auth.service.ModifyRequest;
import auth.service.PermissionDeniedException;
import auth.service.ReadArticleService;
import auth.service.User;
import member.model.BoardInfoList;
import member.model.BoardPicInfo;
import mvc.command.CommandHandler;

public class ModifyArticleHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/view/board/modifyForm.jsp";

	private ReadArticleService readService = new ReadArticleService();
	private ModifyArticleService modifyService = new ModifyArticleService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) throws IOException {
		try {
			String noVal = req.getParameter("boardNo");
			BoardInfoList boardInfoList = readService.view(Integer.parseInt(noVal));
			req.setAttribute("boardInfoList", boardInfoList);
			int boardNo = Integer.parseInt(noVal);
			ArticleData articleData = readService.getArticle(boardNo, false);
			User authUser = (User) req.getSession().getAttribute("authUser");
			if (!canModify(authUser, articleData)) {
				res.sendError(HttpServletResponse.SC_FORBIDDEN);
				return null;
			}
			ModifyRequest modReq = new ModifyRequest(authUser.getUserId(), authUser.getUserNo(), boardNo,
					articleData.getBoardInfo().getBoardTitle(), articleData.getContent());

			req.setAttribute("modReq", modReq);
			return FORM_VIEW;
		} catch (ArticleNotFoundException e) {
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}

	private boolean canModify(User authUser, ArticleData articleData) {
		int userNo = articleData.getBoardInfo().getUserNo();
		return authUser.getUserNo() == userNo;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String uploadPath = req.getRealPath("upload");
		int size = 10 * 1024 * 1024; // 10MB, 筌ㅼ뮆占� 2GB
		MultipartRequest multi = new MultipartRequest(req, uploadPath, size, "utf-8", new DefaultFileRenamePolicy());
		Enumeration files = multi.getFileNames();
		BoardPicInfo boardPicInfo = null;
		List<BoardPicInfo> boardPicInfoList = new ArrayList<BoardPicInfo>();
		String file, filename, origfilename;

		for (int i = 1; i < 2; i++) {
			file = (String) files.nextElement();
			filename = multi.getFilesystemName(file);
			origfilename = multi.getOriginalFileName(file);

			if (filename == null) {
				continue;
			}

			boardPicInfo = new BoardPicInfo(filename);
			boardPicInfoList.add(boardPicInfo);
		}
		User authUser = (User) req.getSession().getAttribute("authUser");
		String noVal = multi.getParameter("boardNo");
		int boardNo = Integer.parseInt(noVal);
		ModifyRequest modReq = new ModifyRequest(authUser.getUserId(), authUser.getUserNo(), boardNo,
				multi.getParameter("boardTitle"), multi.getParameter("boardContents"), boardPicInfoList);
		req.setAttribute("modReq", modReq);
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		modReq.validate(errors);
		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}
		try {
			modifyService.modify(modReq);
			return "/WEB-INF/view/board/success.jsp";
		} catch (ArticleNotFoundException e) {
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		} catch (PermissionDeniedException e) {
			res.sendError(HttpServletResponse.SC_FORBIDDEN);
			return null;
		}
	}
}
