package handler;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.ArticlePage;
import auth.service.ListArticleService;
import mvc.command.CommandHandler;

public class ListArticleHandler implements CommandHandler {
	
	private ListArticleService listService = new ListArticleService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
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

		String search=req.getParameter("searching");
		String pageNoVal = req.getParameter("p");
		String pageView = req.getParameter("v");
		int pageNo = 1;
		int pageV = 10;
		if (pageNoVal != null) {
			pageNo = Integer.parseInt(pageNoVal);
		}
		if(pageView != null) {
			pageV = Integer.parseInt(pageView);
		}
		ArticlePage articlePage = listService.getArticlePage(pageNo,pageV,search);
		req.setAttribute("articlePage", articlePage);
		return "/WEB-INF/view/board/listArticle.jsp";
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
					
				Map<String, Boolean> errors = new HashMap<>();
				req.setAttribute("errors", errors);
				
				String search=req.getParameter("searching");	
				String pageNoVal = req.getParameter("p");
				String pageView = req.getParameter("v");
				int pageNo = 1;
				int pageV = 10;
				if (pageNoVal != null) {
					pageNo = Integer.parseInt(pageNoVal);
				}
				if(pageView != null) {
					pageV = Integer.parseInt(pageView);
				}
				ArticlePage articlePage = listService.getArticlePage(pageNo,pageV,search);
				req.setAttribute("articlePage", articlePage);
					return "/WEB-INF/view/board/listArticle.jsp";

			}

}
