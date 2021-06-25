package auth.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.MessageDao;

public class WriteMessageService {
	private static WriteMessageService instance = new WriteMessageService();

	public static WriteMessageService getInstance() {
		return instance;
	}

	public WriteMessageService() {
	}

	public int writeMessage(Message message) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			MessageDao messageDao = MessageDao.getInstance();
			int a =messageDao.insert(conn, message);
			return a;
		} catch (SQLException e) {
			throw new ServiceException("에러 내용: " + e.getMessage(), e);
		} finally {
			JdbcUtil.close(conn);
		}
		
	}

}