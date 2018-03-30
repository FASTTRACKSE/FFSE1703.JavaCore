package fasttrack.edu.vn.practices;

public class Nhapxe {
	public static void main(String[] args) {
		MyCar car1, car2;
		MyCar[] arrMyCar;
		
		//xe 1
		car1 = new MyCar();
		car1.setCarMaker("honda");
		car1.setCarModel("ML350");
		car1.setCarColor("brom");
		car1.setCarYear(2011);
		
		//xe 2
		car2 = new MyCar();
		car2.setCarMaker("yamaha");
		car2.setCarModel("ML353");
		car2.setCarColor("brom");
		car2.setCarYear(2010);
		
		//khai bao mang xe
		arrMyCar= new MyCar[10];
		arrMyCar[0] = car1;
		arrMyCar[1] = car2;
		
       System.out.println("danh sach cac xe cua toi");
       for (int i = 0; i < 2; i++) {
    	   System.out.println((i+1) + ". Model: " + arrMyCar[i].getCarModel() + " - tuoi doi: " + arrMyCar[i].getCarYear());
       }
	}
}
