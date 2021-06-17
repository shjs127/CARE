package member.model;

public class writer {

	private String userId;
	private String name;

	public writer(String userId, String name) {
		this.userId = userId;
		this.name = name;
	}

	public String getUserId() {
		return userId;
	}

	public String getName() {
		return name;
	}

}
