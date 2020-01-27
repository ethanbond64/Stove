//Lucy Mahorner and Ethan Bond

public class Burner {
public enum Temperature {BLAZING, HOT, WARM, COLD};
	
	private Temperature myTemperature;
	private Setting mySetting;
	private int timer;
	private final static int TIME_DURATION = 2;
	
	public Temperature getMyTemperature() {
		return myTemperature;
	}
	
	Burner(){
		myTemperature = Temperature.COLD;
		mySetting = Setting.OFF;
	}
	
	
	public void plusButton() {
		
		timer = TIME_DURATION;
		
		switch(mySetting) {
		case OFF:
			mySetting = Setting.LOW;
			break;
		case LOW:
			mySetting = Setting.MEDIUM;
			break;
		case MEDIUM:
			mySetting = Setting.HIGH;
			break;
		default:
			break;	
		}
	}
	
	public void minusButton() {
		
		timer = TIME_DURATION;
		
		switch(mySetting) {
		case LOW:
			mySetting = Setting.OFF;
			break;
		case MEDIUM:
			mySetting = Setting.LOW;
			break;
		case HIGH:
			mySetting = Setting.MEDIUM;
			break;
		default:
			break;	
		}
	}
	
	public void updateTemperature() {
		int numSet = 0, numTemp = 0;
		Enum[] enums = new Enum[] { Temperature.COLD, Temperature.WARM, 
				Temperature.HOT, Temperature.BLAZING};
		
		if(mySetting == Setting.OFF){
			numSet = 0;
		}
		else if(mySetting == Setting.LOW){
			numSet = 1;
		}
		else if(mySetting == Setting.MEDIUM){
			numSet = 2;
		}
		else if(mySetting == Setting.HIGH){
			numSet = 3;
		}
		
		if(myTemperature == Temperature.COLD){
			numTemp = 0;
		}
		else if(myTemperature == Temperature.WARM){
			numTemp = 1;
		}
		else if(myTemperature == Temperature.HOT){
			numTemp = 2;
		}
		else if(myTemperature == Temperature.BLAZING){
			numTemp = 3;
		}
		
		if(timer > 0 ) {
			timer--;
		}
		
		switch(timer) {
		case 0:
			if(numSet == numTemp){
				break;
			}
			else if (numSet > numTemp){
				myTemperature = (Temperature) enums[numTemp + 1];
				timer = 2;
			}
			else if (numSet < numTemp){
				myTemperature = (Temperature) enums[numTemp - 1];
				timer = 2;
			}
			break;
		default:
			break;
		}
	}
	
	public void display(){
		String addOn = "";
		if(mySetting.toString().charAt(0) == '+'){
			addOn = ".....VERY HOT! DON'T TOUCH";
		}
		else if(mySetting.toString().charAt(2) == '-'){
			addOn = ".....cooooool";
		}
		else if(mySetting.toString().charAt(1) == '+'){
			addOn = ".....CAREFUL";
		}
		else{
			addOn = ".....warm";
		}
		String output = "[" + mySetting.toString() + "]" + addOn;
		System.out.println(output);
	}
}
