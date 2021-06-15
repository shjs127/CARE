package auth.service;

public class Store {

	private String manageNo;
	private int storeNo;

	public Store(String manageNo, int storeNo) {
		this.manageNo = manageNo;
		this.storeNo = storeNo;
	}

	public String getManageNo() {
		return manageNo;
	}

	public int getStoreNo() {
		return storeNo;
	}

}