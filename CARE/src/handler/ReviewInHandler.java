package handler;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.GetMessageListViewService;
import auth.service.LoginFailException;
import auth.service.Message;
import auth.service.MessageListView;
import auth.service.ReviewInfoService;
import member.model.ReviewInfo;
import mvc.command.CommandHandler;

public class ReviewInHandler implements CommandHandler {

	private static final String FORM_VIEW = "/WEB-INF/view/main/food-details.jsp";
	private ReviewInfoService reviewInfoService = new ReviewInfoService();

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

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
		
		try {
			int storeNo = 1;
			
			ReviewInfo reviewInfo = reviewInfoService.reviewInfo(storeNo);
			req.getSession().setAttribute("reviewInfo", reviewInfo);
			/*
			 * Message message = message.avgScore(storeNo);
			 */
			//System.out.println("avgScore: "+reviewInfo.getAvgScore());
			
		
			
			GetMessageListViewService viewService = GetMessageListViewService.getInstance();
			String pageStr = req.getParameter("page");
			int pageNum = pageStr == null ? 1 : Integer.parseInt(pageStr);
			MessageListView view = viewService.getMessageListView(pageNum);
			
			req.getSession().setAttribute("view", view);

			return FORM_VIEW;
		} catch (LoginFailException e) {
			return FORM_VIEW;
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) throws Exception {

		try {
			
			return FORM_VIEW;
		} catch (LoginFailException e) {
			return FORM_VIEW;
		}
	}

}
