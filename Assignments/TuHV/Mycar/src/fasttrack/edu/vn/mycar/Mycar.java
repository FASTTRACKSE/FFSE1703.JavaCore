package fasttrack.edu.vn.mycar;

public class Mycar {

	public String carModel;
	public  String carMaker;
	public  int carYear;
	public  String carColor;
	public Mycar() {
		
	}
	
	
	public void setcarModel(String name) {
		this.carModel = name;
	}
	public String getcarModel() {
		return this.carModel;
	}
	public void setcarMaker(String name) {
		this.carMaker = name;
	}
	public String getMaker() {
		return this.carMaker;
	}
	public void setcarYear(int year) {
		this.carYear = year;
	}
	public int getcarYear() {
		return this.carYear;
	}
	public void setcarColor(String name) {
		this.carColor = name;
	}
	public String getColor() {
		return this.carColor;
	}
	public int getcarAge() {
		return(2018-this.carYear);
	}
	

	

}
