package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import auth.service.Message;
import jdbc.JdbcUtil;

public class MessageDao {
	private static MessageDao MESSAGEDao = new MessageDao();

	public static MessageDao getInstance() {
		return MESSAGEDao;
	}

	public MessageDao() {
	}

	public int insert(Connection conn, Message message, int userNo, int storeNo) throws SQLException {
		
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("insert into Reviewinfo "
					+ "(reviewNo, userNo, storeNo, avgScore, reviewContents, reviewDate ) values (reviewnum.nextval, ?, ?, ?, ?, sysdate)");
			
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, storeNo);
			pstmt.setDouble(3, message.getAvgScore());
			pstmt.setString(4, message.getReviewContents());
			System.out.println("message.avgScore=" + message.getAvgScore());
			System.out.println("message.reviewContents" + message.getReviewContents());
			return pstmt.executeUpdate();
		} finally {
			JdbcUtil.close(pstmt);
		}
	}

	public Message select(Connection conn, int messageId) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from Reviewinfo where reviewno = ?");
			pstmt.setInt(1, messageId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return null;
			} else {
				return null;
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	private Message makeMessageFromResultSet(ResultSet rs) throws SQLException {
		Message message = new Message(0, 0, 0, 0, null, null);
		message.setReviewNo(rs.getInt("reviewNo"));
		message.setStoreNo(rs.getInt("storeNo"));
		message.setUserNo(rs.getInt("userNo"));
		message.setAvgScore(rs.getDouble("avgScore"));
		message.setReviewContents(rs.getString("reviewContents"));
		message.setReviewDate(rs.getDate("reviewDate"));

		return message;
	}

	public int selectCount(Connection conn) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) from Reviewinfo");
			rs.next();
			return rs.getInt(1);
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}

	public List<Message> selectList(Connection conn, int firstRow, int endRow) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from Reviewinfo " + "order by reviewNo desc");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				List<Message> messageList = new ArrayList<Message>();
				do {
					messageList.add(makeMessageFromResultSet(rs));
				} while (rs.next());
				return messageList;
			} else {
				return Collections.emptyList();
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	public List<Message> selectReviewList(Connection conn, int reviewNo) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from Reviewinfo order by reviewNo desc");
			rs = pstmt.executeQuery();
			List<Message> RvList = new ArrayList<>();
			while (rs.next()) {

					RvList.add(makeMessageFromResultSet(rs));
			}
				return RvList;

		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	public List<Message> selectByUserNo(Connection conn, int userNo) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from Reviewinfo " + "where userNo = ?" + "order by reviewno asc");
			pstmt.setInt(1, userNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				List<Message> messageList = new ArrayList<Message>();
				do {
					messageList.add(makeMessageFromResultSet(rs));
				} while (rs.next());
				return messageList;
			} else {
				return Collections.emptyList();
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	public int delete(Connection conn, int reviewNo) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("delete from Reviewinfo where reviewNo = ?");
			pstmt.setInt(1, reviewNo);
			return pstmt.executeUpdate();
		} finally {
			JdbcUtil.close(pstmt);
		}
	}

}
