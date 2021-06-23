package handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.ListStoreService;
import auth.service.StorePage;
import mvc.command.CommandHandler;

public class SearchHandler implements CommandHandler {

	private ListStoreService listStoreService = new ListStoreService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {

		// 검색 폼에서 파라미터 받기
		String searchKeyword = req.getParameter("searchKeyword");
		
		// 현재 페이지 번호
		String pageNoVal = req.getParameter("pageNo");
		int pageNo = 1;
		if(pageNoVal != null) {
			pageNo = Integer.parseInt(pageNoVal);
		}
		
		StorePage storePage = listStoreService.getStoreSelectPage(pageNo, searchKeyword);
		req.setAttribute("storePage", storePage);
		req.setAttribute("Keyword", searchKeyword);
		return "/WEB-INF/view/board/cafeGrid.jsp";
		
	}

}