package ronbi2810;

public class NhapXe {

	public static void main(String[] args) {
		Car car1,car2;
		Car[] mycar;
		
		// Khai bao xe 1
		car1= new Car();
		car1.setCarMaker("BMW");
		car1.setCarModel("750I");
		car1.setCarCorlor("Black");
		car1.setCarYear(2017);
		
		// khai bao xe 2
		car2= new Car();
		car2.setCarMaker("Audi");
		car2.setCarModel("A8L");
		car2.setCarCorlor("White");
		car2.setCarYear(2016);
		
		//Khai bao mang xe
		mycar = new Car[10];
		mycar[0]=car1;
		mycar[1]=car2;
		
		System.out.println("Danh sach xe cua toi");
		for(int i=0;i<2;i++) {
			System.out.println( mycar[i].getCarMaker()+"\t"+mycar[i].getCarModel()+"\t"+mycar[i].getCarColor());
		}
	}

}
