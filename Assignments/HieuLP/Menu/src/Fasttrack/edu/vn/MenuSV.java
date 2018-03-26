package Fasttrack.edu.vn;

import java.util.Scanner;

public class MenuSV {
	public static Scanner myScanner = new Scanner(System.in);
	public static String[] arrSinhVien;
	public static String[] arrNgaySinh;
	public static Double[] arrLp1;
	public static Double[] arrLp2;
	public static Double[] arrDTB;
	public static int tongSinhVien = 0;
	public static int i, n = 0;

	public static void main(String[] args) {
		showMyMenu();
	}

	public static void showMyMenu() {
		while (true) {
			System.out.println(" __________________________________________ ");
			System.out.println("|                 <MENU>                   |");
			System.out.println("|__________________________________________|");
			System.out.println("| Chức năng :                              |");
			System.out.println("|-1. Nhập tên học sinh                     |");
			System.out.println("|-2. In danh sách SV                       |");
			System.out.println("|-3. Top SV                                |");
			System.out.println("|-4. Kết thúc chương trình                 |");
			System.out.println("|__________________________________________|");
			System.out.println("|Lựa chọn chức năng bạn muốn?              |");
			System.out.println("|__________________________________________|");

			int myOption = myScanner.nextInt();
			if (myOption == 1) {
				nhapThongtinSV();
			} else if (myOption == 2) {
				inSV();
			} else if (myOption == 3) {
				thongkeTopSV();
			} else if (myOption == 4) {
				ketThuc();
			}
		}

	}

	public static void nhapThongtinSV() {
		System.out.println("Nhập tên Sinh Viên");
		System.out.println("__________________");
		System.out.println("Tổng số SV :");
		tongSinhVien = myScanner.nextInt();

		arrSinhVien = new String[tongSinhVien];
		arrNgaySinh = new String[tongSinhVien];
		arrLp1 = new Double[tongSinhVien];
		arrLp2 = new Double[tongSinhVien];
		arrDTB = new Double[tongSinhVien];

		for (int i = 0; i < tongSinhVien; i++) {
			myScanner.nextLine();

			System.out.println("Nhập tên sinh viên " + (i + 1) + " :");
			arrSinhVien[i] = myScanner.nextLine();

			System.out.print("Nhập ngày sinh của Sinh Viên thứ " + (i + 1) + " :");
			arrNgaySinh[i] = myScanner.nextLine();

			System.out.println("Nhập điểm Lp1 " + (i + 1) + " :");
			arrLp1[i] = myScanner.nextDouble();

			System.out.println("Nhập điểm Lp2 " + (i + 1) + " :");
			arrLp2[i] = myScanner.nextDouble();

		}
		myScanner.nextLine();
		System.out.println("Nhấn Enter để về menu chính");
		myScanner.nextLine();
	}

	public static void inSV() {
		System.out.println("Danh sách sinh viên ");
		System.out.println("________________________________________________");
		System.out.println("STT\tHọ và tên\tNgày Sinh\tlp1\tlp2\tĐTB  ");
		System.out.println("________________________________________________");
		for (i = 0; i < tongSinhVien; i++) {
			arrDTB[i] = ((arrLp1[i] + arrLp2[i]) / 2);
			System.out.println((i + 1) + "\t" + arrSinhVien[i] + "\t\t" + arrNgaySinh[i] + "\t" + arrLp1[i]
					+ "\t" + arrLp2[i] + "\t" + arrDTB[i]);
		}
		myScanner.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		myScanner.nextLine();

	}

	public static void thongkeTopSV() {
		double min = arrDTB[0], max = arrDTB[0];
		int x = 0, y = 0;

		for (i = 0; i < n; i++) {
			if (min > arrDTB[i]) {
				min = arrDTB[i];
				x = i;
			}
			if (max < arrDTB[i]) {
				max = arrDTB[i];
				y = i;
			}
		}
		System.out.println("Học sinh có kết quả học tập cao nhất là :");
		System.out.println((y + 1) + "   " + arrSinhVien[y] + "  " + arrNgaySinh[y] + "       " + arrLp1[y] + "     "
				+ arrLp2[y] + "     " + arrDTB[y]);

		System.out.println("Học sinh có kết quả học tập thấp nhất là :");
		System.out.println((x + 1) + "   " + arrSinhVien[x] + "  " + arrNgaySinh[x] + "       " + arrLp1[x] + "     "
				+ arrLp2[x] + "     " + arrDTB[x]);
		
		myScanner.nextLine();
		System.out.println("Nhấn Enter để về menu chính");
		myScanner.nextLine();
	}

	public static void ketThuc() {
		System.out.println("Kết thúc chương trình");
		System.exit(0);

	}

}
