package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import member.model.Favorite;

public class FavoriteDao {

	public Favorite selectCheck(Connection conn, Favorite favorite) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from FAVORITE where USERNO = ? and STORENO=? ");
			pstmt.setInt(1, favorite.getUserNo());
			pstmt.setInt(2, favorite.getStoreNo());
			rs = pstmt.executeQuery();
			
			Favorite favorite1 = null;
			if (rs.next()) {
				favorite1 = new Favorite(
						rs.getInt("userno"),
						rs.getInt("storeno"),
						rs.getString("favoritecheck"));
			}
			return favorite1;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}


	public void insert(Connection conn, Favorite favorite) throws SQLException {
		try (PreparedStatement pstmt = 
				conn.prepareStatement("insert into favorite values(?,?,'y')")) {

			pstmt.setInt(1, favorite.getUserNo());
			pstmt.setInt(2, favorite.getStoreNo());

			pstmt.executeUpdate();
		}
	}


	
	  public void delete(Connection conn, Favorite favorite) throws SQLException{
		  try (PreparedStatement pstmt = conn.prepareStatement(
				  "delete from favorite where userno=? and storeno=? ")) {
			  pstmt.setInt(1, favorite.getUserNo());
			  pstmt.setInt(2,favorite.getStoreNo()); 
	  
			  pstmt.executeUpdate(); } }
	 
}






