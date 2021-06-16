package auth.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.ArticleContentDao;
import member.dao.BOARDINFODao;
import member.model.BOARDINFO;

public class DeleteArticleService {

	private BOARDINFODao boardInfoDao = new BOARDINFODao();
	private ArticleContentDao contentDao = new ArticleContentDao();

	public void delete(ModifyRequest modReq) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			BOARDINFO boardInfo = boardInfoDao.selectById(conn, 
					modReq.getBoardNo());
			if (boardInfo == null) {
				throw new ArticleNotFoundException();
			}
			if (!canModify(modReq.getUserNo(), boardInfo)) {
				throw new PermissionDeniedException();
			}
			contentDao.delete(conn, 
					modReq.getBoardNo());
			conn.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} catch (PermissionDeniedException e) {
			JdbcUtil.rollback(conn);
			throw e;
		} finally {
			JdbcUtil.close(conn);
		}
	}

	private boolean canModify(int modfyingUserNo, BOARDINFO boardInfo) {
		return (boardInfo.getUserNo())==(modfyingUserNo);
	}
}
