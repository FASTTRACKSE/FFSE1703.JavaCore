package Mymenu;

import java.util.Scanner;


public class liststudent {
	//
	public static Scanner myInput = new Scanner(System.in);
	public static String[] arrSinhvien;
	public static String[] arrDate;
	public static double[] arrDiemlp1;
	public static double[] arrDiemlp2;
	public static double[] arrDiemtb;
	public static int a;

	//
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myMenu();
	}

	public static void nhapten() {
		System.out.println("<=====NHAP SINH VIEN=====>");
		System.out.println("Nhap so luong");
		a = myInput.nextInt();
		arrSinhvien = new String[a];
		arrDate = new String[a];
		arrDiemlp1 = new double[a];
		arrDiemlp2 = new double[a];
		arrDiemtb = new double[a];

		for (int i = 0; i < a; i++) {
			myInput.nextLine();
			System.out.println("Nhap Ho Va Ten Sinh Vien");
			arrSinhvien[i] = myInput.nextLine();
			System.out.println("Nhap Ngay Sinh");
			arrDate[i] = myInput.nextLine();
			System.out.println("Nhap Diem LP1");
			arrDiemlp1[i] = myInput.nextDouble();
			System.out.println("Nhap Diem LP2");
			arrDiemlp2[i] = myInput.nextDouble();
			arrDiemtb[i] = ((arrDiemlp1[i] + arrDiemlp2[i]) / (2));
		}

	}

	public static void topsinhvien() {
		System.out.println("<=====DANH SACH TOP=====>");
		double max = arrDiemtb[0];
		int maxvt = 0;
		for (int i = 0; i < arrDiemtb.length; i++) {
			if (max < arrDiemtb[i]) {
				max = arrDiemtb[i];
				maxvt = i;

			}
		}
		System.out.println("Ten Sinh Vien La: " + arrSinhvien[maxvt] + "\t" + "Diem Trung Binh La: " + max);
	}
	public static void sapxepten() {
		System.out.println("<=====SAP XEP SINH VIEN ABC=====>");
		for (int i = 0; i < arrSinhvien.length - 1; i++) {
			for (int j = i + 1; j < arrSinhvien.length; j++) {
				if (arrSinhvien[i].compareTo(arrSinhvien[j]) > 0) {
					String	temp =arrSinhvien[j];
					arrSinhvien[j] = arrSinhvien[i];
					arrSinhvien[i] = temp;
					Double	temp1 =arrDiemtb[j];
					arrDiemtb[j] = arrDiemtb[i];
					arrDiemtb[i] = temp1;
					temp1 =arrDiemlp2[j];
					arrDiemlp2[j] = arrDiemlp2[i];
					arrDiemlp2[i] = temp1;
				}
			}
		}
		for (int i = 0; i < arrSinhvien.length; i++) {
			System.out.println(" Ten Sinh Vien: "+ arrSinhvien[i] +" Diem Trung Binh: "+ arrDiemtb[i]);
		}
	}

	public static void indanhsach() {

		System.out.println("<=====DANH SACH SINH VIEN=====>");
		System.out.println("Ten Sinh Vien " + " Date " + "  Diem LP1 " + "  Diem LP2 " + "  Diem TB ");
		for (int i = 0; i < a; i++) {
			System.out.println(arrSinhvien[i] + " \t " + arrDate[i] + " \t " + arrDiemlp1[i] + " \t " + arrDiemlp2[i]
					+ " \t " + arrDiemtb[i]);
		}
	}

	public static void sapxep() {
		double temp = arrDiemtb[0];
		for (int i = 0; i < arrDiemtb.length - 1; i++) {
			for (int j = i + 1; j < arrDiemtb.length; j++) {
				if (arrDiemtb[i] > arrDiemtb[j]) {
					temp = arrDiemtb[j];
					arrDiemtb[j] = arrDiemtb[i];
					arrDiemtb[i] = temp;
					temp = arrDiemlp1[j];
					arrDiemlp1[j] = arrDiemlp1[i];
					arrDiemlp1[i] = temp;
					temp = arrDiemlp2[j];
					arrDiemlp2[j] = arrDiemlp2[i];
					arrDiemlp2[i] = temp;
					String temp1 = arrDate[j];
					arrDate[j] = arrDate[i];
					arrDate[i] = temp1;
					temp1 = arrSinhvien[j];
					arrSinhvien[j] = arrSinhvien[i];
					arrSinhvien[i] = temp1;
				}
			}
		}
		System.out.println("<==SAP XEP DIEM TU THAP DEN CAO==>");
		System.out.println("DIEM TU THAP DEN CAO: ");
		for (int i = 0; i < arrDiemtb.length; i++) {
			System.out.println(" Ten Sinh Vien: "+ arrSinhvien[i] + " :" + arrDiemtb[i] + " ");
		}

	}

	public static void ketthuc() {
		System.exit(0);
	}

	public static void myMenu() {
		while (true) {
			System.out.println("<=====LUA CHON CHUC NANG=====>");
			System.out.println("|| 1.NHAP TEN SINH VIEN      ||");
			System.out.println("|| 2.TOP SINH VIEN           ||");
			System.out.println("|| 3.DANH SACH SINH VIEN     ||");
			System.out.println("|| 4.SAP XEP TU CAO DEN THAP ||");
			System.out.println("|| 5.SAP XEP SINH VIEN ABC   ||");
			System.out.println("|| 6.KET THUC CHUONG TRINH   ||");
			System.out.println("<============================>");
			System.out.println("      LUA CHON CUA BAN        ");
			int option = myInput.nextInt();
			if (option == 1) {
				nhapten();
			} else if (option == 2) {
				topsinhvien();
			} else if (option == 3) {
				indanhsach();
			} else if (option == 4) {
				sapxep();
			} else if (option == 5) {
				sapxepten();
			} else if (option == 6) {
				ketthuc();
			}
		}
	}
}
