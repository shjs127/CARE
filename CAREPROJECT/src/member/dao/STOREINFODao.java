package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jdbc.JdbcUtil;
import member.model.STOREINFO;
import member.model.BOARDINFO;

public class STOREINFODao {

	public static STOREINFO selectById(Connection conn, String manageNo) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from STOREINFO where manageNo = ?");
			pstmt.setString(1, manageNo);
			rs = pstmt.executeQuery();
			STOREINFO storeinfo = null;
			if (rs.next()) {
				storeinfo = new STOREINFO(
						rs.getInt("storeNo"),
						rs.getString("storeName"), 
						rs.getString("storePic"),
						rs.getString("address"), 
						rs.getString("hours"), 
						rs.getString("closedDay"),
						rs.getString("callNumber"),
						rs.getString("manageNo"));
			}
			return storeinfo;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	public int insert(Connection conn, STOREINFO storeinfo) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		
		try(PreparedStatement pstmt = 
				conn.prepareStatement("insert into STOREINFO"
						+ " values(STORENUM.NEXTVAL,?,?,?,?,?,?,?)")) {

			pstmt.setString(1, storeinfo.getStoreName());
			pstmt.setString(2, storeinfo.getStorePic());
			pstmt.setString(3, storeinfo.getAddress());
			pstmt.setString(4, storeinfo.getHours());
			pstmt.setString(5, storeinfo.getClosedDays());
			pstmt.setString(6, storeinfo.getCallNumber());
			pstmt.setString(7, storeinfo.getManageNo());
			//pstmt.setString(7, storeinfo.getStoreName());
			int insertedCount = pstmt.executeUpdate();
			
			if (insertedCount > 0) {
				stmt = conn.createStatement();
				rs = stmt.executeQuery("select STORENUM.currval from dual");
				if (rs.next()) {
					Integer newNo = rs.getInt(1);
					return newNo;
				}
			}
			return 0;
		}
}

	public int selectCount(Connection conn) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) from storeinfo");
			if (rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}
	
	//List<STOREINFO> select
		public List<STOREINFO> select(Connection conn, int startRow, int size) throws SQLException{
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				pstmt = conn.prepareStatement("select * from ("
						+ "select row_number() over(order by storeno) num, storeinfo.*"
						+ "from storeinfo order by storeno  desc)"
						+ "where num between ? and ?");
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, size);
				rs = pstmt.executeQuery();
				List<STOREINFO> result = new ArrayList<>();
				while(rs.next()) {
					result.add(convertStore(rs));
				}
				return result;
				
			}finally {
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
			}
		}
	
		private STOREINFO convertStore(ResultSet rs) throws SQLException {
			return new STOREINFO(rs.getInt("storeNo"),
								rs.getString("storeName"), 
								rs.getString("storePic"),
								rs.getString("address"), 
								rs.getString("hours"), 
								rs.getString("closedDays"),
								rs.getString("callNumber"),
								rs.getString("manageNo"));
		}

		public void insertApi(Connection conn, STOREINFO storeinfo) throws SQLException {
			try (PreparedStatement pstmt = 
					conn.prepareStatement("insert into storeinfo  (storeno, storename, address, callnumber, manageno) values(STORENUM.NEXTVAL,?,?,?,?)")) {
				pstmt.setString(1, storeinfo.getStoreName());
				pstmt.setString(2, storeinfo.getAddress());
				pstmt.setString(3, storeinfo.getCallNumber());
				pstmt.setString(4, storeinfo.getManageNo());
				pstmt.executeUpdate();
			}
		}
		
		public void updateApi(Connection conn, STOREINFO storeinfo) throws SQLException {
			try (PreparedStatement pstmt = conn.prepareStatement("update storeinfo set storename = ?, address = ?, callnumber = ? where manageno = ?")){
				pstmt.setString(1, storeinfo.getStoreName());
				pstmt.setString(2, storeinfo.getAddress());
				pstmt.setString(3, storeinfo.getCallNumber());
				pstmt.setString(4, storeinfo.getManageNo());
			}
		}
		
		public void updateInfo(Connection conn, STOREINFO storeinfo) throws SQLException{
			try(PreparedStatement pstmt = conn.prepareStatement("update storeinfo set storename = ?, storepic = ?, address = ?,"
					+ "hours = ?, closedays = ?, callnumber = ? ")){
				pstmt.setString(1, storeinfo.getStoreName());
				pstmt.setString(2, storeinfo.getStorePic());
				pstmt.setString(3, storeinfo.getAddress());
				pstmt.setString(4, storeinfo.getHours());
				pstmt.setString(5, storeinfo.getClosedDays());
				pstmt.setString(6, storeinfo.getCallNumber());
				
				pstmt.executeUpdate();
			}
}
}




