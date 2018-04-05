package fasttrackse.edu.vn.quanlysinhvien;

import java.util.ArrayList;
import java.util.Scanner;

public class QuanLySinhVien {

	public static Scanner myScanner = new Scanner(System.in);
	public static ArrayList<SinhVien> arrSV = new ArrayList<SinhVien>();
	public static int i, n = 4;
	public static SinhVien[] SV = new SinhVien[4];

	public static void main(String[] args) {
		arrSV.add(new SinhVien("Hồ Quang Minh", "30/10/99", 8, 6));
		arrSV.add(new SinhVien("Lê Phước Hiếu", "13/05/99", 9, 6));
		arrSV.add(new SinhVien("Nguyễn Thanh Hiếu", "26/09/99", 4, 5));
		arrSV.add(new SinhVien("Hồ Việt Tú", "04/04/99", 6, 4));
		SinhVien.tongSV = 4;
		showMyMenu();
	}

	public static void nhapDSSV() {

		for (i = 0; i < n; i++) {
			System.out.println("Nhập danh sách sinh viên : ");
			System.out.println("---------------------------");
			System.out.print("Số lượng sinh viên :");
			n = myScanner.nextInt();
			SV = new SinhVien[n];
			for (i = 0; i < n; i++) {
				try {

					myScanner.nextLine();

					System.out.print("Nhập tên Sinh Viên :");
					String SVten = myScanner.nextLine();

					System.out.print("Nhập ngày sinh của Sinh Viên :");
					String SVngaysinh = myScanner.nextLine();

					System.out.print("Nhập điểm môn LP1 :");
					double SVLP1 = myScanner.nextDouble();

					System.out.print("Nhập điểm môn LP2 :");
					double SVLP2 = myScanner.nextDouble();

					arrSV.add(new SinhVien(SVten, SVngaysinh, SVLP1, SVLP2));
					SinhVien.tinhTongSV();
					
				}
				

				catch (Exception e) {

					System.out.println("Bạn chỉ được nhập giá trị kiểu số thôi bạn nhé!!!");

					myScanner.nextLine();
				}
				myScanner.nextLine();
				System.out.println("Ấn Enter để về menu chính");
				myScanner.nextLine();

			}

		}
	}

	public static void inDSSV() {

		System.out.println("Danh sách sinh viên có tổng số là :" + SinhVien.tongSV);
		System.out.println("Danh sách sinh viên ");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("STT  Họ và tên              Ngày sinh     lp1  lp2  ĐTB  ");
		System.out.println("--------------------------------------------------------------------");
		for (i = 0; i < SinhVien.tongSV; i++) {

			System.out.printf("%-5s%-23s%-14s%-5s%-5s%-5s\n", (i + 1), arrSV.get(i).getSVten(),
					arrSV.get(i).getSVngaysinh(), arrSV.get(i).getSVLP1(), arrSV.get(i).getSVLP2(),
					arrSV.get(i).getSVDTB());
		}
		myScanner.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		myScanner.nextLine();
	}

	public static void topSV() {
		double min = arrSV.get(0).getSVDTB(), max = min;
		int x = 0, y = 0;

		for (i = 0; i < arrSV.size(); i++) {
			if (min > arrSV.get(i).getSVDTB()) {
				min = arrSV.get(i).getSVDTB();
				x = i;
			}
			if (max < arrSV.get(i).getSVDTB()) {
				max = arrSV.get(i).getSVDTB();
				y = i;
			}
		}

		System.out.println("Học sinh có kết quả học tập cao nhất là :");
		System.out.printf("%-23s%-14s%-5s%-5s%-5s\n", arrSV.get(y).getSVten(), arrSV.get(y).getSVngaysinh(),
				arrSV.get(y).getSVLP1(), arrSV.get(y).getSVLP2(), arrSV.get(y).getSVDTB());

		System.out.println("Học sinh có kết quả học tập thấp nhất là :");
		System.out.printf("%-23s%-14s%-5s%-5s%-5s\n", arrSV.get(x).getSVten(), arrSV.get(x).getSVngaysinh(),
				arrSV.get(x).getSVLP1(), arrSV.get(x).getSVLP2(), arrSV.get(x).getSVDTB());
		myScanner.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		myScanner.nextLine();

	}

