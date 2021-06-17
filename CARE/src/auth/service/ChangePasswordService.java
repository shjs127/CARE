package auth.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.UserInfoDao;
import member.model.UserInfo;
import auth.service.InvalidPasswordException; 

public class ChangePasswordService {

	private UserInfoDao userinfoDao = new UserInfoDao();
	
	public void changePassword(String userId, String curPwd, String newPwd) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			UserInfo userinfo = userinfoDao.selectById(conn, userId);
			if (userinfo == null) {
				throw new MemberNotFoundException();
			}
			if (!userinfo.matchPassword(curPwd)) {
				throw new InvalidPasswordException(newPwd);
			}
			userinfo.changePassword(newPwd);
			userinfoDao.update(conn, userinfo);
			conn.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
}
