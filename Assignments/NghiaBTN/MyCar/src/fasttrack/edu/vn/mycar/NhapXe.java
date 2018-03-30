package fasttrack.edu.vn.mycar;

public class NhapXe {
	public static void main(String[]args) {
		MyCar car1, car2;
		MyCar[] arrMyCar;
		//khai bao xe 1
		car1 = new MyCar();
		car1.setCarMaker("Mercedes benz");
		car1.setCarModel("ML350");
		car1.setCarYear(2008);
		car1.setCarColor("brown");
		
		//khai bao xe 2
		car2 = new MyCar();
		car2.setCarMaker("Toyota");
		car2.setCarModel("Crown");
		car2.setCarYear(2001);
		car2.setCarColor("Sivel");
	}
}
