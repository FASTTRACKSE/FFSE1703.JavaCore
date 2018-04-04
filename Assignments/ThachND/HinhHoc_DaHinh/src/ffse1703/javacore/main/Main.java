package ffse1703.javacore.main;
import java.util.Scanner;

import ffse1703.javacore.model.*;
public class Main {
	private Scanner myInput = new Scanner(System.in);

	public static void Main(String[] args) {
//		HinhHoc HinhTron = new HinhTron(8);
//		HinhHoc HinhChuNhat = new HinhChuNhat(10,6);
//		HinhHoc HinhTamGiac = new HinhTamGiac(12,8);
//		
//		HinhTron.getChuVi();
//		HinhTron.getDienTich();
//		
//		HinhChuNhat.getChuVi();
//		HinhChuNhat.getDienTich();
//		
//		HinhTamGiac.getChuVi();
//		HinhTamGiac.getDienTich();
		
			Main main = main();
			main.myMenu();
		}
			private static Main main() {
		return null;
	}
			public void myMenu() {
				while (true) {
				System.out.println("---  lỰA CHỌN CHỨC NĂNG  ---");
				System.out.println("____________________________" + "\n");
				System.out.println("1. Tính diện tích hình tròn.");
				System.out.println("2. Tính diện tích hình chữ nhật.");
				System.out.println("3. Tính diện tích hình chữ nhật");
				System.out.println("5. Kết thúc.");
				System.out.println("____________________________" + "\n");

				
					System.out.println("Nhập lựa chọn của bạn: ");
					int chose = Integer.parseInt(myInput.nextLine());
					if(chose == 1);
			}
		}
	}




