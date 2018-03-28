package mycar;
import java.util.Scanner;
public class NhapXe {
	public static MyCar car1;
	public static MyCar arrMyCar[];
	public static int soLuong;
	public static void main(String[] args) {
		Scanner myInput = new Scanner(System.in);
		System.out.println("nhập số lượng: ");
		soLuong = myInput.nextInt();
		// Khai báo xe 1
		for(int i = 0; i < soLuong; i++) {
			
			car1 = new MyCar();
			myInput.nextLine();
			System.out.println("a");
			String a = myInput.nextLine();
			car1.setCarMaker(a);
			
			System.out.println("b");
			String b = myInput.nextLine();
			car1.setCarModel(b);
			
			System.out.println("d");
			int d = myInput.nextInt();
			car1.setCarYear(d);
			
			System.out.println("e");
			String e = myInput.nextLine();
			car1.setCarColor(e);
			myInput.nextLine();
			car1.getCarAge();
		}
		for(int i = 0; i < soLuong; i++) {
			arrMyCar[i] = car1;
		}
		
			
		
		// Khai báo xe 2
//		car2 = new MyCar();
//		car2.setCarMaker("Dream");
//		car2.setCarModel("ML555");
//		car2.setCarYear(2009);
//		car2.setCarColor("Black");
//		car2.getCarAge();
		// Khai báo mua xe
		
//		arrMyCar = new MyCar[soLuong];
//		arrMyCar[0] = car1;
//		arrMyCar[1] = car2;

		System.out.println("Danh sách mua xe:");
		for (int i = 0; i < soLuong; i++) {
			System.out.println("Car name: " + arrMyCar[i].getCarMaker() + " Model: " + arrMyCar[i].getCarModel()
					+ " Car color: " + arrMyCar[i].getCarColor() + " Car age: " + arrMyCar[i].getCarAge());
			loai();
		}
		
		

	}
	
	public static void loai() {
		for(int i = 0; i < soLuong; i++) {
			if(arrMyCar[i].getCarAge() > 10) {
				System.out.println("Xe loại tốt: " + arrMyCar[i].getCarMaker());
			}
		}
	}

}
