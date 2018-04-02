package fasstrack.edu.vn;

import java.util.Scanner;
import java.util.ArrayList;

public class QuanLyTienDien {
	public static Scanner myInput = new Scanner(System.in);
	private static ArrayList<BienLai> arrBienLai = new ArrayList<BienLai>();
	public static BienLai []bienLai;
	public static KhachHang []khachHang;
	public static void main(String[] args) {
		menu();
	}
	public static void menu() {
		System.out.println("\n");
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
		khachHang = new KhachHang[slg];
		for (int i = 0; i < slg; i++) {
			khachHang[i] = new KhachHang();
			System.out.print("Ma khach hang: ");
			khachHang[i].setMaKH(myInput.next());	
			System.out.print("Ten khach hang: ");
			khachHang[i].setTenKH(myInput.next());
			System.out.print("Dia chi khach hang: ");
			khachHang[i].setDiaChiKH(myInput.next());
			System.out.print("Ma cong to: ");
			khachHang[i].setMaCT(myInput.next());
			System.out.print("\n");
		}
		myInput.nextLine();
		System.out.println();
		myInput.nextLine();
	}
	public static void chiSoTieuThu() {
		bienLai = new BienLai[khachHang.length];
		System.out.println("Nhap chi so tieu thu dien");
		System.out.print("Nhap thang: ");
		String thang = myInput.next();
		System.out.print("Nhap nam: ");
		String nam = myInput.next();
		for (int j = 0; j < khachHang.length; j++) {
			bienLai[j] = new BienLai();
			bienLai[j].setMaKH(khachHang[j].getMaKH());
			bienLai[j].setTenKH(khachHang[j].getTenKH());
			bienLai[j].setDiaChiKH(khachHang[j].getDiaChiKH());
			bienLai[j].setMaCT(khachHang[j].getMaCT());
			bienLai[j].setThang(thang);
			bienLai[j].setNam(nam);
			System.out.println("Ma cong to: "+bienLai[j].getMaCT());
			System.out.print("Chi so cu: ");
			bienLai[j].setChiSoCu(myInput.nextInt());
			System.out.print("Chi so moi: ");
			bienLai[j].setChiSoMoi(myInput.nextInt());
			arrBienLai.add(bienLai[j]); 
			System.out.println("\n");
		}
		myInput.nextLine();
		System.out.println("\n");
		myInput.nextLine();
	}
	public static void hoaDonKH() {
		System.out.println("\n");
		while (true) {
			System.out.println("Chuong Trinh Quan Ly Tien Dien");
			System.out.println("1. In tat ca bien lai.");
			System.out.println("2. In bien lai theo ma khach hang.");
			System.out.println("3. Thong ke theo thang.");
			System.out.println("4. Thong ke theo nam.");
			System.out.println("5. Thong ke theo khoang thoi gian.");
			System.out.println("0. Quay tro lai.");
			System.out.print("Xin vui long nhap so thu tu de chon chuong trinh: ");
			int x = myInput.nextInt();
			switch (x) {
			case 1:
				inAll();
				break;
			case 2:
				inTheoMaKH();
				break;
			case 3:
				inTheoThang();
				break;
			case 4:
				inTheoNam();
				break;
			case 5:
				inTheoThoiGian();
				break;
			case 0:
				menu();
				break;
			}
		}
	}
	public static void inAll() {
		System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s \n","Ma khach hang","Ten khach hang","Dia chi khach hang","Ma cong to","Chi so cu","Chi so moi","Tien dien","Thang","Nam");
		for (BienLai x: arrBienLai) {
			System.out.printf("%-20s %-20s %-20s %-20s %-20d %-20d %-20d %-20s %-20s Dong \n",x.getMaKH(),x.getTenKH(),x.getDiaChiKH(),x.getMaCT(),x.getChiSoCu(),x.getChiSoMoi(),x.tinhTienDien(),x.getThang(),x.getNam());
		}
		myInput.nextLine();
		System.out.println("\n");
		myInput.nextLine();
	}
	public static void inTheoThang() {
		int tongTien = 0;
		System.out.print("Nhap thang: ");
		String thang = myInput.next();
		System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s \n","Ma khach hang","Ten khach hang","Dia chi khach hang","Ma cong to","Chi so cu","Chi so moi","Tien dien","Thang","Nam");
		for (BienLai x: arrBienLai) {
			if (thang.equals(x.getThang())) {
				System.out.printf("%-20s %-20s %-20s %-20s %-20d %-20d %-20d %-20s %-20s Dong \n",x.getMaKH(),x.getTenKH(),x.getDiaChiKH(),x.getMaCT(),x.getChiSoCu(),x.getChiSoMoi(),x.tinhTienDien(),x.getThang(),x.getNam());
				tongTien += x.tinhTienDien();
			}
		}
		System.out.print("Tong tien dien: "+tongTien);
		myInput.nextLine();
		System.out.println("\n");
		myInput.nextLine();
		
	}
	public static void inTheoNam() {
		int tongTien = 0;
		System.out.print("Nhap nam: ");
		String nam = myInput.next();
		System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s \n","Ma khach hang","Ten khach hang","Dia chi khach hang","Ma cong to","Chi so cu","Chi so moi","Tien dien","Thang","Nam");
		for (BienLai x: arrBienLai) {
			if (nam.equals(x.getNam())) {
				System.out.printf("%-20s %-20s %-20s %-20s %-20d %-20d %-20d %-20s %-20s Dong \n",x.getMaKH(),x.getTenKH(),x.getDiaChiKH(),x.getMaCT(),x.getChiSoCu(),x.getChiSoMoi(),x.tinhTienDien(),x.getThang(),x.getNam());
				tongTien += x.tinhTienDien();
			}
		}
		
		System.out.print("Tong tien dien: "+tongTien);
		myInput.nextLine();
		System.out.println("\n");
		myInput.nextLine();
		
	}
	public static void inTheoMaKH() {
		int tongTien = 0;
		System.out.print("Nhap ma khach hang: ");
		String maKH = myInput.next();
		System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s \n","Ma khach hang","Ten khach hang","Dia chi khach hang","Ma cong to","Chi so cu","Chi so moi","Tien dien","Thang","Nam");
		for (BienLai x: arrBienLai) {
			if (maKH.equals(x.getMaKH())) {
				System.out.printf("%-20s %-20s %-20s %-20s %-20d %-20d %-20d %-20s %-20s Dong \n",x.getMaKH(),x.getTenKH(),x.getDiaChiKH(),x.getMaCT(),x.getChiSoCu(),x.getChiSoMoi(),x.tinhTienDien(),x.getThang(),x.getNam());
				tongTien += x.tinhTienDien();
			}
		}
		System.out.print("Tong tien dien: "+tongTien);
		myInput.nextLine();
		System.out.println("\n");
		myInput.nextLine();
		
	}
	public static void inTheoThoiGian() {
		int tongTien = 0;
		System.out.print("Tu thang: ");
		String thang1 = myInput.next();
		System.out.print("Nam: ");
		String nam1 = myInput.next();
		System.out.print("Den thang: ");
		String thang2 = myInput.next();
		System.out.print("Nam: ");
		String nam2 = myInput.next();
		System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s \n","Ma khach hang","Ten khach hang","Dia chi khach hang","Ma cong to","Chi so cu","Chi so moi","Tien dien","Thang","Nam");
		for (BienLai x: arrBienLai) {
			if ((x.getNam()).compareTo(nam1)>=0 && (x.getNam()).compareTo(nam2)<=0 ){
				if ((x.getThang()).compareTo(thang1)>=0 && (x.getThang()).compareTo(thang2)<=0) {
					System.out.printf("%-20s %-20s %-20s %-20s %-20d %-20d %-20d %-20s %-20s Dong \n",x.getMaKH(),x.getTenKH(),x.getDiaChiKH(),x.getMaCT(),x.getChiSoCu(),x.getChiSoMoi(),x.tinhTienDien(),x.getThang(),x.getNam());
					tongTien += x.tinhTienDien();
				}
			}
		}
		System.out.print("Tong tien dien: "+tongTien);
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
