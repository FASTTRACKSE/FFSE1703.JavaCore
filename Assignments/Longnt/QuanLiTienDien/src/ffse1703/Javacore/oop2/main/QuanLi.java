package ffse1703.Javacore.oop2.main;

import ffse1703.Javacore.oop2.model.*;
import java.util.Scanner;
import java.util.ArrayList;

public class QuanLi {
	public static Scanner myScanner = new Scanner(System.in);
	public static int n;
	static ArrayList<KhachHang> arrKhachHang = new ArrayList<KhachHang>();
	static ArrayList<BienLai> arrBienLai = new ArrayList<BienLai>();

	public static void main(String[] args) {
		myMenu();
	}
//Nhập Khách Hàng
	public static void nhapKhachHang() {
		System.out.print("Nhập Số Lượng Khách Hàng! : ");
		n = myScanner.nextInt();
		String maSoKH;
		String tenKH, diaChi;
		String maCT;
		for (int i = 0; i < n; i++) {

			myScanner.nextLine();
			System.out.println("Nhập Mã Số Khách Hàng Thứ " + (i + 1) + " :");
			maSoKH = myScanner.nextLine();
			System.out.println("Nhập Tên Khách Hàng Thứ " + (i + 1) + " :");
			tenKH = myScanner.nextLine();
			System.out.println("Nhập Địa Chỉ Khách Hàng Thứ " + (i + 1) + " :");
			diaChi = myScanner.nextLine();
			System.out.println("Nhập Mã Công Tơ Khách Hàng Thứ" + (i + 1) + " :");
			maCT = myScanner.nextLine();
			arrKhachHang.add(new KhachHang(maSoKH, tenKH, diaChi, maCT));
		}
	}
//nhập Biên Lai
	public static void nhapBienLai() {
		Double chiSoMoi, chiSoCu;
		int thang, nam;
		System.out.println("Nhập Biên Lai Cho Tháng :");
		thang = myScanner.nextInt();
		System.out.println("Nhập Biên Lai Cho Năm :");
		nam = myScanner.nextInt();
		for (int i = 0; i < arrKhachHang.size(); i++) {
			System.out.println("Biên Lai Tháng : " + thang + " năm " + nam + " :");
			myScanner.nextLine();
			System.out.println("Nhập Chỉ Số Cũ Của Khách Hàng " + arrKhachHang.get(i).getTenKhachHang() + " :");
			chiSoCu = myScanner.nextDouble();
			System.out.println("Nhập Chỉ Số Mới Của Khách Hàng " + arrKhachHang.get(i).getTenKhachHang() + " :");
			chiSoMoi = myScanner.nextDouble();
			arrBienLai.add(new BienLai());
		}
	}
//In Biên Lai
	public static void inBienLai() {
		System.out.println(
				"+---------------------------------DANH SÁCH BIÊN LAI CỦA KHÁCH HÀNG------------------------------ --------+");
		System.out.println(
				"|  Mã KH  |   Tên KH     |     Địa Chỉ  | Mã CT   | Chỉ Số Mới |Chỉ Số Cũ | TỔNG TIỀN  | Tháng | Năm  |");
		for (BienLai x : arrBienLai) {
			System.out.printf("%-10s %-15s %-15s %-10s %-10s %-10s %-11s %-7s %-7s \n", x.getMaKhachHang(),
					x.getTenKhachHang(), x.getDiaChi(), x.getMaCongTo(), x.getChiSoMoi(), x.getChiSoCu(),
					x.getSoTienPhaiTra(), x.getThang(), x.getNam());
		}
		System.out.println("================================");
	}
//In Biên Lai Theo Tháng
	public static void BLTheoThang() {
		int thang, nam;
		System.out.println("Biên Lai Của Tháng :");
		thang = myScanner.nextInt();
		System.out.println("Biên Lai Của Năm :");
		nam = myScanner.nextInt();

		System.out.println(
				"+---------------------------------DANH SÁCH BIÊN LAI TỪNG THÁNG CỦA KHÁCH HÀNG------------------------------ --------+");
		System.out.println(
				"|  Mã KH  |   Tên KH     |     Địa Chỉ  | Mã CT   | Chỉ Số Mới |Chỉ Số Cũ | TỔNG TIỀN  | Tháng | Năm  |");
		for (BienLai x : arrBienLai) {
			if (thang == x.getThang() && nam == x.getNam()) {
				System.out.printf("%-10s %-15s %-15s %-10s %-10s %-10s %-11s %-7s %-7s \n", x.getMaKhachHang(),
						x.getTenKhachHang(), x.getDiaChi(), x.getMaCongTo(), x.getChiSoMoi(), x.getChiSoCu(),
						x.getSoTienPhaiTra(), x.getThang(), x.getNam());
			}
			System.out.println("================================");
		}
	}
//IN Biên Lai Theo Năm
	public static void BLTheoNam() {
		int nam;

		System.out.println("Biên Lai Của Năm :");
		nam = myScanner.nextInt();

		System.out.println(
				"+---------------------------------DANH SÁCH BIÊN LAI CẢ NĂM CỦA KHÁCH HÀNG------------------------------ --------+");
		System.out.println(
				"|  Mã KH  |   Tên KH     |     Địa Chỉ  | Mã CT   | Chỉ Số Mới |Chỉ Số Cũ | TỔNG TIỀN  | Tháng | Năm  |");
		for (BienLai x : arrBienLai) {
			if (nam == x.getNam()) {
				System.out.printf("%-10s %-15s %-15s %-10s %-10s %-10s %-11s %-7s %-7s \n", x.getMaKhachHang(),
						x.getTenKhachHang(), x.getDiaChi(), x.getMaCongTo(), x.getChiSoMoi(), x.getChiSoCu(),
						x.getSoTienPhaiTra(), x.getThang(), x.getNam());
			}
			System.out.println("================================");
		}
	}
//In Biên Lai Theo Mã Khách Hàng
	public static void BLTheoMaKH() {
		String maKH;
		int thang, nam;
		myScanner.nextLine();
		System.out.println("Biên Lai Mã Khách Hàng :");
		maKH = myScanner.nextLine();
		System.out.println("Biên Lai Của tháng :");
		thang = myScanner.nextInt();
		System.out.println("Biên Lai Của Năm :");
		nam = myScanner.nextInt();

		System.out.println(
				"+---------------------------------BIÊN LAI CỦA KHÁCH HÀNG ?------------------------------ --------+");
		System.out.println(
				"|  Mã KH  |   Tên KH     |     Địa Chỉ  | Mã CT   | Chỉ Số Mới |Chỉ Số Cũ | TỔNG TIỀN  | Tháng | Năm  |");
		for (BienLai x : arrBienLai) {
			if (maKH.compareTo(x.getMaKhachHang()) == 0) {
				System.out.printf("%-10s %-15s %-15s %-10s %-10s %-10s %-11s %-7s %-7s \n", x.getMaKhachHang(),
						x.getTenKhachHang(), x.getDiaChi(), x.getMaCongTo(), x.getChiSoMoi(), x.getChiSoCu(),
						x.getSoTienPhaiTra(), x.getThang(), x.getNam());
			}
		}
		System.out.println("<==============???=============>");
	}
//In Danh Sách Khách Hàng
	public static void danhSachKH() {
		System.out.println("+---------------DANH SÁCH KHÁCH HÀNG-------------------+");
		System.out.println("| Mã KH |    Tên KH    |   Địa Chỉ    |   Mã CT      |");
		for (KhachHang x : arrKhachHang) {
			System.out.printf("%-10s%-15s%-15s%-15s \n", x.getMaKhachHang(), x.getTenKhachHang(), x.getDiaChi(),
					x.getMaCongTo());
		}
		System.out.println("================================");
	}
//In Danh Sách Biên Lai
	public static void danhSachBienLai() {
		while (true) {
			System.out.println("+------LỰA CHỌN KIỂU IN BIÊN LAI-------+");
			System.out.println("| 1. IN Theo Ngày/Tháng/Năm            |");
			System.out.println("| 2. IN Theo Năm                       |");
			System.out.println("| 3. IN Theo Mã Của Khách Hàng         |");
			System.out.println("| 4. IN Toàn Bộ Biên Lai               |");
			System.out.println("<======================================>");
			System.out.println("| 6. Kết Thúc                          |");
			System.out.println("<================######================>");
			int option = myScanner.nextInt();
			if (option == 1) {
				BLTheoThang();
			} else if (option == 2) {
				BLTheoNam();
			} else if (option == 3) {
				BLTheoMaKH();
			} else if (option == 4) {
				inBienLai();
			} else if (option == 6) {
				ketThuc();
			}
			System.out.println("Nhấn Enter để tiếp tục");
			System.out.println("______________________________");
			myScanner.nextLine();
		}
	}

