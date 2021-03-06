package member.model;

public class Favorite {

	private int userNo;
	private int storeNo;
	private String favoriteCheck;

	public Favorite(int userNo, int storeNo, String favoriteCheck) {

		this.userNo = userNo;
		this.storeNo = storeNo;
		this.favoriteCheck = favoriteCheck;
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

	public String getFavoriteCheck() {
		return favoriteCheck;
	}

	public void setFavoriteCheck(String favoriteCheck) {
		this.favoriteCheck = favoriteCheck;
	}

	
}