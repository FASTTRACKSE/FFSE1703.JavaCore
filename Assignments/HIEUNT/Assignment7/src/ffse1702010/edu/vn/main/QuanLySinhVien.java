package ffse1702010.edu.vn.main;

import ffse1702010.edu.vn.model.*;
import java.util.Scanner;
import java.util.ArrayList;
import ffse1702010.edu.vn.io.TextFileFactory;

public class QuanLySinhVien {
	public static Scanner input = new Scanner(System.in);
	public static ArrayList<SinhVien> arrSinhVien = new ArrayList<SinhVien>();


	public static void main(String[] args) {
		meNu();
	}
	public static void luuFile() {

		boolean kt = TextFileFactory.luuFile(arrSinhVien, "dulieu.txt");
		if (kt == true) {
			System.out.println("Lưu file thành công");
		} else {
			System.out.println("Lưu file thất bại");
		}
	}

	public static void meNu() {
		while (true) {
			try {
				System.out.println(">>              MENU CUA TOI            <<");
				System.out.println("+----------------------------------------+");
				System.out.println("|1. In danh sách sinh viên               |");
				System.out.println("|2. Đổi tên một sinh viên                |");
				System.out.println("|3. Xóa sinh viên theo tên               |");
				System.out.println("|4. Nhập thông tin sinh viên             |");
				System.out.println("|5. kết thúc chương trình                |");
				System.out.println("+----------------------------------------+");
				System.out.println(">>            Bạn ChON SỐ MẤY?          <<");
				int a;
				a = input.nextInt();
				if (a == 1) {
					inSinhVien();
				} else if (a == 2) {
					doiTen();
				} else if (a == 3) {
					xoaTen();
				} else if (a == 4) {
					nhapThongTin();
				} else if (a == 5) {
					ketThuc();
				} else {
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.println("Chỉ được nhập từ 1 -> 5, hãy nhập lại nhé bạn");
				input.nextLine();
			}

		}

	}

	public static void nhapThongTin() {
		try {

			System.out.print("Số lượng sinh viên :");
			int n = input.nextInt();
			input.nextLine();

			for (int i = 0; i < n; i++) {
				input.nextLine();
				System.out.println("Tên sinh viên:");
				String ten = input.nextLine();
				System.out.println("Ngày sinh    :");
				String ngaysinh = input.nextLine();
				System.out.println("Điểm lp1     :");
				int lp1 = input.nextInt();
				System.out.println("Điểm lp2     :");
				int lp2 = input.nextInt();
				SinhVien.tongSV();
			
				arrSinhVien.add(new SinhVien(ten, ngaysinh, lp1, lp2));
			}

		} catch (Exception y) {
			System.out.println("Bạn nhập sai kiểu dử liện mời nhập lại : ");
			System.out.println("Error: " + y.getMessage());
			nhapThongTin();

		}
	}

	public static void test() {
	}

	public static void doiTen() {
		input.nextLine();
		System.out.println("Nhập tên sinh viên cần đổi :");
		String Ten = input.nextLine();
		System.out.println("Tên cần đổi cho sinh viên :");
		String TenMoi = input.nextLine();
		for (int i = 0; i < arrSinhVien.size(); i++) {
			if (arrSinhVien.get(i).getTen().equals(Ten)) {
				arrSinhVien.get(i).setTen(TenMoi);
			}
		}
	}

	public static void xoaTen() {
		input.nextLine();
		System.out.println("Nhập tên sinh viên cần xóa");
		String Ten = input.nextLine();
		for (int i = arrSinhVien.size() - 1; i > -1; i--) {
			if (arrSinhVien.get(i).getTen().equals(Ten)) 
				SinhVien.tongSV -= 1;
				arrSinhVien.remove(i);
			}
		}
	

	public static void inSinhVien() {
		luuFile();

		System.out.println("Danh sách sinh viên có tổng số là :" + SinhVien.tongSV);
		System.out.println("♥♥♥--------------------------------------------------------------------♥♥♥");
		System.out.println("STT  Họ và tên              Ngày sinh     lp1  lp2     ");
		System.out.println("♥♥♥--------------------------------------------------------------------♥♥♥");
		for (int i = 0; i < arrSinhVien.size(); i++) {
			System.out.println(
					(i + 1) + "	 " + arrSinhVien.get(i).getTen() + "			 " + arrSinhVien.get(i).getNgaySinh()
							+ "  	  " + arrSinhVien.get(i).getLp1() + "	" + arrSinhVien.get(i).getLp2());
		}
	}

	public static void ketThuc() {
		System.out.println("Cảm ơn bạn đã sữ dụng chương trình");
		System.out.println("____________♥♥♥♥♥♥♥♥_____________ ");
		System.exit(0);

	}

}
