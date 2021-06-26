package handler;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.LoginFailException;
import auth.service.Message;
import auth.service.StoreInfoService;
import auth.service.User;
import auth.service.WriteMessageService;
import member.model.StoreInfo;
import member.model.UserInfo;
import mvc.command.CommandHandler;

public class WriteMessageHandler implements CommandHandler {

	private static final String FORM_VIEW = "/WEB-INF/view/main/food-details.jsp";
	private StoreInfoService storeinfoService = new StoreInfoService();
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) {

			System.out.println("WriteMessageHandler GET");
			return processForm(req, res);

		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			System.out.println("WriteMessageHandler POST");
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Message message = new Message();
		User user = (User) req.getSession().getAttribute("authUser");
		
		String reviewC=req.getParameter("reviewContents");
		message.setReviewContents(req.getParameter("reviewContents"));
		double avgScore = Double.parseDouble(req.getParameter("avgScore"));
		message.setAvgScore(avgScore);
		String storeNo = req.getParameter("storeNo");
		int storeNoLog = Integer.parseInt(storeNo);
		
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		
		if ((reviewC) == null || reviewC.isEmpty())
			errors.put("id", Boolean.TRUE);
		
		System.out.println("message.reveiewContents=" + message.getReviewContents());
		System.out.println("message.AvgScore=" + message.getAvgScore());
		System.out.println("storeNo="+storeNo);
		


		try {

			WriteMessageService writeService = WriteMessageService.getInstance();
			 writeService.writeMessage(message,user.getUserNo(),storeNoLog);
			
			res.sendRedirect("foodDetail.do?storeno="+storeNo);
			return null;
		} catch (LoginFailException e) {
			return FORM_VIEW;

		}
	}

}
