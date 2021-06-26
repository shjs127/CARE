package handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.Board;
import auth.service.ListArticleService;
import auth.service.ListStoreService;
import auth.service.Store;
import member.model.ReviewInfo;
import mvc.command.CommandHandler;

public class IndexHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/view/main/index.jsp";
	private ListStoreService listStoreService = new ListStoreService();
	private ListArticleService listArticleService= new ListArticleService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
		return processForm(req, res);
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		int top=6;  
		List<Store> storageAvgTop = listStoreService.storeTop(top);
		req.setAttribute("storageAvgTop", storageAvgTop);
		
		List<Board> boardTop = listArticleService.boardTop(top);
		req.setAttribute("boardTop", boardTop);
		
		List<Store> reviewTop=listStoreService.reviewTop(top);
		req.setAttribute("reviewTop", reviewTop);
		return FORM_VIEW;
	}
}

