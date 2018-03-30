package Fasttrack.edu.vn;

import java.util.Scanner;

public class SinhVien {
	public static Scanner myScanner = new Scanner(System.in);
	public static String ngaysinh[];
	public static String tenSinhvien[];
	public static double diemLP1[];
	public static double diemLP2[];
	public static double diemTB[];
	public static int tongSinhvien=0;
	public static int i=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myMenu();
	}

	public static void myMenu() {
		while (true) {
			System.out.println("--------------------------------");
			System.out.println("Moi cac ban lua chon chuc nang");
			System.out.println("1. Nhap thong tin sinh vien");
			System.out.println("2. In danh sach sinh vien");
			System.out.println("3. Thong ke top sinh vien");
			System.out.println("4. Thoat chuong trinh");
			System.out.println("Lua chon cua ban :");
			int myOption = myScanner.nextInt();
			if (myOption == 1) {
				nhapthongtinSV();
			}
			if (myOption == 2) {
				inDSSV();
			}
			if (myOption == 3) {
				thongkeTopSV();
			}
			if (myOption == 4) {
				ketthuc();
			}
		}
	}

	public static void nhapthongtinSV() {
		System.out.println("Tong so sinh vien : ");
		tongSinhvien = myScanner.nextInt();
		ngaysinh = new String[tongSinhvien];
		tenSinhvien = new String[tongSinhvien];
		diemLP1 = new double[tongSinhvien];
		diemLP2 = new double[tongSinhvien];
		diemTB = new double[tongSinhvien];
		for (i = 0; i < tongSinhvien; i++) {
			System.out.print("Ten cua sinh vien thu " + (i + 1) + " : ");
			tenSinhvien[i] = myScanner.next();
			System.out.print("Ngay sinh cua sinh vien thu " + (i + 1) + " : ");
			ngaysinh[i] = myScanner.next();
			System.out.print("Diem LP1 cua sinh vien thu" + (i + 1) + " : ");
			diemLP1[i] = myScanner.nextDouble();
			System.out.print("Diem LP2 cua sinh vien thu" + (i + 1) + " : ");
			diemLP2[i] = myScanner.nextDouble();
			diemTB[i] = (diemLP1[i]+diemLP2[i])/2;
			System.out.println("Diem trung binh : "+diemTB[i]);
		}
		myScanner.nextLine();
		System.out.println("An Enter de quay lai!");
		myScanner.nextLine();
	}

	public static void inDSSV() {
		for (i = 0; i < tongSinhvien; i++) {
		System.out.println("| Ten sinh vien thu"+(i+1)+" : "+tenSinhvien[i]+" Ngay sinh : "+ngaysinh[i]+" Diem LP1 : "+diemLP1[i]+" Diem LP2 : "+diemLP2[i]+" Diem TB : "+diemTB[i]);
		}
		myScanner.nextLine();
		System.out.println("An Enter de quay lai!");
		myScanner.nextLine();
	}

	public static void thongkeTopSV() {
		double max;
		int vitrimax=0 ;
		max = diemTB[0];
		for (i=0;i<tongSinhvien;i++) {
			if(max<diemTB[i]) {
				max=diemTB[i];
				vitrimax = i;
			}
		}
		System.out.println("Sinh vien thu "+(vitrimax+1)+" ten la "+tenSinhvien[vitrimax]+" co diem TB cao nhat "+diemTB[vitrimax]);
		myScanner.nextLine();
		System.out.println("An Enter de quay lai!");
		myScanner.nextLine();
	}
	public static void ketthuc() {
		System.out.print("Chuong trinh da ket thuc. Cam on ban !");
		System.exit(0);
	}
}
