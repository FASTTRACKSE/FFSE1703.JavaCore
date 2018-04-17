package fasttrack.edu.vn.mycar;

public class MyCar {
	public String carModel;
	private String carMaker;
	private int carYear;
	private String carColor;

	public MyCar() {
		//
	}

	public MyCar(String carModel, String carMaker, int carYear, String carColor) {
		this.carModel = carModel;
		this.carMaker = carMaker;
		this.carYear = carYear;
		this.carColor = carColor;
	}

	public void setCarModel(String name) {
		if (!name.equals("TeslaX"))
			this.carModel = name;
		else
			this.carModel = "I love Facebook";
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

	public void setCarYear(int intYear) {
		this.carYear = intYear;
	}

	public int getCarYear() {
		return this.carYear;
	}

	public void setCarColor(String myColor) {
		this.carColor = myColor;
	}

	public String getCarColor() {
		return this.carColor;
	}

	public int getCarAge() {
		return (2018 - this.carYear);
	}

}
