package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jdbc.JdbcUtil;
import member.model.MenuInfo;

public class MenuInfoDao {

	public MenuInfo selectById(Connection conn, int storeNo) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from menuinfo where storeNo = ?");
			pstmt.setInt(1, storeNo);
			rs = pstmt.executeQuery();
			MenuInfo menuinfo = null;
			if (rs.next()) {
				menuinfo = new MenuInfo(
						rs.getInt("storeNo"),
						rs.getString("menu"),
						rs.getInt("price"), 
						rs.getString("menuPic"));
			}
			return menuinfo;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}


	public void insert(Connection conn, MenuInfo menuinfo) throws SQLException {
		try (PreparedStatement pstmt = 
				conn.prepareStatement("insert into menuinfo values(?,?,?,?)")) {

			pstmt.setInt(1, menuinfo.getStoreNo());
			pstmt.setString(2, menuinfo.getMenu());
			pstmt.setInt(3, menuinfo.getPrice());
			pstmt.setString(4, menuinfo.getMenuPic());

	

			pstmt.executeUpdate();
		}
	}

	
	public List<MenuInfo> selectList(Connection conn, int firstRow, int endRow) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from(select row_number() over(order by menuinfo.storeno) num, menuinfo.*"
					+ "from storeinfo, menuinfo where storeinfo.storeno = menuinfo.storeno"
					+ "order by menuinfo.storeno desc)"
					+ "where num between ? and ?");
			pstmt.setInt(1, firstRow - 1);
			pstmt.setInt(2, endRow - firstRow + 1);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				List<MenuInfo> menuinfoList = new ArrayList<MenuInfo>();
				do {
					menuinfoList.add(makeMenuinfoFromResultSet(rs));
				} while (rs.next());
				return menuinfoList;
			} else {
				return Collections.emptyList();
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	private MenuInfo makeMenuinfoFromResultSet(ResultSet rs) {
		// TODO Auto-generated method stub
		return null;
	}


}





