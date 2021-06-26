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
		
		String searchKeyword = req.getParameter("searchKeyword");
		String orderByVal = req.getParameter("orderBy");
		String orderBy = "orderStoreNo";
		String pageNoVal = req.getParameter("pageNo");
		int pageNo = 1;
		
		if(orderByVal != null) {
			orderBy = orderByVal;
		}
		
		if (pageNoVal != null) {
			pageNo = Integer.parseInt(pageNoVal);
		}
		
		if(searchKeyword == null || searchKeyword.equals("")) {
			StorePage storePage = listStoreService.getStorePage(pageNo, orderBy);
			req.setAttribute("storePage", storePage);
			req.setAttribute("orderBy", orderBy);
			return "/WEB-INF/view/board/cafeGrid.jsp";
		}else {
			StorePage storePage = listStoreService.getStoreSelectPage(pageNo, orderBy, searchKeyword);
			req.setAttribute("storePage", storePage);
			req.setAttribute("orderBy", orderBy);
			req.setAttribute("Keyword", searchKeyword);
			return "/WEB-INF/view/board/cafeGrid.jsp";
		}
	}

}
