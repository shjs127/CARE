package auth.service;

import java.util.Map;

import member.model.Writer;

public class WriteRequest {
	
	private Writer writer;
	private String boardTitle;
	private String boardContents;

	public WriteRequest(Writer writer, String boardTitle, String boardContents) {
		this.writer = writer;
		this.boardTitle = boardTitle;
		this.boardContents = boardContents;
	}
	
	public Writer getWriter() {
		return writer;
	}


	public String getBoardTitle() {
		return boardTitle;
	}

	public String getBoardContents() {
		return boardContents;
	}

	public void validate(Map<String, Boolean> errors) {
		if (boardTitle == null || boardTitle.trim().isEmpty()) {
			errors.put("title", Boolean.TRUE);
		}
	}
}
