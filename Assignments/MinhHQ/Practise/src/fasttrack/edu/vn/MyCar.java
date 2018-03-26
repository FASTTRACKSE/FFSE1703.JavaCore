package fasttrack.edu.vn;

public class MyCar {

	private  String CarModel;
	private  String CarMaker;
	private  int CarYear;
	private  String CarColor;
	
	public MyCar() {
		//
	}

	public void setCarModel(String name) {
		this.CarModel = name;
	}
	
	public String getCarModel() {
		return this.CarModel;
	}
	
	public void setCarMaker(String name) {
		this.CarMaker = name;
	}
	
	public String getCarMaker() {
		return this.CarMaker;
	}
	
	public void setCarYear(int intYear) {
		this.CarYear = intYear;
	}
	
	public int getCarYear() {
		return this.CarYear;
	}
	
	public void setCarColor(String Color) {
		this.CarColor = Color;
	}
	
	public String getCarColor() {
		return this.CarColor;
	}
	
	public int getCarAges() {
		return (2018 - this.CarYear);
	}
}
