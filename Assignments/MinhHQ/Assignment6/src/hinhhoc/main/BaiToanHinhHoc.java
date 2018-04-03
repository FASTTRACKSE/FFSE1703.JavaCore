package hinhhoc.main;

import hinhhoc.model.*;
import java.util.Scanner;

import java.util.ArrayList;

public class BaiToanHinhHoc {
	public static Scanner scanner = new Scanner(System.in);
	public static ArrayList<HinhHoc> arrHinhHoc = new ArrayList<HinhHoc>();
	public static double r, a, cd, cr, b, c, n;

	public static void main(String[] args) {
		showMyMenu();

	}

	public static void nhapHinhTron() {

		System.out.print("Nhập bán kính hình tròn :");
		r = scanner.nextDouble();

		arrHinhHoc.add(new HinhTron(r));
	}

	public static void nhapHinhVuong() {

		System.out.print("Nhập cạnh hình vuông :");
		n = scanner.nextDouble();

		arrHinhHoc.add(new HinhVuong(n));
	}

	public static void nhapHinhChuNhat() {
		System.out.print("Nhập chiều dài hình chữ nhật :");
		cd = scanner.nextDouble();

		System.out.print("Nhập chiều rộng hình chữ nhật :");
		cr = scanner.nextDouble();

		arrHinhHoc.add(new HinhChuNhat(cd, cr));
	}

	public static void nhapHinhTamGiac() {
		System.out.println("Nhập độ dài 3 cạnh của hình tam giác :");
		System.out.print("Nhập độ dài cạnh a :");
		a = scanner.nextDouble();

		System.out.print("Nhập độ dài cạnh b :");
		b = scanner.nextDouble();

		System.out.print("Nhập độ dài cạnh c :");
		c = scanner.nextDouble();

		arrHinhHoc.add(new HinhTamGiac(a, b, c));

	}

	public static void inbangTinh() {
		System.out.println("====================================================================================");
		System.out.println("|STT  |       Hình      |  Thuộc tính      |      Chu vi      |      Diện tích     |");
		System.out.println("====================================================================================");
		int n = 1;
		for (HinhHoc x : arrHinhHoc) {
			if ((x instanceof HinhTron)) {

				System.out.printf("|%-5s|%-17s|Bán kính :%-8s|%-18s|%-20s|\n", n, "Tròn", ((HinhTron) x).getBankinh(),
						x.getChuVi(), x.getDienTich());
			} else if ((x instanceof HinhVuong)) {
				System.out.printf("|%-5s|%-17s|a :%-15s|%-18s|%-20s|\n", n, "Hình Vuông", ((HinhVuong) x).getCanhHV(),
						x.getChuVi(), x.getDienTich());
			} else if ((x instanceof HinhChuNhat)) {
				System.out.printf("|%-5s|%-17s|cd:%-4s cr:%-7s|%-18s|%-20s|\n", n, "Chữ Nhật",
						((HinhChuNhat) x).getChieudai(), ((HinhChuNhat) x).getChieurong(), x.getChuVi(),
						x.getDienTich());
			} else if ((x instanceof HinhTamGiac)) {
				System.out.printf("|%-5s|%-17s|a :%-3s b:%-3s c:%-3s|%-18s|%-20s|\n", n, "Tam Giác",
						((HinhTamGiac) x).getCanhA(), ((HinhTamGiac) x).getCanhB(), ((HinhTamGiac) x).getCanhC(),
						x.getChuVi(), x.getDienTich());
			}
			System.out.println("------------------------------------------------------------------------------------");
			n += 1;
		}

	}

	public static void ketThuc() {
		System.out.println("Kết thúc chương trình!!!!!");
		System.exit(0);
	}

	public static void showMyMenu() {
		while (true) {
			System.out.println(">>    MENU TÍNH DIỆN TÍCH VÀ CHU VI     <<");
			System.out.println("+----------------------------------------+");
			System.out.println("|1. Nhập Hình Tròn                       |");
			System.out.println("|2. Nhập Hình Chữ Nhật                   |");
			System.out.println("|3. Nhập Hình Vuông                      |");
			System.out.println("|4. Nhập Hình Tam Giác                   |");
			System.out.println("|5. In chu vi và diện tích của các hình  |");
			System.out.println("|6. Kết thúc chương trình                |");
			System.out.println("+----------------------------------------+");
			System.out.println(">>            Lựa chọn của bạn?         <<");
			int myOption = scanner.nextInt();
			if (myOption == 1) {
				nhapHinhTron();
			} else if (myOption == 2) {
				nhapHinhChuNhat();
			} else if (myOption == 3) {
				nhapHinhVuong();
			} else if (myOption == 4) {
				nhapHinhTamGiac();
			} else if (myOption == 5) {
				inbangTinh();
			} else if (myOption == 6) {
				ketThuc();
			}
		}
	}
}
