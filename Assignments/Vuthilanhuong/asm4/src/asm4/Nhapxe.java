package asm4;

public class Nhapxe {
	public static void main(String[]args) {
		mycar car1, car2;
		mycar[] arrmycar;
		//khai báo car 1
		car1 = new mycar();
		car1.setCarMaker("Merceders Benz");
		car1.setCarModel("ML350");
		car1.setCarYear(2004);
		car1.setCarColor("Red");
		
		//khai báo car 2
		car2 = new mycar();
		car2.setCarMaker(" Dream");
		car2.setCarModel("ML555");
		car2.setCarYear(2009);
		car2.setCarColor("Black");
		
		//khai báo mua xe
		arrmycar = new mycar[10];
		arrmycar[0] = car1;
		arrmycar[1] = car2;
		System.out.println("Danh sách mua xe");
		for (int i=0; i<2; i++) {
			System.out.println(arrmycar[i].getCarModel());
		}
}
}
