package auth.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.MessageDao;

public class DeleteMessageService {
	
	private MessageDao messageDao = new MessageDao();
	private int messageUserNo;
	
	public void delete(MessageRequest msgReq) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			Message message = messageDao.select(conn, msgReq.getStoreNo());
			if (message == null) {
				throw new ArticleNotFoundException();
			}
			if (!canMessage(msgReq.getUserNo(), message)) {
				throw new PermissionDeniedException();
			}
			messageDao.delete(conn, 
					msgReq.getStoreNo());
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

	private boolean canMessage(int userNo, Message message) {
		
		return (message.getUserNo())==(messageUserNo);
	}

	
}
