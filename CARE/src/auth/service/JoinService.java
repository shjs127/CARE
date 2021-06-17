package auth.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import javax.xml.crypto.Data;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.UserInfoDao;
import member.model.UserInfo;

public class JoinService {

	private UserInfoDao userinfoDao = new UserInfoDao();

	public void join(JoinRequest joinReq) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);

			UserInfo userinfo = userinfoDao.selectById(conn, joinReq.getUserId());
			if (userinfo != null) {
				JdbcUtil.rollback(conn);
				throw new DuplicateIdException();
			}
			
			userinfoDao.insert(conn, new UserInfo(0,joinReq.getUserId() ,joinReq.getPassword(),joinReq.getName(),joinReq.getNickName(),joinReq.getBirth(),joinReq.getEmail(),joinReq.getGender(),"x"));
			conn.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
}
