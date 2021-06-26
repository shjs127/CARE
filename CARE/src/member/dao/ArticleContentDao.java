package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import member.model.ArticleContent;

public class ArticleContentDao {

	public ArticleContent insert(Connection conn, ArticleContent content) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("insert into BOARDINFO " + "(boardNo, boardcontents) values (?,?)");
			pstmt.setInt(1, content.getBoardNo());
			pstmt.setString(2, content.getBoardContents());
			int insertedCount = pstmt.executeUpdate();
			if (insertedCount > 0) {
				return content;
			} else {
				return null;
			}
		} finally {
			JdbcUtil.close(pstmt);
		}
	}

	public ArticleContent selectById(Connection conn, int boardNo) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from BOARDINFO where boardNo = ?");
			pstmt.setInt(1, boardNo);
			rs = pstmt.executeQuery();
			ArticleContent content = null;
			if (rs.next()) {
				content = new ArticleContent(rs.getInt("boardNo"), rs.getString("boardContents"));
			}
			return content;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	public int update(Connection conn, int boardNo, String boardContents) throws SQLException {
		try (PreparedStatement pstmt = conn
				.prepareStatement("update BOARDINFO set boardContents = ?" + "where boardNo = ?")) {
			pstmt.setString(1, boardContents);
			pstmt.setInt(2, boardNo);
			return pstmt.executeUpdate();
		}
	}

	public int delete(Connection conn, int boardNo) throws SQLException {
		try (PreparedStatement pstmt = conn.prepareStatement("delete from BOARDINFO " + "where boardNo = ?")) {
			pstmt.setInt(1, boardNo);
			return pstmt.executeUpdate();
		}
	}

}
