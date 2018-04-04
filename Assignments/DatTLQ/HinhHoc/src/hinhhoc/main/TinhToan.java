package hinhhoc.main;

import hinhhoc.model.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Scanner;

public class TinhToan {
	public static Scanner scanner = new Scanner(System.in);
	public static ArrayList<HinhHoc> arrHinhHoc = new ArrayList<HinhHoc>();
	public static ArrayList<HinhChuNhat> arrHCN = new ArrayList<HinhChuNhat>();
	public static ArrayList<HinhTron> arrHT = new ArrayList<HinhTron>();
	public static ArrayList<HinhTamGiac> arrHTG = new ArrayList<HinhTamGiac>();

	public static void main(String[] args) {
		TinhToan main = new TinhToan();
		myMenu();
		;
	}

	public static void nhapHCN() {
		System.out.println("Xin mời nhập thông số hình chữ nhật");
		System.out.println("Chiều dài:");
		double chieuDai = scanner.nextDouble();
		System.out.println("Chiều rộng");
		double chieuRong = scanner.nextDouble();
		arrHinhHoc.add(new HinhChuNhat(chieuDai, chieuRong));
	}

	public static void nhapHT() {
		System.out.println("Xin mời nhập thông số hình tròn");
		System.out.println("Bán kính");
		double R = scanner.nextDouble();
		arrHinhHoc.add(new HinhTron(R));
	}

	public static void nhapHV() {

	}

	public static void nhapHTG() {
		System.out.println("Xin mời nhập thông số hình tam giác");
		System.out.println("Cạnh A:");
		double canhA = scanner.nextDouble();
		System.out.println("Cạnh B");
		double canhB = scanner.nextDouble();
		System.out.println("Cạnh C");
		double canhC = scanner.nextDouble();
		arrHinhHoc.add(new HinhTamGiac(canhA, canhB, canhC));
	}

	public static void inDS() {
		for (HinhHoc x : arrHinhHoc) {
			if (x instanceof HinhChuNhat) {
				HinhChuNhat hcn = (HinhChuNhat) x;
				System.out.println(
						"Hinh Chu Nhat:" + hcn.getChuVi() + hcn.getDienTich() + hcn.getChieuRong() + hcn.getChieuDai());
			} else if (x instanceof HinhTron) {
				HinhTron ht = (HinhTron) x;
				System.out.println("Hinh Tron:" + ht.getChuVi() + ht.getDienTich() + ht.getR());
			} else if (x instanceof HinhTamGiac) {
				HinhTamGiac htg = (HinhTamGiac) x;
				System.out.println("Hình Tam Giác:" + htg.getChuVi() + htg.getDienTich() + htg.getCanhA()
						+ htg.getCanhB() + htg.getCanhC());
			}

		}

	}
	public static void ketThuc() {
		System.exit(0);
	}

	public static void myMenu() {
		while (true) {
			System.out.println("---LUA CHON CHUC NANG---");
			System.out.println("_______________________________________" + "\n");
			System.out.println("1: Nhập hình chữ nhật ");
			System.out.println("2: Nhập hình tròn ");
			System.out.println("3: Nhập hình vuông");
			System.out.println("4: Nhập hình tam giác");
			System.out.println("5: In danh sách các hình với Chu Vi và Diện Tích");
			System.out.println("6: Kết thúc chương trình");
			System.out.println("_______________________________________" + "\n");
			int input = scanner.nextInt();
			if (input == 1) {
				nhapHCN();

			} else if (input == 2) {
				nhapHT();
			} else if (input == 3) {
				nhapHV();
			} else if (input == 4) {
				nhapHTG();
			} else if (input == 5) {
				inDS();
			}else if(input ==6) {
				ketThuc();
			}
		}

	}
}
