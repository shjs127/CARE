package auth.service;

import java.util.Map;

/*import javafx.scene.control.IndexRange;*/

public class ModifyRequest {

	private String userId;
	private int userNo;
	private int boardNo;
	private String boardTitle;
	private String boardContents;

	public ModifyRequest(String userId, int userNo, int boardNo, String boardTitle, String boardContents) {
		this.userId = userId;
		this.userNo = userNo;
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardContents = boardContents;
	}

	public String getUserId() {
		return userId;
	}

	public int getUserNo() {
		return userNo;
	}
	
	public int getBoardNo() {
		return boardNo;
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
