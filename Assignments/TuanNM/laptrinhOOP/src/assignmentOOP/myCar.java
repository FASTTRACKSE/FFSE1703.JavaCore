package assignmentOOP;

public class myCar {
	private String carModel;
	private String carMaker;
	private int carYear;
	private String carColor;

	public void setCarModel(String name) {
		this.carModel = name;
	}

	public String getCarModel() {
		return this.carModel;
	}

	public void setCarMaker(String maker) {
		this.carMaker = maker;
	}

	public String getCarMaker() {
		return this.carMaker;
	}

	public void setCarYear(int year) {
		this.carYear = year;
	}

	public int getCarYear() {
		return this.carYear;
	}

	public void setCarColor(String color) {
		this.carColor = color;
	}

	public String getCarColor() {
		return this.carColor;

	}
	public int getCarAge() {
		return 2018 - this.carYear;
	}
}
