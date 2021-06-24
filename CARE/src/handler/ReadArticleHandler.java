package handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.ArticleContentNotFoundException;
import auth.service.ArticleData;
import auth.service.ArticleNotFoundException;
import auth.service.LoginService;
import auth.service.ReadArticleService;
import auth.service.User;
import member.model.BoardInfoList;
import mvc.command.CommandHandler;

public class ReadArticleHandler implements CommandHandler {

	private ReadArticleService readService = new ReadArticleService();
	private LoginService loginService = new LoginService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) 
			throws Exception {
		String noVal = req.getParameter("boardNo");
		int articleNum = Integer.parseInt(noVal);
		
		BoardInfoList boardInfoList = readService.view(articleNum);
		req.getSession().setAttribute("boardInfoList", boardInfoList);
		try {
			ArticleData articleData = readService.getArticle(articleNum, true);
			User articleUser = loginService.selectByUserNo(articleData.getBoardInfo().getUserNo());
			req.getSession().setAttribute("articleUser", articleUser);
			req.setAttribute("articleData", articleData);
			return "/WEB-INF/view/board/readArticle.jsp";
		} catch (ArticleNotFoundException | ArticleContentNotFoundException e) {
			req.getServletContext().log("no article", e);
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}

}
