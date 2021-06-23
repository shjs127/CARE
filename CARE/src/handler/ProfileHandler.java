package handler;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.ChangePasswordService;
import auth.service.FavoriteListView;
import auth.service.GetFavoriteListViewService;
import auth.service.GetMessageListViewService;
import auth.service.InvalidPasswordException;
import auth.service.LoginFailException;
import auth.service.MemberNotFoundException;
import auth.service.MessageListView;
import auth.service.User;
import member.model.UserInfo;
import mvc.command.CommandHandler;

public class ProfileHandler implements CommandHandler {

	private static final String FORM_VIEW = "/WEB-INF/view/main/profile.jsp";
	//private JoinService joinService = new JoinService();
	private ChangePasswordService changePwdSvc = new ChangePasswordService();
	private GetMessageListViewService getMessageListViewService = GetMessageListViewService.getInstance();
	private GetFavoriteListViewService getFavoriteListViewService = GetFavoriteListViewService.getInstance();
	
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
			
			UserInfo userInfo = (UserInfo) req.getSession().getAttribute("userInfo");
			int userNo = userInfo.getUserNo();
			
			MessageListView messageListView = getMessageListViewService.selectByUserNo(userNo);
			req.getSession().setAttribute("messageListView", messageListView);
			
			FavoriteListView favoriteListView = getFavoriteListViewService.selectByUserNo(userNo);
			req.getSession().setAttribute("favoriteListView", favoriteListView);
			
			
		
		// 1. session에서 userInfo.userNo 구함
		// 2. userNo를 갖고 reviewInfo 테이블에서 조회하여 review목록은 갖고 온다.
		// 3. session.setAtribute("reviewInfoList", reviewInfoList);
			return FORM_VIEW;
		} catch (LoginFailException e) {
			return FORM_VIEW;
		}
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res)
	throws Exception {
		User user = (User)req.getSession().getAttribute("authUser");
			
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);

		String curPwd = req.getParameter("curPwd");
		String newPwd = req.getParameter("newPwd");
		String newNickName = req.getParameter("newNickName");
		String newBirth = req.getParameter("newBirth");
		String newEmail = req.getParameter("newEmail");
		String newGender = req.getParameter("newGender");
		System.out.println("변경된 데이터 저장");
		if (curPwd == null || curPwd.isEmpty()) {
			errors.put("curPwd", Boolean.TRUE);
		}
		/*
		 * if (newPwd == null || newPwd.isEmpty()) { errors.put("newPwd", Boolean.TRUE);
		 * }
		 */
		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}
		
		try {
			changePwdSvc.changePassword(user.getUserId(), curPwd, newPwd, newNickName, newBirth, newEmail, newGender);
			return "/WEB-INF/view/login/changeProfile.jsp";
		} catch (InvalidPasswordException e) {
			errors.put("badCurPwd", Boolean.TRUE);
			return FORM_VIEW;
		} catch (MemberNotFoundException e) {
			res.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
	}

}
