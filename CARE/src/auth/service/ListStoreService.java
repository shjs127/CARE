package auth.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.connection.ConnectionProvider;
import member.dao.StoreInfoDao;
import member.model.StoreInfo;

public class ListStoreService {

	private StoreInfoDao storeInfoDao = new StoreInfoDao();
	private int size = 9;
	private int endSize = 0;
	

	public StorePage getStorePage(int pageNum, String orderBy) {
		
		endSize = pageNum * size;
		
		try (Connection conn = ConnectionProvider.getConnection()) {
			int total = storeInfoDao.selectCount(conn);
			List<StoreInfo> storeList = null;
			
			if(orderBy.equals("orderStoreNo")) {
				storeList = storeInfoDao.select(conn, (pageNum - 1) * size + 1, endSize);
			}else if(orderBy.equals("orderAvgScore")) {
				storeList = storeInfoDao.selectAvgScore(conn, (pageNum - 1) * size + 1, endSize);
			}else if(orderBy.equals("orderReviewCnt")){
				storeList = storeInfoDao.selectReviewCnt(conn, (pageNum - 1) * size + 1, endSize);
			}
			
			return new StorePage(total, pageNum, size, storeList);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public StorePage getStoreSelectPage(int pageNum, String searchKeyword) {
		
		endSize = pageNum * size;
		
		try (Connection conn = ConnectionProvider.getConnection() ) {
			int total = storeInfoDao.selectSearchCount(conn, searchKeyword);
			List<StoreInfo> storeList = storeInfoDao.getSearch(
					conn, (pageNum -1) * size + 1, endSize, searchKeyword);
	
			return new StorePage(total, pageNum, size, storeList);	
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public List<Store> storeTop(int top) {
		
		try (Connection conn = ConnectionProvider.getConnection()) {
			List<Store> storageAvgTop = storeInfoDao.storeAvgTop(conn,top);
	
			return storageAvgTop;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
