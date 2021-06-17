package auth.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.connection.ConnectionProvider;
import member.dao.ReviewInfoDao;
import member.model.ReviewInfo;


public class ReviewInfoService {

	public ReviewInfo reviewInfo(int storeNo) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			ReviewInfo reviewinfo = ReviewInfoDao.selectByREVIEWINFOId(conn, storeNo);
			if (reviewinfo == null) {
				//throw new LoginFailException();
			}
			
			return reviewinfo;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public static ReviewInfo REVIEWINFO(int storeNo) {
		// TODO Auto-generated method stub
		return null;
	}
}
	
	
	
	

