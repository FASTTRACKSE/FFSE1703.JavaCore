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
		
		System.out.println("Nhap so luong");
		 a = myInput.nextInt();
	 arrSinhvien = new String[a];
	 arrDate = new String[a];
	 arrDiemlp1 = new double[a];
	 arrDiemlp2 = new double[a];
	 arrDiemtb = new double[a];

		for(int i=0;i<a;i++) {
			myInput.nextLine();
			System.out.println("Nhap Ho Va Ten Sinh Vien");
			arrSinhvien[i] = myInput.nextLine();
			System.out.println("Nhap Ngay Sinh");
			arrDate[i] = myInput.nextLine();
			System.out.println("Nhap Diem LP1");
			arrDiemlp1[i] = myInput.nextDouble();
			System.out.println("Nhap Diem LP2");
			arrDiemlp2[i] = myInput.nextDouble();
			arrDiemtb[i]=((arrDiemlp1[i]+arrDiemlp2[i])/(2));
		}

	}
	public static void topsinhvien() {
		System.out.println("DANH SACH TOP");
		double max = arrDiemtb[0];
		int maxvt = 0;
		for(int i=0;i<arrDiemtb.length;i++) {
			if(max < arrDiemtb[i]) {
				max = arrDiemtb[i];
				maxvt = i;
				
			}
		}
		System.out.println("Ten Sinh Vien La: " + arrSinhvien[maxvt] + "\t" + "Diem Trung Binh La: " + max);
	}
	public static void indanhsach() {
		
		System.out.println("DANH SACH SINH VIEN");
		System.out.println("Ten Sinh Vien " + "    Date " + "    Diem LP1 " + "    Diem LP2 " + "    Diem TB ");
		for(int i=0;i<a;i++) {	
			System.out.println( " \t " + arrSinhvien[i] + " \t " + arrDate[i] +  " \t " + arrDiemlp1[i] +  " \t " + arrDiemlp2[i] +  " \t " + arrDiemtb[i] );
		}
	}
	public static void myMenu() {
		while(true) {
		System.out.println("LUA CHON CUA BAN");
		System.out.println("1.TEN SINH VIEN");
		System.out.println("2.TOP SINH VIEN");
		System.out.println("3.IN DANH SACH");
		int option = myInput.nextInt();
		if(option==1) {
			nhapten();
		}else if(option == 2) {
			topsinhvien();
		}else if(option == 3) {
			indanhsach();
		}
		}
	}
}
