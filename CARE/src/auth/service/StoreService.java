package auth.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import javax.xml.crypto.Data;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.StoreInfoDao;
import member.model.StoreInfo;
import member.model.UserInfo;
import member.dao.DetailInfoDao;
import member.model.DetailInfo;

public class StoreService {

	private StoreInfoDao storeinfoDao = new StoreInfoDao();
	private DetailInfoDao detailinfoDao = new DetailInfoDao();
	private StoreInfoDao storeDao = new StoreInfoDao();

	public int store(StoreRequest storeReq, DetailRequest detailReq) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);

			StoreInfo storeSel = storeinfoDao.selectById(conn, storeReq.getStoreNo());

			if (storeSel != null) {
				JdbcUtil.rollback(conn);
				throw new DuplicateIdException();
			}
			StoreInfo storeinfo = toStore(storeReq);
			int savedStoreNo = storeinfoDao.insert(conn, storeinfo);
			if (savedStoreNo == 0) {
				JdbcUtil.rollback(conn);
				throw new RuntimeException("fail to insert storeinfo");
			}

			DetailInfo detailInfo = new DetailInfo(savedStoreNo, detailReq.getTotalSeat(), detailReq.getSocketSeat(),
					detailReq.getDessertSales(), detailReq.getTerrace(), detailReq.getRoofTop(), detailReq.getWifi(),
					detailReq.getCompanionDog(), detailReq.getParkingSpace(), detailReq.getNokidsZone(),
					detailReq.getSmokingArea());

			DetailInfo savedDetail = detailinfoDao.insert(conn, detailInfo);

			if (savedDetail == null) {
				throw new RuntimeException("fail to insert detailinfo");
			}

			conn.commit();

			return savedStoreNo;
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}

	private StoreInfo toStore(StoreRequest req) {
		return new StoreInfo(0, req.getStoreName(), req.getStorePic(), req.getAddress(), req.getHours(),
				req.getClosedDays(), req.getCallNumber(), req.getManageNo());
	}

	public void store(StoreRequest storeReq) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);

			StoreInfo storeInfo = storeDao.selectById(conn, storeReq.getStoreNo());
			if (storeInfo != null) {
				storeDao.updateApi(conn,
						new StoreInfo(storeReq.getStoreNo(), storeReq.getStoreName(), storeReq.getStorePic(),
								storeReq.getAddress(), storeReq.getHours(), storeReq.getClosedDays(),
								storeReq.getCallNumber(), storeReq.getManageNo()));
			}

			storeDao.insertApi(conn, new StoreInfo(0, storeReq.getStoreName(), null, storeReq.getAddress(), null, null,
					storeReq.getCallNumber(), storeReq.getManageNo()));
			conn.commit();

		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}

}
