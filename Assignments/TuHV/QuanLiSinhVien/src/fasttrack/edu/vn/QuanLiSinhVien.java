package fasttrack.edu.vn;

import java.util.Scanner;

public class QuanLiSinhVien {

	public static Scanner myScanner = new Scanner(System.in);

	public static int i, n = 0;
	public static String[] ten_SV;
	public static double[] diemLP1;
	public static double[] diemLP2;
	public static double[] diemDTB;
	public static double[] ngaySinh;

	public static void main(String[] args) {
		showMyMenu();
	}

	public static void nhapDSSV() {
		System.out.println("Nhập danh sách sinh viên : ");
		System.out.println("---------------------------");
		System.out.print("Số lượng sinh viên :");
		n = myScanner.nextInt();
		ten_SV = new String[n];
		ngaySinh = new double[n];
		diemLP1 = new double[n];
		diemLP2 = new double[n];
		diemDTB = new double[n];
		for (i = 0; i < n; i++) {
			myScanner.nextLine();

			System.out.print("Nhập tên Sinh Viên thứ " + (i + 1) + " :");
			ten_SV[i] = myScanner.nextLine();

			System.out.println("Nhập ngày sinh" + " :");
			ngaySinh[i] = myScanner.nextDouble();

			System.out.print("Nhập điểm môn LP1 " + " :");
			diemLP1[i] = myScanner.nextDouble();

			System.out.print("Nhập điểm môn LP2 " + " :");
			diemLP1[i] = myScanner.nextDouble();

			diemDTB[i] = ((diemLP1[i] + diemLP2[i]) / 2);
		}
		myScanner.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		myScanner.nextLine();
	}

	public static void inDSSV() {
		System.out.println("        Danh sách sinh viên      ");
		System.out.println("--------------------------------------------");
		System.out.println("STT\tHọ và tên\t Ngày sinh\t lp1\t lp2\t ĐTB");
		System.out.println("--------------------------------------------");
		for (i = 0; i < n; i++) {
			System.out.println((i + 1) + "\t" + ten_SV[i] + "\t"+ ngaySinh[i] + "\t\t" + diemLP1[i] + "\t" + diemLP2[i]
					+ "\t" + diemDTB[i]);
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
			System.out.println("|3. Top sinh viên                        |");
			System.out.println("|4. Kết thúc chương trình                |");
			System.out.println("+----------------------------------------+");
			System.out.println(">>            Lựa chọn của bạn?         <<");

			int myOption = myScanner.nextInt();
			if (myOption == 1) {
				nhapDSSV();
			} else if (myOption == 2) {
				inDSSV();
			} else if (myOption == 3) {
				topSV();
			} else if (myOption == 4) {
				ketThuc();
			}

		}
	}
}
