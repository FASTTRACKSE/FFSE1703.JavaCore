package quanlisv.main;

import factoryfiles.io.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import sv.model.sinhvien;

public class qlsvtext {
	public static Scanner input = new Scanner(System.in);
	public static int n = 0;
	public static String action;
	static ArrayList<sinhvien> arraySinhvien = new ArrayList<sinhvien>();

	public static void luuFile() {
		String namesv;
		String ngaySinh;
		float Lp1;
		float Lp2;
		float Lp3;
		System.out.println("THEM SINH VIEN VAO LIST");
		System.out.println("============================");
		System.out.print("Nhap so sinh vien ban muon them :");
		n = input.nextInt();

		try {
			
			for (int i = 0; i < n; i++) {
				input.nextLine();
				System.out.println("Nhap ten sinh vien thu  " + (i + 1) + " : ");
				namesv = input.nextLine();
				System.out.println("Nhap ngay sinh sinh vien thu " + (i + 1) + " : ");
				ngaySinh = input.nextLine();
				System.out.println("Nhap diem LP1 cho sinh vien thu " + (i + 1) + " : ");
				Lp1 = input.nextFloat();
				System.out.println("Nhap diem LP2 cho sinh vien thu " + (i + 1) + " : ");
				Lp2 = input.nextFloat();
				System.out.println("Nhap diem LP3 cho sinh vien thu " + (i + 1) + " : ");
				Lp3 = input.nextFloat();
				arraySinhvien.add(new sinhvien(namesv, ngaySinh, Lp1, Lp2, Lp3));
				boolean checked = textfile.luuFile(arraySinhvien, "dlsv.txt");
				if (checked == true) {
					System.out.println("Da luu thong tin cua " + n + " sinh vien");
				} else {
					System.out.println("Luu that bai");
				}
			}
		} catch (Exception e) {
			System.out.println("Nhap sai dinh dang, vui long thu lai");
		}

	}

	public static void main(String[] args) {
		File file = new File("C:/dlsv.txt");
		if (file.exists()) {
			ArrayList<sinhvien> arrSvFile = textfile.docFile("dlsv.txt");
			arraySinhvien = arrSvFile;
		}
	myMenu();
	}
	public static void docFile() {
		int i = 1;
		ArrayList<sinhvien> arrSvFile = textfile.docFile("dlsv.txt");
//		 arraySinhVien = arrSvFile ;
		System.out.println("Danh sach sinh vien nhap vao:");
		System.out.println("STT\tTen\tNgay sinh\tDiem LP1\tDiem LP2\tDiem LP3\tDiem TB");
		for (sinhvien sv : arrSvFile) {
			System.out.print((i ++) + "\t");
			System.out.printf("%-10s %-15s %-15s %-10s %10s %15s \n", sv.getTenSV(), sv.getNgaysinh(), sv.getLp1(),
					sv.getLp2(), sv.getLP3(), sv.getDiemTB());
		}

	}
	public static void KetThuc() {
		System.out.println("=======Hen gap lai======");
		System.exit(0);
	}

	public static void myMenu() {
		while (true) {
			try {
				System.out.println("|=======LUA CHON CHUC NANG=======|");
				System.out.println("| 1. Nhap va luu du lieu vao file|");
				System.out.println("| 2. Doc thong tin sinh vien     |");
				System.out.println("| 3. Ket thuc chuong trinh       |");
				System.out.println("|================================|");
			
			
				int aye = input.nextInt();
				if (aye == 1) {
					luuFile();
				} else if (aye == 2) {
					docFile();
				} else if (aye == 3) {
					KetThuc();
				} else {
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.println(" Chi duoc nhyap tu 1 den 10, vui long thu lai!");
				input.nextLine();

			}

		}
	}
}