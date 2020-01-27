//Lucy Mahorner and Ethan Bond

public enum Setting {
	OFF("---"), LOW("--+"), MEDIUM("-++"), HIGH("+++");
	private String value;
	
	Setting(String aString) {
		value = aString;
	}
	
	public String toString() {
		return value;
	}
}
