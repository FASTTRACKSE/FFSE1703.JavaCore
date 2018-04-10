package Fasttrack.edu.vn.main;

import java.util.ArrayList;
import java.util.Scanner;

import Fasttrack.edu.vn.model.SinhVien;

public class NhapSV {
	public static Scanner myScanner = new Scanner(System.in);
	public static ArrayList<SinhVien> NhapSV = new ArrayList<SinhVien>();

	public static int i, n = 4;
	public static SinhVien[] SV = new SinhVien[4];

	public static void main(String[] args) {
		NhapSV.add(new SinhVien("Hồ Quang Minh", "30/10/99", 8.0, 6.0));
		NhapSV.add(new SinhVien("Lê Phước Hiếu", "13/05/99", 9.0, 9.0));
		NhapSV.add(new SinhVien("Nguyễn Thanh Hiếu", "26/09/99", 4.0, 5.0));
		NhapSV.add(new SinhVien("Hồ Việt Tú", "04/04/99", 6.0, 4.0));
		SinhVien.tongSV = 4;
		showMyMenu();
	}

	public static void showMyMenu() {
		while (true) {
			try {
				System.out.println("	>>======================================<<");
				System.out.println("	>>         <MENU QUẢN LÝ SINH VIÊN>     <<");
				System.out.println("	||______________________________________||");
				System.out.println("	|| <1>. Nhập danh sách sinh viên        ||");
				System.out.println("	|| <2>. In danh sách sinh viên          ||");
				System.out.println("	|| <3>. Top sinh viên                   ||");
				System.out.println("	|| <4>. Sắp xếp theo điểm TBM           ||");
				System.out.println("	|| <5>. Sắp xếp theo Tên                ||");
				System.out.println("	|| <6>. Đổi tên sinh viên               ||");
				System.out.println("	|| <7>. Xóa sinh viên                   ||");
				System.out.println("	|| <8>. Kết thúc chương trình           ||");
				System.out.println("	|========================================|");
				System.out.println("	>>           Lựa chọn của bạn?          <<");
				System.out.println("	|========================================|");

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
					doiTenSV();
				} else if (myOption == 7) {
					xoaSV();
				} else if (myOption == 8) {
					ketThuc();
				} else {
					throw new Exception();
				}

			} catch (Exception e) {
				System.out.println("Bạn chỉ được nhập từ 1 tới 8.Hãy nhập lại nhé!!!");
				myScanner.nextLine();
			}
		}
	}

	public static void nhapDSSV() {
		try {
			System.out.println("Nhập danh sách sinh viên : ");
			System.out.println("--------------------------");
			System.out.print("Số lượng sinh viên :");
			n = myScanner.nextInt();

			for (i = 0; i < n; i++) {
				myScanner.nextLine();
				System.out.print("Nhập tên Sinh Viên :");
				String Name = myScanner.nextLine();

				System.out.print("Nhập ngày sinh của Sinh Viên :");
				String Date = myScanner.nextLine();

				System.out.print("Nhập điểm môn Lp1 :");
				double Lp1 = myScanner.nextDouble();

				System.out.print("Nhập điểm môn Lp2 :");
				double Lp2 = myScanner.nextDouble();

				NhapSV.add(new SinhVien(Name, Date, Lp1, Lp2));
				SinhVien.tinhTongSV();
			}
			myScanner.nextLine();
			System.out.println("Ấn Enter để về menu chính");
			myScanner.nextLine();
		} catch (Exception e) {
			System.out.println("Hãy nhập lại nhé!!!");
			myScanner.nextLine();
			nhapDSSV();
		}
	}

	public static void inDSSV() {
		System.out.println("Danh sách sinh viên có tổng số là :" + SinhVien.tongSV);
		System.out.println("Danh sách sinh viên ");
		System.out.println("---------------------------------------------------------");
		System.out.println("STT  Họ và tên              Ngày sinh     lp1  lp2  ĐTB  ");
		System.out.println("---------------------------------------------------------");
		for (i = 0; i < SinhVien.tongSV; i++) {

			System.out.printf("%-5s%-23s%-14s%-5s%-5s%-5s\n", (i + 1), NhapSV.get(i).getName(), NhapSV.get(i).getDate(),
					NhapSV.get(i).getLp1(), NhapSV.get(i).getLp2(), NhapSV.get(i).getTBM());
		}
		myScanner.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		myScanner.nextLine();
	}

	public static void topSV() {
		double min = NhapSV.get(0).getTBM(), max = min;
		int x = 0, y = 0;

		for (i = 0; i < NhapSV.size(); i++) {
			if (min > NhapSV.get(i).getTBM()) {
				min = NhapSV.get(i).getTBM();
				x = i;
			}
			if (max < NhapSV.get(i).getTBM()) {
				max = NhapSV.get(i).getTBM();
				y = i;
			}
		}

		System.out.println("Học sinh có kết quả học tập cao nhất là :");
		System.out.printf("%-23s%-14s%-5s%-5s%-5s\n", NhapSV.get(y).getName(), NhapSV.get(y).getDate(),
				NhapSV.get(y).getLp1(), NhapSV.get(y).getLp2(), NhapSV.get(y).getTBM());

		System.out.println("Học sinh có kết quả học tập thấp nhất là :");
		System.out.printf("%-23s%-14s%-5s%-5s%-5s\n", NhapSV.get(x).getName(), NhapSV.get(x).getDate(),
				NhapSV.get(x).getLp1(), NhapSV.get(x).getLp2(), NhapSV.get(x).getTBM());
		myScanner.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		myScanner.nextLine();

	}

	public static void sapxepTBM() {
		SinhVien[] temp = new SinhVien[NhapSV.size()];
		for (int i = 0; i < NhapSV.size() - 1; i++) {
			for (int j = i + 1; j < NhapSV.size(); j++) {
				if (NhapSV.get(i).getTBM() < NhapSV.get(j).getTBM()) {
					temp[i] = NhapSV.get(j);
					NhapSV.set(j, NhapSV.get(i));
					NhapSV.set(i, temp[i]);
				}
			}
		}

		System.out.println("Danh sách sinh viên đã được sắp xếp theo điểm trung bình ");
		System.out.println("-------------------------------------------------------------------");
		System.out.println("STT  Họ và tên              Ngày sinh     lp1  lp2  ĐTB  Xếp Loại  ");
		System.out.println("-------------------------------------------------------------------");
		for (int i = 0; i < NhapSV.size(); i++) {
			System.out.printf("%-5s%-23s%-14s%-5s%-5s%-5s%-10s\n", (i + 1), NhapSV.get(i).getName(),
					NhapSV.get(i).getDate(), NhapSV.get(i).getLp1(), NhapSV.get(i).getLp2(), NhapSV.get(i).getTBM(),
					NhapSV.get(i).XepLoai());

		}

		myScanner.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		myScanner.nextLine();
	}

	public static void sapxepTen() {
		SinhVien[] temp = new SinhVien[NhapSV.size()];
		for (i = 0; i < NhapSV.size() - 1; i++) {
			for (int j = i + 1; j < NhapSV.size(); j++) {// compareTo để so sánh chuỗi trong trường hợp sắp xếp theo tên
				if (NhapSV.get(i).getName().compareTo(NhapSV.get(j).getName()) > 0) {
					temp[i] = NhapSV.get(j);
					NhapSV.set(j, NhapSV.get(i));
					NhapSV.set(i, temp[i]);
				}
			}
		}

		for (i = 0; i < n; i++) {
			System.out.println("Danh sách sinh viên theo tên ");
			System.out.println("--------------------------------------------------------------------");
			System.out.println("STT  Họ và tên              Ngày sinh     lp1  lp2  ĐTB  Xếp Loại   ");
			System.out.println("--------------------------------------------------------------------");
			for (i = 0; i < n; i++) {
				System.out.printf("%-5s%-23s%-14s%-5s%-5s%-5s%-10s\n", (i + 1), NhapSV.get(i).getName(),
						NhapSV.get(i).getDate(), NhapSV.get(i).getLp1(), NhapSV.get(i).getLp2(), NhapSV.get(i).getTBM(),
						NhapSV.get(i).XepLoai());

			}
		}

		myScanner.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		myScanner.nextLine();
	}

	public static void doiTenSV() {

		myScanner.nextLine();
		System.out.println("Nhập tên sinh viên cần đổi :");
		String DoiTen = myScanner.nextLine();
		System.out.println("Tên cần đổi cho sinh viên :");
		String TenMoi = myScanner.nextLine();
		for (SinhVien x : NhapSV) {
			if ((x.getName().equals(DoiTen))) {
				x.setName(TenMoi);
			}
		}
	}

	public static void xoaSV() {
		myScanner.nextLine();
		System.out.println("Nhập tên sinh viên cần xóa :");
		String XoaTen = myScanner.nextLine();

		for (int j = NhapSV.size() - 1; j > -1; j--) {
			if ((NhapSV.get(j).getName().equals(XoaTen))) {
				NhapSV.remove(j);
				SinhVien.tongSV -= 1;
			}
		}

	}

	public static void ketThuc() {
		System.out.println("Kết thúc chương trình!!!!!");
		System.exit(0);
	}

}