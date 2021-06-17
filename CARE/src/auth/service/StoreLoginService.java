package auth.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.connection.ConnectionProvider;
import member.dao.STOREINFODao;
import member.model.Storeinfo;
import auth.service.*;

public class StoreLoginService {

	private STOREINFODao storeinfoDao = new STOREINFODao();

	public Store login(String manageNo, int storeNo) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			Storeinfo storeinfo = storeinfoDao.selectById(conn, manageNo);
			System.out.println("¼¿·º");
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
