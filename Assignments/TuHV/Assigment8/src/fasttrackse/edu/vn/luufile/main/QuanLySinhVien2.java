package fasttrackse.edu.vn.luufile.main;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import fasttarckse.edu.vn.luufile.io.TextFileFactory;
import fasttrackse.edu.vn.luufile.*;
import fasttrackse.edu.vn.luufile.model.*;




public class QuanLySinhVien2 {
	
	public static Scanner myScanner = new Scanner(System.in);
	public static ArrayList<SinhVien> arrSV1 = new ArrayList<SinhVien>();

	public static int i, n = 4;
	public static SinhVien[] SV = new SinhVien[4];
	static ArrayList<SinhVien> arrSV = new ArrayList<SinhVien>();

	public static void luuFile() {
		arrSV1.add(new SinhVien("Hieu","12/12/1999",6,6));
		arrSV1.add(new SinhVien("Hieu","12/12/1999",6,6));
		arrSV1.add(new SinhVien("Hieu","12/12/1999",6,6));
		arrSV1.add(new SinhVien("Hieu","12/12/1999",6,6));

		boolean kt = TextFileFactory.luuFile(arrSV1, "dulieu2.txt");
		if (kt == true) {
			System.out.println("Đã lưu file thành công");
		} else {
			System.out.println("Lưu file thất bại");
		}
	}

	public static void main(String[] args) {
	showMyMenu();

}
	public static void nhapDSSV() {
		try {
		for (i = 0; i < n; i++) {
			System.out.println("Nhập danh sách sinh viên : ");
			System.out.println("---------------------------");
			System.out.print("Số lượng sinh viên :");
			n = myScanner.nextInt();
			SV = new SinhVien[n];
			for (i = 0; i < n; i++) {
				

					myScanner.nextLine();

					System.out.print("Nhập tên Sinh Viên :");
					String SVten = myScanner.nextLine();

					System.out.print("Nhập ngày sinh của Sinh Viên :");
					String SVngaysinh = myScanner.nextLine();

					System.out.print("Nhập điểm môn LP1 :");
					double SVLP1 = myScanner.nextDouble();

					System.out.print("Nhập điểm môn LP2 :");
					double SVLP2 = myScanner.nextDouble();

					arrSV1.add(new SinhVien(SVten, SVngaysinh, SVLP1, SVLP2));
					SinhVien.tinhTongSV();

				
			}
		}
				myScanner.nextLine();
				System.out.println("Ấn Enter để về menu chính");
				myScanner.nextLine();

		} catch (Exception e) {

				System.out.println("Bạn chỉ được nhập giá trị kiểu số thôi bạn nhé!!!");

				myScanner.nextLine();
				nhapDSSV();
			}
		

	}
	public static void inDSSV() {

		System.out.println("Danh sách sinh viên có tổng số là :" + SinhVien.tongSV);
		System.out.println("Danh sách sinh viên ");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("STT  Họ và tên              Ngày sinh     lp1  lp2  ĐTB  ");
		System.out.println("--------------------------------------------------------------------");
		for (i = 0; i < SinhVien.tongSV; i++) {

			System.out.printf("%-5s%-23s%-14s%-5s%-5s%-5s\n", (i + 1), arrSV1.get(i).getSVten(),
					arrSV1.get(i).getSVngaysinh(), arrSV1.get(i).getSVLP1(), arrSV1.get(i).getSVLP2(),
					arrSV1.get(i).getSVDTB());
		}
		myScanner.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		myScanner.nextLine();
	}

	public static void topSV() {
		double min = arrSV1.get(0).getSVDTB(), max = min;
		int x = 0, y = 0;

		for (i = 0; i < arrSV1.size(); i++) {
			if (min > arrSV1.get(i).getSVDTB()) {
				min = arrSV1.get(i).getSVDTB();
				x = i;
			}
			if (max < arrSV1.get(i).getSVDTB()) {
				max = arrSV1.get(i).getSVDTB();
				y = i;
			}
		}

		System.out.println("Học sinh có kết quả học tập cao nhất là :");
		System.out.printf("%-23s%-14s%-5s%-5s%-5s\n", arrSV1.get(y).getSVten(), arrSV1.get(y).getSVngaysinh(),
				arrSV1.get(y).getSVLP1(), arrSV1.get(y).getSVLP2(), arrSV1.get(y).getSVDTB());

		System.out.println("Học sinh có kết quả học tập thấp nhất là :");
		System.out.printf("%-23s%-14s%-5s%-5s%-5s\n", arrSV1.get(x).getSVten(), arrSV1.get(x).getSVngaysinh(),
				arrSV1.get(x).getSVLP1(), arrSV1.get(x).getSVLP2(), arrSV1.get(x).getSVDTB());
		myScanner.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		myScanner.nextLine();

	}

