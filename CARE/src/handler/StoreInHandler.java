package handler;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.LoginFailException;
import auth.service.StoreLoginService;
import auth.service.Store;
import mvc.command.CommandHandler;

public class StoreInHandler implements CommandHandler {

	private static final String FORM_VIEW = "/WEB-INF/view/login/login.jsp";
	private StoreLoginService storeLoginService = new StoreLoginService();


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

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}

	
	private String processSubmit(HttpServletRequest req, HttpServletResponse res) 
	throws Exception {
		String manageNo = trim(req.getParameter("manageNo"));
		String storeVal = trim(req.getParameter("storeNo"));
		int storeNo=Integer.parseInt(storeVal);
		
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);

		if (manageNo == null || manageNo.isEmpty())
			errors.put("manageNoErr", Boolean.TRUE);
		if (storeVal == null || storeVal.isEmpty()/*"".equals(storeNo)*/)
			errors.put("storeNoErr", Boolean.TRUE);

		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}
		try {
			Store store = storeLoginService.login(manageNo, storeNo);
			req.getSession().setAttribute("Store", store);
			res.sendRedirect(req.getContextPath() + "/main/index.do");
			return null;
		} catch (LoginFailException e) {
			errors.put("idOrPwNotMatch", Boolean.TRUE);
			return FORM_VIEW;
		}
	}

	private String trim(String str) {
		return str == null ? null : str.trim();
	}
}
