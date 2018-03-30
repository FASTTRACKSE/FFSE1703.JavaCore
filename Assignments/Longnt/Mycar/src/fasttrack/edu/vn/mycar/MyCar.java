package fasttrack.edu.vn.mycar;

public class MyCar {

    public String carModel;
    public String carMaker;
    public int carYear;
    public String carColor;
    
    
    public MyCar() {
    	
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
    
    public String getcarMaker() {
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
    
    public String getcarColor() {
    	return this.carColor;
    }
}
