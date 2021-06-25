package auth.service;

import java.util.Date;

public class Message {

	private int reviewNo;
	private int storeNo;
	private int userNo;
	private double avgScore;
	private String reviewContents;
	private Date reviewDate;

	public Message() {
	}

	public Message(int reviewNo, int storeNo, int userNo, double avgScore, String reviewContents, Date reviewDate) {
		super();
		this.reviewNo = reviewNo;
		this.storeNo = storeNo;
		this.userNo = userNo;
		this.avgScore = avgScore;
		this.reviewContents = reviewContents;
		this.reviewDate = reviewDate;

	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public int getStoreNo() {
		return storeNo;
	}

	public void setStoreNo(int storeNo) {
		this.storeNo = storeNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
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

}