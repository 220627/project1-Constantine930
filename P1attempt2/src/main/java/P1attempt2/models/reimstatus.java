package P1attempt2.models;

public class reimstatus {
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "reimstatus [status=" + status + "]";
	}

	public reimstatus(String status) {
		super();
		this.status = status;
	}

}
