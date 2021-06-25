package auth.service;

import java.util.Date;
import java.util.Map;

public class MessageRequest {

	private int reviewNo;
	private int userNo;
	private int storeNo;
	private double avgScore;
	private String reviewContents;
	private Date reviewDate;

	public MessageRequest(int reviewNo, int userNo, int storeNo, double avgScore, String reviewContents,
			Date reviewDate) {
		super();
		this.reviewNo = reviewNo;
		this.userNo = userNo;
		this.storeNo = storeNo;
		this.avgScore = avgScore;
		this.reviewContents = reviewContents;
		this.reviewDate = reviewDate;
	}

	public MessageRequest(String userId, Integer userNo2, int reviewNo2, Message message, String content) {
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getStoreNo() {
		return storeNo;
	}

	public void setStoreNo(int storeNo) {
		this.storeNo = storeNo;
	}

	public double getAvgScore() {
		return avgScore;
	}

	public void setAvgScore(double avgScore) {
		this.avgScore = avgScore;
	}

	public String getReviewContents() {
		return reviewContents;
	}

	public void setReviewContents(String reviewContents) {
		this.reviewContents = reviewContents;
	}

	public Date getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}

	public void validate(Map<String, Boolean> errors) {
		if (reviewContents == null || reviewContents.trim().isEmpty()) {
			errors.put("Review", Boolean.TRUE);
		}
	}

}
