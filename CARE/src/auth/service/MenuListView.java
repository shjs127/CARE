package auth.service;

import java.util.List;



import member.model.MenuInfo;

public class MenuListView {

	private List<MenuInfo> menuInfoList;
	private int totalMenu, totalPages, currentPage;
	private int menuPerPage, firstRow, endRow;
	
	public MenuListView(List<MenuInfo> menuInfoList,
			int totalMenu, int currentPage,
			int menuPerPage, int firstRow, int endRow) {
		this.menuInfoList = menuInfoList;
		this.totalMenu = totalMenu;
		this.currentPage = currentPage;
		this.menuPerPage = menuPerPage;
		this.firstRow = firstRow;
		this.endRow = endRow;
		setTotalPages();
	}

	private void setTotalPages() {
		if (isEmpty())
			totalPages = 0;
		else
			totalPages = (int)Math.ceil((double)totalMenu / menuPerPage);
	}

	private boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public List<MenuInfo> getMenuInfoList() {
		return menuInfoList;
	}

	public void setMenuInfoList(List<MenuInfo> menuInfoList) {
		this.menuInfoList = menuInfoList;
	}

	public int getTotalMenu() {
		return totalMenu;
	}

	public void setTotalMenu(int totalMenu) {
		this.totalMenu = totalMenu;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getMenuPerPage() {
		return menuPerPage;
	}

	public void setMenuPerPage(int menuPerPage) {
		this.menuPerPage = menuPerPage;
	}

	public int getFirstRow() {
		return firstRow;
	}

	public void setFirstRow(int firstRow) {
		this.firstRow = firstRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
}
	
	