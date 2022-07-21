package P1attempt2.models;

public class userole {
	private String role;

	@Override
	public String toString() {
		return "userole [role=" + role + "]";
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public userole(String role) {
		super();
		this.role = role;
	}

}
