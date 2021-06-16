package auth.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import javax.xml.crypto.Data;


import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.STOREINFODao;
import member.model.STOREINFO;
import member.model.USERINFO;
import member.dao.DETAILINFODao;
import member.model.DETAILINFO;

public class StoreService {

	private STOREINFODao storeinfoDao = new STOREINFODao();
	private DETAILINFODao detailinfoDao = new DETAILINFODao();
	private STOREINFODao storeDao = new STOREINFODao();
	
	//留ㅼ옣 �벑濡앹쓣 �넻�븳 storeinfo, detailinfo ���옣
	public int store(StoreRequest storeReq, DetailRequest detailReq) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			//�뜲�씠�꽣 �솗�씤
			System.out.println("storeReq="+storeReq);
			
			STOREINFO storeSel = storeinfoDao.selectById(conn, storeReq.getManageNo());
			//�뜲�씠�꽣 �솗�씤
			System.out.println("storeSel="+storeSel);
			
			if (storeSel != null) {
				JdbcUtil.rollback(conn);
				throw new DuplicateIdException();
			}
			STOREINFO storeinfo =toStore(storeReq);
			int savedStoreNo = storeinfoDao.insert(conn, storeinfo);
			if (savedStoreNo == 0) {
				JdbcUtil.rollback(conn);
				throw new RuntimeException("fail to insert storeinfo");
			}
					
			  DETAILINFO detailInfo=new DETAILINFO( savedStoreNo, detailReq.getTotalSeat(),
			  detailReq.getSocketSeat(), detailReq.getDessertSales(),
			  detailReq.getTerrace(), detailReq.getRoofTop(), detailReq.getWifi(),
			  detailReq.getCompanionDog(), detailReq.getParkingSpace(),
			  detailReq.getNokidsZone(), detailReq.getSmokingArea() ); 
			  
			  DETAILINFO savedDetail=detailinfoDao.insert(conn, detailInfo); 
			  
			  if (savedDetail == null)
			  { throw new RuntimeException("fail to insert detailinfo"); }
			 
			conn.commit();
			//storeno���옣
			System.out.println("savedStoreNo="+savedStoreNo);

			return savedStoreNo;
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
	private STOREINFO toStore(StoreRequest req) {
		return new STOREINFO(0, req.getStoreName(), 
				req.getStorePic(), req.getAddress(), req.getHours(), 
				req.getClosedDays(), req.getCallNumber(),req.getManageNo());
	}
	
	//api瑜� �넻�빐 storeinfo�뿉 ���옣
	public void store(StoreRequest storeReq) {
		Connection conn  = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			//TODO 以묐났�맂 storeInfo媛� �엳�쓣 寃쎌슦 �뿉�윭瑜� 媛뺤젣濡� 諛쒖깮�떆�궎�뒗寃� �븘�땲�씪 update援щЦ�쑝濡� 蹂�寃쏀븯嫄곕굹 �샊�� �궗�쟾�뿉 諛⑹뼱 �냼�뒪媛� �븘�슂�븿
			STOREINFO storeInfo = storeDao.selectById(conn, storeReq.getManageNo());
			if(storeInfo != null) {
				storeDao.updateApi(conn, new STOREINFO(storeReq.getStoreNo(), storeReq.getStoreName(),storeReq.getStorePic(),
						storeReq.getAddress(), storeReq.getHours(), storeReq.getClosedDays(), storeReq.getCallNumber(), storeReq.getManageNo()));
			}
			
			storeDao.insertApi(conn, new STOREINFO(0, storeReq.getStoreName(), null, storeReq.getAddress(), null, null, storeReq.getCallNumber(), storeReq.getManageNo()));
			conn.commit();
			
		}catch(SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		}finally {
			JdbcUtil.close(conn);
		}
	}

}
