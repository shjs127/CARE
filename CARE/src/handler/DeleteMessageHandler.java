package handler;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.DeleteMessageService;
import auth.service.GetMessageListViewService;
import auth.service.Message;
import auth.service.MessageNotFoundException;
import auth.service.MessageRequest;
import auth.service.PermissionDeniedException;
import auth.service.User;
import auth.service.WriteMessageService;
import member.model.ReviewInfo;
import mvc.command.CommandHandler;

public class DeleteMessageHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/view/guestbook/deleteMessage.jsp";

	private WriteMessageService writeMessageService = new WriteMessageService();
	private Message message = new Message();
	private GetMessageListViewService getMessageListViewService = GetMessageListViewService.getInstance();
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
			System.out.println("reviewNo="+noVal);
			
			int reviewNo= Integer.parseInt(noVal);
			ReviewInfo getReviewInfo1 = (ReviewInfo) req.getSession().getAttribute("reviewInfo");
			User authUser = (User) req.getSession().getAttribute("authUser");
			if (!canMessage(reviewNo, getReviewInfo1)) {
				res.sendError(HttpServletResponse.SC_FORBIDDEN);
				return null;
			}
			MessageRequest msgReq = new MessageRequest(getReviewInfo1.getReviewNo(),authUser.getUserNo(), getReviewInfo1.getStoreNo(),getReviewInfo1.getAvgScore(), getReviewInfo1.getReviewContents(), getReviewInfo1.getReviewDate());

			req.setAttribute("msgReq", msgReq);
			return FORM_VIEW;
		} catch (MessageNotFoundException e) {
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}

	private boolean canMessage(int reviewNo, ReviewInfo reviewInfo) {
		int s = reviewInfo.getReviewNo();
		return s == reviewNo;
	}


	private String processSubmit(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		User authUser = (User) req.getSession().getAttribute("authUser");
		//ReviewInfo reviewInfo = (ReviewInfo) req.getSession().getAttribute("reviewinfo"); 
		
		String noVal = req.getParameter("reviewNo");
		System.out.println("reviewNo="+noVal);
		
		int reviewNo = Integer.parseInt(noVal);

		//MessageRequest msgReq = new MessageRequest( reviewInfo.getReviewNo(),authUser.getUserNo(),reviewInfo.getStoreNo(), reviewInfo.getAvgScore(), reviewInfo.getReviewContents(), reviewInfo.getReviewDate());
		//req.setAttribute("msgReq", msgReq);

		/*
		 * Map<String, Boolean> errors = new HashMap<>(); req.setAttribute("errors",
		 * errors); msgReq.validate(errors); if (!errors.isEmpty()) { return FORM_VIEW;
		 * }
		 */
		
		try {
			deleteService.delete(reviewNo);
			return "/WEB-INF/view/main/reviewSuccess.jsp";
		} catch (MessageNotFoundException e) {
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		} catch (PermissionDeniedException e) {
			res.sendError(HttpServletResponse.SC_FORBIDDEN);
			return null;
		}
	}
}
