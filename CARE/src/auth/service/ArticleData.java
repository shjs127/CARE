package auth.service;

import member.model.ArticleContent;
import member.model.BoardInfo;

public class ArticleData {

	private BoardInfo boardInfo;
	private ArticleContent content;

	public ArticleData(BoardInfo boardInfo, ArticleContent content) {
		this.boardInfo = boardInfo;
		this.content = content;
	}
	public ArticleData(BoardInfo boardInfo) {
		this.boardInfo = boardInfo;
	}

	public BoardInfo getBoardInfo() {
		return boardInfo;
	}

	public String getContent() {
		return content.getBoardContents();
	}

}
