package hinhhoc.main;

import java.util.Scanner;
import hinhhoc.model.*;

public class ChuViDienTichHinhHoc {
	public static HinhHoc hinhHoc1 = new HinhTron();
	public static HinhHoc hinhHoc2 = new HinhChuNhat();
	public static HinhHoc hinhHoc3 = new HinhTamGiac();
	public static HinhTron hinh1 = new HinhTron();
	public static HinhChuNhat hinh2 = new HinhChuNhat();
	public static HinhTamGiac hinh3 = new HinhTamGiac();
	public static Scanner myInput = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		menu();
	}
	public static void menu() {
		while (true) {
			System.out.println("Danh sach bai toan");
			System.out.println("1. Chu vi va dien tich hinh tron.");
			System.out.println("2. Chu vi va dien tich hinh chu nhat.");
			System.out.println("3. Chu vi va dien tich hinh tam giac.");
			System.out.print("Vui long nhap so de chon: ");
			int x = myInput.nextInt();
			switch (x) {
			case 1:
				hinhTron();
				break;
			case 2:
				hinhChuNhat();
				break;
			case 3:
				hinhTamGiac();
				break;
			case 4:
				ketThuc();
				break;
			}
		}
	}
	public static void hinhTron() {
		System.out.print("Nhap ban kinh hinh tron: ");
		double banKinh = myInput.nextDouble();
		hinh1.setBanKinh(banKinh);
		System.out.printf("Chu vi hinh tron la: %.2f \n",hinhHoc1.getChuVi());
		System.out.printf("Dien tich hinh tron la: %.2f \n",hinhHoc1.getDienTich());
		
		myInput.nextLine();
		System.out.println();
		myInput.nextLine();
	}
	public static void hinhChuNhat() {
		System.out.print("Nhap chieu dai hinh chu nhat: ");
		double chieuDai = myInput.nextDouble();
		System.out.print("Nhap chieu rong hinh chu nhat: ");
		double chieuRong = myInput.nextDouble();
		hinh2.setDaiRong(chieuDai,chieuRong);
		System.out.printf("Chu vi hinh chu nhat la: %.2f \n",hinhHoc2.getChuVi());
		System.out.printf("Dien tich hinh chu nhat la: %.2f \n",hinhHoc2.getDienTich());
		
		myInput.nextLine();
		System.out.println();
		myInput.nextLine();
	}
	public static void hinhTamGiac() {
		System.out.print("Nhap canh thu nhat hinh tam giac: ");
		double canhA = myInput.nextDouble();
		System.out.print("Nhap canh thu hai hinh tam giac: ");
		double canhB = myInput.nextDouble();
		System.out.print("Nhap canh thu ba hinh tam giac: ");
		double canhC = myInput.nextDouble();
		if ((canhA+canhB) == canhC || (canhA+canhC) == canhB || (canhB+canhC) == canhA) {
			System.out.println();
			System.out.println("Xin vui long nhap lai!");
			hinhTamGiac();
		} else {
		hinh3.setCanh(canhA,canhB,canhC);
		System.out.printf("Chu vi hinh tam giac la: %.2f \n",hinhHoc3.getChuVi());
		System.out.printf("Dien tich hinh tam giac la: %.2f \n",hinhHoc3.getDienTich());
		myInput.nextLine();
		System.out.println();
		myInput.nextLine();
		}
	}
	public static void ketThuc() {
		System.out.println();
		System.out.println("Cam on ban da su dung chuong trinh!");
		System.exit(0);
	}

}
