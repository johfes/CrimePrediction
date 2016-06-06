package biz.fesenmeyer;

public class Arrest {
	private String location;
	private String crimeType;

	public Arrest(String location, String crimeType) {
		super();
		this.location = location;
		this.crimeType = crimeType;
	}

	public String getLocation() {
		return location;
	}

	public String getCrimeType() {
		return crimeType;
	}

	@Override
	public String toString() {
		return "Ort: " + location + " Grund: " + crimeType;
	}


	

}
