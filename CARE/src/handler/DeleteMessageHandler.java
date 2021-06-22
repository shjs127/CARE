package handler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.DeleteMessageService;
import auth.service.GetMessageListViewService;
import auth.service.Message;
import auth.service.MessageData;
import auth.service.MessageNotFoundException;
import auth.service.MessageRequest;
import auth.service.PermissionDeniedException;
import auth.service.User;
import auth.service.WriteMessageService;
import mvc.command.CommandHandler;

public class DeleteMessageHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/view/guestbook/deleteMessage.jsp";

	private WriteMessageService writeMessageService = new WriteMessageService();
	private Message message = new Message();
	private GetMessageListViewService getMessageListViewService = new GetMessageListViewService();
	private DeleteMessageService deleteService = new DeleteMessageService();

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
			
			int reviewNo= Integer.parseInt(noVal);
			MessageData messageData = getMessageListViewService.getMessageListView();
			User authUser = (User) req.getSession().getAttribute("authUser");
			if (!canMessage(authUser, messageData)) {
				res.sendError(HttpServletResponse.SC_FORBIDDEN);
				return null;
			}
			MessageRequest msgReq = new MessageRequest(authUser.getUserId(), authUser.getUserNo(), reviewNo,
					messageData.getMessage(),
					messageData.getContent());

			req.setAttribute("msgReq", msgReq);
			return FORM_VIEW;
		} catch (MessageNotFoundException e) {
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}

	private boolean canMessage(User authUser, MessageData messageData) {
		int userNo = messageData.getMessage().getUserNo();
		return authUser.getUserNo() == userNo;
	}


	private String processSubmit(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		User authUser = (User) req.getSession().getAttribute("authUser");
		String noVal = req.getParameter("reviewNo");
		int boardNo = Integer.parseInt(noVal);

		MessageRequest msgReq = new MessageRequest(authUser.getUserId(), authUser.getUserNo(), storeNo,
				req.getParameter("reviewContents"));
		req.setAttribute("msgReq", msgReq);

		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		msgReq.validate(errors);
		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}
		try {
			deleteService.delete(msgReq);
			return "/WEB-INF/view/board/success.jsp";
		} catch (MessageNotFoundException e) {
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		} catch (PermissionDeniedException e) {
			res.sendError(HttpServletResponse.SC_FORBIDDEN);
			return null;
		}
	}
}
