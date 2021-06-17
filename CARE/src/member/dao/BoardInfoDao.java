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
import member.model.BoardInfo;

public class BoardInfoDao {

	// 寃뚯?��湲� insert
	public BoardInfo insert(Connection conn, BoardInfo boardinfo) throws SQLException {
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement("insert into boardinfo values(BOARDNUM.NEXTVAL,?,?,?,?,0,?)");
			pstmt.setInt(1, boardinfo.getUserNo());
			pstmt.setString(2, boardinfo.getBoardTitle());
			pstmt.setString(3, boardinfo.getBoardContents());
			pstmt.setString(4, boardinfo.getBoardPic());
			pstmt.setTimestamp(5, new Timestamp(boardinfo.getBoardDate().getTime()));
			int insertedCount = pstmt.executeUpdate();

			if (insertedCount > 0) {
				stmt = conn.createStatement();
				rs = stmt.executeQuery("select BOARDNUM.currval from boardinfo");
				if (rs.next()) {
					Integer newNo = rs.getInt(1);
					return new BoardInfo(newNo, boardinfo.getUserNo(), boardinfo.getBoardTitle(),
							boardinfo.getBoardContents(), boardinfo.getBoardPic(), 0, boardinfo.getBoardDate());
				}
			}
			return null;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(pstmt);
		}
	}

	private Timestamp toTimestamp(Date date) {
		return new Timestamp(date.getTime());
	}

	public int selectCount(Connection conn) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) from boardinfo");
			if (rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}

	public List<BoardInfo> select(Connection conn, int startRow, int size) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from ( " + "select row_number() over(order by boardno) num, boardinfo.* "
							+ "from boardinfo order by boardno desc) " + "where num between ? and ? ");
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, size);
			rs = pstmt.executeQuery();
			List<BoardInfo> result = new ArrayList<>();
			while (rs.next()) {
				result.add(convertBoard(rs));
			}
			return result;

		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	private BoardInfo convertBoard(ResultSet rs) throws SQLException {
		return new BoardInfo(rs.getInt("boardno"), rs.getInt("userno"), rs.getString("boardtitle"),
				rs.getString("boardcontents"), rs.getString("boardpic"), rs.getInt("viewcount"),
				rs.getDate("boarddate"));
	}

	private Date toDate(Timestamp timestamp) {
		return new Date(timestamp.getTime());
	}

	public BoardInfo selectById(Connection conn, int boardNo) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from BOARDINFO where BOARDNO = ?");
			pstmt.setInt(1, boardNo);
			rs = pstmt.executeQuery();
			BoardInfo boardinfo = null;
			if (rs.next()) {
				boardinfo = convertBoard(rs);
			}
			return boardinfo;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	public void increaseReadCount(Connection conn, int boardno) throws SQLException {
		try (PreparedStatement pstmt = conn
				.prepareStatement("update boardinfo set viewcount = viewcount + 1 " + "where boardno = ?")) {
			pstmt.setInt(1, boardno);
			pstmt.executeUpdate();
		}
	}
	
	public int delete(Connection conn, int boardNo) throws SQLException {
		try (PreparedStatement pstmt = conn.prepareStatement("delete from BOARDINFO " + "where BOARDNO = ?")) {
			pstmt.setInt(1, boardNo);
			return pstmt.executeUpdate();
		}
	}

//	public BOARDINFO selectById(Connection conn, String boardNo) throws SQLException {
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			pstmt = conn.prepareStatement(
//					"select * from BOARDINFO where BOARDNO = ?");
//			pstmt.setString(1, boardNo);
//			rs = pstmt.executeQuery();
//			BOARDINFO boardinfo = null;
//			if (rs.next()) {
//				boardinfo = new BOARDINFO(
//						rs.getInt("boardNo"),
//						rs.getInt("userNo"), 
//						rs.getString("boardTitle"),
//						rs.getString("boardContents"), 
//						rs.getString("boardPic"), 
//						rs.getInt("viewCount"),
//						toDate(rs.getTimestamp("regdate")));
//			}
//			return boardinfo;
//		} finally {
//			JdbcUtil.close(rs);
//			JdbcUtil.close(pstmt);
//		}
//	}

//	private Date toDate(Timestamp date) {
//		return date == null ? null : new Date(date.getTime());
//	}

//	public void insert(Connection conn, BOARDINFO boardinfo) throws SQLException {
//		try (PreparedStatement pstmt = 
//				conn.prepareStatement("insert into boardinfo values(BOARDNUM.NEXTVAL,?,?,?,?,?,?)")) {
//
//			pstmt.setInt(1, boardinfo.getUserNo());
//			pstmt.setString(2, boardinfo.getBoardTitle());
//			pstmt.setString(3, boardinfo.getBoardContents());
//			pstmt.setString(4, boardinfo.getBoardPic());
//			pstmt.setInt(5, boardinfo.getViewCount());
//			pstmt.setTimestamp(4, new Timestamp(boardinfo.getBoardDate().getTime()));
//	
//
//			pstmt.executeUpdate();
//		}
//	}

	public int update(Connection conn, int boardNo, String boardTitle) throws SQLException {
		try (PreparedStatement pstmt = conn
				.prepareStatement("update boardinfo set BOARDTITLE = ?" 
								+ "where BOARDNO = ?")) {
			pstmt.setString(1, boardTitle);
			pstmt.setInt(2, boardNo);
			pstmt.executeUpdate();
			return pstmt.executeUpdate();
		}
	}

}
