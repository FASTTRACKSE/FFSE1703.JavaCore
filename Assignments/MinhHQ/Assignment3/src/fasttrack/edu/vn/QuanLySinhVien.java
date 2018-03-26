package fasttrack.edu.vn;

import java.util.Scanner;

public class QuanLySinhVien {
	// tên,ngày sinh, điểm lp1,2,TBM

	public static Scanner myScanner = new Scanner(System.in);

	public static int i, n = 4;
	public static String[] ten_SV = { "Hồ Quang Minh", "Nguyễn Phước Hiếu", "Nguyễn Thanh Hiếu", "Hồ Viết Tú" };
	public static String[] ngay_Sinh = { "30/10/99", "13/05/99", "26/09/99", "04/04/99" };
	public static double[] diem_lp1 = { 8.0, 7.0, 9.0, 6.0 };
	public static double[] diem_lp2 = { 4.0, 6.0, 8.0, 4.0 };
	public static double[] diem_tbm;
	public static double[] sx_diem;

	public static void main(String[] args) {
		showMyMenu();
	}

	public static void nhapDSSV() {
		System.out.println("Nhập danh sách sinh viên : ");
		System.out.println("---------------------------");
		System.out.print("Số lượng sinh viên :");
		n = myScanner.nextInt();
		ten_SV = new String[n];
		ngay_Sinh = new String[n];
		diem_lp1 = new double[n];
		diem_lp2 = new double[n];

		for (i = 0; i < n; i++) {
			myScanner.nextLine();

			System.out.print("Nhập tên Sinh Viên thứ " + (i + 1) + " :");
			ten_SV[i] = myScanner.nextLine();

			System.out.print("Nhập ngày sinh của Sinh Viên thứ " + (i + 1) + " :");
			ngay_Sinh[i] = myScanner.nextLine();

			System.out.print("Nhập điểm môn LP1 " + " :");
			diem_lp1[i] = myScanner.nextDouble();

			System.out.print("Nhập điểm môn LP2 " + " :");
			diem_lp2[i] = myScanner.nextDouble();

		}
		myScanner.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		myScanner.nextLine();
	}

	public static void inDSSV() {
		diem_tbm = new double[n];

		System.out.println("Danh sách sinh viên ");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("STT  Họ và tên              Ngày sinh     lp1  lp2  ĐTB  ");
		System.out.println("--------------------------------------------------------------------");
		for (i = 0; i < n; i++) {
			diem_tbm[i] = ((diem_lp1[i] + diem_lp2[i]) / 2);
			System.out.printf("%-5s%-23s%-14s%-5s%-5s%-5s\n", (i + 1), ten_SV[i], ngay_Sinh[i], diem_lp1[i],
					diem_lp2[i], diem_tbm[i]);
		}
		myScanner.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		myScanner.nextLine();
	}

	public static void topSV() {
		double min = diem_tbm[0], max = diem_tbm[0];
		int x = 0, y = 0;

		for (i = 0; i < n; i++) {
			if (min > diem_tbm[i]) {
				min = diem_tbm[i];
				x = i;
			}
			if (max < diem_tbm[i]) {
				max = diem_tbm[i];
				y = i;
			}
		}
		System.out.println("Học sinh có kết quả học tập cao nhất là :");
		System.out.println((y + 1) + " \t " + ten_SV[y] + " \t " + ngay_Sinh[y] + " \t " + diem_lp1[y] + " \t "
				+ diem_lp2[y] + " \t " + diem_tbm[y]);

		System.out.println("Học sinh có kết quả học tập thấp nhất là :");
		System.out.println((x + 1) + " \t " + ten_SV[x] + " \t " + ngay_Sinh[x] + " \t " + diem_lp1[x] + " \t "
				+ diem_lp2[x] + " \t " + diem_tbm[x]);

		myScanner.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		myScanner.nextLine();

	}

	public static void sapxepTBM() {
		int[] vitri = new int[n];
		for (i = 0; i < n; i++) {
			vitri[i] = i;
		}
		int temp;
		for (i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (diem_tbm[vitri[i]] < diem_tbm[vitri[j]]) {
					temp = vitri[j];
					vitri[j] = vitri[i];
					vitri[i] = temp;
				}
			}
		}
		

		for (i = 0; i < n; i++) {
			System.out.println("Danh sách sinh viên đã được sắp xếp theo điểm trung bình ");
			System.out.println("--------------------------------------------------------------------");
			System.out.println("STT  Họ và tên              Ngày sinh     lp1  lp2  ĐTB  ");
			System.out.println("--------------------------------------------------------------------");
			for (i = 0; i < n; i++) {
				System.out.printf("%-5s%-23s%-14s%-5s%-5s%-5s\n", (i + 1), ten_SV[vitri[i]], ngay_Sinh[vitri[i]],
						diem_lp1[vitri[i]], diem_lp2[vitri[i]], diem_tbm[vitri[i]]);
			}
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
			System.out.println("|3. Top sinh viên                        |");
			System.out.println("|4. Sắp xếp theo điểm TBM                |");
			System.out.println("|5. Kết thúc chương trình                |");
			System.out.println("+----------------------------------------+");
			System.out.println(">>            Lựa chọn của bạn?         <<");
			// .compareTo để so sánh chuỗi trong trường hợp sắp xếp theo tên
			int myOption = myScanner.nextInt();
			if (myOption == 1) {
				nhapDSSV();
			} else if (myOption == 2) {
				inDSSV();
			} else if (myOption == 3) {
				topSV();
			} else if (myOption == 4) {
				sapxepTBM();
			} else if (myOption == 5) {
				ketThuc();
			}

		}
	}
}
