package quanlisv.main;

import java.util.ArrayList;
import java.util.Scanner;
import factoryfiles.io.serialize;
import sv.model.sinhvien;
import java.io.File;

public class qlsv {
	public static Scanner input = new Scanner(System.in);
	public static int n = 0;
	public static String action;
	static ArrayList<sinhvien> arraySinhVien = new ArrayList<sinhvien>();

	public static void luuFile() {
		String namesv;
		String ngaySinh;
		float Lp1;
		float Lp2;
		float Lp3;
		System.out.println("==THEM SINH VIEN VAO DANH SACH==");
		System.out.println("================================");
		System.out.println("Nhap so sinh vien ban muon them:");
		n = input.nextInt();
		for (int z = 0; z < n; z++) {
			input.nextLine();
			System.out.println("Nhap ten sinh vien thu  " + (z + 1) + " : ");
			namesv = input.nextLine();
			System.out.println("Nhap ngay sinh cho sinh vien thu " + (z + 1) + " : ");
			ngaySinh = input.nextLine();
			System.out.println("Nhap diem LP1 so sinh vien thu " + (z + 1) + " : ");
			Lp1 = input.nextFloat();
			System.out.println("Nhap diem LP2 so sinh vien thu " + (z + 1) + " : ");
			Lp2 = input.nextFloat();
			System.out.println("Nhap diem LP3 so sinh vien thu " + (z + 1) + " : ");
			Lp3 = input.nextFloat();
			arraySinhVien.add(new sinhvien(namesv, ngaySinh, Lp1, Lp2, Lp3));
		}
		action = input.nextLine();
		System.out.println("=====================================");

		boolean kt = serialize.luuFile(arraySinhVien, "text1.txt");
		if (kt == true) {
			System.out.println("Da luu thong tin cua " + n + " sinh vien");
		} else {
			System.out.println("Luu file that bai!");
		}
	}

	public static void main(String[] args) {
		myMenu();
			}
	public static void docFile() {
		ArrayList<sinhvien> dsSV = serialize.docFile("text1.txt");
		arraySinhVien = dsSV;
		int i = 1;
		System.out.println("Danh sach sinh vien nhap vao la:");
		System.out.println("STT\tTen\tNgay sinh\tDiem LP1\tDiem LP2\tDiem LP3\tDiem TB");
		for (sinhvien sv : dsSV) {
			System.out.print((i ++) + "\t");
			System.out.printf("%-10s %-15s %-15s %-10s %10s %15s \n", sv.getTenSV(), sv.getNgaysinh(), sv.getLp1(),
					sv.getLp2(), sv.getLP3(), sv.getDiemTB());
		}

	}
	public static void KetThuc() {
		System.out.println("=======HEN GAP LAI======");
		System.exit(0);
	}

	public static void myMenu() {
		while (true) {
			try {
				System.out.println("|======LUA CHON CHUC NANG=======|");
				System.out.println("| 1. Nhap danh sach sinh vien   |");
				System.out.println("| 2. Doc thong tin sinh vien    |");
				System.out.println("| 3. Ket thuc chuong trinh      |");
				System.out.println("|===============================|");
			
			
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
				System.out.println(" Chi duoc nhap tu 1 den 3, vui long thu lai");
				input.nextLine();

			}

		}
	}
}