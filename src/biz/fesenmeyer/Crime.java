package biz.fesenmeyer;

public class Crime {
	private String location;
	private String type;

	public Crime(String location, String type) {
		super();
		this.location = location;
		this.type = type;
	}

	public String getLocation() {
		return location;
	}

	public String getType() {
		return type;
	}

	@Override
	public String toString() {
		return type + " in "+location;
	}
}
