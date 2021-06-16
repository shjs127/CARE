package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jdbc.JdbcUtil;
import member.model.Menuinfo;

public class MENUINFODao {

	public Menuinfo selectById(Connection conn, String storeNo) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from menuinfo where storeNo = ?");
			pstmt.setString(1, storeNo);
			rs = pstmt.executeQuery();
			Menuinfo menuinfo = null;
			if (rs.next()) {
				menuinfo = new Menuinfo(
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


	public void insert(Connection conn, Menuinfo menuinfo) throws SQLException {
		try (PreparedStatement pstmt = 
				conn.prepareStatement("insert into menuinfo values(?,?,?,?)")) {

			pstmt.setInt(1, menuinfo.getStoreNo());
			pstmt.setString(2, menuinfo.getMenu());
			pstmt.setInt(3, menuinfo.getPrice());
			pstmt.setString(4, menuinfo.getMenuPic());

	

			pstmt.executeUpdate();
		}
	}

	
	public List<Menuinfo> selectList(Connection conn, int firstRow, int endRow) throws SQLException {
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
				List<Menuinfo> menuinfoList = new ArrayList<Menuinfo>();
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
	private Menuinfo makeMenuinfoFromResultSet(ResultSet rs) {
		// TODO Auto-generated method stub
		return null;
	}


	public static Menuinfo selectByMENUINFOId(Connection conn, int storeNo) {
		// TODO Auto-generated method stub
		return null;
	}
}





