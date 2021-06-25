package auth.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.connection.ConnectionProvider;
import member.dao.FavoriteDao;
import member.model.Favorite;

public class FavoriteCheckService {

	private FavoriteDao favoriteDao = new FavoriteDao();

	public boolean isExistFavoriteData(Favorite favorite) throws SQLException {
		Connection conn = null;
		conn = ConnectionProvider.getConnection();

		return favoriteDao.selectCheck(conn, favorite) != null;
	}

	public void changeFavoriteData(Favorite favorite) throws SQLException {
		Connection conn = null;
		conn = ConnectionProvider.getConnection();
		if (favorite.getFavoriteCheck().equals("y")) {
			favoriteDao.delete(conn, favorite);
		} else {
			favoriteDao.insert(conn, favorite);
		}
	}
}
