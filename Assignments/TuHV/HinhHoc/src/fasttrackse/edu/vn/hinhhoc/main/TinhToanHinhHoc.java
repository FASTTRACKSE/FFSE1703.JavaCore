package fasttrackse.edu.vn.hinhhoc.main;

import java.util.ArrayList;
import java.util.Scanner;

import fasttrackse.edu.vn.hinhhoc.model.*;


public class TinhToanHinhHoc {
	public static Scanner Scanner = new Scanner(System.in);
	public static Scanner input = new Scanner(System.in);
	public static ArrayList<HinhHoc> arrHinhHoc = new ArrayList<HinhHoc>();
	public static HinhTron Tron = new HinhTron();
	public static void main(String[] args) {
		showMyMenu();

	}

	public static void nhapHinhTron() {
		Scanner.nextLine();
		HinhTron Tron = new HinhTron();
		System.out.print("Nhập bán kính hình tròn :");
		int r = input.nextInt();
		Tron.setBanKinh(r);
		System.out.println("Chu vi hình tròn là : " + Tron.getChuVi());
		System.out.println("Diện tích hình tròn là : " + Tron.getDienTich());
		arrHinhHoc.add(new HinhTron(r));
		Scanner.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		Scanner.nextLine();
		
	}
	
	
	public static void nhapHinhVuong() {
		Scanner.nextLine();
		HinhVuong Vuong = new HinhVuong();
		System.out.print("Nhập cạnh hình vuông :");
		int a = input.nextInt();
		Vuong.setCanhA(a);
		System.out.println("Chu vi hình vuông là : " + Vuong.getChuVi());
		System.out.println("Diện tích hình vuông là : " + Vuong.getDienTich());
		arrHinhHoc.add(new HinhVuong(a));
		Scanner.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		Scanner.nextLine();
	}

	public static void nhapHinhChuNhat() {
		Scanner.nextLine();
		HinhChuNhat CNhat = new HinhChuNhat();
		System.out.print("Nhập chiều dài hình chữ nhật :");
		int Cdai = input.nextInt();
		CNhat.setChieuDai(Cdai);

		System.out.print("Nhập chiều rộng hình chữ nhật :");
		int Crong = input.nextInt();
		CNhat.setChieuRong(Crong);

		System.out.println("Chu vi hình chữ nhật là : " + CNhat.getChuVi());
		System.out.println("Diện tích hình chữ nhật là : " + CNhat.getDienTich());
		arrHinhHoc.add(new HinhChuNhat(Cdai,Crong));
		Scanner.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		Scanner.nextLine();
	}

	public static void nhapHinhTamGiac() {
		Scanner.nextLine();
		HinhTamGiac TamGiac = new HinhTamGiac();
		System.out.println("Nhập độ dài 3 cạnh của hình tam giác :");
		System.out.print("Nhập độ dài cạnh a :");
		int a = input.nextInt();
		TamGiac.setCanhA(a);

		System.out.print("Nhập độ dài cạnh b :");
		int b = input.nextInt();
		TamGiac.setCanhB(b);

		System.out.print("Nhập độ dài cạnh c :");
		int c = input.nextInt();
		TamGiac.setCanhC(c);

		System.out.println("Chu vi hình chữ nhật là : " + TamGiac.getChuVi());
		System.out.println("Diện tích hình chữ nhật là : " + TamGiac.getDienTich());
		arrHinhHoc.add(new HinhTamGiac(a,b,c));
		Scanner.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		Scanner.nextLine();

	}
	
	public static void inbangTinh() {
		Scanner.nextLine();
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("|STT  |       Hình      |  Thuộc tính      |      Chu vi      |      Diện tích     |");
		System.out.println("------------------------------------------------------------------------------------");
		int n = 1;
		for (HinhHoc x : arrHinhHoc) {
			if ((x instanceof HinhTron)) {

				System.out.printf("%-5s%-17sBán kính :%-8s%-18s%-20s\n", n, "Tròn", ((HinhTron) x).getBanKinh(),
						x.getChuVi(), x.getDienTich());
			} else if ((x instanceof HinhVuong)) {
				System.out.printf("%-5s%-17sa :%-15s%-18s%-20s\n", n, "Hình Vuông", ((HinhVuong) x).getCanhA(),
						x.getChuVi(), x.getDienTich());
			} else if ((x instanceof HinhChuNhat)) {
				System.out.printf("%-5s%-17scd:%-4s cr:%-7s%-18s%-20s\n", n, "Chữ Nhật",
						((HinhChuNhat) x).getChieuDai(), ((HinhChuNhat) x).getChieuRong(), x.getChuVi(),
						x.getDienTich());
			} else if ((x instanceof HinhTamGiac)) {
				System.out.printf("%-5s%-17sa :%-3s b:%-3s c:%-3s%-18s%-20s\n", n, "Tam Giác",
						((HinhTamGiac) x).getCanhA(), ((HinhTamGiac) x).getCanhB(), ((HinhTamGiac) x).getCanhC(),
						x.getChuVi(), x.getDienTich());
			}
			System.out.println("------------------------------------------------------------------------------------");
			n += 1;
		}
		Scanner.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		Scanner.nextLine();

		
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
			int myOption = input.nextInt();
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
