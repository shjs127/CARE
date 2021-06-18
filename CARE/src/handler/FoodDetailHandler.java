package handler;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.DetailInfoService;
import auth.service.GetMessageListViewService;
import auth.service.LoginFailException;
import auth.service.MenuInfoService;
import auth.service.MessageListView;
import auth.service.ReviewInfoService;
import auth.service.StoreInfoService;
import member.model.DetailInfo;
import member.model.MenuInfo;
import member.model.ReviewInfo;
import member.model.StoreInfo;
import mvc.command.CommandHandler;



public class FoodDetailHandler implements CommandHandler {

	private static final String FORM_VIEW = "/WEB-INF/view/main/food-details.jsp";
	private MenuInfoService menuinfoService = new MenuInfoService();
	private StoreInfoService storeinfoService = new StoreInfoService();
	private DetailInfoService detailinfoService = new DetailInfoService();
	private ReviewInfoService reviewinfoService = new ReviewInfoService();

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

		/*
		 * GetMessageListViewService viewService =
		 * GetMessageListViewService.getInstance(); String pageStr =
		 * req.getParameter("page"); int pageNum = pageStr == null ? 1 :
		 * Integer.parseInt(pageStr); MessageListView view =
		 * viewService.getMessageListView(pageNum);
		 * 
		 * req.getSession().setAttribute("view", view);
		 * 
		 * return FORM_VIEW;
		 */
		
		try {
			int storeNo = 1;
			StoreInfo storeinfo = storeinfoService.storeInfo(storeNo);
			req.getSession().setAttribute("storeinfo", storeinfo);
			MenuInfo menuinfo = menuinfoService.menuInfo(storeNo);
			req.getSession().setAttribute("menuinfo", menuinfo);
			DetailInfo detailinfo = detailinfoService.detailInfo(storeNo);
			req.getSession().setAttribute("detailinfo", detailinfo);
			ReviewInfo reviewinfo = reviewinfoService.reviewInfo(storeNo);
			req.getSession().setAttribute("reviewinfo", reviewinfo);

			GetMessageListViewService viewService = GetMessageListViewService.getInstance();
			String pageStr = req.getParameter("page");
			int pageNum = pageStr == null ? 1 : Integer.parseInt(pageStr);
			MessageListView view = viewService.getMessageListView(pageNum);
			
			req.getSession().setAttribute("view", view);

			return FORM_VIEW;
		} catch (LoginFailException e) {
			return FORM_VIEW;
		}
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception {

		try {
			// User user = loginService.login(id, password);
			// req.getSession().setAttribute("authUser", user);
			// res.sendRedirect(req.getContextPath() + "/CARE/view/main/food-details.jsp");
			/*
			 * int storeno = 1; Storeinfo storeinfo = foodService.storeinfo(storeno);
			 * req.getSession().setAttribute("storeinfo", storeinfo); Menuinfo menuinfo =
			 * foodService.menuinfo(storeno); req.getSession().setAttribute("menuinfo",
			 * menuinfo); Detailinfo detailinfo = foodService.detailinfo(storeno);
			 * req.getSession().setAttribute("detailinfo", detailinfo); Reviewinfo
			 * reviewinfo = foodService.reviewinfo(storeno);
			 * req.getSession().setAttribute("reviewinfo", reviewinfo);
			 */

			return FORM_VIEW;
		} catch (LoginFailException e) {
			return FORM_VIEW;
		}
	}

}
