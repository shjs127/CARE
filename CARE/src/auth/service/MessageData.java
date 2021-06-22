package auth.service;

import member.model.ReviewContents;

public class MessageData {

	private Message message;
	private ReviewContents content;

	public MessageData(Message message, ReviewContents content) {
		this.message = message;
		this.content = content;
	}

	public Message getMessage() {
		return message;
	}

	public String getContent() {
		return content.getReviewContents();
	}

}
