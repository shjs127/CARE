package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import jdbc.JdbcUtil;
import member.model.CommentInfo;

public class CommentInfoDao {

	public CommentInfo selectById(Connection conn, String boardNo) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from COMMENTINFO where BOARDNO = ?");
			pstmt.setString(1, boardNo);
			rs = pstmt.executeQuery();
			CommentInfo commentinfo = null;
			if (rs.next()) {
				commentinfo = new CommentInfo(rs.getInt("boardNo"), rs.getInt("commentNo"), rs.getInt("userNo"),
						rs.getString("commentContents"), toDate(rs.getTimestamp("commentDate")));
			}
			return commentinfo;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	private Date toDate(Timestamp date) {
		return date == null ? null : new Date(date.getTime());
	}

	public void insert(Connection conn, CommentInfo commentinfo) throws SQLException {
		try (PreparedStatement pstmt = conn
				.prepareStatement("insert into commentinfo values(?,COMMENTNUM.NEXTVAL,?,?,?)")) {

			pstmt.setInt(1, commentinfo.getBoardNo());
			pstmt.setInt(2, commentinfo.getUserNo());
			pstmt.setString(3, commentinfo.getCommentContents());
			pstmt.setTimestamp(4, new Timestamp(commentinfo.getCommentDate().getTime()));

			pstmt.executeUpdate();
		}
	}
}
