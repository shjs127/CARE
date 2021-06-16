package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import jdbc.JdbcUtil;
import member.model.Detailinfo;
import member.model.Storeinfo;

public class DETAILINFODao {

	public Detailinfo selectById(Connection conn, String manageNo) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from Detailinfo where manageNo = ?");
			pstmt.setString(1, manageNo);
			rs = pstmt.executeQuery();
			Detailinfo detailinfo = null;
			if (rs.next()) {
				detailinfo = new Detailinfo(
						rs.getInt("storeNo"),
						rs.getInt("totalSeat"), 
						rs.getInt("socketSeat"),
						rs.getString("dessertSales"), 
						rs.getString("terrace"),
						rs.getString("roofTop"),
						rs.getString("wifi"),
						rs.getString("companionDog"),
						rs.getString("parkingSpace"),
						rs.getString("noKidsZone"),
						rs.getString("smokingArea"));
			}
			return detailinfo;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}


	private Date toDate(Timestamp date) {
		return date == null ? null : new Date(date.getTime());
	}




	public Detailinfo insert(Connection conn, Detailinfo detailinfo) throws SQLException {

		try (PreparedStatement pstmt = 
				conn.prepareStatement("insert into Detailinfo values(?,?,?,?,?,?,?,?,?,?,?)")) {

			pstmt.setInt(1, detailinfo.getStoreNo());
			pstmt.setInt(2, detailinfo.getTotalSeat());
			pstmt.setInt(3, detailinfo.getSocketSeat());
			pstmt.setString(4, detailinfo.getDessertSales());
			pstmt.setString(5, detailinfo.getTerrace());
			pstmt.setString(6, detailinfo.getRoofTop());
			pstmt.setString(7, detailinfo.getWifi());
			pstmt.setString(8, detailinfo.getCompanionDog());
			pstmt.setString(9, detailinfo.getParkingSpace());
			pstmt.setString(10, detailinfo.getNoKidsZone());
			pstmt.setString(11, detailinfo.getSmokingArea());
	
			pstmt.executeUpdate();
		}
		return detailinfo;
	}


	public static Detailinfo selectByDETAILINFOId(Connection conn, int storeNo) {
		// TODO Auto-generated method stub
		return null;
	}

}





