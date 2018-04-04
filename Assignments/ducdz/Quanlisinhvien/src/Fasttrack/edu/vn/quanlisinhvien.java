package Fasttrack.edu.vn;

import java.util.Scanner;
public class quanlisinhvien {
	public static int tongsosinhvien=0;
	public static sinhvien[] sv = new sinhvien[100];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		menu();
	}
	public static Scanner myScanner = new Scanner(System.in);
	public static void menu() {
		System.out.println("Menu lua chon:");
		System.out.println("1.Nhap thong tin sinh vien");
		System.out.println("2.In danh sach sinh vien");
		System.out.println("3.In sinh vien cao diem nhat va thap diem nhat");
		System.out.println("4.In danh sach theo diem TB tu cao den thap");
		System.out.print("Lua chon cua ban la : ");
		int myOption =0;
		myOption = myScanner.nextInt();
		if(myOption==1) {
			nhap_info_sinhvien();
		}
		if(myOption==2) {
			in_danh_sach();
		}
		if(myOption==3) {
			in_sinhvien_maxmin();
		}
		if(myOption==4) {
			in_tu_cao_den_thap();
		}
	}
	
	public static void nhap_info_sinhvien() {
		System.out.print("Tong so sinh vien : ");
		tongsosinhvien = myScanner.nextInt();
		for(int i=0;i<tongsosinhvien;i++) {
			sinhvien newSV = new sinhvien();
			
			myScanner.nextLine();
			System.out.print("Ten cua sinh vien thu "+(i+1) + ": ");
			String name = myScanner.nextLine();
			newSV.set_tensinhvien(name);
			System.out.println("Ngay sinh cua sinh vien thu "+(i+1)+": ");
			int date = myScanner.nextInt();
			newSV.set_ngaysinh(date);
			System.out.println("Diem LP1 : ");
			int point1 = myScanner.nextInt();
			newSV.set_diemLP1(point1);
			System.out.println("Diem LP2 : ");
			int point2 = myScanner.nextInt();
			newSV.set_diemLP2(point2);
			
			sv[i] = newSV;
			
			System.out.println("Diem trung binh : "+sv[i].tinh_diemTB());
			System.out.println("Xep loai : "+sv[i].xeploai());
			back_menu();
			}
	}
	public static void back_menu() {
		myScanner.nextLine();
		System.out.println("An Enter de tro ve !");
		myScanner.nextLine();
	}
	public static void in_danh_sach(sinhvien sv) {
		System.out.print("Danh sach sinh vien");
		for(int i=0;i<tongsosinhvien;i++) {
		System.out.print(sv.get_tensinhvien());
		}
	}
	public static void in_sinhvien_maxmin() {
		
	}
	public static void in_tu_cao_den_thap() {
		
	}
}
