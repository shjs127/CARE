package auth.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.connection.ConnectionProvider;
import member.dao.DetailInfoDao;
import member.dao.MenuInfoDao;
import member.dao.ReviewInfoDao;
import member.dao.StoreInfoDao;
import member.model.DetailInfo;
import member.model.MenuInfo;
import member.model.ReviewInfo;
import member.model.StoreInfo;

public class FoodDetailsService {

	private MenuInfoDao menuInfoDao = new MenuInfoDao();
	private ReviewInfoDao reviewInfoDao = new ReviewInfoDao();
	private DetailInfoDao detailInfoDao = new DetailInfoDao();
	private StoreInfoDao storeInfoDao = new StoreInfoDao();

	public DetailInfo detailInfo(int storeNo) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			DetailInfo detailinfo = detailInfoDao.selectById(conn, storeNo);
			if (detailinfo == null) {
			}

			return detailinfo;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public DetailInfo DETAILINFO(int storeNo) {
		return null;
	}

	public ReviewInfo reviewInfo(int storeNo) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			ReviewInfo reviewinfo = reviewInfoDao.selectById(conn, storeNo);
			if (reviewinfo == null) {
			}

			return reviewinfo;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public ReviewInfo REVIEWINFO(int storeNo) {
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

	public MenuInfo MENUINFO(int storeNo) {
		return null;
	}

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

	public StoreInfo STOREINFO(int storeNo) {
		return null;
	}

	public float storeAvg(int storeNo) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			float storeAvg = storeInfoDao.storeAvg(conn, storeNo);

			return storeAvg;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
