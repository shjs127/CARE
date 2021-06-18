package auth.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.connection.ConnectionProvider;
import member.dao.DETAILINFODao;
import member.model.Detailinfo;
import member.model.Reviewinfo;


public class DetailInfoService {

	
	public  Detailinfo detailInfo(int storeNo) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			Detailinfo detailinfo = DETAILINFODao.selectByDETAILINFOId(conn, storeNo);
			if (detailinfo == null) {
				//throw new LoginFailException();
			}
			
			return detailinfo;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public static Detailinfo DETAILINFO(int storeNo) {
		// TODO Auto-generated method stub
		return null;
	}
}
	

	
	
	
	

