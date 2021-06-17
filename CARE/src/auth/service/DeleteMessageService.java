package auth.service;
//이수하 추가파일
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.MESSAGEDao;
public class DeleteMessageService {

	private static DeleteMessageService instance = new DeleteMessageService();

	public static DeleteMessageService getInstance() {
		return instance;
	}

	private DeleteMessageService() {
	}

	public void deleteMessage(int reviewno,int storeno, int userno, int avgscore, String reviewcontents, Date reviewdate) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);

			MESSAGEDao messageDao = MESSAGEDao.getInstance();
			Message message = messageDao.select(conn, reviewno);
			if (message == null) {
				throw new MessageNotFoundException("硫붿떆吏� �뾾�쓬");
			}
			
			messageDao.delete(conn, reviewno);

			conn.commit();
		} catch (SQLException ex) {
			JdbcUtil.rollback(conn);
			throw new ServiceException("�궘�젣 �떎�뙣:" + ex.getMessage(), ex);
		} catch (InvalidPasswordException | MessageNotFoundException ex) {
			JdbcUtil.rollback(conn);
			throw ex;
		} finally {
			JdbcUtil.close(conn);
		}
	}
}