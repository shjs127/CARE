package auth.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.connection.ConnectionProvider;
import member.dao.ReviewInfoDao;
import member.model.ReviewInfo;

public class ReviewInfoService {

	private ReviewInfoDao reviewInfoDao = new ReviewInfoDao();

	public ReviewInfo reviewInfo(int storeNo) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			ReviewInfo reviewinfo = reviewInfoDao.selectById(conn, storeNo);

			return reviewinfo;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public float storeAvg(int storeNo) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			float storeAvg = reviewInfoDao.storeAvg(conn, storeNo);

			return storeAvg;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
