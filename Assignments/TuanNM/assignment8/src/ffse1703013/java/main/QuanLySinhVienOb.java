package ffse1703013.java.main;

import java.util.Scanner;
import ffse1703013.java.io.SerializeFileFactory;
import ffse1703013.java.io.TextFileFactory;
import ffse1703013.java.modle.*;

import ffse1703013.java.modle.SinhVien;
import java.util.Collections;
import java.util.ArrayList;

import java.io.File;

public class QuanLySinhVienOb {

	public static int size;
	public static Scanner myScanner = new Scanner(System.in);
	static ArrayList<SinhVien> arrSinhVien = new ArrayList<SinhVien>();

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		myMenu();
	}

	public static void themSv() {
//
			File file = new File("D:/FFSE1703.JavaCore/Assignments/TuanNM/assignment8/dulieu2.txt");	    
		    if(file.exists()) {
		    	ArrayList<SinhVien> arrSvFile = SerializeFileFactory.docFile("dulieu2.txt");
		  		arrSinhVien=arrSvFile;
		    }
		    try {
			System.out.print("Nhap vao so số sinh viên cần thêm : ");
			size = myScanner.nextInt();
			for (int i = 0; i < size; i++) {
				myScanner.nextLine();
				System.out.println("Nhập tên sinh viên thứ " + (i + 1) + " :");
				String ten = myScanner.nextLine();		
				System.out.println("Nhập ngày sinh sinh viên thứ " + (i + 1) + " :");
				String ngaySinh = myScanner.nextLine();				
				System.out.println("Nhập điểm lp1 sinh viên thứ " + (i + 1) + " :");
				Double lP1 = myScanner.nextDouble();				
				System.out.println("Nhập điểm lp2 sinh viên thứ " + (i + 1) + " :");
				Double lP2 = myScanner.nextDouble();		
				System.out.println("Nhấn Enter để tiếp tục");
				System.out.println("______________________________");
				myScanner.nextLine();
				SinhVien.tongSo();
				arrSinhVien.add(new SinhVien(ten, ngaySinh, lP1, lP2));		
			}
			boolean kt = SerializeFileFactory.luuFile(arrSinhVien, "dulieu2.txt");
			if (kt == true) {
				System.out.println("Đã lưu file thành công");
			} else {
				System.out.println("Lưu file thất bại");
			}
		} catch (Exception e) {
			System.out.println("Nhập sai. vui lòng nhập lại");
			myScanner.nextLine();
		}
	}

	public static void dsSinhVien() {
		System.out.println("Tong so sinh vien la: " + SinhVien.toTal);
		System.out.println("+---------------------------------Danh sách sinh viên---------------------------------+");
		System.out.println("|tên SV      |     ngày sinh  |      lp1     |       lp2  |      ĐTB   |     xếp loại");
		ArrayList<SinhVien> dsKH = SerializeFileFactory.docFile("dulieu2.txt");
		for (SinhVien x : dsKH) {
			System.out.println(x);
		}
		System.out.println("============================================================");

	}


	public static void sapXepDtb() {

		System.out.println("+---------------------------------Danh sách sinh viên---------------------------------+");
		System.out.println("|tên SV      |     ngày sinh  |      lp1     |       lp2  |      ĐTB   |     xếp loại");
		ArrayList<SinhVien> arrSv = TextFileFactory.docFile("dulieusinhvientext.txt");
		Collections.sort(arrSv, SinhVien.SVDTBComparator);
		for (SinhVien x : arrSv) {
			System.out.println(x);
		}
	}

	public static void sortName() {
		System.out.println("+---------------------------------Danh sách sinh viên---------------------------------+");
		System.out.println("|tên SV      |     ngày sinh  |      lp1     |       lp2  |      ĐTB   |     xếp loại");
		ArrayList<SinhVien> arrSv = TextFileFactory.docFile("dulieusinhvientext.txt");
		Collections.sort(arrSv, SinhVien.SVNameComparator);
		for (SinhVien x : arrSv) {
			System.out.println(x);
		}
	}

	public static void chinhSuaTen() {

		myScanner.nextLine();
		try {
			System.out.println("Nhập tên cần chỉnh sửa:");
			String ten = myScanner.nextLine();
			System.out.println("Nhập tên mới:");
			String tenNew = myScanner.nextLine();
			for (SinhVien x : arrSinhVien) {
				if (ten.equals(x.getName())) {
					x.setName(tenNew);
				}
			}

		} catch (Exception e) {
			System.out.println("         Nhập sai định dạng !!!");
			System.out.println("         Vui lòng nhập lại!!!");
		}
	}

	public static void timKiem() {
		myScanner.nextLine();
		System.out.println("Nhập tên cần tìm kiếm:");
		String ten = myScanner.nextLine();
		System.out.println("+-------------------------Danh sách sinh viên-----------------------+");
		System.out.println("|tên SV    |   ngày sinh   |  lp1   |  lp2  |  ĐTB  | xếp loại");
		for (SinhVien x : arrSinhVien) {
			if (ten.equals(x.getName())) {
				System.out.println("|" + x.getName() + "\t \t" + x.getBirthday() + "\t \t" + x.getLp1() + " \t"
						+ x.getLp2() + "\t" + x.getDtb() + "\t" + x.getXepLoai());
			}
		}
	}

	public static void xoaTen() {
		myScanner.nextLine();
		System.out.println("Nhập tên cần xóa");
		String ten = myScanner.nextLine();
		for (int i = 0; i < arrSinhVien.size(); i++) {
			for (SinhVien x : arrSinhVien) {
				if (ten.equals(x.getName())) {
					arrSinhVien.remove(x);
					i--;
					break;
				}
			}
		}
	}

	public static void xoaToanBo() {
		try {
			System.out.println("+------BẠN MUỐN XÓA TOÀN BỘ-----+");
			System.out.println("| 1. Đồng ý                     |");
			System.out.println("| 2. Không và quay lai          |");
			System.out.println("=================================");

			int option = myScanner.nextInt();
			if (option == 1) {
				arrSinhVien.clear();
			} else if (option == 2) {
				myMenu();
			}
		} catch (Exception e) {
			System.out.println("Vui lòng chọn 1 hoặc 2, vui lòng nhậ lại.!!");
			myScanner.nextLine();
		}
	}

	public static void ketThuc() {
		System.out.println("Cám ơn bạn đã sử dụng chương trình");
		System.exit(0);
	}

	public static void myMenu() {
		while (true) {
			try {
				System.out.println("+------LỰA CHỌN CHỨC NĂNG-------+");
				System.out.println("| 1. Thêm sinh viên             |");
				System.out.println("| 2. Danh sach sinh viên        |");
				System.out.println("| 3. Tốp sinh viên              |");
				System.out.println("| 4. Sắp xếp theo điểm TB       |");
				System.out.println("| 5. Sắp xếp theo tên           |");
				System.out.println("| 6. Chỉnh sửa tên              |");
				System.out.println("| 7. Tìm Kiếm                   |");
				System.out.println("| 8. Xóa theo tên               |");
				System.out.println("| 9. Xóa toàn bộ                |");
				System.out.println("=================================");
				System.out.println("| 0. Kết thúc                   |");
				System.out.println("+-------------------------------+");
				int option = myScanner.nextInt();
				if (option == 1) {
					themSv();
				} else if (option == 2) {
					dsSinhVien();
				} else if (option == 3) {

				} else if (option == 4) {
					sapXepDtb();
				} else if (option == 5) {
					sortName();
				} else if (option == 6) {
					chinhSuaTen();
				} else if (option == 7) {
					timKiem();
				} else if (option == 8) {
					xoaTen();
				} else if (option == 9) {
					xoaToanBo();
				} else if (option == 0) {
					ketThuc();
				}
			} catch (Exception e) {
				System.out.println("Lựa chọn của bạn chưa đúng. Vui lòng nhập lại!!");
				myScanner.nextLine();
				myScanner.nextLine();
			}
		}
	}
}
