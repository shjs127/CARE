package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import jdbc.JdbcUtil;
import member.model.UserInfo;

public class UserInfoDao {

	public UserInfo selectById(Connection conn, String userId) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from USERINFO where userId = ?");
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			UserInfo userinfo = null;
			if (rs.next()) {
				userinfo = new UserInfo(
						rs.getInt("userNo"),
						rs.getString("userId"), 
						rs.getString("password"),
						rs.getString("userName"), 
						rs.getString("nickName"), 
						rs.getString("birth"),
						rs.getString("email"),
						rs.getString("gender"),
						rs.getString("administer"));
			}
			return userinfo;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}


	public UserInfo selectByUserNo(Connection conn, int userNo) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from USERINFO where userNo = ?");
			pstmt.setInt(1, userNo);
			rs = pstmt.executeQuery();
			UserInfo userinfo = null;
			if (rs.next()) {
				userinfo = new UserInfo(
						rs.getInt("userNo"),
						rs.getString("userId"), 
						rs.getString("password"),
						rs.getString("userName"), 
						rs.getString("nickName"), 
						rs.getString("birth"),
						rs.getString("email"),
						rs.getString("gender"),
						rs.getString("administer"));
			}
			return userinfo;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	public void insert(Connection conn, UserInfo userinfo) throws SQLException {
		try (PreparedStatement pstmt = 
				conn.prepareStatement("insert into USERINFO values(USERNUM.NEXTVAL,?,?,?,?,?,?,?,?)")) {

			pstmt.setString(1, userinfo.getUserId());
			pstmt.setString(2, userinfo.getPassword());
			pstmt.setString(3, userinfo.getName());
			pstmt.setString(4, userinfo.getNickName());
			pstmt.setString(5, userinfo.getBirth());
			pstmt.setString(6, userinfo.getEmail());
			pstmt.setString(7, userinfo.getGender());
			pstmt.setString(8, userinfo.getAdminister());
	

			pstmt.executeUpdate();
		}
	}

	public void update(Connection conn, UserInfo userinfo) throws SQLException {
		try (PreparedStatement pstmt = conn.prepareStatement(
				"update USERINFO set PASSWORD = ?, NICKNAME = ?, BIRTH = ? ,EMAIL = ?, GENDER = ? where USERID = ?")) {
			pstmt.setString(1, userinfo.getPassword());
			pstmt.setString(2, userinfo.getNickName());
			pstmt.setString(3, userinfo.getBirth());
			pstmt.setString(4, userinfo.getEmail());
			pstmt.setString(5, userinfo.getGender());
			pstmt.setString(6, userinfo.getUserId());
			pstmt.executeUpdate();
			}	
			}
}





