package fasttrack.edu.vn.assigment;
import java.util.Scanner;
public class Quanlysinhvien {
	public static Scanner myScanner = new Scanner(System.in);

	public static int i, n = 4;
	public static SinhVien[] SV = new SinhVien[4];

	public static void main(String[] args) {
		SinhVien Sv1 = new SinhVien("Bùi Thế Nghĩa", "01/01/99", 6.0, 6.0);
		SinhVien Sv2 = new SinhVien("Nguyễn Thị A", "02/02/99", 9.0, 8.0);
		SinhVien Sv3 = new SinhVien("Trần Văn B", "26/03/99", 3.0, 5.0);
		SinhVien Sv4 = new SinhVien("Hoàng C", "05/07/99", 6.0, 4.0);
		SV[0] = Sv1;
		SV[1] = Sv2;
		SV[2] = Sv3;
		SV[3] = Sv4;
		showMyMenu();
	}

	public static void nhapDSSV() {
		System.out.println("Nhập danh sách sinh viên : ");
		System.out.println("---------------------------");
		System.out.print("Số lượng sinh viên :");
		n = myScanner.nextInt();
		String[] ten_SV = new String[n];
		String[] ngay_Sinh = new String[n];
		double[] diem_lp1 = new double[n];
		double[] diem_lp2 = new double[n];
		SinhVien[] SV = new SinhVien[n];

		for (i = 0; i < n; i++) {
			myScanner.nextLine();

			System.out.print("Nhập tên Sinh Viên thứ " + (i + 1) + " :");
			ten_SV[i] = myScanner.nextLine();
			SV[i].setName(ten_SV[i]);

			System.out.print("Nhập ngày sinh của Sinh Viên thứ " + (i + 1) + " :");
			ngay_Sinh[i] = myScanner.nextLine();
			SV[i].setDate(ngay_Sinh[i]);

			System.out.print("Nhập điểm môn LP1 " + " :");
			diem_lp1[i] = myScanner.nextDouble();
			SV[i].setLp1(diem_lp1[i]);

			System.out.print("Nhập điểm môn LP2 " + " :");
			diem_lp2[i] = myScanner.nextDouble();
			SV[i].setLp2(diem_lp2[i]);

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
		System.out.println("Nhấn Enter để về menu chính");
		myScanner.nextLine();
	}
	public static void sapxepTen() {
		SinhVien[] temp = new SinhVien[n];
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (SV[i].getName().compareTo(SV[j].getName()) > 0) {
					temp[i] = SV[j];
					SV[j] = SV[i];
					SV[i] = temp[i];
				}
			}
		}

		for (int i = 0; i < n; i++) {
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

	public static void showMyMenu() {
		while (true) {
			System.out.println("         MENU QUẢN LÝ SINH VIÊN       ");
			System.out.println("1. Nhập danh sách sinh viên             ");
			System.out.println("2. In danh sách sinh viên               ");
			System.out.println("3. Top sinh viên                        ");
			System.out.println("4. Sắp xếp theo điểm TBM                ");
			System.out.println("5. Sắp xếp theo Tên                     ");
			System.out.println("6. Kết thúc chương trình                ");
			System.out.println("            Lựa chọn của bạn?         ");
			// .compareTo để so sánh chuỗi trong trường hợp sắp xếp theo tên
			int myOption = myScanner.nextInt();
			if (myOption == 1) {
				nhapDSSV();
			}  else if (myOption == 2) {
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
}