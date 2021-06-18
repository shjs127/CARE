package auth.service;
//�̼��� �߰� ����
import java.sql.Connection;
import java.sql.SQLException;

import jdbc.connection.ConnectionProvider;
import member.dao.REVIEWINFODao;
import member.model.Reviewinfo;


public class ReviewInfoService {

	public Reviewinfo reviewInfo(int storeNo) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			Reviewinfo reviewinfo = REVIEWINFODao.selectByREVIEWINFOId(conn, storeNo);
			if (reviewinfo == null) {
				//throw new LoginFailException();
			}
			
			return reviewinfo;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public static Reviewinfo REVIEWINFO(int storeNo) {
		// TODO Auto-generated method stub
		return null;
	}
}
	
	
	
	

