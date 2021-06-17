package auth.service;

import java.util.Map;

import member.model.writer;

public class WriteRequest {
	
	private writer writer;
	private String boardTitle;
	private String boardContents;

	public WriteRequest(writer writer, String boardTitle, String boardContents) {
		this.writer = writer;
		this.boardTitle = boardTitle;
		this.boardContents = boardContents;
	}
	
	public writer getWriter() {
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
