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
		StorePage storePage = listStoreService.getStorePage(pageNo, orderBy);
		req.setAttribute("storePage", storePage);
		return "/WEB-INF/view/board/cafeGrid.jsp";
	}

}
