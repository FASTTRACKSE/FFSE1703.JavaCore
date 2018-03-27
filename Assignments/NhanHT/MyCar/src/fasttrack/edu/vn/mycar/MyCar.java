package fasttrack.edu.vn.mycar;

public class MyCar {
	public String carModel;
	public String carMaker;
	public int carYear;
	public String carColor;
	//
	public void setCarModel(String name) {
		this.carModel = name;
	}
	public String getCarModel() {
		return this.carModel;
	}
	
	//
	public void setCarMaker(String name) {
		this.carMaker = name;
	}
	public String getCarMaker() {
		return this.carMaker;
	}
	//
	
	public void setCarYear(int intyear) {
		this.carYear = intyear;
	}
	public int getCarYear() {
		return (2018-this.carYear);
	}
	
	//
	public void setCarColor(String MyColor) {
		this.carColor = MyColor;
	}
	public String getCarColor() {
		return this.carColor;
	} 
}
