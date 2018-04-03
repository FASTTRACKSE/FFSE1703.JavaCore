package Fasttrack.edu.vn;

public class nhap_xe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myCar car1,car2;
		myCar[] arrmyCar;
		
		car1 = new myCar();
		
		car1.setCarMaker("Mercedes");
		car1.setCarModel("C250");
		
		car1.setCarYear(2012);
		car1.setCarColor("Blue");
		
		car2 = new myCar();
		car2.setCarMaker("Xe cua tao");
		car2.setCarModel("Duc Dep Trai");
		car2.setCarYear(1998);
		car2.setCarColor("Mau cua tao");
		System.out.println (car1.getCarColor());
		System.out.println(car1.getCarMaker());
		System.out.println(car1.getCarModel());
		System.out.println(car1.getCarYear());
	}

}
