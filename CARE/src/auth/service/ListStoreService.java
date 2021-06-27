package auth.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.connection.ConnectionProvider;
import member.dao.StoreInfoDao;
import member.model.ReviewInfo;
import member.model.StoreInfo;

public class ListStoreService {

	private StoreInfoDao storeInfoDao = new StoreInfoDao();
	private int size = 9;
	private int endSize = 0;

	public StorePage getStorePage(int pageNum, String orderBy) {
		
		endSize = pageNum * size;
		
		try (Connection conn = ConnectionProvider.getConnection()) {
			int total = 0;
			List<StoreInfo> storeList = null;
			
			if(orderBy.equals("orderStoreNo")) {
				total = storeInfoDao.selectCount(conn);
				storeList = storeInfoDao.select(conn, (pageNum - 1) * size + 1, endSize);
			}else if(orderBy.equals("orderAvgScore")) {
				total = storeInfoDao.selectAvgScoreCount(conn);
				storeList = storeInfoDao.selectAvgScore(conn, (pageNum - 1) * size + 1, endSize);
			}else if(orderBy.equals("orderReviewCnt")){
				total = storeInfoDao.selectReviewCount(conn);
				storeList = storeInfoDao.selectReviewCnt(conn, (pageNum - 1) * size + 1, endSize);
			}
			
			return new StorePage(total, pageNum, size, storeList);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public StorePage getStoreSelectPage(int pageNum, String orderBy, String searchKeyword) {
		
		endSize = pageNum * size;
		
		try (Connection conn = ConnectionProvider.getConnection() ) {
			List<StoreInfo> storeList = null;
			int total = 0;
			
			
			if(orderBy.equals("orderStoreNo")) {
				total = storeInfoDao.selectSearchCount(conn, searchKeyword);
				storeList = storeInfoDao.getSearchStoreNo(conn, (pageNum - 1) * size + 1, endSize, searchKeyword);
			}else if(orderBy.equals("orderAvgScore")) {
				total = storeInfoDao.selectAvgScoreSearchCount(conn, searchKeyword);
				storeList = storeInfoDao.getSearchOrderAvgScore(conn, (pageNum - 1) * size + 1, endSize, searchKeyword);
			}else if(orderBy.equals("orderReviewCnt")){
				total = storeInfoDao.selectReviewCntSearchCount(conn, searchKeyword);
				storeList = storeInfoDao.getSearchOrderReviewCnt(conn, (pageNum - 1) * size + 1, endSize, searchKeyword);
			}
					
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
	
public List<Store> reviewTop(int top) {
		
		try (Connection conn = ConnectionProvider.getConnection()) {
			List<Store> reviewTop = storeInfoDao.reviewTop(conn,top);
	
			return reviewTop;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
