package auth.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.connection.ConnectionProvider;
import member.dao.DetailInfoDao;
import member.dao.MenuInfoDao;
import member.dao.ReviewInfoDao;
import member.dao.StoreInfoDao;
import member.dao.UserInfoDao;
import member.model.DetailInfo;
import member.model.MenuInfo;
import member.model.ReviewInfo;
import member.model.StoreInfo;


public class FoodDetailsService {
	
	private MenuInfoDao menuInfoDao = new MenuInfoDao();
	private ReviewInfoDao reviewInfoDao = new ReviewInfoDao();
	private DetailInfoDao detailInfoDao = new DetailInfoDao();
	private StoreInfoDao storeInfoDao = new StoreInfoDao();
	
	public  DetailInfo detailInfo(int storeNo) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			DetailInfo detailinfo = detailInfoDao.selectById(conn, storeNo);
			if (detailinfo == null) {
				//throw new LoginFailException();
			}
			
			return detailinfo;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public DetailInfo DETAILINFO(int storeNo) {
		// TODO Auto-generated method stub
		return null;
	}

	

		public ReviewInfo reviewInfo(int storeNo) {
			try (Connection conn = ConnectionProvider.getConnection()) {
				ReviewInfo reviewinfo = ReviewInfoDao.selectByREVIEWINFOId(conn, storeNo);
				if (reviewinfo == null) {
					//throw new LoginFailException();
				}
				
				return reviewinfo;
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

		public ReviewInfo REVIEWINFO(int storeNo) {
			// TODO Auto-generated method stub
			return null;
		}

		public MenuInfo menuInfo(int storeNo) {
			try (Connection conn = ConnectionProvider.getConnection()) {
				MenuInfo menuinfo = menuInfoDao.selectById(conn, storeNo);
				if (menuinfo == null) {
					
				}
				
				
				return menuinfo;
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

		public  MenuInfo MENUINFO(int storeNo) {
			// TODO Auto-generated method stub
			return null;
		}

		public StoreInfo storeInfo(int storeNo) {
			try (Connection conn = ConnectionProvider.getConnection()) {
				StoreInfo storeinfo = StoreInfoDao.selectBySTOREINFOId(conn, storeNo);
				if (storeinfo == null) {

				}
				
				return storeinfo;
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

		public StoreInfo STOREINFO(int storeNo) {
			// TODO Auto-generated method stub
			return null;
		}

}
		








	

	
	
	
	

