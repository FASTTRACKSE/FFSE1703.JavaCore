package fasttrack.edu.vn.quanlyxe;

import fasttrack.edu.vn.mycar.MyCar;

public class NhapXe {
	public static MyCar[] arrMyCar;

	public static void main(String[] args) {
		MyCar car1, car2, car3;
		
		// Khai bao xe 1
		car1 = new MyCar();		
		
		car1.setCarMaker("Mercedes Benz");
		car1.setCarModel("TeslaX");
		car1.carModel = "ML350 - Truc tiep";	
		
		car1.setCarYear(2004);
		car1.setCarColor("Brown");
		
		// Khai bao xe 2
		car2 = new MyCar();		
		car2.setCarMaker("Toyota");
		car2.setCarModel("Crown");
		car2.setCarYear(2001);
		car2.setCarColor("Silver");
		
		car3 = new MyCar("i10", "Huyndai", 2017, "white");
		
		// Khai bao mang xe
		arrMyCar = new MyCar[10];
		arrMyCar[0] = car1;
		arrMyCar[1] = car2;
		arrMyCar[2] = car3;
		
		arrMyCar[3] = new MyCar();
		
		System.out.println("Danh sach cac xe cua toi");
		for (int i=0; i<4; i++) {
			System.out.println((i+1) + ". Model: " + arrMyCar[i].getCarModel() + " - Tuoi doi: " + arrMyCar[i].getCarAge());
		}
		
	}

}
