package auth.service;

public class Board {

	private int boardNo;
	private String boardTitle;
	private int viewCount;
	
	public Board(int boardNo, String boardTitle, int viewCount) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.viewCount = viewCount;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public int getViewCount() {
		return viewCount;
	}
	
	
}