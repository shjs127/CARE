package auth.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.connection.ConnectionProvider;
import member.dao.DetailInfoDao;
import member.model.DetailInfo;
import member.model.ReviewInfo;


public class DetailInfoService {

	private DetailInfoDao detailInfoDao=new DetailInfoDao();
	public  DetailInfo detailInfo(int storeNo) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			DetailInfo detailinfo = detailInfoDao.selectById(conn, storeNo);
			if (detailinfo == null) {
				//throw new LoginFailException();
			}
			
			return detailinfo;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
	

	
	
	
	

