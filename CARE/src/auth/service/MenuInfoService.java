package auth.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.connection.ConnectionProvider;
import member.dao.MenuInfoDao;
import member.model.MenuInfo;
import member.model.ReviewInfo;



public class MenuInfoService {

			
	private MenuInfoDao menuInfoDao=new MenuInfoDao();

	public MenuInfo menuInfo(int storeNo) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			MenuInfo menuinfo = menuInfoDao.selectById(conn, storeNo);
			if (menuinfo == null) {
				
			}
			
			
			return menuinfo;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public static MenuInfo MENUINFO(int storeNo) {
		// TODO Auto-generated method stub
		return null;
	}
}
	

	
	
	
	

