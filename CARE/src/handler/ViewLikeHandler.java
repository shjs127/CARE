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
import member.model.Detailinfo;
import member.model.Menuinfo;
import member.model.Reviewinfo;
import member.model.Storeinfo;
import mvc.command.CommandHandler;
public class ViewLikeHandler implements CommandHandler {

	private static final String FORM_VIEW = "/WEB-INF/view/main/viewLike.jsp";
	

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
			
			Detailinfo detailinfo = DetailInfoService.DETAILINFO(storeNo);
			req.getSession().setAttribute("detailinfo", detailinfo);
			Reviewinfo reviewinfo = ReviewInfoService.REVIEWINFO(storeNo);
			req.getSession().setAttribute("reviewinfo", reviewinfo);
			Storeinfo storeinfo = StoreInfoService.STOREINFO(storeNo);
			req.getSession().setAttribute("storeinfo", storeinfo);
			Menuinfo menuinfo = MenuInfoService.MENUINFO(storeNo);
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
