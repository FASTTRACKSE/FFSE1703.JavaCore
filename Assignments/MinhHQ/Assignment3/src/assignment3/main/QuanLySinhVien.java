package assignment3.main;

import java.util.Scanner;

public class MenuSV {
	public static Scanner myScanner = new Scanner(System.in);
	public static String[] arrSinhVien = { "Lê Phước Hiếu", "Hồ Quang Minh", "Hồ Viết Tú" };
	public static String[] arrNgaySinh = { "16/02/99", "12/02/99", "14/02/99" };
	public static Double[] arrLp1 = { 8.0, 7.0, 7.0 };
	public static Double[] arrLp2 = { 7.0, 6.0, 7.0 };
	public static Double[] arrDTB;
	public static int tongSinhVien = 3;
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
			System.out.println("|-4. Top ĐTB                               |");
			System.out.println("|-5. Kết thúc chương trình                 |");
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
				topDTB();
			} else if (myOption == 5) {
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
		arrDTB = new Double[tongSinhVien];

		System.out.println("Danh sách sinh viên ");
		System.out.println("_________________________________________________________");
		System.out.println("STT   Họ và tên             Ngày Sinh     lp1  lp2  ĐTB  ");
		System.out.println("_________________________________________________________");
		for (i = 0; i < tongSinhVien; i++) {
			arrDTB[i] = ((arrLp1[i] + arrLp2[i]) / 2);
			System.out.printf("%-5s%-23s%-14s%-5s%-5s%-5s\n", (i + 1), arrSinhVien[i], arrNgaySinh[i], arrLp1[i],
					arrLp2[i], arrDTB[i]);
		}
		myScanner.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		myScanner.nextLine();

	}

	public static void thongkeTopSV() {
		double min = arrDTB[0], max = arrDTB[0];
		int x = 0, y = 0;

		for (i = 0; i < tongSinhVien; i++) {
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

	public static void topDTB() {

		int[] vitri = new int[tongSinhVien];
		for (i = 0; i < tongSinhVien; i++) {
			vitri[i] = i;
		}
		int temp;
		for (i = 0; i < tongSinhVien - 1; i++) {
			for (int j = i + 1; j < tongSinhVien; j++) {
				if (arrDTB[vitri[i]] < arrDTB[vitri[j]]) {
					temp = vitri[j];
					vitri[j] = vitri[i];
					vitri[i] = temp;
				}
			}
		}

		System.out.println("Danh sách sinh viên đã được sắp xếp theo điểm trung bình            ");
		System.out.println("____________________________________________________________________");
		System.out.println("STT  Họ và tên              Ngày sinh     lp1  lp2  ĐTB             ");
		System.out.println("____________________________________________________________________");
		
		for (i = 0; i < tongSinhVien; i++) {
			System.out.printf("%-5s%-23s%-14s%-5s%-5s%-5s\n", (i + 1), arrSinhVien[vitri[i]], arrNgaySinh[vitri[i]],
					arrLp1[vitri[i]], arrLp2[vitri[i]], arrDTB[vitri[i]]);
		}

		myScanner.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		myScanner.nextLine();

	}

	public static void ketThuc() {
		System.out.println("Kết thúc chương trình");
		System.exit(0);

	}

}}