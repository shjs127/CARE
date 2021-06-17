package auth.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.connection.ConnectionProvider;
import member.dao.StoreInfoDao;
import member.model.StoreInfo;
import auth.service.*;

public class StoreLoginService {

	private StoreInfoDao storeinfoDao = new StoreInfoDao();

	public Store login(String manageNo, int storeNo) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			StoreInfo storeinfo = storeinfoDao.selectById(conn, manageNo);
			System.out.println("����");
			if (storeinfo == null) {
				throw new LoginFailException();
			}
			System.out.println("storeinfo =null");
			if (!storeinfo.matchStoreNo(storeNo)) {
				throw new LoginFailException();
			}
			System.out.println("return");
			return new Store(storeinfo.getManageNo(), storeinfo.getStoreNo());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
