package fasttrack.edu.vn.mycar;

public class MyCar {
	private String carModle;
	private String carMaker;
	private int carYear;
	private String carColor;

	public String getCarModle() {
		return carModle;
	}

	public void setCarModle(String carModle) {
		this.carModle = carModle;
	}

	public String getCarMaker() {
		return carMaker;
	}

	public void setCarMaker(String carMaker) {
		this.carMaker = carMaker;
	}

	public int getCarYear() {
		return carYear;
	}

	public void setCarYear(int carYear) {
		this.carYear = carYear;
	}

	public String getCarColor() {
		return carColor;
	}

	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}

	public int getCarAges() {
		return (2018 - this.carYear);
	}

}
