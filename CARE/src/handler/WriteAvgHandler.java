package handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.LoginFailException;
import auth.service.Message;
import auth.service.WriteAvgService;
import mvc.command.CommandHandler;

public class WriteAvgHandler implements CommandHandler {

	private static final String FORM_VIEW = "/WEB-INF/view/main/food-details.jsp";

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			System.out.println("WriteAvgHandler GET �떎�뻾...");
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			System.out.println("WriteAvgHandler POST �떎�뻾...");
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

		try {
			Message message = new Message();

			message.setReviewContents(req.getParameter("avgScore"));
			System.out.println("message.avgScore=" + message.getAvgScore());

			WriteAvgService writeAvgService = WriteAvgService.getInstance();
			int writeResult = writeAvgService.writeAvg(message);

			req.getSession().setAttribute("view", writeResult);

			return FORM_VIEW;
		} catch (LoginFailException e) {
			return FORM_VIEW;
		}
	}

}
