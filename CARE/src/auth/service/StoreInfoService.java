package auth.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.StoreInfoDao;
import member.model.StoreInfo;

public class StoreInfoService {

	private StoreInfoDao storeInfoDao = new StoreInfoDao();

	public StoreInfo storeInfo(int storeNo) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			StoreInfo storeinfo = storeInfoDao.selectById(conn, storeNo);
			if (storeinfo == null) {
				JdbcUtil.rollback(conn);
				throw new DuplicateIdException();
			}

			return storeinfo;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<StoreInfo> selectByUserNo(int userNo) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			List<StoreInfo> storeInfoList = storeInfoDao.selectByUserNo(conn, userNo);
			if (storeInfoList == null) {
				JdbcUtil.rollback(conn);
				throw new DuplicateIdException();
			}

			return storeInfoList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
