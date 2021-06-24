package auth.service;

//이수하 추가 파일
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.StoreInfoDao;
import member.model.StoreInfo;

public class GetStoreInfoListViewService {

	private static GetStoreInfoListViewService instance = new GetStoreInfoListViewService();

	public static GetStoreInfoListViewService getInstance() {
		return instance;
	}

	private GetStoreInfoListViewService() {
	}

	

	public StoreInfoListView getStoreInfoListView(int pageNum) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			StoreInfoDao storeInfoDAO = StoreInfoDao.getInstance();

			List<StoreInfo> storeInfoList = null;
			

			
			
			return new StoreInfoListView(storeInfoList);
		} catch (SQLException e) {
			throw new ServiceException("목록 구하기 실패: " + e.getMessage(), e);
		} finally {
			JdbcUtil.close(conn);
		}
	}

	public StoreInfoListView selectByStoreNo(int storeNo) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			StoreInfoDao storeInfoDao = StoreInfoDao.getInstance();

			List<StoreInfo> storeInfoList = null;
			storeInfoList = StoreInfoDao.selectByStoreNo(conn, storeNo);
			System.out.println("storeList=" + storeInfoList);
			return new StoreInfoListView(storeInfoList);
		} catch (

		SQLException e) {
			throw new ServiceException("목록 구하기 실패: " + e.getMessage(), e);
		} finally {
			JdbcUtil.close(conn);
		}
	}

}
