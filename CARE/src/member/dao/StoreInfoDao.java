package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import auth.service.Store;
import jdbc.JdbcUtil;
import member.model.ReviewInfo;
import member.model.StoreInfo;

public class StoreInfoDao {

	public StoreInfo selectById(Connection conn, int storeNo) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from storeinfo where storeNo = ?");
			pstmt.setInt(1, storeNo);
			rs = pstmt.executeQuery();
			StoreInfo storeinfo = null;
			if (rs.next()) {
				storeinfo = new StoreInfo(rs.getInt("storeNo"), rs.getString("storeName"), rs.getString("storePic"),
						rs.getString("address"), rs.getString("hours"), rs.getString("closedDays"),
						rs.getString("callNumber"), rs.getString("manageNo"));
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

		try (PreparedStatement pstmt = conn
				.prepareStatement("insert into storeinfo" + " values(STORENUM.NEXTVAL,?,?,?,?,?,?,?)")) {

			pstmt.setString(1, storeinfo.getStoreName());
			pstmt.setString(2, storeinfo.getStorePic());
			pstmt.setString(3, storeinfo.getAddress());
			pstmt.setString(4, storeinfo.getHours());
			pstmt.setString(5, storeinfo.getClosedDays());
			pstmt.setString(6, storeinfo.getCallNumber());
			pstmt.setString(7, storeinfo.getManageNo());
			// pstmt.setString(7, storeinfo.getStoreName());
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

	public int selectSearchCount(Connection conn, String searchKeyword) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select count(*) " + "from storeinfo " + "where storeinfo.storename LIKE '%'||?||'%' "
				+ "OR storeinfo.address LIKE '%'||?||'%' " + "order by storeinfo.storeno desc";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchKeyword);
			pstmt.setString(2, searchKeyword);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	// List<STOREINFO> select
	public List<StoreInfo> select(Connection conn, int startRow, int size) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select storeinfo.* " + "from (select rownum as rnum, storeinfo.* "
					+ "from storeinfo " + "order by storeno desc" + ") storeinfo " + "where rnum between ? and ?");
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, size);
			rs = pstmt.executeQuery();
			List<StoreInfo> result = new ArrayList<>();
			while (rs.next()) {
				result.add(convertStore(rs));
			}
			return result;

		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	// List<STOREINFO> avgScore select
	public List<StoreInfo> selectAvgScore(Connection conn, int startRow, int size) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select s.* " + "from (select storeno , AVG(avgscore) as aa from reviewinfo "
					+ "group by storeno order by aa DESC,storeno DESC) r, storeinfo s "
					+ "where r.storeno = s.storeno and rownum between ? and ?");
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, size);
			rs = pstmt.executeQuery();
			List<StoreInfo> result = new ArrayList<>();
			while (rs.next()) {
				result.add(convertStore(rs));
			}
			return result;

		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	// List<STOREINFO> ReviewCount select
	public List<StoreInfo> selectReviewCnt(Connection conn, int startRow, int size) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("SELECT A.* " + "FROM ( " + "SELECT A.*, ROWNUM AS RNUM " + "FROM ("
					+ "SELECT A.* " + "FROM ( " + "SELECT A.*, " + "(SELECT COUNT(1) FROM REVIEWINFO R "
					+ "WHERE A.STORENO = R.STORENO GROUP BY R.STORENO) AS REVIEW_CNT " + "FROM STOREINFO A " + ") A "
					+ "ORDER BY REVIEW_CNT " + ") A " + ") A " + "WHERE RNUM BETWEEN ? AND ?");
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, size);
			rs = pstmt.executeQuery();
			List<StoreInfo> result = new ArrayList<>();
			while (rs.next()) {
				result.add(convertStore(rs));
			}
			return result;

		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	// main select
	public List<StoreInfo> getSearch(Connection conn, int startRow, int size, String searchKeyword)
			throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select storeinfo.* " + "from (select rownum as rnum, storeinfo.* " + "from storeinfo "
				+ "where storeinfo.storename LIKE '%'||?||'%' " + "OR storeinfo.address LIKE '%'||?||'%' "
				+ "order by storeinfo.storeno desc) storeinfo " + "where rnum between ? and ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchKeyword);
			pstmt.setString(2, searchKeyword);
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, size);
			rs = pstmt.executeQuery();
			List<StoreInfo> result = new ArrayList<>();
			while (rs.next()) {
				result.add(convertStore(rs));
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	public static List<StoreInfo> selectByStoreNo(Connection conn, int storeNo) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from storeinfo where storeno= ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, storeNo);

			rs = pstmt.executeQuery();
			List<StoreInfo> result = new ArrayList<>();
			while (rs.next()) {
				;
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	public static List<StoreInfo> selectByUserNo(Connection conn, int userNo) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select s.storeno, s.storename from storeinfo s , favorite f "
				+ "where s.storeno=f.storeno and f.userno=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);

			rs = pstmt.executeQuery();
			List<StoreInfo> result = new ArrayList<>();
			while (rs.next()) {
				StoreInfo storeInfo = new StoreInfo(rs.getInt("storeno"), rs.getString("storename"));
				result.add(storeInfo);
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	private StoreInfo convertStore(ResultSet rs) throws SQLException {
		return new StoreInfo(rs.getInt("storeNo"), rs.getString("storeName"), rs.getString("storePic"),
				rs.getString("address"), rs.getString("hours"), rs.getString("closedDays"), rs.getString("callNumber"),
				rs.getString("manageNo"));
	}

	public void insertApi(Connection conn, StoreInfo storeinfo) throws SQLException {
		try (PreparedStatement pstmt = conn.prepareStatement(
				"insert into storeinfo  (storeno, storename, address, callnumber, manageno) values(STORENUM.NEXTVAL,?,?,?,?)")) {
			pstmt.setString(1, storeinfo.getStoreName());
			pstmt.setString(2, storeinfo.getAddress());
			pstmt.setString(3, storeinfo.getCallNumber());
			pstmt.setString(4, storeinfo.getManageNo());
			pstmt.executeUpdate();
		}
	}

	public void updateApi(Connection conn, StoreInfo storeinfo) throws SQLException {
		try (PreparedStatement pstmt = conn.prepareStatement(
				"update storeinfo set storeName = ?, address = ?, callNumber = ? where manageNo = ?")) {
			pstmt.setString(1, storeinfo.getStoreName());
			pstmt.setString(2, storeinfo.getAddress());
			pstmt.setString(3, storeinfo.getCallNumber());
			pstmt.setString(4, storeinfo.getManageNo());
		}
	}

	public void updateInfo(Connection conn, StoreInfo storeinfo) throws SQLException {
		try (PreparedStatement pstmt = conn
				.prepareStatement("update storeinfo set storeName = ?, storePic = ?, address = ?,"
						+ "hours = ?, closedDays = ?, callNumber = ? ")) {
			pstmt.setString(1, storeinfo.getStoreName());
			pstmt.setString(2, storeinfo.getStorePic());
			pstmt.setString(3, storeinfo.getAddress());
			pstmt.setString(4, storeinfo.getHours());
			pstmt.setString(5, storeinfo.getClosedDays());
			pstmt.setString(6, storeinfo.getCallNumber());

			pstmt.executeUpdate();
		}
	}

	public static StoreInfoDao getInstance() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Store> storeAvgTop(Connection conn, int top) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select r.storeno storeNo, r.aa storeAvg, s.storename storeName  from (select storeno , AVG(avgscore) as aa from reviewinfo "
							+ "group by storeno order by aa DESC,storeno DESC) r, storeinfo s "
							+ "where r.storeno = s.storeno and rownum<=? ");
			pstmt.setInt(1, top);
			rs = pstmt.executeQuery();
			List<Store> result = new ArrayList<>();
			while (rs.next()) {
				result.add(convertStoreAvg(rs));
			}

			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	private Store convertStoreAvg(ResultSet rs) throws SQLException {
		return new Store(rs.getInt("storeNo"), rs.getString("storeName"), rs.getFloat("storeAvg"));

	}

	public float storeAvg(Connection conn, int storeNo) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		float count = 0;
		try {
			pstmt = conn.prepareStatement(
					"select AVG(avgscore) from reviewinfo " + "group by storeno " + "having storeno=?");
			pstmt.setInt(1, storeNo);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				count = rs.getFloat(1);

			}
			return count;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	public List<Store> reviewTop(Connection conn, int top) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("SELECT A.* " + "FROM ( " + "SELECT A.*, ROWNUM AS RNUM " + "FROM ("
					+ "SELECT A.* " + "FROM ( " + "SELECT A.*, " + "(SELECT COUNT(1) FROM REVIEWINFO R "
					+ "WHERE A.STORENO = R.STORENO GROUP BY R.STORENO) AS REVIEW_CNT " + "FROM STOREINFO A " + ") A "
					+ "WHERE NOT REVIEW_CNT IS NULL ORDER BY REVIEW_CNT DESC " + ") A " + ") A " + "WHERE RNUM BETWEEN 1 AND ?");
			pstmt.setInt(1, top);
			rs = pstmt.executeQuery();
			List<Store> result = new ArrayList<>();
			while (rs.next()) {
				result.add(convertReview(rs));
			}
			return result;

		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	private Store convertReview(ResultSet rs) throws SQLException {
		return new Store(
				rs.getInt("storeno"), rs.getString("storename"), rs.getInt("review_cnt")
				);
	}
}
