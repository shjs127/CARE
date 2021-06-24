package auth.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.BoardInfoDao;
import member.model.BoardInfo;
import member.model.BoardPicInfo;

public class WriteArticleService {

	private BoardInfoDao boardInfoDao = new BoardInfoDao();

	public Integer write(WriteRequest req, User user) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);

			BoardInfo boardInfo = toBoardInfo(req, user);

			Integer newNo = boardInfoDao.insert(conn, boardInfo);
			if (newNo == null) {
				throw new RuntimeException("fail to insert article");
			}
			/*
			 * ArticleContent content = new ArticleContent( savedBoardinfo.getBoardNo(),
			 * req.getBoardContents()); ArticleContent savedContent =
			 * contentDao.insert(conn, content); if (savedContent == null) { throw new
			 * RuntimeException("fail to insert article_content"); }
			 */

			conn.commit();

			return newNo;
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

	private BoardInfo toBoardInfo(WriteRequest req, User user) {
		Date now = new Date();
		// return new BOARDINFO(null, req.getWriter(), req.getBoardTitle(),
		// req.getBoardContents(), null, 0, now);
		return new BoardInfo(1, user.getUserNo(), req.getBoardTitle(), req.getBoardContents(), 0, now);
	}

	public void upload(WriteRequest writeRequest) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);

			boardInfoDao.PicInsert(conn, writeRequest);

			conn.commit();
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
}
