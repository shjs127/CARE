package member.model;


public class UserInfo {

	private int userNo;
	private String userId;
	private String password;
	private String name;
	private String nickName;
	private String birth;
	private String email;
	private String gender;
	private String administer;

	public UserInfo(int userNo, String userId, String password, String name, String nickName, String birth, String email,
			String gender, String administer) {
		this.userNo = userNo;
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.nickName = nickName;
		this.birth = birth;
		this.email = email;
		this.gender = gender;
		this.administer = administer;
	}

	public String getUserId() {
		return userId;
	}
	public String getAdminister() {
		return administer;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}
	
	public int getUserNo() {
		return userNo;
	}
	
	public String getNickName() {
		return nickName;
	}
	
	public String getBirth() {
		return birth;
	}
	
	public String getGender() {
		return gender;
	}
	
	public String getEmail() {
		return email;
	}
	
	public boolean matchPassword(String pwd) {
		return password.equals(pwd);
	}

	public void changePassword(String newPwd) {
		this.password = newPwd;
	}

	public void changeNickName(String newNickName) {
		this.nickName = newNickName;
	}
	
	public void changeBirth(String newBirth) {
		this.birth = newBirth;
	}
	public void changeEmail(String newEmail) {
		this.email = newEmail;
	}
	public void changeGender(String newGender) {
		this.gender = newGender;
	}
	
}
