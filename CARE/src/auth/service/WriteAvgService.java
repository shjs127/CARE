package auth.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.MessageDao;

public class WriteAvgService {
	private static WriteAvgService instance = new WriteAvgService();

	public static WriteAvgService getInstance() {
		return instance;
	}

	private WriteAvgService() {
	}

	public int writeAvg(Message message) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			MessageDao messageDao = MessageDao.getInstance();
			MessageDao.insert(conn, message);
		} catch (SQLException e) {
			throw new ServiceException("에러 내용: " + e.getMessage(), e);
		} finally {
			JdbcUtil.close(conn);
		}
		return 0;
	}

}