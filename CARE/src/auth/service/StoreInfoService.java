package auth.service;
//�̼��� �߰� ����
import java.sql.Connection;
import java.sql.SQLException;

import jdbc.connection.ConnectionProvider;
import member.dao.STOREINFODao;
import member.model.Reviewinfo;
import member.model.Storeinfo;


public class StoreInfoService {

	

	public Storeinfo storeInfo(int storeNo) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			Storeinfo storeinfo = STOREINFODao.selectBySTOREINFOId(conn, storeNo);
			if (storeinfo == null) {

			}
			
			return storeinfo;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public static Storeinfo STOREINFO(int storeNo) {
		// TODO Auto-generated method stub
		return null;
	}
}
	

	
	
	
	

