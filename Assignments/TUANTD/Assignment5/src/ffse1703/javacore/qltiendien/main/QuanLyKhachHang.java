package ffse1703.javacore.qltiendien.main;

import ffse1703.javacore.qltiendien.model.*;
import java.util.Scanner;
import java.util.ArrayList;

public class QuanLyKhachHang {
	private static final String MaCongTo = null;
	private static final String SoNha = null;
	private static final String MaKhachHang = null;
	private static final String TenKhachHang = null;
	public static Scanner myScanner = new Scanner(System.in);
	public static int size;
	static ArrayList<KhachHang> arrayKhachHang = new ArrayList<KhachHang>();
	static ArrayList<BienLai> arrayBienLai = new ArrayList<BienLai>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myMenu();
	}

	public static void themKH() {
		System.out.print("Nhập Số Lượng Khách Hành? : ");
		size = myScanner.nextInt();
		String maSoKH;
		String tenKH, diaChi;
		String maCT;
		for (int i = 0; i < size; i++) {

			myScanner.nextLine();
			System.out.println("Nhập Mã Số Khách Hàng Thứ " + (i + 1) + " :");
			maSoKH = myScanner.nextLine();
			System.out.println("Nhập Tên Khách Hàng Thứ " + (i + 1) + " :");
			tenKH = myScanner.nextLine();
			System.out.println("Nhập Địa Chỉ Khách Hàng Thứ " + (i + 1) + " :");
			diaChi = myScanner.nextLine();
			System.out.println("Nhập Mã Công Tơ Khách Hàng Thứ" + (i + 1) + " :");
			maCT = myScanner.nextLine();
			arrayKhachHang.add(new KhachHang(MaKhachHang, TenKhachHang, SoNha, MaCongTo));
		}
	}

	public static void themBL() {
		Double chiSoMoi, chiSoCu;
		int thang, nam;
		System.out.println("Nhập Biên Lai Tháng :");
		thang = myScanner.nextInt();
		System.out.println("Nhập Biên Lai Năm :");
		nam = myScanner.nextInt();
		for (int i = 0; i < arrayKhachHang.size(); i++) {
			System.out.println("Biên Lai Tháng : " + thang + " năm " + nam + " :");
			myScanner.nextLine();
			System.out.println("Nhập Chỉ Số Mới Của Khách Hàng " + arrayKhachHang.get(i).getTenKhachHang() + " :");
			chiSoMoi = myScanner.nextDouble();
			System.out.println("Nhập Chỉ Số Cũ Của Khách Hàng" + arrayKhachHang.get(i).getTenKhachHang() + " :");
			chiSoCu = myScanner.nextDouble();
			arrayBienLai.add(new BienLai(arrayKhachHang.get(i).getMaKhachHang(),
					arrayKhachHang.get(i).getTenKhachHang(), arrayKhachHang.get(i).getSoNha(),
					arrayKhachHang.get(i).getMaCongTo(), chiSoCu, chiSoMoi, thang, nam));
		}
	}

	public static void bienLai() {
		System.out.println(
				"+---------------------------------DANH SÁCH BIÊN LAI CỦA KHÁCH HÀNG------------------------------ --------+");
		System.out.println(
				"|  Mã KH  |   Tên KH     |     Địa Chỉ  | Mã CT   | Chỉ Số Mới |Chỉ Số Cũ | TỔNG TIỀN  | Tháng | Năm  |");
		for (BienLai x : arrayBienLai) {
			System.out.printf("%-10s %-15s %-15s %-10s %-10s %-10s %-11s %-7s %-7s \n", x.getMaKhachHang(),
					x.getTenKhachHang(), x.getSoNha(), x.getMaCongTo(), x.getChiSoMoi(), x.getChiSoCu(),
					x.getTienDien(), x.getThang(), x.getNam());
		}
		System.out.println("================================");
	}

	public static void inBienLaiThang() {
		int thang, nam;
		System.out.println("Biên Lai Của Tháng :");
		thang = myScanner.nextInt();
		System.out.println("Biên Lai Của Năm :");
		nam = myScanner.nextInt();

		System.out.println(
				"+---------------------------------DANH SÁCH BIÊN LAI TỪNG THÁNG CỦA KHÁCH HÀNG------------------------------ --------+");
		System.out.println(
				"|  Mã KH  |   Tên KH     |     Địa Chỉ  | Mã CT   | Chỉ Số Mới |Chỉ Số Cũ | TỔNG TIỀN  | Tháng | Năm  |");
		for (BienLai x : arrayBienLai) {
			if (thang == x.getThang() && nam == x.getNam()) {
				System.out.printf("%-10s %-15s %-15s %-10s %-10s %-10s %-11s %-7s %-7s \n", x.getMaKhachHang(),
						x.getTenKhachHang(), x.getSoNha(), x.getMaCongTo(), x.getChiSoMoi(), x.getChiSoCu(),
						x.getTienDien(), x.getThang(), x.getNam());
			}
			System.out.println("================================");
		}
	}

	public static void inBienLaiNam() {
		int nam;

		System.out.println("Biên Lai Của Năm :");
		nam = myScanner.nextInt();

		System.out.println(
				"+---------------------------------DANH SÁCH BIÊN LAI CẢ NĂM CỦA KHÁCH HÀNG------------------------------ --------+");
		System.out.println(
				"|  Mã KH  |   Tên KH     |     Địa Chỉ  | Mã CT   | Chỉ Số Mới |Chỉ Số Cũ | TỔNG TIỀN  | Tháng | Năm  |");
		for (BienLai x : arrayBienLai) {
			if (nam == x.getNam()) {
				System.out.printf("%-10s %-15s %-15s %-10s %-10s %-10s %-11s %-7s %-7s \n", x.getMaKhachHang(),
						x.getTenKhachHang(), x.getSoNha(), x.getMaCongTo(), x.getChiSoMoi(), x.getChiSoCu(),
						x.getTienDien(), x.getThang(), x.getNam());
			}
			System.out.println("================================");
		}
	}

	public static void inBienLaiMaKH() {
		String maKH;
		int thang, nam;
		System.out.println("Biên Lai Mã Khách Hàng :");
		maKH = myScanner.nextLine();
		System.out.println("Biên Lai Của tháng :");
		thang = myScanner.nextInt();
		System.out.println("Biên Lai Của Năm :");
		nam = myScanner.nextInt();

		System.out.println(
				"+---------------------------------BIÊN LAI CỦA KHÁCH HÀNG------------------------------ --------+");
		System.out.println(
				"|  Mã KH  |   Tên KH     |     Địa Chỉ  | Mã CT   | Chỉ Số Mới |Chỉ Số Cũ | TỔNG TIỀN  | Tháng | Năm  |");
		for (BienLai x : arrayBienLai) {
			if (thang == x.getThang() && nam == x.getNam() && maKH.compareTo(x.getMaKhachHang()) == 0) {
				System.out.println("     +----------------BIÊN LAI TIỀN ĐIỆN--------------+");
				System.out.println("     |<==============================================>|");
				System.out.println("     |Mã khách hàng:"  + "  " + x.getMaKhachHang()  +"|");
				System.out.println("     |Tên Khách Hàng:" + "  " + x.getTenKhachHang() +"|");
				System.out.println("     |Địa chỉ:"        + "  " + x.getSoNha()        +"|");
				System.out.println("     |Mã Công Tơ:"     + "  " + x.getMaCongTo()     +"|");
				System.out.println("     |<==============================================>|");
				System.out.println("     |Mã chỉ Số mới:"  + "  " + x.getMaKhachHang()  +"|");
			}
			System.out.println("<==============???=============>");
		}
	}

	public static void danhSachKH() {
		System.out.println("+---------------DANH SÁCH KHÁCH HÀNG-------------------+");
		System.out.println("| Mã KH |    Tên KH    |   Địa Chỉ    |   Mã CT      |");
		for (KhachHang x : arrayKhachHang) {
			System.out.printf("%-10s%-15s%-15s%-15s", x.getMaKhachHang(), x.getTenKhachHang(), x.getSoNha(),
					x.getMaCongTo());
		}
		System.out.println("================================");
	}

	public static void danhSachBienLai() {
		while (true) {
			System.out.println("+------LỰA CHỌN In Biên Lai-------+");
			System.out.println("| 1. In theo tháng,năm            |");
			System.out.println("| 2. In theo năm                  |");
			System.out.println("| 3. In theo mã khách hàng        |");
			System.out.println("| 4. In toàn bộ biên lai          |");
			System.out.println("==================================");
			System.out.println("| 6. Kết thúc                     |");
			System.out.println("+---------------------------------+");
			int option = myScanner.nextInt();
			if (option == 1) {
				inBienLaiThang();
			} else if (option == 2) {
				inBienLaiNam();
			} else if (option == 3) {
				inBienLaiMaKH();
			} else if (option == 4) {
				bienLai();
			} else if (option == 6) {
				ketThuc();
			}
			System.out.println("Nhấn Enter để tiếp tục");
			System.out.println("______________________________");
			myScanner.nextLine();
		}
	}

	public static void ketThuc() {
		System.out.println("++++++ Chương trình kết thúc+++++++");
		System.exit(0);
	}

	public static void myMenu() {
		while (true) {
			System.out.println("+------LỰA CHỌN CHỨC NĂNG-------+");
			System.out.println("| 1. Thêm khách hàng            |");
			System.out.println("| 2. Thêm chỉ số                |");
			System.out.println("| 3. Biên lai                   |");
			System.out.println("| 4. Danh sach khách hàng       |");
			System.out.println("| 5. Danh sach biên lai         |");
			System.out.println("=================================");
			System.out.println("| 6. Kết thúc                   |");
			System.out.println("+-------------------------------+");
			int option = myScanner.nextInt();
			if (option == 1) {
				themKH();
			} else if (option == 2) {
				themBL();
			} else if (option == 3) {
				bienLai();
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
