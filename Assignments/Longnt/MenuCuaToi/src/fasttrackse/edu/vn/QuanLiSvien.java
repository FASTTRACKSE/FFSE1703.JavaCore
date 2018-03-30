package fasttrackse.edu.vn;

import java.util.Scanner;

public class QuanLiSvien {
	public static Scanner myScanner = new Scanner(System.in);
	public static String[] arrSinhVien;
	public static Double[] diemlP1;
	public static Double[] diemLP2;
	public static Double[] diemTB;
	public static int tongSinhVien = 0;

	public static void showMenu() {
		while(true) {
			System.out.println("LUA CHON CHUC NANG");
			System.out.println("1. Nhap danh sach sih vien");
			System.out.println("2. In danh sach sinh vien");
			System.out.println("3. Top sinh vien");
			System.out.println("4. Kết thúc chương trình");
			System.out.println("Lựa chọn của bạn");
			
			int myOption = myScanner.nextInt();
			
			if (myOption == 1) {
				nhapThongTinSinhVien();
			} else if (myOption == 2) {
				inDiemSinhVien();
			} else if (myOption == 3) {
				sinhVienTieuBieu();
			} else if (myOption == 4 ) {
				ketThuc();
			}
	}}
		public static void nhapThongTinSinhVien() {
			System.out.println("Nhap danh sach sinh vien");
			System.out.println("------------------------");
			System.out.println("Tong so sinh vien");
			tongSinhVien =  myScanner.nextInt();
			arrSinhVien = new String[tongSinhVien];
			for (int i = 0; i<tongSinhVien; i ++) {
				
			}
			}
			
   public static void inDiemSinhVien() {
		
	}
    public static void sinhVienTieuBieu() {
    	
    }
    public static void ketThuc() {
		
   	}
}
