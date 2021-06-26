package member.model;

import java.util.List;

public class BoardInfoList {
	private String fileName1;
	private List<BoardPicInfo> files;
	private int boardNo;
	
	public BoardInfoList(String fileName1, List<BoardPicInfo> files) {
		super();
		this.fileName1 = fileName1;
		this.files = files;
	}
	
	public BoardInfoList(int boardNo, List<BoardPicInfo> files) {
		super();
		this.boardNo = boardNo;
		this.files = files;
	}
	

	public BoardInfoList(List<BoardPicInfo> files) {
		super();
		this.files = files;
	}

	public String getFileName1() {
		return fileName1;
	}


	public void setFileName1(String fileName1) {
		this.fileName1 = fileName1;
	}


	public List<BoardPicInfo> getFiles() {
		return files;
	}

	public void setFiles(List<BoardPicInfo> files) {
		this.files = files;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
}

