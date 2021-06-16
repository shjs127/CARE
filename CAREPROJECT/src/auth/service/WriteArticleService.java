package auth.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.BOARDINFODao;
import member.model.BOARDINFO;

public class WriteArticleService {

	private BOARDINFODao boardInfoDao = new BOARDINFODao();

	public BOARDINFO write(WriteRequest req, User user) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);

			BOARDINFO boardInfo = toBoardInfo(req, user);
			
			BOARDINFO savedBoardinfo = boardInfoDao.insert(conn, boardInfo);
			if (savedBoardinfo == null) {
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

	private BOARDINFO toBoardInfo(WriteRequest req, User user) {
		Date now = new Date();
		//return new BOARDINFO(null, req.getWriter(), req.getBoardTitle(), req.getBoardContents(), null, 0, now);
		return new BOARDINFO(1, user.getUserNo(), req.getBoardTitle(), req.getBoardContents(), "n/a", 0, now);
	}
}
