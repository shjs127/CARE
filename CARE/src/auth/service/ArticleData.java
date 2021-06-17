package auth.service;

import member.model.ArticleContent;
import member.model.BOARDINFO;

public class ArticleData {

	private BOARDINFO boardInfo;
	private ArticleContent content;

	public ArticleData(BOARDINFO boardInfo, ArticleContent content) {
		this.boardInfo = boardInfo;
		this.content = content;
	}

	public BOARDINFO getBoardInfo() {
		return boardInfo;
	}

	public String getContent() {
		return content.getBoardContents();
	}

}
