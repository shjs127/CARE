package auth.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import member.model.WriteRequest;
import member.dao.ArticleContentDao;
import member.model.ArticleContent;
import member.model.BOARDINFO;
import member.dao.BOARDINFODao;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

public class WriteArticleService {

	private BOARDINFODao boardInfoDao = new BOARDINFODao();
	private ArticleContentDao contentDao = new ArticleContentDao();

	public Integer write(WriteRequest req) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);

			BOARDINFO boardInfo = toBoardInfo(req);
			int savedBoardinfo = boardInfoDao.insert(conn, boardInfo);
			if (savedBoardinfo == 0) {
				throw new RuntimeException("fail to insert article");
			}
			/*
			 * ArticleContent content = new ArticleContent( savedBoardinfo.getBoardNo(),
			 * req.getBoardContents()); ArticleContent savedContent =
			 * contentDao.insert(conn, content); if (savedContent == null) { throw new
			 * RuntimeException("fail to insert article_content"); }
			 */

			conn.commit();

			return savedBoardinfo;
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} catch (RuntimeException e) {
			JdbcUtil.rollback(conn);
			throw e;
		} finally {
			JdbcUtil.close(conn);
		}
	}

	private BOARDINFO toBoardInfo(WriteRequest req) {
		Date now = new Date();
		//return new BOARDINFO(null, req.getWriter(), req.getBoardTitle(), req.getBoardContents(), null, 0, now);
		return new BOARDINFO(1, 4, req.getBoardTitle(), req.getBoardContents(), "n/a", 0, now);
	}
}
