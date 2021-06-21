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

	public ArticlePage getArticlePage(int pageNum, int pageV) {
		
		endSize = pageNum * pageV;
		
		try (Connection conn = ConnectionProvider.getConnection()) {
			int total = boardInfoDao.selectCount(conn);
			List<BoardInfo> boardList = boardInfoDao.select(conn, (pageNum - 1) * pageV + 1, endSize);
			return new ArticlePage(total, pageNum, pageV, boardList);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public ArticlePage searchArticlePage(int pageNum, int pageV, String search) {
		
		endSize = pageNum * pageV;
		
		try (Connection conn = ConnectionProvider.getConnection()) {
			int total = boardInfoDao.searchCount(conn, search);
			System.out.println("total="+total);
			List<BoardInfo> boardList = boardInfoDao.search(conn, (pageNum - 1) * pageV + 1, endSize, search);
			System.out.println("boardList입력");
			return new ArticlePage(total, pageNum, pageV, boardList);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
