package auth.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.connection.ConnectionProvider;
import member.dao.ArticleContentDao;
import member.dao.BoardInfoDao;
import member.model.ArticleContent;
import member.model.BoardInfo;


public class ReadArticleService {

	private BoardInfoDao boardInfoDao = new BoardInfoDao();
	private ArticleContentDao contentDao = new ArticleContentDao();
	
	public ArticleData getArticle(int boardNo, boolean increaseReadCount) {
		try (Connection conn = ConnectionProvider.getConnection()){
			BoardInfo boardInfo = boardInfoDao.selectById(conn, boardNo);
			if (boardInfo == null) {
				throw new ArticleContentNotFoundException();
			}
			ArticleContent content = contentDao.selectById(conn, boardNo);
			if (content == null) {
				throw new ArticleContentNotFoundException();
			}
			if (increaseReadCount) {
				boardInfoDao.increaseReadCount(conn, boardNo);
			}
			return new ArticleData(boardInfo, content);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
