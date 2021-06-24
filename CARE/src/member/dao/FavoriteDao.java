package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jdbc.JdbcUtil;
import member.model.Favorite;
import member.model.StoreInfo;

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
	private static Favorite makeFavoriteFromResultSet(ResultSet rs) throws SQLException {
		Favorite favorite = new Favorite(0, 0, null);
		favorite.setUserNo(rs.getInt("userNo"));
		favorite.setStoreNo(rs.getInt("storeNo"));
		favorite.setFavoriteCheck(rs.getString("favoriteCheck"));
		
		
		return favorite;
	}
	
	
	public static List<Favorite> selectByUserNo(Connection conn, int userNo) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from favorite where userNo= ? order by storeNo asc");
			 pstmt.setInt(1, userNo); 
			
			// pstmt.setInt(2, endRow - firstRow + 1);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				List<Favorite> favoriteList = new ArrayList<Favorite>();
				do {
					favoriteList.add(makeFavoriteFromResultSet(rs));
				} while (rs.next());
				return favoriteList;
			} else {
				return Collections.emptyList();
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	/*
	 * public static List<StoreInfo> selectByStoreNo(Connection conn, int storeNo)
	 * throws SQLException { PreparedStatement pstmt = null; ResultSet rs = null;
	 * try { pstmt = conn.prepareStatement("select * " + "from storeinfo " +
	 * "where storeno= ? " + "order by storeno asc"); pstmt.setInt(1, storeNo);
	 * 
	 * 
	 * // pstmt.setInt(2, endRow - firstRow + 1); rs = pstmt.executeQuery(); if
	 * (rs.next()) { List<StoreInfo> storeInfoList = new ArrayList<StoreInfo>();
	 * 
	 * return storeInfoList; } else { return Collections.emptyList(); } } finally {
	 * JdbcUtil.close(rs); JdbcUtil.close(pstmt); } }
	 */

	
	  public void delete(Connection conn, Favorite favorite) throws SQLException{
		  try (PreparedStatement pstmt = conn.prepareStatement(
				  "delete from favorite where userno=? and storeno=? ")) {
			  pstmt.setInt(1, favorite.getUserNo());
			  pstmt.setInt(2,favorite.getStoreNo()); 
	  
			  pstmt.executeUpdate(); } }



	public static FavoriteDao getInstance() {
		// TODO Auto-generated method stub
		return null;
	}
	 
}






