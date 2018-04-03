package ffse1703.edu.vn.main;

import ffse1703.edu.vn.model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyHinhHoc {
	public Scanner input = new Scanner(System.in);
	// public static HinhHoc tinh1=new HinhTron();
	// public static HinhHoc tinh2=new HinhTamGiac();
	// public static HinhHoc tinh3=new HinhChuNhat();
	static ArrayList<HinhHoc> arrHinhHoc = new ArrayList<>();

	public static void main(String[] args) {
		QuanLyHinhHoc a = new QuanLyHinhHoc();
		a.myMenu();
	}

	public void tinhHinhTron() {
		System.out.println("TÍNH CHU VI & DIỆN TÍCH HÌNH TRÒN");
		System.out.println("=================================");
		System.out.print("Nhập Bán Kính Hình Tròn : ");
		double banKinh = input.nextDouble();
		arrHinhHoc.add(new HinhTron(banKinh));
		System.out.println("<==========Thông Tin Nhập Vào==========>");
		System.out.println("| Bán Kính |  Chu Vi |  Diện Tích | ");
		for (HinhHoc x : arrHinhHoc) {
			if (x instanceof HinhTron) {
				System.out.printf("%-10s %-15s %-15s \n", ((HinhTron) x).getBanKinh(), x.getChuVi(), x.getDienTich());
			}
		}
	}

	public void tinhHinhTamGiac() {
		System.out.println("TÍNH CHU VI HÌNH TAM GIÁC");
		System.out.println("=========================");
		System.out.print("Nhập Cạnh thứ nhất của hình tam giác : ");
		int canhA = input.nextInt();
		System.out.print("Nhập Cạnh thứ hai của hình tam giác : ");
		int canhB = input.nextInt();
		System.out.print("Nhập Cạnh thứ ba của hình tam giác : ");
		int canhC = input.nextInt();
		arrHinhHoc.add(new HinhTamGiac(canhA, canhB, canhC));

		System.out.println("<==========Thông Tin Nhập Vào==========>");
		System.out.println("|  Cạnh A  |   Cạnh B     |     Cạnh C  | Chu Vi | Diện Tích |");
		for (HinhHoc x : arrHinhHoc) {
			if (x instanceof HinhTamGiac) {
				System.out.printf("%-10s %-15s %-15s %-10s %-10s \n", ((HinhTamGiac) x).getCanhA(),
						((HinhTamGiac) x).getCanhB(), ((HinhTamGiac) x).getCanhC(), x.getChuVi(), x.getDienTich());
			}
		}
	}

	public void tinhHinhChuNhat() {
		System.out.println("TÍNH CHU VI & DIỆN TÍCH HÌNH CHỮ NHẬT");
		System.out.println("=====================================");
		System.out.print("Nhập Chiều Dài Hình Chữ Nhật : ");
		int chieuDai = input.nextInt();
		System.out.print("Nhập Chiều Rộng Hình Chữ Nhật : ");
		int chieuRong = input.nextInt();
		arrHinhHoc.add(new HinhChuNhat(chieuDai, chieuRong));
		System.out.println("<==========Thông Tin Nhập Vào==========>");
		System.out.println("| Chiều Dài | Chiều Rộng |  Chu Vi |  Diện Tích | ");
		for (HinhHoc x : arrHinhHoc) {
			if (x instanceof HinhChuNhat) {
				System.out.printf("%-10s %-15s %-15s %-10s \n", ((HinhChuNhat) x).getChieuDai(),
						((HinhChuNhat) x).getChieuRong(), x.getChuVi(), x.getDienTich());
			}
		}
	}

	public static void ketThuc() {
		System.out.println("Kết thúc chương trình");
		System.out.println("======================");
		System.out.println("=======Tkank you======");
		System.exit(0);
	}

	public void myMenu() {
		while (true) {
			System.out.println("         __________________________________________");
			System.out.println("         |=========================================|");
			System.out.println("         |-----------CHỌN LỰA CHỨC NĂNG------------|");
			System.out.println("         |-----------------------------------------|");
			System.out.println("         |--1.Tính Chu Vi & Diện Hình Tròn---------|");
			System.out.println("         |--2.Tính Chu Vi & Diện Tích Hình Tam Giác|");
			System.out.println("         |--3.Tính Chu Vi & Diện Tích Hình Chữ Nhật|");
			System.out.println("         |--5.IN|");
			System.out.println("         |=========================================|");
			System.out.println("         |--4.Kết thúc chương trình----------------|");
			System.out.println("         |_________________________________________|");
			System.out.print("     Nhập chức năng mà bạn muốn thực hiện :");
			int act = Integer.parseInt(input.nextLine());
			if (act == 1) {
				tinhHinhTron();
			} else if (act == 2) {
				tinhHinhTamGiac();
			} else if (act == 3) {
				tinhHinhChuNhat();
			} else if (act == 5) {

			} else if (act == 4) {
				ketThuc();
			}
			input.nextLine();
			System.out.println("=====================================");
			System.out.println("-------Nhập ENTER để tiếp tục------");
			input.nextLine();
		}
	}
}
