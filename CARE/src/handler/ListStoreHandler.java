package handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import auth.service.ListStoreService;
import auth.service.StorePage;

public class ListStoreHandler implements CommandHandler {

	private ListStoreService listStoreService = new ListStoreService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) 
			throws Exception {
		String pageNoVal = req.getParameter("pageNo");
		int pageNo = 1;
		if (pageNoVal != null) {
			pageNo = Integer.parseInt(pageNoVal);
		}
		StorePage storePage = listStoreService.getStorePage(pageNo);
		req.setAttribute("storePage", storePage);
		return "/WEB-INF/view/board/cafeGrid.jsp";
	}

}
