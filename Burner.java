
public class Burner {
	enum Temperature {BLAZING, HOT, WARM, COLD};
	
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

		if(timer > 0 ) {
			timer--;
		}
		
		switch(timer) {
		case 0:
			if(mySetting == Setting.OFF) {
				myTemperature = Temperature.COLD;
				break;
			}		
			
			
			
			break;
			
		default:
			break;
		}

		
	}
		
	
}
