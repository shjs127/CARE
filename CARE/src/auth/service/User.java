package auth.service;

public class User {

	private Integer userNo;
	private String nickName;
	private String userId;

	
	public User(Integer userNo, String userId, String nickName) {
		this.userNo = userNo;
		this.userId = userId;
		this.nickName = nickName;
	}
	
	public Integer getUserNo() {
		return userNo;
	}

	public String getUserId() {
		return userId;
	}

	public String getNickName() {
		return nickName;
	}

}
