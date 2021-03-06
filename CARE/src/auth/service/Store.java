package auth.service;

public class Store {

	private String manageNo;
	private int storeNo;
	private float storeAvg;
	private String storeName;
	private int reviewCount;

	public int getReviewCount() {
		return reviewCount;
	}

	public Store(int storeNo,String storeName, int reviewCount) {
		this.storeNo = storeNo;
		this.storeName = storeName;
		this.reviewCount = reviewCount;
	}
	public Store(String manageNo, int storeNo) {
		this.manageNo = manageNo;
		this.storeNo = storeNo;
	}

	public Store(int storeNo, String storeName, float storeAvg) {
		this.storeName = storeName;
		this.storeAvg = storeAvg;
		this.storeNo = storeNo;
	}

	public int getStoreNo() {
		return storeNo;
	}

	public String getManageNo() {
		return manageNo;
	}

	public String getStoreName() {
		return storeName;
	}

	public float getStoreAvg() {
		return storeAvg;
	}
}