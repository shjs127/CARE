package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import jdbc.JdbcUtil;
import member.model.DetailInfo;

public class DetailInfoDao {

	public DetailInfo selectById(Connection conn, int storeNo) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from DETAILINFO where storeNo = ?");
			pstmt.setInt(1, storeNo);
			rs = pstmt.executeQuery();
			DetailInfo detailinfo = null;
			if (rs.next()) {
				detailinfo = new DetailInfo(rs.getInt("storeNo"), rs.getInt("totalSeat"), rs.getInt("socketSeat"),
						rs.getString("dessertSales"), rs.getString("terrace"), rs.getString("roofTop"),
						rs.getString("wifi"), rs.getString("companionDog"), rs.getString("parkingSpace"),
						rs.getString("noKidsZone"), rs.getString("smokingArea"));
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

	public DetailInfo insert(Connection conn, DetailInfo detailinfo) throws SQLException {

		try (PreparedStatement pstmt = conn.prepareStatement("insert into detailinfo values(?,?,?,?,?,?,?,?,?,?,?)")) {

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
}
