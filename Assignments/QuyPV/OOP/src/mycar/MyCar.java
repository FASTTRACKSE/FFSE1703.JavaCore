package mycar;

public class MyCar {
	
	public String carModel;
	public String carMaker;
	public int carYear;
	public String carColor, loai;
	public int carAge;
	
	public String getCarModel() {
		return this.carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	public String getCarMaker() {
		return this.carMaker;
	}
	public void setCarMaker(String carMaker) {
		this.carMaker = carMaker;
	}
	public int getCarYear() {
		return this.carYear;
	}
	public void setCarYear(int carYear) {
		this.carYear = carYear;
	}
	public String getCarColor() {
		return this.carColor;
	}
	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}
	
	public int getCarAge() {
	return this.carAge = 2018 - this.carYear;
		
	}
	

	
	
	
}
