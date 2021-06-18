package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.JdbcUtil;
import member.model.StoreInfo;

public class StoreInfoDao {

	public StoreInfo selectById(Connection conn, int storeNo) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from storeinfo where storeNo = ?");
			pstmt.setInt(1, storeNo);
			rs = pstmt.executeQuery();
			StoreInfo storeinfo = null;
			if (rs.next()) {
				storeinfo = new StoreInfo(
						rs.getInt("storeNo"),
						rs.getString("storeName"), 
						rs.getString("storePic"),
						rs.getString("address"), 
						rs.getString("hours"), 
						rs.getString("closedDays"),
						rs.getString("callNumber"),
						rs.getString("manageNo"));
			}
			return storeinfo;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	public int insert(Connection conn, StoreInfo storeinfo) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		
		try(PreparedStatement pstmt = 
				conn.prepareStatement("insert into storeinfo"
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
		public List<StoreInfo> select(Connection conn, int startRow, int size) throws SQLException{
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				pstmt = conn.prepareStatement("select * from ("
						+ "select row_number() over(order by storeNo) num, storeinfo.*"
						+ "from storeinfo order by storeNo  desc)"
						+ "where num between ? and ?");
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, size);
				rs = pstmt.executeQuery();
				List<StoreInfo> result = new ArrayList<>();
				while(rs.next()) {
					result.add(convertStore(rs));
				}
				return result;
				
			}finally {
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
			}
		}
	
		private StoreInfo convertStore(ResultSet rs) throws SQLException {
			return new StoreInfo(rs.getInt("storeNo"),
								rs.getString("storeName"), 
								rs.getString("storePic"),
								rs.getString("address"), 
								rs.getString("hours"), 
								rs.getString("closedDays"),
								rs.getString("callNumber"),
								rs.getString("manageNo"));
		}

		public void insertApi(Connection conn, StoreInfo storeinfo) throws SQLException {
			try (PreparedStatement pstmt = 
					conn.prepareStatement("insert into storeinfo  (storeno, storename, address, callnumber, manageno) values(STORENUM.NEXTVAL,?,?,?,?)")) {
				pstmt.setString(1, storeinfo.getStoreName());
				pstmt.setString(2, storeinfo.getAddress());
				pstmt.setString(3, storeinfo.getCallNumber());
				pstmt.setString(4, storeinfo.getManageNo());
				pstmt.executeUpdate();
			}
		}
		
		public void updateApi(Connection conn, StoreInfo storeinfo) throws SQLException {
			try (PreparedStatement pstmt = conn.prepareStatement("update storeinfo set storeName = ?, address = ?, callNumber = ? where manageNo = ?")){
				pstmt.setString(1, storeinfo.getStoreName());
				pstmt.setString(2, storeinfo.getAddress());
				pstmt.setString(3, storeinfo.getCallNumber());
				pstmt.setString(4, storeinfo.getManageNo());
			}
		}
		
		public void updateInfo(Connection conn, StoreInfo storeinfo) throws SQLException{
			try(PreparedStatement pstmt = conn.prepareStatement("update storeinfo set storeName = ?, storePic = ?, address = ?,"
					+ "hours = ?, closedDays = ?, callNumber = ? ")){
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




