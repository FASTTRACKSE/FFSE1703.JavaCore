package fasttrack.edu.vn;

import java.util.Scanner;

public class QuanLiSinhVien {

	public static Scanner myScanner = new Scanner(System.in);

	public static int i, n = 3;
	public static String[] ten_SV = { "Hồ Viết Tú", "Hồ Quang Minh", "Lê Phước Hiếu" };
	public static double[] diemLP1 = { 8.0, 6.0, 9.0 };
	public static double[] diemLP2 = { 5.0, 3.0, 9.0 };
	public static double[] diemDTB;
	public static String[] ngaySinh = { "09/01", "10/04", "07/02" };

	public static void main(String[] args) {
		showMyMenu();
	}

	public static void nhapDSSV() {
		System.out.println("Nhập danh sách sinh viên : ");
		System.out.println("---------------------------");
		System.out.print("Số lượng sinh viên :");
		n = myScanner.nextInt();
		ten_SV = new String[n];
		ngaySinh = new String[n];
		diemLP1 = new double[n];
		diemLP2 = new double[n];

		for (i = 0; i < n; i++) {
			myScanner.nextLine();

			System.out.print("Nhập tên Sinh Viên thứ " + (i + 1) + " :");
			ten_SV[i] = myScanner.nextLine();

			System.out.println("Nhập ngày sinh" + " :");
			ngaySinh[i] = myScanner.nextLine();

			System.out.print("Nhập điểm môn LP1 " + " :");
			diemLP1[i] = myScanner.nextDouble();

			System.out.print("Nhập điểm môn LP2 " + " :");
			diemLP2[i] = myScanner.nextDouble();

		}
		myScanner.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		myScanner.nextLine();

	}

	public static void inDSSV() {
		diemDTB = new double[n];
		System.out.println("        Danh sách sinh viên      ");
		System.out.println("--------------------------------------------");
		System.out.println("STT  Họ và tên              Ngày sinh   lp1  lp2  ĐTB");
		System.out.println("--------------------------------------------");
		for (i = 0; i < n; i++) {
			diemDTB[i] = ((diemLP1[i] + diemLP2[i]) / 2);
			System.out.printf("%-5s%-25s%-10s%-5s%-5s%-5s\n", (i + 1), ten_SV[i], ngaySinh[i], diemLP1[i], diemLP2[i],
					diemDTB[i]);
		}
		myScanner.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		myScanner.nextLine();
	}

	public static void topSV() {
		double min = diemDTB[0], max = diemDTB[0];
		int x = 0, y = 0;

		for (i = 0; i < n; i++) {
			if (min > diemDTB[i]) {
				min = diemDTB[i];
				x = i;
			}
			if (max < diemDTB[i]) {
				max = diemDTB[i];
				y = i;
			}
		}
		System.out.println("Học sinh có kết quả học tập cao nhất là :");
		System.out.println((y + 1) + "   " + ten_SV[y] + " " + ngaySinh[i] + "  " + diemLP1[y] + "     " + diemLP2[y]
				+ "     " + diemDTB[y]);

		System.out.println("Học sinh có kết quả học tập thấp nhất là :");
		System.out.println((x + 1) + "   " + ten_SV[x] + "  " + ngaySinh[i] + "    " + diemLP1[x] + "     " + diemLP2[x]
				+ "     " + diemDTB[x]);
	}

	public static void insxDTB() {
		int[] DTB = new int[n];
		for (i = 0; i < n; i++) {
			DTB[i] = i;
		}
		int temp;
		for (i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (diemDTB[DTB[i]] < diemDTB[DTB[j]]) {
					temp = DTB[j];
					DTB[j] = DTB[i];
					DTB[i] = temp;
				}
			}
		}

		System.out.println("        Danh sách sinh viên      ");
		System.out.println("--------------------------------------------");
		System.out.println("STT  Họ và tên              Ngày sinh   lp1  lp2  ĐTB");
		System.out.println("--------------------------------------------");
		for (i = 0; i < n; i++) {

			System.out.printf("%-5s%-25s%-10s%-5s%-5s%-5s\n", (i + 1), ten_SV[DTB[i]], ngaySinh[DTB[i]],
					diemLP1[DTB[i]], diemLP2[DTB[i]], diemDTB[DTB[i]]);

		}
		myScanner.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		myScanner.nextLine();
	}

	public static void ketThuc() {
		System.out.println("Kết thúc chương trình!!!!!");
		System.exit(0);
	}

	public static void showMyMenu() {
		while (true) {
			System.out.println(">>         MENU QUẢN LÝ SINH VIÊN       <<");
			System.out.println("+----------------------------------------+");
			System.out.println("|1. Nhập danh sách sinh viên             |");
			System.out.println("|2. In danh sách sinh viên               |");
			System.out.println("|5. In danh sách sinh viên theo điểm              |");
			System.out.println("|3. Top sinh viên                        |");
			System.out.println("|4. Kết thúc chương trình                |");
			System.out.println("+----------------------------------------+");
			System.out.println(">>            Lựa chọn của bạn?         <<");

			int myOption = myScanner.nextInt();
			if (myOption == 1) {
				nhapDSSV();
			} else if (myOption == 2) {
				inDSSV();
			} else if (myOption == 5) {
				insxDTB();
			} else if (myOption == 3) {
				topSV();
			} else if (myOption == 4) {
				ketThuc();
			}

		}
	}
}
