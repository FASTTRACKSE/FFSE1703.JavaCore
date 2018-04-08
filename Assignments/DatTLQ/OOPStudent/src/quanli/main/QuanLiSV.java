package quanli.main;

import java.util.Scanner;
import java.util.ArrayList;

import sinhvien.model.*;

public class QuanLiSV {

	public static Scanner scanner = new Scanner(System.in);
	public static int soLuong;
	public static ArrayList<SinhVien> arrSinhVien = new ArrayList<SinhVien>();
	public static int sortByDTB[];
	public static int sortByABC[];

	public static void main(String[] arg) {

		mymenu();

	}

	public static void nhapsinhvien() {
		try {
		System.out.println("Nhap so sinh vien" + " ");
		soLuong = scanner.nextInt();
		
			for (int i = 0; i < soLuong; i++) {

				scanner.nextLine();
				System.out.println("Nhap ten sinh vien" + " " + (i + 1) + ":");

				String stuName = scanner.nextLine();
				System.out.println("Nhap ngay sinh" + " " + (i + 1) + ":");
				String stuDate = scanner.nextLine();
				System.out.println("Nhap diem LP1" + " " + ":");
				double DLP1 = scanner.nextInt();
				System.out.println("Nhap diem LP2" + " " + ":");
				double DLP2 = scanner.nextInt();

				arrSinhVien.add(new SinhVien(stuName, stuDate, DLP1, DLP2));
			}
		} catch (Exception e) {
			System.out.println("Hay nhap dung dinh dang");
			scanner.nextLine();
		}
	}

	public static void indanhsach() {
		System.out.println("Danh Sach Sinh Vien");
		// tự chỉnh lại cái ni cho đều nữa
		System.out.printf("| %-20s | %-20s | %-15s | %-15s | %-15s | %-15s |\n", "Ten", "Ngay Sinh", "Diem LP1",
				"Diem LP2", "Diem TB", "Xep Loai");

		for (SinhVien x : arrSinhVien) {
			System.out.println(x);

		}
	}

	public static void topmin() {

		double max = arrSinhVien.get(0).getDTB(), min = arrSinhVien.get(0).getDTB();
		int keymax = 0, keymin = 0;
		for (int b = 1; b < soLuong; b++) {
			if (max < arrSinhVien.get(b).getDTB()) {
				max = arrSinhVien.get(b).getDTB();
				keymax = b;
			}
			if (min > arrSinhVien.get(b).getDTB()) {
				min = arrSinhVien.get(b).getDTB();
				keymin = b;
			}

		}
		System.out.println("Diem TB Cao Nhat:" + arrSinhVien.get(keymax).getStuName()
				+ arrSinhVien.get(keymax).getStuDate() + max);
		System.out.println("Diem TB Thap Nhat:" + arrSinhVien.get(keymin).getStuName()
				+ arrSinhVien.get(keymin).getStuDate() + min);
	}

	public static void maxmin() {
		sortByDTB = new int[soLuong];
		for (int i = 0; i < soLuong; i++) {
			sortByDTB[i] = i;
		}
		for (int i = 0; i < soLuong - 1; i++) {
			for (int j = i + 1; j < soLuong; j++) {
				if (arrSinhVien.get(sortByDTB[i]).getDTB() > arrSinhVien.get(sortByDTB[j]).getDTB()) {
					int temp = sortByDTB[j];
					sortByDTB[j] = sortByDTB[i];
					sortByDTB[i] = temp;
				}
			}

		}

		System.out.printf("| %-20s | %-20s | %-15s | %-15s | %-15s | %-15s |\n", "Ten", "Ngay Sinh", "Diem LP1",
				"Diem LP2", "Diem TB", "Xep Loai");
		for (int i = 0; i < soLuong; i++) {

			System.out.printf("| %-20s | %-20s | %-15s | %-15s | %-15s | %-15s |",
					arrSinhVien.get(sortByDTB[i]).getStuName(), arrSinhVien.get(sortByDTB[i]).getStuDate(),
					arrSinhVien.get(sortByDTB[i]).getDLP1(), arrSinhVien.get(sortByDTB[i]).getDLP2(),
					arrSinhVien.get(sortByDTB[i]).getDTB(), arrSinhVien.get(sortByDTB[i]).getXeploai());

		}
	}

