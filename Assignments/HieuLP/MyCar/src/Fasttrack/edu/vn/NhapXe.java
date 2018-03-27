package Fasttrack.edu.vn;

public class NhapXe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyCar car1, car2;
		MyCar[] arrMyCar;
		// khai bao xe 1
		car1 = new MyCar();
		car1.setCarMaker("For Ranger");
		car1.setCarModle("LP550");
		car1.setCarYear(2016);
		car1.setCarColor("Brown");
		// khai bao xe 2
		car2 = new MyCar();
		car2.setCarMaker("BMW i8");
		car2.setCarModle("MK350");
		car2.setCarYear(2015);
		car2.setCarColor("Red");
		// khai tao mang xe
		arrMyCar = new MyCar[4];
		arrMyCar[0] = car1;
		arrMyCar[1] = car2;

		System.out.println("Danh sách xe của tôi");
		for (int i = 0; i < 2; i++) {
			System.out.println((i+1) + ".Modle " + arrMyCar[i].getCarModle() + "-Tuổi đời: " + arrMyCar[i].getCarAges()) ;
		}

	}
}
