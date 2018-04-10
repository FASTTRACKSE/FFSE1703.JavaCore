package fasttrack.edu.vn.mycar;

public class NhapXe {

	public static void main(String[] args) {
		MyCar car1,car2;
		MyCar[] arrMyCar;
		
		//Khai bao xe 1
		car1 = new MyCar();
		car1.setCarMaker("Merceder Benz");
		car1.setCarModle("M 400");
		car1.setCarYear(2005);
		car1.setCarColor("Green");

		//Khai bao xe 2
		car2 = new MyCar();
		car2.setCarMaker("Toyota");
		car2.setCarModle("Camry");
		car2.setCarYear(2009);
		car2.setCarColor("black");
		
		//Khai bao mang xe
		arrMyCar = new MyCar[10];
		arrMyCar[0]= car1;
		arrMyCar [1] = car2;
		
	System.out.println("Danh sach xe: ");
	int i;
	for(i=0; i < 2 ; i++ ) {
		System.out.println((i + 1) + "Modle:" + arrMyCar[i].getCarModle()+ "Tuoi xe" + arrMyCar[i].getCarAges());
	}
		
		
	}



}
