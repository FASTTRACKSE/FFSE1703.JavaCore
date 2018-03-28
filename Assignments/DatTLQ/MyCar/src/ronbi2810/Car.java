package ronbi2810;

public class Car {
	public  String carModel;
	public  String carMaker;
	public  String carColor;
	public  int carYear;
	
	
	
	public void setCarModel(String name) {
		this.carModel = name;
	}
	public String getCarModel() {
		return this.carModel;
	}
	public void setCarMaker(String name) {
		this.carMaker = name;
	}
	public String getCarMaker() {
		return this.carMaker;
	}
	public void setCarCorlor(String mycolor) {
		this.carColor = mycolor;
	}
	public String getCarColor() {
		return this.carColor;
	}
	public void setCarYear(int intyear) {
		this.carYear = intyear;
	}
	public int getCarYear() {
		return this.carYear;
	}
	public int doixe() {
		return (2018-this.carYear);
	}
}
