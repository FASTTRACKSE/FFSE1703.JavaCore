package Fasttrack.edu.vn;

public class MyCar {

	public  String carModle;
	public  String carMaker;
	public  int carYear;
	public  String carColor;

	public MyCar() {

	}

	public void setCarModle(String name) {
		this.carModle = name;
	}

	public String getCarModle() {
		return this.carModle;
	}

	public void setCarMaker(String name) {
		this.carMaker = name;
	}

	public String getCarMaker() {
		return this.carMaker;
	}

	public void setCarYear(int Year) {
		this.carYear = Year;
	}

	public int getCarYear() {
		return this.carYear;
	}

	public void setCarColor(String name) {
		 this.carColor = name;
	}

	public String getCarColor() {
		return this.carColor;

	}

	public int getCarAges() {
		return (2018 - this.carYear);

	}
}
