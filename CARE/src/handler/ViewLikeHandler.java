package handler;
//�̼��� �߰� ����
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
public class ViewLikeHandler implements CommandHandler {

	private static final String FORM_VIEW = "/WEB-INF/view/main/viewLike.jsp";
	
	private DetailInfoService detailInfoService=new DetailInfoService();
	private ReviewInfoService reviewInfoService=new ReviewInfoService();
	private	StoreInfoService storeInfoService=new StoreInfoService();
	private MenuInfoService menuInfoService=new MenuInfoService();
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

		
		
		try {
			int storeNo = 1;
			
			DetailInfo detailinfo = detailInfoService.detailInfo(storeNo);
			req.getSession().setAttribute("detailinfo", detailinfo);
			ReviewInfo reviewinfo = reviewInfoService.reviewInfo(storeNo);
			req.getSession().setAttribute("reviewinfo", reviewinfo);
			StoreInfo storeinfo = storeInfoService.storeInfo(storeNo);
			req.getSession().setAttribute("storeinfo", storeinfo);
			MenuInfo menuinfo = menuInfoService.menuInfo(storeNo);
			req.getSession().setAttribute("menuinfo", menuinfo);
			
			
		
			
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
			
			return FORM_VIEW;
		} catch (LoginFailException e) {
			return FORM_VIEW;
		}
	}

}
