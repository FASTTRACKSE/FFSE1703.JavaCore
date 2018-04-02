package Fasttrack.edu.vn;

import java.util.Scanner;

public class NhapSV {
	public static Scanner myScanner = new Scanner(System.in);

	public static int i, n = 4;
	public static SinhVien[] SV = new SinhVien[4];

	public static void main(String[] args) {
		SinhVien Sv1 = new SinhVien("Hồ Quang Minh", "30/10/99", 8.0, 6.0);
		SinhVien Sv2 = new SinhVien("Lê Phước Hiếu", "13/05/99", 9.0, 10.0);
		SinhVien Sv3 = new SinhVien("Nguyễn Thanh Hiếu", "26/09/99", 4.0, 5.0);
		SinhVien Sv4 = new SinhVien("Hồ Việt Tú", "04/04/99", 6.0, 4.0);
		SV[0] = Sv1;
		SV[1] = Sv2;
		SV[2] = Sv3;
		SV[3] = Sv4;
		showMyMenu();
	}

	public static void showMyMenu() {
		while (true) {
			System.out.println(">>         <MENU QUẢN LÝ SINH VIÊN>     <<");
			System.out.println("__________________________________________");
			System.out.println("|1. Nhập danh sách sinh viên             |");
			System.out.println("|2. In danh sách sinh viên               |");
			System.out.println("|3. Top sinh viên                        |");
			System.out.println("|4. Sắp xếp theo điểm TBM                |");
			System.out.println("|5. Sắp xếp theo Tên                     |");
			System.out.println("|6. Kết thúc chương trình                |");
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
				sapxepTBM();
			} else if (myOption == 5) {
				sapxepTen();
			} else if (myOption == 6) {
				ketThuc();
			}

		}
	}

	public static void nhapDSSV() {

		for (i = 0; i < n; i++) {
			System.out.println("Nhập danh sách sinh viên : ");
			System.out.println("---------------------------");
			System.out.print("Số lượng sinh viên :");
			n = myScanner.nextInt();
			SV = new SinhVien[n];
			for (i = 0; i < n; i++) {
				SV[i] = new SinhVien();
				SV[i].Input();
			}

		}

		myScanner.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		myScanner.nextLine();
	}

	public static void inDSSV() {

		System.out.println("Danh sách sinh viên ");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("STT  Họ và tên              Ngày sinh     lp1  lp2  ĐTB  ");
		System.out.println("--------------------------------------------------------------------");
		for (i = 0; i < n; i++) {

			System.out.printf("%-5s%-23s%-14s%-5s%-5s%-5s\n", (i + 1), SV[i].getName(), SV[i].getDate(), SV[i].getLp1(),
					SV[i].getLp2(), SV[i].getTBM());
		}
		myScanner.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		myScanner.nextLine();
	}

	public static void topSV() {
		double min = SV[0].getTBM(), max = min;
		int x = 0, y = 0;

		for (i = 0; i < n; i++) {
			if (min > SV[i].getTBM()) {
				min = SV[i].getTBM();
				x = i;
			}
			if (max < SV[i].getTBM()) {
				max = SV[i].getTBM();
				y = i;
			}
		}

		System.out.println("Học sinh có kết quả học tập cao nhất là :");
		System.out.printf("%-23s%-14s%-5s%-5s%-5s\n", SV[y].getName(), SV[y].getDate(), SV[y].getLp1(), SV[y].getLp2(),
				SV[y].getTBM());

		System.out.println("Học sinh có kết quả học tập thấp nhất là :");
		System.out.printf("%-23s%-14s%-5s%-5s%-5s\n", SV[x].getName(), SV[x].getDate(), SV[x].getLp1(), SV[x].getLp2(),
				SV[x].getTBM());
		myScanner.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		myScanner.nextLine();

	}

	public static void sapxepTBM() {
		SinhVien[] temp = new SinhVien[n];
		for (i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (SV[i].getTBM() < SV[j].getTBM()) {
					temp[i] = SV[j];
					SV[j] = SV[i];
					SV[i] = temp[i];
				}
			}
		}

		for (i = 0; i < n; i++) {
			System.out.println("Danh sách sinh viên đã được sắp xếp theo điểm trung bình ");
			System.out.println("--------------------------------------------------------------------");
			System.out.println("STT  Họ và tên              Ngày sinh     lp1  lp2  ĐTB  Xếp Loại  ");
			System.out.println("--------------------------------------------------------------------");
			for (i = 0; i < n; i++) {
				System.out.printf("%-5s%-23s%-14s%-5s%-5s%-5s%-10s\n", (i + 1), SV[i].getName(), SV[i].getDate(),
						SV[i].getLp1(), SV[i].getLp2(), SV[i].getTBM(), SV[i].XepLoai());
			}
		}

		myScanner.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		myScanner.nextLine();
	}

	public static void sapxepTen() {
		SinhVien[] temp = new SinhVien[n];
		for (i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {// compareTo để so sánh chuỗi trong trường hợp sắp xếp theo tên
				if (SV[i].getName().compareTo(SV[j].getName()) > 0) {
					temp[i] = SV[j];
					SV[j] = SV[i];
					SV[i] = temp[i];
				}
			}
		}

		for (i = 0; i < n; i++) {
			System.out.println("Danh sách sinh viên đã được sắp xếp theo điểm trung bình ");
			System.out.println("--------------------------------------------------------------------");
			System.out.println("STT  Họ và tên              Ngày sinh     lp1  lp2  ĐTB  Xếp Loại  ");
			System.out.println("--------------------------------------------------------------------");
			for (i = 0; i < n; i++) {
				System.out.printf("%-5s%-23s%-14s%-5s%-5s%-5s%-10s\n", (i + 1), SV[i].getName(), SV[i].getDate(),
						SV[i].getLp1(), SV[i].getLp2(), SV[i].getTBM(), SV[i].XepLoai());
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

}