	public static void luuFile1() {
		luuFile();
		String fileName = "dulieu2.txt";
		Path path = Paths.get(fileName);

		if (Files.exists(path)) {
			// file exist
			arrSV1 = TextFileFactory.docFile(fileName);
		}

		else {
			arrSV1 = new ArrayList<SinhVien>();
		}

		System.out.println("Danh sách khách hàng nạp vào máy tính là:");
		System.out.println("Ngay Sinh----Tên----Điểm LP1----Điểm LP2");
		for (SinhVien kh : arrSV1) {
			System.out.println(kh);
		}
	

		myScanner.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		myScanner.nextLine();
	}


	public static void sapxepten() {
		SinhVien[] temp = new SinhVien[n];
		for (i = 0; i < arrSV1.size() - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (arrSV1.get(i).getSVten().compareTo(arrSV1.get(i).getSVten()) > 0) {
					temp[i] = arrSV1.get(j);
					arrSV1.set(j, arrSV1.get(i));
					arrSV1.set(i, temp[i]);
				}
			}
		}

		for (i = 0; i < n; i++) {
			System.out.println("Danh sách sinh viên đã được sắp xếp theo điểm trung bình ");
			System.out.println("--------------------------------------------------------------------");
			System.out.println("STT  Họ và tên              Ngày sinh     lp1  lp2  ĐTB  Xếp Loại  ");
			System.out.println("--------------------------------------------------------------------");
			for (i = 0; i < n; i++) {
				System.out.printf("%-5s%-23s%-14s%-5s%-5s%-5s%-10s\n", (i + 1), arrSV1.get(i).getSVten(),
						arrSV1.get(i).getSVngaysinh(), arrSV1.get(i).getSVLP1(), arrSV1.get(i).getSVLP2(),
						arrSV1.get(i).getSVDTB(), arrSV1.get(i).getSVxeploai());
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
		for (SinhVien x : arrSV1) {
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
		for (SinhVien x : arrSV1) {
			if ((x.getSVten().equals(ten))) {
				SinhVien.tongSV -= 1;
				arrSV1.remove(x);
				break;
			}
		}
		myScanner.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		myScanner.nextLine();
	}
	public static void deleteSV2() {
		myScanner.nextLine();
		System.out.println("Nhập tên sinh viên muốn xóa :");
		String ten = myScanner.nextLine();
		for (int i = arrSV1.size() -1; i>-1; i--) {
			if ((arrSV1.get(i).getSVten().equals(ten))) {
				SinhVien.tongSV -= 1;
				arrSV1.remove(i);
				
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
				System.out.println("|4. Lưu File                             |");
				System.out.println("|5. Sắp xếp theo điểm theo tên           |");
				System.out.println("|6. Đổi tên cho sinh viên                |");
				System.out.println("|7. Xóa  từng sinh viên                  |");
				System.out.println("|8. Xóa tất cả sinh viên                 |");
				System.out.println("|9. Kết thúc chương trình                |");
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
					luuFile1();
				} else if (myOption == 5) {
					sapxepten();
				} else if (myOption == 6) {
					replaceTen();
				} else if (myOption == 7) {
					deleteSV();
				} else if (myOption == 8) {
					deleteSV2();
				} else if (myOption == 9) {
					ketThuc();
				}
				 else {

                     throw new Exception();

              }
			}

			catch (Exception e) {

				System.out.println("Chi duoc nhap tu 1 den 9, hay nhap lai nhe ban!!!");

				myScanner.nextLine();
			}
		}
	}
}
