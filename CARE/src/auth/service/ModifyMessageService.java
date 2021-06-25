package auth.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.MessageDao;
import member.model.BoardInfo;
import auth.service.MessageNotFoundException;

public class ModifyMessageService {

	private MessageDao messageDao = new MessageDao();

	public void message(MessageRequest msgReq) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			MessageDao messageDao = messageDao.select(conn, msgReq.getReviewNo());
			if (messageDao == null) {
				throw new MessageNotFoundException(null);
			}
			if (!canMessage(msgReq.getUserNo(), messageDao)) {
				throw new PermissionDeniedException();
			}

			messageDao.update(conn, msgReq.getAvgScore(), msgReq.getReviewContents(), msgReq.getReviewDate(),
					msgReq.getReviewNo(), msgReq.getStoreNo(), msgReq.getUserNo());

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

	private boolean canMessage(int modfyingUserNo, Message message) {
		return message.getUserNo() == modfyingUserNo;
	}
}
