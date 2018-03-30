package fasstrack.edu.vn;

import java.util.Scanner;
import java.util.ArrayList;

public class QuanLyTienDien {
	public static Scanner myInput = new Scanner(System.in);
	private static ArrayList<BienLai> arrBienLai = new ArrayList<BienLai>();
	public static BienLai []bienLai;
	public static void main(String[] args) {
		menu();
	}
	public static void menu() {
		while (true) {
			System.out.println("Chuong Trinh Quan Ly Tien Dien");
			System.out.println("1. Nhap thong tin khach hang.");
			System.out.println("2. Nhap chi so tieu thu dien.");
			System.out.println("3. Hoa don tien dien.");
			System.out.println("4. Ket thu chuong trinh.");
			System.out.print("Xin vui long nhap so thu tu de chon chuong trinh: ");
			int x = myInput.nextInt();
			switch (x) {
			case 1:
				thongTinKH();
				break;
			case 2:
				chiSoTieuThu();
				break;
			case 3:
				hoaDonKH();
				break;
			case 4:
				ketThuc();
				break;
			}
		}
	}
	public static void thongTinKH() {
		System.out.print("Nhap so luong khach hang: ");
		int slg = myInput.nextInt();
		bienLai = new BienLai[slg];
		for (int i = 0; i < slg; i++) {
			bienLai[i] = new BienLai();
			System.out.print("Ma khach hang: ");
			bienLai[i].setMaKH(myInput.next());	
			System.out.print("Ten khach hang: ");
			bienLai[i].setTenKH(myInput.next());
			System.out.print("Dia chi khach hang: ");
			bienLai[i].setDiaChiKH(myInput.next());
			System.out.print("Ma cong to: ");
			bienLai[i].setMaCT(myInput.next());
			System.out.print("\n");
		}
		myInput.nextLine();
	}
	public static void chiSoTieuThu() {
		System.out.println("Nhap chi so tieu thu dien");
		for (int j = 0; j < bienLai.length; j++) {
			System.out.println("Ma cong to: "+bienLai[j].getMaCT());
			System.out.print("Chi so cu: ");
			bienLai[j].setChiSoCu(myInput.nextInt());
			System.out.print("Chi so moi: ");
			bienLai[j].setChiSoMoi(myInput.nextInt());
			arrBienLai.add(bienLai[j]); 
			System.out.println("\n");
		}
		myInput.nextLine();
		myInput.nextLine();
	}
	public static void hoaDonKH() {
		System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-12s \n","Ma khach hang","Ten khach hang","Dia chi khach hang","Ma cong to","Chi so cu","Chi so moi","Tien dien");
		for (BienLai x: arrBienLai) {
			System.out.printf("%-20s %-20s %-20s %-20s %-20d %-20d %-12d Dong \n",x.getMaKH(),x.getTenKH(),x.getDiaChiKH(),x.getMaCT(),x.getChiSoCu(),x.getChiSoMoi(),x.tinhTienDien());
		}
		myInput.nextLine();
		System.out.println("\n");
		myInput.nextLine();
	}
	public static void ketThuc() {
		System.out.println("\n");
		System.out.println("Cam on ban da Su dung chuong trinh!");
		System.exit(0);
	}

}
