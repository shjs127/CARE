package auth.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.connection.ConnectionProvider;
import member.dao.DETAILINFODao;
import member.dao.MENUINFODao;
import member.dao.REVIEWINFODao;
import member.dao.STOREINFODao;
import member.dao.USERINFODao;
import member.model.Detailinfo;
import member.model.Menuinfo;
import member.model.Reviewinfo;
import member.model.Storeinfo;


public class FoodDetailsService {
	
	private MENUINFODao menuInfoDao = new MENUINFODao();
	private REVIEWINFODao reviewInfoDao = new REVIEWINFODao();
	private DETAILINFODao detailInfoDao = new DETAILINFODao();
	private STOREINFODao storeInfoDao = new STOREINFODao();
	
	public  Detailinfo detailInfo(int storeNo) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			Detailinfo detailinfo = detailInfoDao.selectById(conn, storeNo);
			if (detailinfo == null) {
				//throw new LoginFailException();
			}
			
			return detailinfo;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Detailinfo DETAILINFO(int storeNo) {
		// TODO Auto-generated method stub
		return null;
	}

	

		public Reviewinfo reviewInfo(int storeNo) {
			try (Connection conn = ConnectionProvider.getConnection()) {
				Reviewinfo reviewinfo = reviewInfoDao.selectById(conn, storeNo);
				if (reviewinfo == null) {
					//throw new LoginFailException();
				}
				
				return reviewinfo;
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

		public Reviewinfo REVIEWINFO(int storeNo) {
			// TODO Auto-generated method stub
			return null;
		}

		public Menuinfo menuInfo(int storeNo) {
			try (Connection conn = ConnectionProvider.getConnection()) {
				Menuinfo menuinfo = menuInfoDao.selectById(conn, storeNo);
				if (menuinfo == null) {
					
				}
				
				
				return menuinfo;
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

		public  Menuinfo MENUINFO(int storeNo) {
			// TODO Auto-generated method stub
			return null;
		}

		public Storeinfo storeInfo(int storeNo) {
			try (Connection conn = ConnectionProvider.getConnection()) {
				Storeinfo storeinfo = storeInfoDao.selectById(conn, storeNo);
				if (storeinfo == null) {

				}
				
				return storeinfo;
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

		public Storeinfo STOREINFO(int storeNo) {
			// TODO Auto-generated method stub
			return null;
		}

}
		








	

	
	
	
	

