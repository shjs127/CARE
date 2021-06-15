package handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.StoreRequest;
import mvc.command.CommandHandler;
import auth.service.StoreService;

public class SearchHandler implements CommandHandler {

	private static final String FORM_VIEW = "/WEB-INF/view/main/index.jsp";
	private StoreService storeService = new StoreService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		}else if(req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		}else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}
	
	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
		
		/*StoreRequest storeReq = new StoreRequest();
		
		
		try {
			storeService.select(storeReq);
			return "/WEB-INF/view/board/cafeGrid.jsp";
			
		}catch(DuplicateIdException e) {
			error.put("duplicatedId", Boolean.TRUE);*/
			return FORM_VIEW;
			/* } */
	}
	

}
