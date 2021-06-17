package auth.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.connection.ConnectionProvider;
import member.dao.StoreInfoDao;
import member.model.StoreInfo;

public class ListStoreService {

	private StoreInfoDao storeInfoDao = new StoreInfoDao();
	private int size = 10;

	public StorePage getStorePage(int pageNum) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			int total = storeInfoDao.selectCount(conn);
			List<StoreInfo> storeList = storeInfoDao.select(
					conn, (pageNum - 1) * size, size);
			return new StorePage(total, pageNum, size, storeList);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
