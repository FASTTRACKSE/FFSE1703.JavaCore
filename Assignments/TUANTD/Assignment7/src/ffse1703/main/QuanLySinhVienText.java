package ffse1703.main;

import ffse1703.io.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import ffse1703.io.TextFileFactory;
import ffse1703.model.SinhVien;

public class QuanLySinhVienText {
	public static Scanner input = new Scanner(System.in);
	public static int n = 0;
	public static String action;
	static ArrayList<SinhVien> arraySinhVien = new ArrayList<SinhVien>();

	public static void addSv() {
		String namesv;
		String ngaySinh;
		float Lp1;
		float Lp2;
		float Lp3;
		System.out.println("         THÊM SINH VIÊN VÀO DANH SÁCH");
		System.out.println("         ============================");
		System.out.print("         Bạn muốn nhập bao nhiêu Sinh Viên :");
		File file = new File("C:/FFSE1703.JavaCore/Assignments/TuanTD/Assignment7/dulieusinhvientext.txt");
		if (file.exists()) {
			ArrayList<SinhVien> arrSvFile = TextFileFactory.docFile("dulieusinhvientext.txt");
			arraySinhVien = arrSvFile;
		}
		try {
			int size = Integer.parseInt(input.nextLine());
			for (int i = 0; i < size; i++) {
				input.nextLine();
				System.out.println("Nhập Tên Sinh Viên Thứ  " + (i + 1) + " : ");
				namesv = input.nextLine();
				System.out.println("Nhập Ngày Sinh Cho Sinh Viên Thứ " + (i + 1) + " : ");
				ngaySinh = input.nextLine();
				System.out.println("Nhập Điểm LP#1 Cho Sinh Viên Thứ " + (i + 1) + " : ");
				Lp1 = input.nextFloat();
				System.out.println("Nhập Điểm LP#2 Cho Sinh Viên Thứ " + (i + 1) + " : ");
				Lp2 = input.nextFloat();
				System.out.println("Nhập Điểm LP#3 Cho Sinh Viên Thứ " + (i + 1) + " : ");
				Lp3 = input.nextFloat();
				arraySinhVien.add(new SinhVien(namesv, ngaySinh, Lp1, Lp2, Lp3));
				boolean checked = TextFileFactory.luuFile(arraySinhVien, "dulieusinhvientext.txt");
				if (checked == true) {
					System.out.println("Đã lưu thông tin của " + size + " sinh viên");
				} else {
					System.out.println("Lưu thất bại");
				}
			}
		} catch (Exception e) {
			System.out.println("         Nhập sai định dạng !!!");
			System.out.println("         Vui lòng nhập lại");
		}

	}

	public static void main(String[] args) {
		addSv();
		int i = 0;
		ArrayList<SinhVien> dsSV = TextFileFactory.docFile("dulieusinhvientext.txt");
		System.out.println("Danh Sách Sinh Viên Nhập Vào Là:");
		System.out.println("STT\tTên\tNgày Sinh\tĐiểm LP#1\tĐiểm LP#2\tĐiểm LP#3\tĐiểm TB");
		for (SinhVien sv : dsSV) {
			System.out.print((i + 1) + "\t");
			System.out.printf("%-10s %-15s %-15s %-10s %10s %15s \n", sv.getNameSV(), sv.getNgaySinh(), sv.getLp1(),
					sv.getLp2(), sv.getLp3(), sv.getDiemTB());
		}
	}
}