	public static void sapxepTBM() {
		SinhVien[] temp = new SinhVien[n];
		for (i = 0; i < arrSV.size() - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (arrSV.get(i).getSVDTB() < arrSV.get(j).getSVDTB()) {
					temp[i] = arrSV.get(j);
					arrSV.set(j, arrSV.get(i));
					arrSV.set(i, temp[i]);
				}
			}
		}

		for (i = 0; i < n; i++) {
			System.out.println("Danh sách sinh viên đã được sắp xếp theo điểm trung bình ");
			System.out.println("--------------------------------------------------------------------");
			System.out.println("STT  Họ và tên              Ngày sinh     lp1  lp2  ĐTB  Xếp Loại  ");
			System.out.println("--------------------------------------------------------------------");
			for (i = 0; i < n; i++) {
				System.out.printf("%-5s%-23s%-14s%-5s%-5s%-5s%-10s\n", (i + 1), arrSV.get(i).getSVten(),
						arrSV.get(i).getSVngaysinh(), arrSV.get(i).getSVLP1(), arrSV.get(i).getSVLP2(),
						arrSV.get(i).getSVDTB(), arrSV.get(i).getSVxeploai());
			}
		}

		myScanner.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		myScanner.nextLine();
	}

	public static void sapxepten() {
		SinhVien[] temp = new SinhVien[n];
		for (i = 0; i < arrSV.size() - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (arrSV.get(i).getSVten().compareTo(arrSV.get(i).getSVten()) > 0) {
					temp[i] = arrSV.get(j);
					arrSV.set(j, arrSV.get(i));
					arrSV.set(i, temp[i]);
				}
			}
		}

		for (i = 0; i < n; i++) {
			System.out.println("Danh sách sinh viên đã được sắp xếp theo điểm trung bình ");
			System.out.println("--------------------------------------------------------------------");
			System.out.println("STT  Họ và tên              Ngày sinh     lp1  lp2  ĐTB  Xếp Loại  ");
			System.out.println("--------------------------------------------------------------------");
			for (i = 0; i < n; i++) {
				System.out.printf("%-5s%-23s%-14s%-5s%-5s%-5s%-10s\n", (i + 1), arrSV.get(i).getSVten(),
						arrSV.get(i).getSVngaysinh(), arrSV.get(i).getSVLP1(), arrSV.get(i).getSVLP2(),
						arrSV.get(i).getSVDTB(), arrSV.get(i).getSVxeploai());
			}
		}

		myScanner.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		myScanner.nextLine();
	}

	public static void replaceTen() {
		myScanner.nextLine();

		System.out.println("Nhập tên sinh viên bạn muốn đổi :");
		String doiTen = myScanner.nextLine();

		System.out.println("Tên bạn cần muốn thay đổi cho sinh viên :");
		String tenMoi = myScanner.nextLine();
		for (SinhVien x : arrSV) {
			if ((x.getSVten().equals(doiTen))) {
				x.setSVten(tenMoi);
			}
		}
		myScanner.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		myScanner.nextLine();
	}

	public static void deleteSV() {
		myScanner.nextLine();
		System.out.println("Nhập tên sinh viên muốn xóa :");
		String ten = myScanner.nextLine();
		for (SinhVien x : arrSV) {
			if ((x.getSVten().equals(ten))) {
				SinhVien.tongSV -= 1;
				arrSV.remove(x);
				break;
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
			try {
				System.out.println(">>         MENU QUẢN LÝ SINH VIÊN       <<");
				System.out.println("+----------------------------------------+");
				System.out.println("|1. Nhập danh sách sinh viên             |");
				System.out.println("|2. In danh sách sinh viên               |");
				System.out.println("|3. Top sinh viên                        |");
				System.out.println("|4. Sắp xếp theo điểm TBM                |");
				System.out.println("|5. Sắp xếp theo điểm theo tên           |");
				System.out.println("|6. Đổi tên cho sinh viên                |");
				System.out.println("|7. Xóa sinh viên                        |");
				System.out.println("|8. Kết thúc chương trình                |");
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
					sapxepten();
				} else if (myOption == 6) {
					replaceTen();
				} else if (myOption == 7) {
					deleteSV();
				} else if (myOption == 8) {
					ketThuc();
				}
			}

			catch (Exception e) {

				System.out.println("Chi duoc nhap tu 1 den 8, hay nhap lai nhe ban!!!");

				myScanner.nextLine();
			}
		}
	}
}
