package member.model;

public class ArticleContent {

	private Integer boardNo;
	private String boardContents;

	public ArticleContent(Integer boardNo, String boardContents) {
		this.boardNo = boardNo;
		this.boardContents = boardContents;
	}

	public Integer getBoardNo() {
		return boardNo;
	}

	public String getBoardContents() {
		return boardContents;
	}

}
