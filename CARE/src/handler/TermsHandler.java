package handler;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;

public class TermsHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/view/main/terms.jsp";
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}

}

