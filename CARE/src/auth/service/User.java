package auth.service;

public class User {

	private Integer userNo;
	private String userId;
	private String password;
	private String userName;
	private String nickName;
	private String email;
	private String gender;
	
	public User(Integer userNo, String userId, String nickName) {
		this.userNo = userNo;
		this.userId = userId;
		this.nickName = nickName;
	}	
	public User(String userId, String password, String userName,String nickName, String email, String gender ) {
		this.userId = userId;
		this.password = password;
		this.userName= userName;
		this.nickName = nickName;
		this.email = email;
		this.gender = gender;
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
	public String getUserName() {
		return userName;
	}	
	public String getEmail() {
		return email;
	}
	public String getGender() {
		return gender;
	}
	public String getPassword() {
		return password;
	}
}
