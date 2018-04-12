package ffse1703.main;

import java.util.ArrayList;
import java.util.Scanner;
import ffse1703.io.SerializeFileFactory;
import ffse1703.model.SinhVien;
import java.io.File;

public class QuanLySinhVien {
	public static Scanner input = new Scanner(System.in);
	public static int n = 0;
	public static String action;
	static ArrayList<SinhVien> arraySinhVien = new ArrayList<SinhVien>();

	public static void luuFile() {
		String namesv;
		String ngaySinh;
		float Lp1;
		float Lp2;
		float Lp3;
		System.out.println("THÊM SINH VIÊN VÀO DANH SÁCH");
		System.out.println("============================");
		System.out.println("Bạn muốn nhập bao nhiêu sinh viên:");
		n = input.nextInt();
		for (int z = 0; z < n; z++) {
			input.nextLine();
			System.out.println("Nhập Tên Sinh Viên Thứ  " + (z + 1) + " : ");
			namesv = input.nextLine();
			System.out.println("Nhập Ngày Sinh Cho Sinh Viên Thứ " + (z + 1) + " : ");
			ngaySinh = input.nextLine();
			System.out.println("Nhập Điểm LP#1 Cho Sinh Viên Thứ " + (z + 1) + " : ");
			Lp1 = input.nextFloat();
			System.out.println("Nhập Điểm LP#2 Cho Sinh Viên Thứ " + (z + 1) + " : ");
			Lp2 = input.nextFloat();
			System.out.println("Nhập Điểm LP#3 Cho Sinh Viên Thứ " + (z + 1) + " : ");
			Lp3 = input.nextFloat();
			arraySinhVien.add(new SinhVien(namesv, ngaySinh, Lp1, Lp2, Lp3));
		}
		action = input.nextLine();
		System.out.println("=====================================");

		boolean kt = SerializeFileFactory.luuFile(arraySinhVien, "text1.txt");
		if (kt == true) {
			System.out.println("Đã lưu thông tin của " + n + " sinh viên");
		} else {
			System.out.println("Lưu File Thất Bại!");
		}
	}

	public static void main(String[] args) {
		myMenu();
			}
	public static void docFile() {
		ArrayList<SinhVien> dsSV = SerializeFileFactory.docFile("text1.txt");
		arraySinhVien = dsSV;
		int i = 1;
		System.out.println("Danh Sách Sinh Viên Nhập Vào Là:");
		System.out.println("STT\tTên\tNgày Sinh\tĐiểm LP#1\tĐiểm LP#2\tĐiểm LP#3\tĐiểm TB");
		for (SinhVien sv : dsSV) {
			System.out.print((i ++) + "\t");
			System.out.printf("%-10s %-15s %-15s %-10s %10s %15s \n", sv.getNameSV(), sv.getNgaySinh(), sv.getLp1(),
					sv.getLp2(), sv.getLp3(), sv.getDiemTB());
		}

	}
	public static void KetThuc() {
		System.out.println("=======Tkank you!======");
		System.exit(0);
	}

	public static void myMenu() {
		while (true) {
			try {
				System.out.println("|<-----LỰA CHỌN CHỨC NĂNG------>|");
				System.out.println("| 1. Nhập Danh Sách Sinh Viên   |");
				System.out.println("| 2. Đọc File Thông Tin SV      |");
				System.out.println("| 3. Kết Thúc   |");
				
				System.out.println("|=============!!!!==============|");
			
			
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
				System.out.println(" Chỉ Được Nhập Từ 1 Tới 3,Hãy Nhập Lại Nha Bạn!");
				System.out.println(" Thank You!");
				input.nextLine();

			}

		}
	}
}
