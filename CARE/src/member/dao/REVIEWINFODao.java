package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import jdbc.JdbcUtil;
import member.model.Reviewinfo;

public class REVIEWINFODao {

	public Reviewinfo selectById(Connection conn, int storeNo) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from reviewinfo where storeNo = ?");
			pstmt.setInt(1, storeNo); 
			rs = pstmt.executeQuery();
			Reviewinfo reviewinfo = null;
			if (rs.next()) {
				reviewinfo = new Reviewinfo(
						rs.getInt("reviewNo"),
						rs.getInt("userNo"), 
						rs.getInt("storeNo"),
						rs.getDouble("avgScore"), 
						rs.getString("reviewContents"), 
						toDate(rs.getTimestamp("reviewDate")));
			}
			return reviewinfo;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}


	private Date toDate(Timestamp date) {
		return date == null ? null : new Date(date.getTime());
	}




	public void insert(Connection conn, Reviewinfo reviewinfo) throws SQLException {
		try (PreparedStatement pstmt = 
				conn.prepareStatement("insert into reviewinfo values(REVIEWNUM.NEXTVAL,?,?,?,?,?)")) {

			pstmt.setInt(1, reviewinfo.getReviewNo());
			pstmt.setInt(2, reviewinfo.getUserNo());
			pstmt.setInt(3, reviewinfo.getStoreNo());
			pstmt.setDouble(4, reviewinfo.getAvgScore());
			pstmt.setString(5, reviewinfo.getReviewContents());
			pstmt.setTimestamp(6, new Timestamp(reviewinfo.getReviewDate().getTime()));
	

			pstmt.executeUpdate();
		}
	}


	public static Reviewinfo selectByREVIEWINFOId(Connection conn, int storeNo) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * public void update(Connection conn, reviewinfo reviewinfo) throws SQLException
	 * { try (PreparedStatement pstmt = conn.prepareStatement(
	 * "update reviewinfo set USERNAME = ?, PASSWORD = ? where USERID = ?")) {
	 * pstmt.setString(1, reviewinfo.getName()); pstmt.setString(2,
	 * reviewinfo.getPassword()); pstmt.setString(3, reviewinfo.getUserId());
	 * pstmt.executeUpdate(); } }
	 */
}





