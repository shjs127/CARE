package auth.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.FavoriteDao;
import member.model.Favorite;

public class GetFavoriteListViewService {

	private static GetFavoriteListViewService instance = new GetFavoriteListViewService();

	public static GetFavoriteListViewService getInstance() {
		return instance;
	}

	private GetFavoriteListViewService() {
	}

	public FavoriteListView getFavoriteListView(int pageNum) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();

			List<Favorite> favoriteList = null;

			return new FavoriteListView(favoriteList);
		} catch (SQLException e) {
			throw new ServiceException("목록 구하기 실패: " + e.getMessage(), e);
		} finally {
			JdbcUtil.close(conn);
		}
	}

	public FavoriteListView selectByUserNo(int userNo) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();

			List<Favorite> favoriteList = null;
			favoriteList = FavoriteDao.selectByUserNo(conn, userNo);
			System.out.println("favoriteList=" + favoriteList);
			return new FavoriteListView(favoriteList);
		} catch (

		SQLException e) {
			throw new ServiceException("목록 구하기 실패: " + e.getMessage(), e);
		} finally {
			JdbcUtil.close(conn);
		}
	}

}
