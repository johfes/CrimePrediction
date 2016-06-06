package biz.fesenmeyer;

public class Crime {
	String location;

	public Crime(String location) {
		super();
		this.location = location;
	}

	public String getLocation() {
		return location;
	}

	@Override
	public String toString() {
		return "Crime [location=" + location + "]";
	}
	
}
