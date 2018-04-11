package ffse1702.fasttrack.edu.main;

import java.util.ArrayList;
import ffse1702.fasttrack.edu.io.SerializeFileFactory;
import java.util.Collections;
import java.nio.file.*;
import java.util.Scanner;

import ffse1702.fasttrack.edu.model.*;

public class QuanLySV  {
	public static Scanner myScanner = new Scanner(System.in);
	public static ArrayList<SinhVien> arrSV = new ArrayList<SinhVien>();

	public static int i, n = 4;
	public static SinhVien[] SV = new SinhVien[4];

	public static void main(String[] args) {
		
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

			System.out.println("Nhập danh sách sinh viên : ");
			System.out.println("--------------------------");
			System.out.print("Số lượng sinh viên :");
			
			Path path = Paths.get("dulieu.txt");
			if(Files.exists(path)) {
				arrSV = SerializeFileFactory.docFile("dulieu.txt");
			}else {
				arrSV = new ArrayList<SinhVien>();
				arrSV.add(new SinhVien("Hồ Quang Minh", "30/10/99", 8.0, 6.0));
				arrSV.add(new SinhVien("Lê Phước Hiếu", "13/05/99", 9.0, 9.0));
				arrSV.add(new SinhVien("Nguyễn Thanh Hiếu", "26/09/99", 4.0, 5.0));
				arrSV.add(new SinhVien("Hồ Việt Tú", "04/04/99", 6.0, 4.0));
				SinhVien.tongSV = 4;
			}
			
			try {	
			int n = myScanner.nextInt();

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

				arrSV.add(new SinhVien(Name, Date, Lp1, Lp2));
				SinhVien.tinhTongSV();
				boolean checked= SerializeFileFactory.luuFile(arrSV, "dulieu.txt");
				if (checked == true) {
					System.out.println("Đã lưu thông tin của "+ (i+1) +" sinh viên");
				} else {
					System.out.println("Lưu thất bại");
				
				}
				}

			myScanner.nextLine();
			System.out.println("Ấn Enter để về menu chính");
			myScanner.nextLine();
				}catch(Exception e) {
					System.out.println("Bạn đã nhập sai vui lòng nhập lại!");
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
		ArrayList<SinhVien> arrSV = SerializeFileFactory.docFile("dulieu.txt");
		for (i = 0; i < arrSV.size(); i++) {

			System.out.printf("%-5s%-23s%-14s%-5s%-5s%-5s\n", (i + 1), arrSV.get(i).getName(), arrSV.get(i).getDate(),
					arrSV.get(i).getLp1(), arrSV.get(i).getLp2(), arrSV.get(i).getTBM());
		}
		myScanner.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		myScanner.nextLine();
	}

	public static void topSV() {
		ArrayList<SinhVien> NhapSV = SerializeFileFactory.docFile("dulieu.txt");
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
		ArrayList<SinhVien> arrSV = SerializeFileFactory.docFile("dulieu.txt");
		SinhVien[] temp = new SinhVien[arrSV.size()];
		for (int i = 0; i < arrSV.size() - 1; i++) {
			for (int j = i + 1; j < arrSV.size(); j++) {
				if (arrSV.get(i).getTBM() < arrSV.get(j).getTBM()) {
					temp[i] = arrSV.get(j);
					arrSV.set(j, arrSV.get(i));
					arrSV.set(i, temp[i]);
				}
			}
		}

		System.out.println("Danh sách sinh viên đã được sắp xếp theo điểm trung bình ");
		System.out.println("-------------------------------------------------------------------");
		System.out.println("STT  Họ và tên              Ngày sinh     lp1  lp2  ĐTB  Xếp Loại  ");
		System.out.println("-------------------------------------------------------------------");
		for (int i = 0; i < arrSV.size(); i++) {
			System.out.printf("%-5s%-23s%-14s%-5s%-5s%-5s%-10s\n", (i + 1), arrSV.get(i).getName(),
					arrSV.get(i).getDate(), arrSV.get(i).getLp1(), arrSV.get(i).getLp2(), arrSV.get(i).getTBM(),
					arrSV.get(i).XepLoai());

		}

		myScanner.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		myScanner.nextLine();
	}

	public static void sapxepTen() {
		ArrayList<SinhVien> arrSV = SerializeFileFactory.docFile("dulieu.txt");
		SinhVien[] temp = new SinhVien[arrSV.size()];
		for (i = 0; i < arrSV.size() - 1; i++) {
			for (int j = i + 1; j < arrSV.size(); j++) {// compareTo để so sánh chuỗi trong trường hợp sắp xếp theo tên
				if (arrSV.get(i).getName().compareTo(arrSV.get(j).getName()) > 0) {
					temp[i] = arrSV.get(j);
					arrSV.set(j, arrSV.get(i));
					arrSV.set(i, temp[i]);
				}
			}
		}

		for (i = 0; i < n; i++) {
			System.out.println("Danh sách sinh viên theo tên ");
			System.out.println("--------------------------------------------------------------------");
			System.out.println("STT  Họ và tên              Ngày sinh     lp1  lp2  ĐTB  Xếp Loại   ");
			System.out.println("--------------------------------------------------------------------");
			for (i = 0; i < arrSV.size(); i++) {
				System.out.printf("%-5s%-23s%-14s%-5s%-5s%-5s%-10s\n", (i + 1), arrSV.get(i).getName(),
						arrSV.get(i).getDate(), arrSV.get(i).getLp1(), arrSV.get(i).getLp2(), arrSV.get(i).getTBM(),
						arrSV.get(i).XepLoai());

			}
		}

		myScanner.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		myScanner.nextLine();
	}

	public static void doiTenSV() {
		ArrayList<SinhVien> arrSV = SerializeFileFactory.docFile("dulieu.txt");
		myScanner.nextLine();
		System.out.println("Nhập tên sinh viên cần đổi :");
		String DoiTen = myScanner.nextLine();
		System.out.println("Tên cần đổi cho sinh viên :");
		String TenMoi = myScanner.nextLine();
		for (SinhVien x : arrSV) {
			if ((x.getName().equals(DoiTen))) {
				x.setName(TenMoi);
				boolean checked= SerializeFileFactory.luuFile(arrSV, "dulieu.txt");
			}
		}
	}

	public static void xoaSV() {
		myScanner.nextLine();
		System.out.println("Nhập tên sinh viên cần xóa :");
		String XoaTen = myScanner.nextLine();

		for (int j = arrSV.size() - 1; j > -1; j--) {
			if ((arrSV.get(j).getName().equals(XoaTen))) {
				arrSV.remove(j);
				SinhVien.tongSV -= 1;
				boolean checked= SerializeFileFactory.luuFile(arrSV, "dulieu.txt");
			}
		}

	}

	public static void ketThuc() {
		System.out.println("Kết thúc chương trình!!!!!");
		System.exit(0);
	}

}
