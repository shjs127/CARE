package auth.service;
//이수하 추가 파일
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import com.sun.glass.ui.Menu;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.model.MenuInfo;
import member.dao.MenuInfoDao;
import member.dao.StoreInfoDao;


public class GetMenuListViewService {
	
	private MenuInfoDao menuInfoDao = new MenuInfoDao();

	private static GetMenuListViewService instance = new GetMenuListViewService();
	public static GetMenuListViewService getInstance() {
		return instance;
	}
	public GetMenuListViewService() {}

	private static final int MSG_PER_PAGE = 3;

	public MenuListView getMenuListView(int pageNum) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();

			List<MenuInfo> menuInfoList = null;
			int totalMenu = 1;
			System.out.println("totalMenu="+totalMenu);
			int currentPage = pageNum;
			int firstRow = 0, endRow = 0;
			
			if (totalMenu > 0) {
				firstRow = 1;
				endRow = 1;
				menuInfoList = menuInfoDao.selectList(conn, firstRow, endRow);
			} else {
				currentPage = 0;
				menuInfoList = Collections.emptyList();
			}
			return new MenuListView(menuInfoList, totalMenu, currentPage, MSG_PER_PAGE, firstRow, endRow);
		} catch (SQLException e) {
			throw new ServiceException("목록 구하기 실패: " + e.getMessage(), e);
		} finally {
			JdbcUtil.close(conn);
		}
	}

}
