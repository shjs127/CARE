package handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.ListArticleService;
import auth.service.ListStoreService;
import auth.service.Store;
import mvc.command.CommandHandler;

public class IndexHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/view/main/index.jsp";
	private ListStoreService listStoreService = new ListStoreService();

	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
		return processForm(req, res);
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		int top=6;  
		List<Store> storageAvgTop = listStoreService.storeTop(top);
		req.setAttribute("storageAvgTop", storageAvgTop);
		

		return FORM_VIEW;
	}
}

