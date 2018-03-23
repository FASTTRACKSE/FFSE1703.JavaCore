package fasttrackse.edu.vn;

import java.util.Scanner;

public class QuanLiSvien {
	public static Scanner myScanner = new Scanner(System.in);
	public static Double[] arrSTT;
	public static String[] arrSinhVien;
	public static Double[] diemLP1;
	public static Double[] diemLP2;
	public static Double[] diemTB;
	public static int tongSinhVien = 0;
	public static void main(String[] args) {
	showMenu();

	}

	public static void showMenu() {
		while(true) {
			System.out.println("LUA CHON CHUC NANG");
			System.out.println("1. Nhap danh sach sih vien");
			System.out.println("2. In danh sach sinh vien");
			System.out.println("3. SinhVienTieuBieu");
			System.out.println("4. sinhVienYeuNhat");
			System.out.println("5. Kết thúc chương trình");
			System.out.println("Lựa chọn của bạn");
			
			int myOption = myScanner.nextInt();
			
			if (myOption == 1) {
				nhapThongTinSinhVien();
			} else if (myOption == 2) {
				inDiemSinhVien();
			} else if (myOption == 3) {
				sinhVienTieuBieu();
			}
			else if (myOption == 4) {
				sinhVienYeuNhat();
			}
			else if (myOption == 5 ) {
				ketThuc();
			}
	}}
		public static void nhapThongTinSinhVien() {
			System.out.println("Nhap danh sach sinh vien");
			int size;
			System.out.println("------------------------");
			System.out.print("Tong so sinh vien");
			size = myScanner.nextInt();
			arrSinhVien = new String[size];
			diemLP1 = new Double[size];
			diemLP2 = new Double[size];
			diemTB = new Double[size];
			for (int i = 0; i < size; i++) {
			myScanner.nextLine();
			System.out.println("Nhap ten sinh vien thu" + (i+1)+ ":");
			arrSinhVien[i] = myScanner.nextLine();
			System.out.println("Nhap diem LP1 " + (i+1)+ ":");
			diemLP1[i] = myScanner.nextDouble();
			System.out.println("Nhap diem LP2 " + (i+1)+ ":");
			diemLP2[i] = myScanner.nextDouble();
			diemTB[i] = (diemLP1[i] + diemLP2[i])/2;
			
			myScanner.nextLine();
			}
			}
			
   public static void inDiemSinhVien() {
	   System.out.println("Danh sach sinh vien");
	   System.out.println("      STT      |      Ten SV      |      Diem LP1       |      Diem LP2     |      Diem TB       ");
	   for (int  i=0 ; i < arrSinhVien.length ; i++) { 
		   System.out.println("                  "+ arrSinhVien[i] +"               "+ diemLP1[i] +"               "+ diemLP2[i] +"                 "+ diemTB[i] +"     ");
			myScanner.nextLine();  
	   }
	   
	}
    public static void sinhVienTieuBieu() {
    	Double max = diemTB[0];
    	int vtri = 0;
    	for ( int i=0 ; i < arrSinhVien.length   ; i++) { 
    		if (max < diemTB[i])  max = diemTB[i];	
    	}
    	System.out.println("Sinh vien tieu bieu là :   "+ arrSinhVien[vtri] +" "+ diemTB + " " + max);
    }
    public static void sinhVienYeuNhat() {
    	Double min = diemTB[0];
    	int vtri = 0;
    	for ( int i=0 ; i < arrSinhVien.length   ; i++) { 
    		if (min < diemTB[i])  min = diemTB[i];	
    	}
    	System.out.println("Sinh vien yeu nhat là :   "+ arrSinhVien[vtri] +" "+ diemTB + " " + min);
    }
    public static void ketThuc() {
		System.out.println("Kết thúc chương trình");
		System.exit(0);
		
	}
}

