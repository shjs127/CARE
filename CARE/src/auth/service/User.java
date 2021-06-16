package auth.service;

public class User {

	private Integer userNo;
	private String nickName;
	private String userId;
	
	public User(String userId, String nickName) {
		this.userId = userId;
		this.nickName = nickName;
	}
	
	public Integer getUserNo() {
		return userNo;
	}
	public String getNickName() {
		return nickName;
	}
	public String getUserId() {
		return userId;
	}


}