	public static void abc() {
		sortByABC = new int[soLuong];
		for (int i = 0; i < soLuong; i++) {
			sortByABC[i] = i;
		}
		for (int i = 0; i < soLuong - 1; i++) {
			for (int j = i + 1; j < soLuong; j++) {
				if (arrSinhVien.get(sortByABC[i]).getStuName()
						.compareTo(arrSinhVien.get(sortByABC[j]).getStuName()) > 0) {
					int temp = sortByABC[j];
					sortByABC[j] = sortByABC[i];
					sortByABC[i] = temp;
				}
			}

		}

		System.out.printf("| %-20s | %-20s | %-15s | %-15s | %-15s | %-15s |\n", "Ten", "Ngay Sinh", "Diem LP1",
				"Diem LP2", "Diem TB", "Xep Loai");

		for (int i = 0; i < soLuong; i++) {

			System.out.printf("| %-20s | %-20s | %-15s | %-15s | %-15s | %-15s |",
					arrSinhVien.get(sortByABC[i]).getStuName(), arrSinhVien.get(sortByABC[i]).getStuDate(),
					arrSinhVien.get(sortByABC[i]).getDLP1(), arrSinhVien.get(sortByABC[i]).getDLP2(),
					arrSinhVien.get(sortByABC[i]).getDTB(), arrSinhVien.get(sortByABC[i]).getXeploai());
		}
	}

	public static void inName() {
		scanner.nextLine();

		System.out.println("Nhap ten sinh vien");
		String stuName = scanner.nextLine();
		System.out.println("In thanh cong sinh vien");
		System.out.printf("| %-20s | %-20s | %-15s | %-15s | %-15s | %-15s |\n", "Ten", "Ngay Sinh", "Diem LP1",
				"Diem LP2", "Diem TB", "Xep Loai");

		for (SinhVien x : arrSinhVien) {
			if (x.getStuName().indexOf(stuName)>-1) {
				System.out.println(x);

			}
		}
	}

	public static void reName() {
		scanner.nextLine();

		System.out.println("Nhap ten sinh vien");
		String stuName = scanner.nextLine();
		System.out.println("Nhap ten muon thay doi");
		String reName = scanner.nextLine();
		System.out.println("Doi thanh cong sinh vien");
		System.out.printf("| %-20s | %-20s | %-15s | %-15s | %-15s | %-15s |\n", "Ten", "Ngay Sinh", "Diem LP1",
				"Diem LP2", "Diem TB", "Xep Loai");

		for (SinhVien x : arrSinhVien) {
			if (x.getStuName().indexOf(stuName)>-1) {
				x.setStuName(reName);
				System.out.println(x);

			}
		}

	}

	public static void delName() {
		scanner.nextLine();
		System.out.printf("| %-20s | %-20s | %-15s | %-15s | %-15s | %-15s |\n", "Ten", "Ngay Sinh", "Diem LP1",
				"Diem LP2", "Diem TB", "Xep Loai");

		for (SinhVien x : arrSinhVien) {
			System.out.println(x);

		}
		System.out.println("Nhap ten sinh vien ban muon xoa");
		String stuName = scanner.nextLine();
		for (int i = 0; i < arrSinhVien.size(); i++) {
			if (arrSinhVien.get(i).getStuName().indexOf(stuName)>-1) {
				arrSinhVien.remove(i);
				i--;
			}
		}
		System.out.println("Danh sach sinh vien moi nhat");
		System.out.printf("| %-20s | %-20s | %-15s | %-15s | %-15s | %-15s |\n", "Ten", "Ngay Sinh", "Diem LP1",
				"Diem LP2", "Diem TB", "Xep Loai");
		for (SinhVien x : arrSinhVien) {
			System.out.println(x);

		}
	}

	public static void end() {
		System.exit(0);
	}

	public static void mymenu() {
		while (true) {
			try {
				System.out.println("---LUA CHON CHUC NANG---");
				System.out.println("_______________________________________" + "\n");
				System.out.println("||1: Nhap ten sinh vien 	     \t||");
				System.out.println("||2: In danh sach                    \t||");
				System.out.println("||3: In sinh vien cao diem va tha    \t||");
				System.out.println("||4: In sinh vien DTB tu cao den thap\t||");
				System.out.println("||5: In sinh vien DTB theo ABC       \t||");
				System.out.println("||6: In sinh vien theo ten           \t||");
				System.out.println("||7: Doi ten sinh vien               \t||");
				System.out.println("||8: Xoa sinh vien                   \t||");
				System.out.println("||Ket Thuc Chuong Trinh              \t||");

				System.out.println("_______________________________________" + "\n");

				int input = scanner.nextInt();
				if (input == 1) {
					nhapsinhvien();
				} else if (input == 2) {
					indanhsach();
				} else if (input == 3) {
					topmin();
				} else if (input == 4) {
					maxmin();
				} else if (input == 5) {
					abc();
				} else if (input == 6) {
					inName();
				} else if (input == 7) {
					reName();
				} else if (input == 8) {
					delName();
				} else if (input == 9) {
					end();
				} else {
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.println("Chi nhap lai tu 1 den 9,hay nhap lai nhe");
				scanner.nextLine();
			}

		}
	}

}
