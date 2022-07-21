package P1attempt2.models;

public class reimtype {
	private String type;

	public reimtype(String type) {
		super();
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "reimtype [type=" + type + "]";
	}

}
