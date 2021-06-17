package auth.service;

import java.util.List;

public class MessageListView {

	private List<Message> messageList;
	private int totalMessages, totalPages, currentPage;
	private int messagesPerPage, firstRow, endRow;
	
	public MessageListView(List<Message> messageList,
			int totalMessages, int currentPage,
			int messagesPerPage, int firstRow, int endRow) {
		this.messageList = messageList;
		this.totalMessages = totalMessages;
		this.currentPage = currentPage;
		this.messagesPerPage = messagesPerPage;
		this.firstRow = firstRow;
		this.endRow = endRow;
		setTotalPages();
	}

	private void setTotalPages() {
		if (isEmpty())
			totalPages = 0;
		else
			totalPages = (int)Math.ceil((double)totalMessages / messagesPerPage);
	}
	
	public boolean isEmpty() {
		return totalMessages == 0;
	}

	public List<Message> getMessageList() {
		return messageList;
	}

	public int getTotalMessages() {
		return totalMessages;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getMessagesPerPage() {
		return messagesPerPage;
	}

	public int getFirstRow() {
		return firstRow;
	}

	public int getEndRow() {
		return endRow;
	}

}