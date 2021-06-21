package handler;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*import org.omg.CORBA.ORB;*/

import auth.service.ChangePasswordService;
import auth.service.InvalidPasswordException;
import auth.service.MemberNotFoundException;
import auth.service.User;
import mvc.command.CommandHandler;


public class ChangePasswordHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WebContent/CARE/changePwdForm.jsp";
	private ChangePasswordService changePwdSvc = new ChangePasswordService();
	
	public String process(HttpServletRequest req, HttpServletResponse res) 
	throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}


	private String processSubmit(HttpServletRequest req, HttpServletResponse res)
	throws Exception {
		User user = (User)req.getSession().getAttribute("authUser");
			
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);

		String curPwd = req.getParameter("curPwd");
		String newPwd = req.getParameter("newPwd");
		
		if (curPwd == null || curPwd.isEmpty()) {
			errors.put("curPwd", Boolean.TRUE);
		}
		if (curPwd == null || curPwd.isEmpty()) {
			errors.put("newPwd", Boolean.TRUE);
		}
		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}
		
		try {
			changePwdSvc.changePassword(user.getUserId(), curPwd, newPwd, newPwd, newPwd, newPwd, newPwd);
			return "/WebContent/CARE/changePwdSuccess.jsp";
		} catch (InvalidPasswordException e) {
			errors.put("badCurPwd", Boolean.TRUE);
			return FORM_VIEW;
		} catch (MemberNotFoundException e) {
			res.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
	}

	
	public String getCommandName() {
		// TODO Auto-generated method stub
		return null;
	}


	/*
	 * public void printCommandHelp(PrintStream arg0, boolean arg1) { // TODO
	 * Auto-generated method stub
	 * 
	 * }
	 * 
	 * 
	 * public boolean processCommand(String[] arg0, ORB arg1, PrintStream arg2) { //
	 * TODO Auto-generated method stub return false; }
	 */
}