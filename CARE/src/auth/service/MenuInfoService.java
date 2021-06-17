package auth.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.connection.ConnectionProvider;
import member.dao.MENUINFODao;
import member.model.Menuinfo;
import member.model.Reviewinfo;



public class MenuInfoService {

			
	

	public Menuinfo menuInfo(int storeNo) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			Menuinfo menuinfo = MENUINFODao.selectByMENUINFOId(conn, storeNo);
			if (menuinfo == null) {
				
			}
			
			
			return menuinfo;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public static Menuinfo MENUINFO(int storeNo) {
		// TODO Auto-generated method stub
		return null;
	}
}
	

	
	
	
	

