package fasttrack.edu.vn.mycar;

public class MyCar {
	public static String CarModel;
	public static String CarMaker;
	public static int CarYear;
	public static String CarColor;
	
	public void setCarMode(String name) {
		this.CarModel = name;
	}
	public String getCarModel() {
		return this.CarModel;
	}
	public void getCarModel(String name) {
		this.CarMaker = name;
	}
	public String getCarModel() {
		return this.CarMaker;
	}
	public void getCarYear(int intYear) {
		this.CarYear = intYear;
	}
	public String getCarYear() {
		return this.CarYear;
	}	
}
