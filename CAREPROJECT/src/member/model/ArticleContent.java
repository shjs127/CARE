package member.model;

public class ArticleContent {

	private Integer boardNo;
	private String boardContents;

	public ArticleContent(Integer boardNo, String boardContents) {
		this.boardNo = boardNo;
		this.boardContents = boardContents;
	}

	public Integer getboardNo() {
		return boardNo;
	}

	public String getboardContents() {
		return boardContents;
	}

}
