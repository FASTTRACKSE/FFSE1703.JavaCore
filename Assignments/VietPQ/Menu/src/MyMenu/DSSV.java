package MyMenu;

import java.util.Scanner;

public class DSSV {
	public static Scanner myScanner = new Scanner(System.in);
	public static String[] arrSinhVien;
	public static Double[] arrLP1;
	public static Double[] arrLP2;
	public static Double[] arrLP3;
	public static int tongSinhVien = 0;

	public static void main(String[] args) {
		showMenu();
	}

	public static void showMenu() {
			while (true) {
				System.out.println("Lua chon chuc nang");
				System.out.println("1.Nhap danh sach sinh vien");
				System.out.println("2.In danh sach sinh vien");
				System.out.println("3.Sinh vien tieu bieu");
				System.out.println("4.Ket thuc chuong trinh");
				System.out.println("Lua chon cua ban");
				
				int myOption = myScanner.nextInt();
				if (myOption == 1) {
					nhapDSSV();
				} else if (myOption == 2) {
					inDSSV();
				} else if (myOption == 3) {
					SVTB();
				} else if (myOption == 4) {
					Ketthuc();
				}
			}
	}
	
	public static void nhapDSSV() {
		System.out.println("Nhap danh sach sinh vien");
		System.out.println("---------");
	}

	public static void inDSSV() {
		System.out.println("In danh sach sinh vien");
		System.out.println("---------");
	}

	public static void SVTB() {
		System.out.println("Sinh vien tieu bieu");
		System.out.println("---------");
	}

	public static void Ketthuc() {
		System.out.println("Cam on va chao tam biet");
		System.out.println("---------");
	}
}