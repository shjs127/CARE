package handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.ArticlePage;
import auth.service.ListArticleService;
import mvc.command.CommandHandler;

public class ListArticleHandler implements CommandHandler {

	private ListArticleService listService = new ListArticleService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) 
			throws Exception {
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
		ArticlePage articlePage = listService.getArticlePage(pageNo,pageV);
		req.setAttribute("articlePage", articlePage);
		return "/WEB-INF/view/board/listArticle.jsp";
	}

}
