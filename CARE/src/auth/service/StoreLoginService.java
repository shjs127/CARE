package auth.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.connection.ConnectionProvider;
import member.dao.STOREINFODao;
import member.model.STOREINFO;

public class StoreLoginService {

	private STOREINFODao storeinfoDao = new STOREINFODao();

	public Store login(String manageNo, int storeNo) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			STOREINFO storeinfo = storeinfoDao.selectById(conn, manageNo);
			if (storeinfo == null) {
				throw new LoginFailException();
			}
			if (!storeinfo.matchStoreNo(storeNo)) {
				throw new LoginFailException();
			}
			return new Store(storeinfo.getManageNo(), storeinfo.getStoreNo());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
