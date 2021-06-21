package auth.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.connection.ConnectionProvider;
import member.dao.BoardInfoDao;
import member.model.BoardInfo;

public class ListArticleService {

	private BoardInfoDao boardInfoDao = new BoardInfoDao();
	private int size = 10;
	private int endSize = 0;

	public ArticlePage getArticlePage(int pageNum) {
		
		endSize = pageNum * size;
		
		try (Connection conn = ConnectionProvider.getConnection()) {
			int total = boardInfoDao.selectCount(conn);
			List<BoardInfo> boardList = boardInfoDao.select(conn, (pageNum - 1) * size + 1, endSize);
			return new ArticlePage(total, pageNum, size, boardList);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
