package handler;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.DuplicateIdException;
import auth.service.FavoriteCheckService;
import auth.service.Store;
import auth.service.User;
import member.model.Favorite;
import mvc.command.CommandHandler;

public class FavoriteHandler implements CommandHandler {

	private static final String FORM_VIEW = "/WEB-INF/view/main/food-details.jsp";
	private FavoriteCheckService favoriteService=new FavoriteCheckService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
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
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
		int userNo = Integer.parseInt(req.getParameter("userNo"));
		int storeNo= Integer.parseInt(req.getParameter("storeNo"));
		System.out.println("storeNo="+storeNo);
		System.out.println("userNo="+userNo);
		Favorite favorite=new Favorite(userNo,storeNo, "n");
		
		try {
			boolean isExisFavoriteData=favoriteService.isExistFavoriteData(favorite);
			//req.getSession().setAttribute("isExisFavoriteData", isExisFavoriteData);
			System.out.println("isExisFavoriteData="+isExisFavoriteData);
			if(isExisFavoriteData) favorite.setFavoriteCheck("y");
			favoriteService.changeFavoriteData(favorite);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			return "/WEB-INF/view/main/food-details.jsp";
		} catch (DuplicateIdException e) {
			
			return FORM_VIEW;
		}
	}


}
