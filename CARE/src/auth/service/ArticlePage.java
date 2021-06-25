package auth.service;

import java.util.List;

import member.model.BoardInfo;
import member.model.BoardPicInfo;

public class ArticlePage {

	private int total; 
	private int currentPage; 
	private List<BoardInfo> list;  // 2媛� Article 媛앹껜�룷�븿�븳 由ъ뒪�듃
	private List<BoardPicInfo> picList;
	private int totalPages;  // 1
	private int startPage;   // 1
	private int endPage;     // 1
	private int pageV=10;

	public ArticlePage(int total, int currentPage, int size, List<BoardInfo> list) {
		this.total = total;
		this.currentPage = currentPage;
		this.list = list;
		this.pageV = size;
		if (total == 0) {
			totalPages = 0;
			startPage = 0;
			endPage = 0;
		} else {
			totalPages = total / size;  // 2 / 10 = 0
			if (total % size > 0) {     // 2 % 10 = 2
				totalPages++;           // 0 + 1 = 1
			}
			int modVal = currentPage % 5;  // 1
			startPage = currentPage / 5 * 5 + 1;  // 1/5 * 5 + 1 = 1
			if (modVal == 0) startPage -= 5;
			
			endPage = startPage + 4;  // 1+4 = 5
			if (endPage > totalPages) endPage = totalPages;  // 1
		}
	}
	
	public ArticlePage(List<BoardPicInfo> picList) {
		this.picList = picList;
	}

	public int getTotal() {
		return total;
	}

	public boolean hasNoArticles() {
		return total == 0;
	}

	public boolean hasArticles() {
		return total > 0;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public List<BoardInfo> getList() {
		return list;
	}

	public int getStartPage() {
		return startPage;
	}
	
	public int getEndPage() {
		return endPage;
	}
	public int getPageV() {
		return pageV;
	}

	public List<BoardPicInfo> getPicList() {
		return picList;
	}

	public void setPicList(List<BoardPicInfo> picList) {
		this.picList = picList;
	}
	
}
