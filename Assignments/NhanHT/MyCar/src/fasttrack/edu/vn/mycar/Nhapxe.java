package fasttrack.edu.vn.mycar;

public class Nhapxe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyCar car1,car2;
		MyCar[] arrMyCar;
		//khai bao xe 1
		car1= new MyCar();
		car1.setCarModel("ML350");
		car1.setCarMaker("Mercedes Benz");
		car1.setCarYear(2004);
		car1.setCarColor("Browm");
		
		//khai bao xe 2
		car2= new MyCar();
		car2.setCarModel("i8");
		car2.setCarMaker("BMW");
		car2.setCarYear(2013);
		car2.setCarColor("Blue");
		
		//khai bao mang xe
		arrMyCar = new MyCar[10];
		arrMyCar[0] = car1;
		arrMyCar[1] = car2;
		
		System.out.println( "Danh sach cac xe cua toi");
		for(int i = 0;i< 2;i++) {
			System.out.println((i+1)+ " " + arrMyCar[i].getCarModel()+" "+arrMyCar[i].getCarYear());
		}
	}
	
}
