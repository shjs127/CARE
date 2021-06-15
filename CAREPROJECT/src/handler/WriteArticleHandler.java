package handler;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.User;
import member.model.WriteRequest;
import member.model.Writer;
import member.service.WriteArticleService;
import mvc.command.CommandHandler;

public class WriteArticleHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/view/board/write.jsp";
	private WriteArticleService writeService = new WriteArticleService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
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
	
	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);

		User user = (User)req.getSession(false).getAttribute("authUser");
		WriteRequest writeReq = createWriteRequest(user, req);
		writeReq.validate(errors);
		
		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}
		
		int newArticleNo = writeService.write(writeReq);
		req.setAttribute("newArticleNo", newArticleNo);
		
		return "/WEB-INF/view/board/newArticleSuccess.jsp";
	}

	private WriteRequest createWriteRequest(User user, HttpServletRequest req) {
		return new WriteRequest(
				new Writer(user.getId(),user.getName()),
				req.getParameter("boardTitle"),
				req.getParameter("boardContents"));
	}
}
