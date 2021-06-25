package auth.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.UserInfoDao;
import member.model.UserInfo;

public class ChangePasswordService {

	private UserInfoDao userinfoDao = new UserInfoDao();
	
	public void changePassword(String userId, String curPwd, String newPwd, 
			String newNickName, String newBirth, String newEmail, String newGender) {
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
			if (newPwd==null || newPwd.isEmpty()) {
				newPwd=userinfo.getPassword();
			}
			if (newNickName==null || newNickName.isEmpty()) {
				newNickName=userinfo.getNickName();
			}
			if (newBirth==null || newBirth.isEmpty()) {
				newBirth=userinfo.getBirth();
			}
			if (newEmail==null || newEmail.isEmpty()) {
				newEmail=userinfo.getEmail();
			}
			if (newGender==null || newGender.isEmpty()) {
				newGender=userinfo.getGender();
			}
			userinfo.changePassword(newPwd);
			userinfo.changeNickName(newNickName);
			userinfo.changeBirth(newBirth);
			userinfo.changeEmail(newEmail);
			userinfo.changeGender(newGender);
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
