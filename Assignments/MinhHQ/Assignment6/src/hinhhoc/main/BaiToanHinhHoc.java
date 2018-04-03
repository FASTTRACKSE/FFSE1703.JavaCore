package hinhhoc.main;

import hinhhoc.model.*;
import java.util.Scanner;

import java.util.ArrayList;

public class BaiToanHinhHoc {
	public static Scanner scanner = new Scanner(System.in);
	public static ArrayList<HinhHoc> arrHinhHoc = new ArrayList<HinhHoc>();
	public static HinhTron Tron = new HinhTron();
	public static HinhVuong Vuong = new HinhVuong();
	public static HinhTamGiac TamGiac = new HinhTamGiac();
	public static HinhChuNhat CNhat = new HinhChuNhat();
	public static double r,a,cd,cr,b,c,n;
	public static void main(String[] args) {
		showMyMenu();

	}

	public static void nhapHinhTron() {
		Tron = new HinhTron();
		System.out.print("Nhập bán kính hình tròn :");
		r = scanner.nextDouble();
		Tron.setBankinh(r);

		arrHinhHoc.add(new HinhTron(r));
	}
	
	public static void nhapHinhVuong() {
		Vuong = new HinhVuong();
		System.out.print("Nhập cạnh hình vuông :");
		n = scanner.nextDouble();
		Vuong.setCanhHV(n);

		arrHinhHoc.add(new HinhVuong(n));
	}

	public static void nhapHinhChuNhat() {
		CNhat = new HinhChuNhat();
		System.out.print("Nhập chiều dài hình chữ nhật :");
		double cd = scanner.nextDouble();
		CNhat.setChieudai(cd);

		System.out.print("Nhập chiều rộng hình chữ nhật :");
		double cr = scanner.nextDouble();
		CNhat.setChieurong(cr);

		arrHinhHoc.add(new HinhChuNhat(cd,cr));
	}

	public static void nhapHinhTamGiac() {
		TamGiac = new HinhTamGiac();
		System.out.println("Nhập độ dài 3 cạnh của hình tam giác :");
		System.out.print("Nhập độ dài cạnh a :");
		double a = scanner.nextDouble();
		TamGiac.setCanhA(a);

		System.out.print("Nhập độ dài cạnh b :");
		double b = scanner.nextDouble();
		TamGiac.setCanhB(b);

		System.out.print("Nhập độ dài cạnh c :");
		double c = scanner.nextDouble();
		TamGiac.setCanhC(c);

		arrHinhHoc.add(new HinhTamGiac(a,b,c));

	}
	
	public static void inbangTinh() {
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("|STT  |       Hình      |  Thuộc tính      |      Chu vi      |      Diện tích     |");
		System.out.println("------------------------------------------------------------------------------------");
		int n =1;
		for (HinhHoc x : arrHinhHoc) {
			if ((x instanceof HinhTron)) {
				System.out.printf("|%-5s|%-17s|Bán kính :%-8s|%-18s|%-20s|\n",n,"Tròn",Tron.getBankinh(),x.getChuVi() , x.getDienTich());
			}
			else if ((x instanceof HinhVuong)) {
				System.out.printf("|%-5s|%-17s|a :%-15s|%-18s|%-20s|\n",n,"Hình Vuông",Vuong.getCanhHV(),x.getChuVi() , x.getDienTich());
			}
			else if ((x instanceof HinhChuNhat)) {
				System.out.printf("|%-5s|%-17s|cd:%-4s cr:%-7s|%-18s|%-20s|\n",n,"Chữ Nhật",CNhat.getChieudai(),CNhat.getChieurong(),x.getChuVi() , x.getDienTich());
			}
			else if ((x instanceof HinhTamGiac)) {
				System.out.printf("|%-5s|%-17s|a :%-3s b:%-3s c:%-3s|%-18s|%-20s|\n",n,"Tam Giác",TamGiac.getCanhA(),TamGiac.getCanhB(),TamGiac.getCanhC(),x.getChuVi() , x.getDienTich());
			}
			n += 1;
		}
		
	}

	public static void ketThuc() {
		System.out.println("Kết thúc chương trình!!!!!");
		System.exit(0);
	}

	public static void showMyMenu() {
		while (true) {
			System.out.println(">>    MENU TÍNH DIỆN TÍCH VÀ CHU VI     <<");
			System.out.println("+----------------------------------------+");
			System.out.println("|1. Nhập Hình Tròn                       |");
			System.out.println("|2. Nhập Hình Chữ Nhật                   |");
			System.out.println("|3. Nhập Hình Vuông                      |");
			System.out.println("|4. Nhập Hình Tam Giác                   |");
			System.out.println("|5. In chu vi và diện tích của các hình  |");
			System.out.println("|6. Kết thúc chương trình                |");
			System.out.println("+----------------------------------------+");
			System.out.println(">>            Lựa chọn của bạn?         <<");
			int myOption = scanner.nextInt();
			if (myOption == 1) {
				nhapHinhTron();
			} else if (myOption == 2) {
				nhapHinhChuNhat();
			} else if (myOption == 3) {
				nhapHinhVuong();
			} else if (myOption == 4) {
				nhapHinhTamGiac();
			} else if (myOption == 5) {
				inbangTinh();
			} else if (myOption == 6) {
				ketThuc();
			}
		}
	}
}
