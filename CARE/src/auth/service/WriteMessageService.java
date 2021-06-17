package auth.service;
//이수하 추가 파일
import java.sql.Connection;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.MESSAGEDao;

public class WriteMessageService {
	private static WriteMessageService instance = new WriteMessageService();

	public static WriteMessageService getInstance() {
		return instance;
	}

	private WriteMessageService() {
	}

	public int writeMessage(Message message) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			MESSAGEDao messageDao = MESSAGEDao.getInstance();
			MESSAGEDao.insert(conn, message);
		} catch (SQLException e) {
			throw new ServiceException(
					"에러 내용: " + e.getMessage(), e);
		} finally {
			JdbcUtil.close(conn);
		}
		return 0;
	}

}