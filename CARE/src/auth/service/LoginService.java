package auth.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.connection.ConnectionProvider;
import member.dao.UserInfoDao;
import member.model.UserInfo;

public class LoginService {

	private UserInfoDao userinfoDao = new UserInfoDao();

	public User login(String userId, String password) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			UserInfo userinfo = userinfoDao.selectById(conn, userId);
			if (userinfo == null) {
				throw new LoginFailException();
			}
			if (!userinfo.matchPassword(password)) {
				throw new LoginFailException();
			}
			return new User(userinfo.getUserNo(), userinfo.getUserId(), userinfo.getNickName());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public UserInfo userInfo(String userId, String password) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			UserInfo userinfo = userinfoDao.selectById(conn, userId);
			if (userinfo == null) {
				throw new LoginFailException();
			}
			if (!userinfo.matchPassword(password)) {
				throw new LoginFailException();
			}
			return new UserInfo(userinfo.getUserNo(), userinfo.getUserId(), userinfo.getPassword(), 
					userinfo.getName(), userinfo.getNickName(), userinfo.getBirth(), userinfo.getEmail(), 
					userinfo.getGender(), userinfo.getAdminister());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public User selectByUserNo(int userNo) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			UserInfo userinfo = userinfoDao.selectByUserNo(conn, userNo);
			if (userinfo == null) {
				throw new LoginFailException();
			}
			return new User(userinfo.getUserNo(), userinfo.getUserId(), userinfo.getNickName());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
