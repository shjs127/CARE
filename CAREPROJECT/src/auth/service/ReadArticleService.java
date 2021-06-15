package auth.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.connection.ConnectionProvider;
import member.dao.ArticleContentDao;
import member.dao.BOARDINFODao;
import member.model.ArticleContent;
import member.model.BOARDINFO;


public class ReadArticleService {

	private BOARDINFODao boardInfoDao = new BOARDINFODao();
	private ArticleContentDao contentDao = new ArticleContentDao();
	
	public ArticleData getArticle(int boardNo, boolean increaseReadCount) {
		try (Connection conn = ConnectionProvider.getConnection()){
			BOARDINFO boardInfo = boardInfoDao.selectById(conn, boardNo);
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
