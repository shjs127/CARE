package handler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.ArticleData;
import auth.service.ArticleNotFoundException;
import auth.service.MessageData;
import auth.service.MessageRequest;
import auth.service.ModifyMessageService;
import auth.service.ModifyRequest;
import auth.service.PermissionDeniedException;
import auth.service.User;
import mvc.command.CommandHandler;

public class ModifyMessageHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/view/guest/modifyForm.jsp";

	private ModifyMessageService messageService = new ModifyMessageService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res)
			throws IOException {
		try {
			String noVal = req.getParameter("reviewNo");
			int reviewNo = Integer.parseInt(noVal);
			MessageData messageData = (reviewNo, false);
			User authUser = (User) req.getSession().getAttribute("authUser");
			if (!canMessage(authUser, messageData)) {
				res.sendError(HttpServletResponse.SC_FORBIDDEN);
				return null;
			}
			MessageRequest msgReq = new MessageRequest(authUser.getUserId(), authUser.getUserNo(), reviewNo,
					null, messageData.getContent());

			req.setAttribute("msgReq", msgReq);
			return FORM_VIEW;
		} catch (ArticleNotFoundException e) {
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}

	private boolean canMessage(User authUser, MessageData messageData) {
		int userNo = MessageData.getReviewInfo().getUserNo();
		return authUser.getUserNo() == userNo;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		User authUser = (User) req.getSession().getAttribute("authUser");
		String noVal = req.getParameter("reviewNo");
		int reviewNo = Integer.parseInt(noVal);
		ModifyRequest modReq = new ModifyRequest(authUser.getUserId(), authUser.getUserNo(), reviewNo,
				req.getParameter("reviewContents"), noVal);
		req.setAttribute("msgReq", msgReq);
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		modReq.validate(errors);
		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}
		try {
			messageService.modify(msgReq);
			return "/WEB-INF/view/guestbook/success.jsp";
		} catch (MessageNotFoundException e) {
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		} catch (PermissionDeniedException e) {
			res.sendError(HttpServletResponse.SC_FORBIDDEN);
			return null;
		}
	}
}
