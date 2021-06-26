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

import auth.service.Board;
import auth.service.WriteRequest;
import jdbc.JdbcUtil;
import member.model.BoardInfo;
import member.model.BoardPicInfo;

public class BoardInfoDao {

	public Integer insert(Connection conn, BoardInfo boardinfo) throws SQLException {
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement("insert into boardinfo values(BOARDNUM.NEXTVAL,?,?,?,0,?)");
			pstmt.setInt(1, boardinfo.getUserNo());
			pstmt.setString(2, boardinfo.getBoardTitle());
			pstmt.setString(3, boardinfo.getBoardContents());
			pstmt.setTimestamp(4, new Timestamp(boardinfo.getBoardDate().getTime()));
			int insertedCount = pstmt.executeUpdate();

			if (insertedCount > 0) {
				stmt = conn.createStatement();
				rs = stmt.executeQuery("select BOARDNUM.currval from boardinfo");
				if (rs.next()) {
					Integer newNo = rs.getInt(1);
					return newNo;
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

	public int searchCount(Connection conn, String search) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		String sql = "select count(*) from boardinfo WHERE BOARDTITLE LIKE '%'||?||'%' OR BOARDCONTENTS LIKE '%'||?||'%'";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search);
			pstmt.setString(2, search);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
			return count;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	public List<BoardInfo> search(Connection conn, int startRow, int size, String search) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select boardinfo.* from (select rownum as rnum, boardinfo.* from boardinfo "
					+ "WHERE boardinfo.BOARDTITLE LIKE '%'||?||'%' OR boardinfo.BOARDCONTENTS LIKE '%'||?||'%' "
					+ "order by BOARDNO desc) boardinfo " + "where rnum between ? and ? ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search);
			pstmt.setString(2, search);
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, size);
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

	public List<BoardInfo> select(Connection conn, int startRow, int size) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select boardinfo.* from (select rownum as rnum, boardinfo.* from boardinfo order by BOARDNO desc) boardinfo "
							+ "where rnum between ? and ? ");
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
				rs.getString("boardcontents"), rs.getInt("viewcount"), rs.getDate("boarddate"));
	}
	
	private int convertBoardNo(ResultSet rs) throws SQLException{
		return rs.getInt("nextNo");
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

	public int update(Connection conn, int boardNo, String boardTitle) throws SQLException {
		try (PreparedStatement pstmt = conn
				.prepareStatement("update boardinfo set BOARDTITLE = ?" + "where BOARDNO = ?")) {
			pstmt.setString(1, boardTitle);
			pstmt.setInt(2, boardNo);
			pstmt.executeUpdate();
			return pstmt.executeUpdate();
		}
	}
	
	public int picUpdate(Connection conn, int boardNo, String boardPic1) throws SQLException {
		try (PreparedStatement pstmt = conn
				.prepareStatement("update BOARDPIC set BOARDPIC1 = ?" + "where BOARDNO = ?")) {
			pstmt.setString(1, boardPic1);
			pstmt.setInt(2, boardNo);
			pstmt.executeUpdate();
			return pstmt.executeUpdate();
		}
	}

	public int PicInsert(Connection conn, WriteRequest writeRequest) throws SQLException {
		try (PreparedStatement pstmt = conn
				.prepareStatement("insert into BoardPic " + "(BoardNo, BoardPic1) values (?, ?) ")) {
			pstmt.setInt(1, writeRequest.getBoardNo());
			if(writeRequest.getBoardPicInfoList().size()==0) {
				pstmt.setNString(2, null);
			}else {
			pstmt.setString(2, writeRequest.getBoardPicInfoList().get(0).getBoardPic1());
			}
			return pstmt.executeUpdate();
	}
	}
	public List<BoardPicInfo> selectByBoardNo(Connection conn, int boardNo) throws SQLException {
		ResultSet rs = null;
		try (PreparedStatement pstmt = conn.prepareStatement("select * from BoardPic " + "where boardNo = ? ")) {
			pstmt.setInt(1, boardNo);
			rs = pstmt.executeQuery();
			List<BoardPicInfo> result = new ArrayList<>();
			while (rs.next()) {
				result.add(convertBoardInfo(rs));
			}
			return result;
		}
	}

	private BoardPicInfo convertBoardInfo(ResultSet rs) throws SQLException {
		return new BoardPicInfo(rs.getString("boardPic1"));
	}

	public List<Board> boardViewTop(Connection conn, int top) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select b.boardno bno, b.boardtitle btitle, b.vc bvc from ( "
					+ "select boardno , boardtitle, viewcount as vc from boardinfo "
					+ "order by vc DESC ) b "
					+ "where ROWNUM <= ? ");
			pstmt.setInt(1, top);
			rs = pstmt.executeQuery();
			List<Board> result = new ArrayList<>();
			while (rs.next()) {
				result.add(convertBoardTop(rs));
			}

			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	private Board convertBoardTop(ResultSet rs) throws SQLException {
		return new Board(rs.getInt("bno"), rs.getString("btitle"), rs.getInt("bvc"));

	}

	public int nextView(Connection conn, int boardNo) throws SQLException {
		ResultSet rs = null;
		try (PreparedStatement pstmt = conn.prepareStatement(" select * " + 
				" from( " + 
				" select boardNo, " + 
				" lead(boardno) over (order by boardno) nextNo " + 
				" from boardinfo order by boardNo " + 
				" ) " + 
				" where boardNo = ? ");
				) {
			pstmt.setInt(1, boardNo);
			rs = pstmt.executeQuery();
			int nextBoardNo = 0;
			if (rs.next()) {
				nextBoardNo = convertBoardNo(rs);
			}
			return nextBoardNo;
		}
	}
	
	public int prevView(Connection conn, int boardNo) throws SQLException {
		ResultSet rs = null;
		try (PreparedStatement pstmt = conn.prepareStatement(" select * " + 
				" from( " + 
				" select boardNo, " + 
				" lag(boardno) over (order by boardno) nextNo " + 
				" from boardinfo order by boardNo " + 
				" ) " + 
				" where boardNo = ? ");
				) {
			pstmt.setInt(1, boardNo);
			rs = pstmt.executeQuery();
			int prevBoardNo = 0;
			if (rs.next()) {
				prevBoardNo = convertBoardNo(rs);
			}
			return prevBoardNo;
		}
	}

}
