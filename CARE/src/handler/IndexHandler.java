package handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.Board;
import auth.service.ListArticleService;
import auth.service.ListStoreService;
import auth.service.Store;
import mvc.command.CommandHandler;

public class IndexHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/view/main/index.jsp";
	private ListStoreService listStoreService = new ListStoreService();
	private ListArticleService listArticleService=new ListArticleService();

	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
		/*
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
		*/
		return processForm(req, res);
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		int top=6;  
		List<Store> storageAvgTop = listStoreService.storeTop(top);
		req.setAttribute("storageAvgTop", storageAvgTop);
		
		/*
		 * List<Board> boardViewTop = listArticleService.boardViewTop(top);
		 * req.setAttribute("boardViewTop", boardViewTop);
		 */

		return FORM_VIEW;
	}

	/*
	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
	
		
		try {
			joinService.join(joinReq);
			return "/WEB-INF/view/joinSuccess.jsp";
		} catch (DuplicateIdException e) {
			errors.put("duplicateId", Boolean.TRUE);
			return FORM_VIEW;
		}
	}
	*/

}

