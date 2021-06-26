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
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String noVal = req.getParameter("boardNo");
		int articleNum = Integer.parseInt(noVal);

		try {
			ArticleData articleData = readService.getArticle(articleNum, true);
			User articleUser = loginService.selectByUserNo(articleData.getBoardInfo().getUserNo());
			BoardInfoList boardInfoList = readService.view(articleNum);
			int nextBoardNo = readService.nextView(articleNum, true);
			int prevBoardNo = readService.prevView(articleNum, true);
			req.setAttribute("boardInfoList", boardInfoList);
			req.setAttribute("nextBoardNo", nextBoardNo);
			req.setAttribute("prevBoardNo", prevBoardNo);
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
