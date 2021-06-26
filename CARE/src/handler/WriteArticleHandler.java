package handler;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import auth.service.User;
import auth.service.WriteArticleService;
import auth.service.WriteRequest;
import member.model.BoardPicInfo;
import member.model.Writer;
import mvc.command.CommandHandler;

public class WriteArticleHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/view/board/write.jsp";
	private WriteArticleService writeService = new WriteArticleService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws IOException {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws IOException {
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);

		User user = (User) req.getSession(false).getAttribute("authUser");

		WriteRequest writeReq = createWriteRequest(user, req);

		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}

		Integer boardNo = writeService.write(writeReq, user);

		writeReq.setBoardNo(boardNo);
		writeService.upload(writeReq);

		req.setAttribute("newArticleNo", boardNo);

		return "/WEB-INF/view/board/success.jsp";
	}

	private WriteRequest createWriteRequest(User user, HttpServletRequest req) throws IOException {
		String uploadPath = req.getRealPath("upload");
		int size = 10 * 1024 * 1024; // 10MB, 筌ㅼ뮆占� 2GB

		BoardPicInfo boardPicInfo = null;
		List<BoardPicInfo> boardPicInfoList = new ArrayList<BoardPicInfo>();

		MultipartRequest multi = new MultipartRequest(req, uploadPath, size, "utf-8", new DefaultFileRenamePolicy());


		Enumeration files = multi.getFileNames();

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
		return new WriteRequest(new Writer(user.getUserId(), user.getNickName()), multi.getParameter("boardTitle"),
				multi.getParameter("boardContents"), boardPicInfoList);
	}
}
