package biz.fesenmeyer;

public class Arrest {
	String location;

	public Arrest(String location) {
		super();
		this.location = location;
	}

	public String getLocation() {
		return location;
	}

	@Override
	public String toString() {
		return "Arrest [location=" + location + "]";
	}
	
	

}
