package Assignment_8.main;

import Assignment_8.model.*;
import Assignment_8.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class QuanLySinhVien {
	private static Scanner myInput= new Scanner(System.in);
	public static int Sv;
	public static SinhVien []Sinhvien;
	public static ArrayList<SinhVien> arrSinhVien = new ArrayList<SinhVien>();
	public static ArrayList<SinhVien> arSinhVien = new ArrayList<SinhVien>();
	public static void main(String[] args) {	
		menu();
	}
	public static void menu() {
		while (true) {
			System.out.println("Xin chon chuong trinh duoi day:");
			System.out.println("1. Nhap thong tin sinh vien.");
			System.out.println("2. Danh sach sinh vien.");
			System.out.println("3. Doi ten sinh vien.");
			System.out.println("4. Xoa sinh vien.");
			System.out.println("5. Tim kiem sinh vien.");
			System.out.println("6. Ket thuc chuong trinh.");
			try {
				System.out.print("Vui long nhap so de chon bai toan: ");
				int x = myInput.nextInt();
				if (x==1) {
					ThongtinSV();
				} else if (x==2) {
					Danhsach();
				} else if (x==3) {
					renameSV();
				} else if (x==4) {
					removeSV();
				} else if (x==5) {
					search();
				} else if (x==6) {
					ketthuc();
				} else {
					throw new Exception();
				}
			} catch (NumberFormatException e) {
				System.out.println("Xin hay nhap cac so tu 1 den 6!");
				myInput.nextLine();
			} catch (Exception e) {
				System.out.println("Xin hay nhap so!");
				myInput.nextLine();
			}		
		}
	}
	public static void ThongtinSV() {
		System.out.print("\n");
		try {
			System.out.print("Nhap so luong sinh vien: ");
			Sv = myInput.nextInt();
			Sinhvien = new SinhVien[Sv];
		} catch (Exception e) {
			System.out.println("Xin hay nhap so!");
			
		}
		for (int i = 0; i < Sv; i++) {
			Sinhvien[i] = new SinhVien();
			System.out.print("Nhap ten sinh vien: ");
			String Hoten = myInput.next();
			Sinhvien[i].setHoten(Hoten);
			try {
				System.out.print("Nhap tuoi sinh vien: ");
				int tuoiSV = myInput.nextInt();
				Sinhvien[i].setTuoiSV(tuoiSV);
			} catch (Exception e) {
				System.out.println("Xin hay nhap so!");
				myInput.nextLine();
			}
			try {
				System.out.print("Nhap diem LP1: ");
				float DiemLP1 = myInput.nextFloat();
				Sinhvien[i].setDiemLP1(DiemLP1);
			} catch (Exception e) {
				System.out.println("Xin hay nhap so!");
			}
			try {
				System.out.print("Nhap diem LP2: ");
				float DiemLP2 = myInput.nextFloat();
				Sinhvien[i].setDiemLP2(DiemLP2);
			} catch (Exception e) {
				System.out.println("Xin hay nhap so!");
			}
			arrSinhVien.add(Sinhvien[i]);
		}
		ghiFile();
		myInput.nextLine();
		System.out.print("\n");
		myInput.nextLine();
	}
	public static void Danhsach() {
		ArrayList<SinhVien> arSinhVien = FileFactory.docFile("dulieu.txt");
		ArrayList<SinhVien> arSinhVien2 = FileFactory2.docFile("dulieu2.txt");
		System.out.print("\n");
		System.out.printf("%-12s %-12s %-12s %-12s %-12s %-12s \n","Ten","Tuoi","Diem LP1","Diem LP2","Diem TB","Xep Loai");
		for (SinhVien x: arSinhVien) {
			System.out.printf("%-12s %-12d %-12.2f %-12.2f %-12.2f %-12s \n",x.getHoten(),x.getTuoiSV(),x.getDiemLP1(),x.getDiemLP2(),x.getDiemTB(),x.getXeploai());
		}
		System.out.println("\n");
		for (SinhVien x: arSinhVien2) {
			System.out.printf("%-12s %-12d %-12.2f %-12.2f %-12.2f %-12s \n",x.getHoten(),x.getTuoiSV(),x.getDiemLP1(),x.getDiemLP2(),x.getDiemTB(),x.getXeploai());
		}
		myInput.nextLine();
		System.out.print("\n");
		myInput.nextLine();
	}
	public static void search() {
		ArrayList<SinhVien> arSinhVien = FileFactory.docFile("dulieu.txt");
		System.out.println("Nhap ten sinh vien: ");
		String keyWord = myInput.next();
		System.out.printf("%-12s %-12s %-12s %-12s %-12s %-12s \n","Ten","Tuoi","Diem LP1","Diem LP2","Diem TB","Xep Loai");
		for (SinhVien x: arSinhVien) {
			if (x.getHoten().equals(keyWord)) {
				System.out.printf("%-12s %-12d %-12.2f %-12.2f %-12.2f %-12s \n",x.getHoten(),x.getTuoiSV(),x.getDiemLP1(),x.getDiemLP2(),x.getDiemTB(),x.getXeploai());
			}	
		}
		myInput.nextLine();
		System.out.print("\n");
		myInput.nextLine();

	}
	public static void renameSV() {
		ArrayList<SinhVien> arSinhVien = FileFactory.docFile("dulieu.txt");
		System.out.println("Do ten sinh vien");
		System.out.print("Ten sinh vien: ");
		String oldName = myInput.next();
		System.out.print("Ten moi: ");
		String newName = myInput.next();
		for (SinhVien x : arSinhVien) {
			if ((x.getHoten()).equals(oldName)) {
				x.setHoten(newName);
			}
		}
		System.out.printf("%-12s %-12s %-12s %-12s %-12s %-12s \n","Ten","Tuoi","Diem LP1","Diem LP2","Diem TB","Xep Loai");
		for (SinhVien x: arSinhVien) {
			System.out.printf("%-12s %-12d %-12.2f %-12.2f %-12.2f %-12s \n",x.getHoten(),x.getTuoiSV(),x.getDiemLP1(),x.getDiemLP2(),x.getDiemTB(),x.getXeploai());
		}
		myInput.nextLine();
		System.out.print("\n");
		myInput.nextLine();

	}
	public static void removeSV() {
		ArrayList<SinhVien> arSinhVien = FileFactory.docFile("dulieu.txt");
		System.out.print("Ten sinh vien can xoa thong tin: ");
		String nameSV = myInput.next();
		for (SinhVien x : arSinhVien) {
			if ((x.getHoten()).equals(nameSV)) {
				arrSinhVien.remove(x);
				break;
			}
		}
		System.out.printf("%-12s %-12s %-12s %-12s %-12s %-12s \n","Ten","Tuoi","Diem LP1","Diem LP2","Diem TB","Xep Loai");
		for (SinhVien x: arrSinhVien) {
			System.out.printf("%-12s %-12d %-12.2f %-12.2f %-12.2f %-12s \n",x.getHoten(),x.getTuoiSV(),x.getDiemLP1(),x.getDiemLP2(),x.getDiemTB(),x.getXeploai());
		}
		myInput.nextLine();
		System.out.print("\n");
		myInput.nextLine();

	}
	public static void ghiFile() {
		boolean kt = FileFactory.luuFile(arrSinhVien, "dulieu.txt");
		if (kt == true) {
			System.out.println("Luu file kieu byte thanh cong!");
		} else {
			System.out.println("Luu file kieu byte that bai!");
		}
		boolean kt2 = FileFactory2.luuFile(arrSinhVien, "dulieu2.txt");
		if (kt == true) {
			System.out.println("Luu file kieu text thanh cong!");
		} else {
			System.out.println("Luu file kieu text that bai!");
		}
	}
	public static void ketthuc() {
		System.out.println("\n");
		System.out.println("Cam on ban da su dung chuong trinh!");
		System.exit(0);
	}	

}