package ffse1703.javacore.hinhhoc.main;

import ffse1703.javacore.hinhhoc.model.*;

import java.util.Scanner;
import java.util.ArrayList;
public class BTHinhHoc {

	public static Scanner scanner = new Scanner(System.in);
	public static ArrayList<hinhHoc> arrHinhHoc = new ArrayList<hinhHoc>();
	public static double rc, a, cd, cr, b, c, n;

	public static void main(String[] args) {
		myMenu();
	}

	public static void myMenu() {
		while (true) {

			System.out.println("        ___________________________________");
			System.out.println("         |       CHỌN LỰA CHỨC NĂNG      |");
			System.out.println("         |  1.Nhập hình tròn             |");
			System.out.println("         |  2.Nhập hình chữ nhật         |");
			System.out.println("         |  3.Nhập hình tam giác         |");
			System.out.println("         |  4.Nhập hình vuông            |");
			System.out.println("         |  5.In tất cả giá trị          |");
			System.out.println("         |  6.Kết thúc chương trình      |");
			System.out.println("         |_______________________________|");
			System.out.print("     Nhập chức năng mà bạn muốn thực hiện :");
			int act = scanner.nextInt();
			if (act == 1) {
				HinhTroncvdt();
			} else if (act == 2) {
				HinhChuNhatcvdt();
			} else if (act == 3) {
				HinhTamGiaccvdt();
			} else if (act == 4) {
				HinhVuongcvdt();
			} else if (act == 5) {
				inGiaTri();
			} else if (act == 6) {
				ketThuc();
			}
			scanner.nextLine();
			System.out.println("     =====================================");
			System.out.println("        -----Nhập ENTER để tiếp tục-----");
			scanner.nextLine();
		}
	}

	public static void HinhTroncvdt() {
		System.out.print("Nhập bán kính hình tròn :");
		rc = scanner.nextDouble();

		arrHinhHoc.add(new HinhTron(rc));
	}

	public static void HinhChuNhatcvdt() {
		
			System.out.print("Nhập chiều dài hình chữ nhật :");
			cd = scanner.nextDouble();

			System.out.print("Nhập chiều rộng hình chữ nhật :");
			cr = scanner.nextDouble();

			arrHinhHoc.add(new HinhChuNhat(cd, cr));
	}

	public static void HinhTamGiaccvdt() {
		System.out.println("Nhập độ dài 3 cạnh của hình tam giác :");
		System.out.print("Nhập độ dài cạnh a :");
		a = scanner.nextDouble();

		System.out.print("Nhập độ dài cạnh b :");
		b = scanner.nextDouble();

		System.out.print("Nhập độ dài cạnh c :");
		c = scanner.nextDouble();

		arrHinhHoc.add(new HinhTamGiac(a, b, c));

	}

	public static void HinhVuongcvdt() {
		System.out.print("Nhập cạnh hình vuông :");
		n = scanner.nextDouble();

		arrHinhHoc.add(new HinhVuong(n));

	}

	public static void inGiaTri() {
		System.out.println("====================================================================================");
		System.out.println("|STT  |       Hình      |  Thuộc tính      |      Chu vi      |      Diện tích     |");
		System.out.println("====================================================================================");
		int n = 1;
		for (hinhHoc x : arrHinhHoc) {
			if ((x instanceof HinhTron)) {

				System.out.printf("|%-5s|%-17s|Bán kính :%-8s|%-18s|%.2f\n", n, "Tròn", ((HinhTron) x).getBanKinh(),
						x.getChuVi(), x.getDienTich());
			} else if ((x instanceof HinhVuong)) {
				System.out.printf("|%-5s|%-17s|a :%-15s|%-18s|%.2f\n", n, "Hình Vuông", ((HinhVuong) x).getcanhA(),
						x.getChuVi(), x.getDienTich());
			} else if ((x instanceof HinhChuNhat)) {
				System.out.printf("|%-5s|%-17s|cd:%-4s cr:%-7s|%-18s|%.2f\n", n, "Chữ Nhật",
						((HinhChuNhat) x).getChieuDai(), ((HinhChuNhat) x).getChieuRong(), x.getChuVi(),
						x.getDienTich());
			} else if ((x instanceof HinhTamGiac)) {
				System.out.printf("|%-5s|%-17s|a :%-3s b:%-3s c:%-3s|%-18s|%.2f\n", n, "Tam Giác",
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
}
