package handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.DetailInfoService;
import auth.service.FavoriteCheckService;
import auth.service.FoodDetailsService;
import auth.service.GetMenuListViewService;
import auth.service.GetMessageListViewService;
import auth.service.LoginFailException;
import auth.service.MenuInfoService;
import auth.service.MenuListView;
import auth.service.MessageListView;
import auth.service.ReviewInfoService;
import auth.service.StoreInfoService;
import auth.service.User;
import member.model.DetailInfo;
import member.model.Favorite;
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
	private FavoriteCheckService favoriteService = new FavoriteCheckService();
	private FoodDetailsService foodDetailsService = new FoodDetailsService();

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

	private String processForm(HttpServletRequest req, HttpServletResponse res) throws Exception {
		User user = (User) req.getSession().getAttribute("authUser");

		try {
			int storeNo = Integer.parseInt(req.getParameter("storeno"));

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

			GetMenuListViewService getMenuListViewService = GetMenuListViewService.getInstance();
			MenuListView menuListView = getMenuListViewService.getMenuListView(pageNum);
			req.getSession().setAttribute("menuListView", menuListView);

			if (user != null) {

				Favorite favorite = new Favorite(user.getUserNo(), storeNo, "n");

				boolean isExisFavoriteData = favoriteService.isExistFavoriteData(favorite);
				System.out.println("isExisFavoriteData=" + isExisFavoriteData);

				req.getSession().setAttribute("isExisFavoriteData", isExisFavoriteData);

				System.out.println("userNo=" + user.getUserNo());
			}

			float storeAvg = foodDetailsService.storeAvg(storeNo);
			req.getSession().setAttribute("storeAvg", storeAvg);

			return FORM_VIEW;
		} catch (LoginFailException e) {
			return FORM_VIEW;
		}
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception {
		try {
			return FORM_VIEW;
		} catch (LoginFailException e) {
			return FORM_VIEW;
		}
	}

}
