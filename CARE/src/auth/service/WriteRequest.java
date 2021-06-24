package auth.service;

import java.util.List;

import member.model.BoardPicInfo;
import member.model.Writer;

public class WriteRequest {
	
	private int boardNo;
	private Writer writer;
	private String boardTitle;
	private String boardContents;
	private List<BoardPicInfo> boardPicInfoList;
	
	public WriteRequest(member.model.Writer writer, String boardTitle, String boardContents,
			List<BoardPicInfo> boardPicInfoList) {
		super();
		this.writer = writer;
		this.boardTitle = boardTitle;
		this.boardContents = boardContents;
		this.boardPicInfoList = boardPicInfoList;
	}
	
	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public Writer getWriter() {
		return writer;
	}

	public void setWriter(Writer writer) {
		this.writer = writer;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContents() {
		return boardContents;
	}

	public void setBoardContents(String boardContents) {
		this.boardContents = boardContents;
	}

	public List<BoardPicInfo> getBoardPicInfoList() {
		return boardPicInfoList;
	}

	public void setBoardPicInfoList(List<BoardPicInfo> boardPicInfoList) {
		this.boardPicInfoList = boardPicInfoList;
	}
	
	

	
}
