package auth.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.connection.ConnectionProvider;
import member.dao.BoardInfoDao;
import member.model.BoardInfo;

public class ListArticleService {

	private BoardInfoDao boardInfoDao = new BoardInfoDao();
	private int endSize = 0;

	public ArticlePage getArticlePage(int pageNum, int pageV, String search) {
		
		endSize = pageNum * pageV;
		
		try (Connection conn = ConnectionProvider.getConnection()) {
			int total = boardInfoDao.searchCount(conn, search);
			List<BoardInfo> boardList = boardInfoDao.search(conn, (pageNum - 1) * pageV + 1, endSize, search);
			return new ArticlePage(total, pageNum, pageV, boardList);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Board> boardViewTop(int top) {
		
		try (Connection conn = ConnectionProvider.getConnection()) {
			List<Board> boardViewTop = boardInfoDao.boardViewTop(conn,top);
	
			return boardViewTop;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
