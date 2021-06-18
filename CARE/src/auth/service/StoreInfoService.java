package auth.service;
//�̼��� �߰� ����
import java.sql.Connection;
import java.sql.SQLException;

import jdbc.connection.ConnectionProvider;
import member.dao.StoreInfoDao;
import member.model.ReviewInfo;
import member.model.StoreInfo;


public class StoreInfoService {

	private StoreInfoDao storeInfoDao=new StoreInfoDao();

	public StoreInfo storeInfo(int storeNo) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			StoreInfo storeinfo = storeInfoDao.selectById(conn, storeNo);
			if (storeinfo == null) {

			}
			
			return storeinfo;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
	

	
	
	
	

