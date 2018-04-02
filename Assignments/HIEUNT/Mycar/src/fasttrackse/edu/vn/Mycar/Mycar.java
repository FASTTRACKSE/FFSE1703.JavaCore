package fasttrackse.edu.vn.Mycar;

public class Mycar {

      public  String carModel;
      
      private  String carMaker;

      private  String carColor;

      private  int carYear;
      public Mycar() {}

  public void setcarModel(String name) {
	  this.carModel =name;
	  
  }
  public String getcarModel() {
	  return this.carModel;
  }
  public void setcarMaker(String name) {
	  this.carMaker =name;
	  
  }
  public String getcarMaker() {
	  return this.carMaker;
  }
  public void setcarColor(String name) {
	  this.carColor =name;
	  
  }
  public String getcarColor() {
	  return this.carColor;
  }
  public void setcarYear(int intyear) {
	  this.carYear =intyear;
	  
  }
  public int getcarYear() {
	  return this.carYear;
	  
  }
  public int getcarAges() {
	  return (2018-this.carYear);
  }
  
  

}

