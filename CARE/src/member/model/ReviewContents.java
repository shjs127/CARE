package member.model;

public class ReviewContents {

	private Integer storeNo;
	private String reviewContents;

	public ReviewContents(Integer storeNo, String reviewContents) {
		this.storeNo = storeNo;
		this.reviewContents = reviewContents;
	}

	public Integer getStoreNo() {
		return storeNo;
	}

	public String getReviewContents() {
		return reviewContents;
	}

}
