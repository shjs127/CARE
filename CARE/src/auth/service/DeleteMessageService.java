package auth.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.MessageDao;

public class DeleteMessageService {
	
	private MessageDao messageDao = new MessageDao();
	private int messageUserNo;
	
	public void delete(int reviewNo) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			messageDao.delete(conn, reviewNo);
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
