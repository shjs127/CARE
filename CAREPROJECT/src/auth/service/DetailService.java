package auth.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import javax.xml.crypto.Data;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.DETAILINFODao;
import member.model.DETAILINFO;

public class DetailService {

	private DETAILINFODao detailinfoDao = new DETAILINFODao();

	public void detail(DetailRequest detailReq) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);

			DETAILINFO detailinfo = detailinfoDao.selectById(conn, detailReq.getStoreNo());
			if (detailinfo != null) {
				JdbcUtil.rollback(conn);
				throw new DuplicateIdException();
			}
			
			detailinfoDao.insert(conn, new DETAILINFO(
				0,detailReq.getTotalSeat() ,detailReq.getSocketSeat(),detailReq.getDessertSales(),detailReq.getTerrace(),
				detailReq.getRoofTop(),detailReq.getWifi(),detailReq.getCompanionDog(),detailReq.getParkingSpace(),detailReq.getNokidsZone(),detailReq.getSmokingArea()));
			conn.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
}