	public static void ketThuc() {
		System.out.println("**********THANK YOU!*********");
		System.exit(0);
	}
//Menu 
	public static void myMenu() {
		while (true) {
			System.out.println("+------LỰA CHỌN CHỨC NĂNG-------+");
			System.out.println("| 1. Nhập Số Lượng Khách Hàng   |");
			System.out.println("| 2. Nhập Chỉ Số Điện Hằng Tháng|");
			System.out.println("| 3. IN Biên Lai Cho Khách Hàng |");
			System.out.println("| 4. IN Danh Sách Khách Hàng    |");
			System.out.println("| 5. IN Danh Sách Biên Lai      |");
			System.out.println("=================================");
			System.out.println("| 6. Kết Thúc                   |");
			System.out.println("+-------------------------------+");
			int option = myScanner.nextInt();
			if (option == 1) {
				nhapKhachHang();
			} else if (option == 2) {
				nhapBienLai();
			} else if (option == 3) {
				inBienLai();
			} else if (option == 4) {
				danhSachKH();
			} else if (option == 5) {
				danhSachBienLai();
			} else if (option == 6) {
				ketThuc();
			}
			System.out.println("Nhấn Enter để tiếp tục");
			System.out.println("______________________________");
			myScanner.nextLine();
		}
	}

}
