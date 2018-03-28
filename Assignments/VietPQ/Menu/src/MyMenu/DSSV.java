package MyMenu;

import java.util.Scanner;

public class DSSV {
	public static Scanner myScanner = new Scanner(System.in);
	public static String[] arrSinhVien;
	public static String[] arrDate;
	public static Double[] arrLP1;
	public static Double[] arrLP2;
	public static Double[] arrLP3;
	public static Double[] arrDTB;
	public static int a;

	public static void main(String[] args) {
		myMenu();
	}

	public static void myMenu() {
		while (true) {
			System.out.println("+-----Lua chon chuc nang-----+");
			System.out.println("|1.Nhap danh sach sinh vien  |");
			System.out.println("|2.In danh sach sinh vien    |");
			System.out.println("|3.Sinh vien tieu bieu       |");
			System.out.println("|4.Ket thuc chuong trinh     |");
			System.out.println("+----------------------------+");
			System.out.println("Lua chon cua ban:");

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
		System.out.println("Nhap so luong");
		a = myScanner.nextInt();
		arrSinhVien = new String[a];
		arrDate = new String[a];
		arrLP1 = new Double[a];
		arrLP2 = new Double[a];
		arrDTB = new Double[a];

		for (int i = 0; i < a; i++) {
			myScanner.nextLine();
			System.out.println("Nhap Ho Va Ten Sinh Vien");
			arrSinhVien[i] = myScanner.nextLine();
			System.out.println("Nhap Ngay Sinh");
			arrDate[i] = myScanner.nextLine();
			System.out.println("Nhap Diem LP1");
			arrLP1[i] = myScanner.nextDouble();
			System.out.println("Nhap Diem LP2");
			arrLP2[i] = myScanner.nextDouble();
			arrDTB[i] = ((arrLP1[i] + arrLP2[i]) / (2));
		}
	}

	public static void inDSSV() {
		System.out.println("In danh sach sinh vien");
		System.out.println("---------");
		System.out.println("DANH SACH TOP");
		double max = arrDTB[0];
		int maxvt = 0;
		for (int i = 0; i < arrDTB.length; i++) {
			if (max < arrDTB[i]) {
				max = arrDTB[i];
				maxvt = i;

			}
		}
		System.out.println("Ten Sinh Vien La: " + arrSinhVien[maxvt] + "\t" + "Diem Trung Binh La: " + max);
	}

	public static void SVTB() {
		System.out.println("Sinh vien tieu bieu");
		System.out.println("---------");

		System.out.println("DANH SACH SINH VIEN");
		System.out.println("Ten Sinh Vien " + "    Date " + "    Diem LP1 " + "    Diem LP2 " + "    Diem TB ");
		for (int i = 0; i < a; i++) {
			System.out.println(" \t " + arrSinhVien[i] + " \t " + arrDate[i] + " \t " + arrLP1[i] + " \t " + arrLP2[i]
					+ " \t " + arrDTB[i]);
		}
	}

	public static void Ketthuc() {
		System.out.println("-----------------------");
		myScanner.nextLine();
		System.out.println("Cam on va chao tam biet");
		System.exit(0);
	}
}