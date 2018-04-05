package ffse1703.javacore.main;
import java.util.ArrayList;
import java.util.Scanner;

import ffse1703.javacore.model.*;
public class Main {
	
	private static ArrayList<HinhHoc> arrHinhHoc = new ArrayList<>();
	private static Scanner myInput = new Scanner(System.in);

	public static void main(String[] args) {
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
		
			
			myMenu();
		}
			private static Main main() {
		return null;
	}
			public static void myMenu() {
				while (true) {
				System.out.println("---  lỰA CHỌN CHỨC NĂNG  ---");
				System.out.println("____________________________" + "\n");
				System.out.println("1. Tính diện tích hình tròn.");
				System.out.println("2. Tính diện tích hình chữ nhật.");
				System.out.println("3. Tính diện tích hình tam giác");
				System.out.println("4. Tính diện tích hình vuông");
				System.out.println("5. In ");
				System.out.println("0. Kết thúc.");
				System.out.println("____________________________" + "\n");

				
				System.out.println("Nhập lựa chọn của bạn: ");
				int chose = Integer.parseInt(myInput.nextLine());
				
				if (chose == 1) {
					hinhTron();
				} else if (chose == 2) {
					hinhChuNhat();
				} else if (chose == 3) {
					hinhTamGiac();
				} else if (chose == 4) {
					hinhVuong();
				} else if (chose == 5) {
					In();
				} else if (chose == 0) {
					ketThuc();
				}
					
			}
		}
			public static void hinhTron() {
				System.out.println("Nhập bán kính hình tròn: ");
				double r = Double.parseDouble(myInput.nextLine());
				
				arrHinhHoc.add(new HinhTron(r));
				
				
			}
			public static void hinhChuNhat() {
				
				System.out.println("Nhập chiều dài hình chữ nhật: ");
				double chieudai = Double.parseDouble(myInput.nextLine());
				
				System.out.println("Nhập chiều rộng hình chữ nhật");
				double chieurong = Double.parseDouble(myInput.nextLine());
				
				arrHinhHoc.add(new HinhChuNhat(chieudai, chieurong));
			}
			public static void hinhTamGiac() {
				
				System.out.println("Nhập cạnh A: ");
				int canhA = Integer.parseInt(myInput.nextLine());
				
				System.out.println("Nhập cạnh B: ");
				int canhB = Integer.parseInt(myInput.nextLine());
				
				System.out.println("Nhập cạnh C: ");
				int canhC = Integer.parseInt(myInput.nextLine());
				
				arrHinhHoc.add(new HinhTamGiac(canhA, canhB, canhC));
			}
			public static void hinhVuong() {
				System.out.println("Nhập cạnh A: ");
				double canhA = Double.parseDouble(myInput.nextLine());
				
				arrHinhHoc.add(new HinhVuong(canhA));
			}
			public static void ketThuc() {
				System.out.println("Cảm ơn bạn đã sử dụng chương trình của chúng tôi!!!");
				System.exit(0);
				
			}
			public static void In() {
				for(HinhHoc x : arrHinhHoc) {
					if(x instanceof HinhTron) {
						System.out.println("Hình tròn: " + "Bán kính: " +((HinhTron) x).getR() + " Chu vi: " + x.getChuVi() + " Diện tích: " + x.getDienTich());
					} else if (x instanceof HinhChuNhat) {
						System.out.println("Hình chữ nhật: " + "Chiều dài: " + ((HinhChuNhat) x).getChieuDai() + " Chiều rộng: " + ((HinhChuNhat) x).getChieuRong() + " Chu vi: " + x.getChuVi() + " Diện tích: " + x.getDienTich());
					} else if (x instanceof HinhTamGiac) {
						System.out.println("HinhTamGiac: " + "Cạnh A" + ((HinhTamGiac) x).getCanhA() + " Cạnh B: " + ((HinhTamGiac) x).getCanhB() + " Cạnh C: " + ((HinhTamGiac) x).getCanhC() + " Chu vi: " + x.getChuVi()+ " Diện tích: " + x.getDienTich());
					} else if (x instanceof HinhVuong) {
						System.out.println("HinhVuong: " + "Cạnh A: " + ((HinhVuong) x).getCanhA() + " Chu Vi: " + x.getChuVi()+ " Diện Tích: " + x.getDienTich());
					}
				}
				
			}
}




