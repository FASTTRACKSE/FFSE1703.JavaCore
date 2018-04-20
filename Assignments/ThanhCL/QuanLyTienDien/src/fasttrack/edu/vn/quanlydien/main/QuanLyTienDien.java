package fasttrack.edu.vn.quanlydien.main;

import java.util.ArrayList;
import java.util.Scanner;

import fasttrack.edu.vn.quanlydien.models.*;

public class QuanLyTienDien {
	private static ArrayList<KhachHang> dsKhachHang = new ArrayList<KhachHang>();
	private static ArrayList<BienLai> dsBienLai = new ArrayList<BienLai>();
	private static Scanner myScanner = new Scanner(System.in);

	public static void main(String[] args) {
		myMenu();
	}

	public static void myMenu() {
		while (true) {
			System.out.println("\nLỰA CHỌN CHỨC NĂNG");
			System.out.println("1. Nhập danh sách khách hàng");
			System.out.println("2. In danh sách khách hàng");
			System.out.println("3. Nhập hoá đơn tiền điện");
			System.out.println("4. In biên lai tiền điện");
			System.out.println("5. Kết thúc chương trình");
			System.out.print("Lua chon cua ban: ");

			int myOption = myScanner.nextInt();
			if (myOption == 1) {
				initDataKhachHang();
			} else if (myOption == 2) {
				inDanhSachKhachHang();
			} else if (myOption == 3) {
				initDataBienLai();
			} else if (myOption == 4) {
				mySubMenu();
			} else if (myOption == 5) {
				ketThuc();
			}

			if (myOption != 4) {
				backToMainMenu();
			}
		}
	}

	public static void mySubMenu() {
		while (true) {
			System.out.println("\n4. LỰA CHỌN CHỨC NĂNG IN BIÊN LAI");
			System.out.println("1. In biên lai theo chu kỳ");
			System.out.println("2. In biên lai theo mã khách hàng");
			System.out.println("3. In toàn bộ bộ biên lai của năm");
			System.out.println("4. Quay về menu chính");
			System.out.print("Lua chon cua ban: ");

			int myOption = myScanner.nextInt();
			if (myOption == 1) {
				inDanhSachBienLaiTien(1, 2018);
				inDanhSachBienLaiTien(2, 2018);
				inDanhSachBienLaiTien(3, 2018);
			} else if (myOption == 2) {
				inDanhSachBienLaiTien("FFSE1701001", 3, 2018);
				inDanhSachBienLaiTien("FFSE1701001");
			} else if (myOption == 3) {
				inDanhSachBienLaiTien(2018);
			} else if (myOption == 4) {
				break;
			}
			backToSubMenu();
		}
	}

	public static void backToMainMenu() {
		myScanner.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		myScanner.nextLine();
	}

	public static void backToSubMenu() {
		myScanner.nextLine();
		System.out.println("Ấn Enter để về menu in biên lai");
		myScanner.nextLine();
	}

	public static void inDanhSachBienLaiTien(int thang, int nam) {
		System.out.println("\nBIÊN LAI TIỀN ĐIỆN THÁNG " + thang + " NĂM " + nam);
		System.out.println("---------------------------------------------------------------------------");
		System.out.println(" STT HỌ TÊN                   MÃ CÔNG TƠ     CS ĐẦU CS CUỐI TỔNG TIỀN      ");
		System.out.println("---------------------------------------------------------------------------");

		int stt = 1;
		long tongTien = 0;
		for (BienLai x : dsBienLai) {
			if (x.getThangTinhChuKy() == thang && x.getNamTinhChuKy() == nam) {
				System.out.printf("  %-3s%-25s%-15s%6s%8s%,10d\n", stt, x.getTenKhachHang(), x.getMaCongToDien(),
						x.getSoDienDauKy(), x.getSoDienCuoiKy(), x.tinhTienTieuThu());
				stt++;
				tongTien += x.tinhTienTieuThu();
			}
		}

		System.out.println("---------------------------------------------------------------------------");
		System.out.printf("                                              TỔNG TIỀN:   %,10d\n", tongTien);
		System.out.println("---------------------------------------------------------------------------");

	}

	public static void inDanhSachBienLaiTien(String maKH, int thang, int nam) {
		for (BienLai x : dsBienLai) {
			if (x.getMaKhachHang().equals(maKH) && x.getThangTinhChuKy() == thang && x.getNamTinhChuKy() == nam) {
				System.out.println("\nBIÊN LAI TIỀN ĐIỆN");
				System.out.println("-----------------------------------");
				System.out.println("CHU KỲ        : " + thang + "/" + nam);
				System.out.println("MÃ KHÁCH HÀNG : " + maKH);
				System.out.println("TÊN KHÁCH HÀNG: " + x.getTenKhachHang());
				System.out.println("-----------------------------------");
				System.out.println("MÃ CÔNG TƠ    : " + x.getMaCongToDien());
				System.out.println("CS ĐẦU        : " + x.getSoDienDauKy());
				System.out.println("CS CUỐI       : " + x.getSoDienCuoiKy());
				System.out.printf("TỔNG TIỀN     : %,d\n", x.tinhTienTieuThu());
				System.out.println("-----------------------------------");
			}
		}
	}

	public static void inDanhSachBienLaiTien(String maKH) {
		System.out.println("\nBIÊN LAI TIỀN ĐIỆN");
		System.out.println("MÃ KHÁCH HÀNG: " + maKH);
		System.out.println("------------------------------------------------------------------------------");
		System.out.println(" STT HỌ TÊN                   MÃ CÔNG TƠ     CHU KỲ  CS ĐẦU CS CUỐI TỔNG TIỀN      ");
		System.out.println("------------------------------------------------------------------------------");

		int stt = 1;
		long tongTien = 0;
		for (BienLai x : dsBienLai) {
			if (x.getMaKhachHang().equals(maKH)) {
				System.out.printf("  %-3s%-25s%-15s%-8s%6s%8s%,10d\n", stt, x.getTenKhachHang(), x.getMaCongToDien(),
						x.getThangTinhChuKy() + "/" + x.getNamTinhChuKy(), x.getSoDienDauKy(), x.getSoDienCuoiKy(),
						x.tinhTienTieuThu());
				stt++;
				tongTien += x.tinhTienTieuThu();
			}
		}

		System.out.println("------------------------------------------------------------------------------");
		System.out.printf("                                                      TỔNG TIỀN:   %,10d\n", tongTien);
		System.out.println("------------------------------------------------------------------------------");

	}

	public static void inDanhSachBienLaiTien(int nam) {
		System.out.println("\nBIÊN LAI TIỀN ĐIỆN");
		System.out.println("NĂM: " + nam);

		System.out.println("------------------------------------------------------------------------------");
		System.out.println(" STT HỌ TÊN                   MÃ CÔNG TƠ     CHU KỲ  CS ĐẦU CS CUỐI TỔNG TIỀN      ");
		System.out.println("------------------------------------------------------------------------------");

		int stt = 1;
		long tongTien = 0;
		for (BienLai x : dsBienLai) {
			if (x.getNamTinhChuKy() == nam) {
				System.out.printf("  %-3s%-25s%-15s%-8s%6s%8s%,10d\n", stt, x.getTenKhachHang(), x.getMaCongToDien(),
						x.getThangTinhChuKy() + "/" + x.getNamTinhChuKy(), x.getSoDienDauKy(), x.getSoDienCuoiKy(),
						x.tinhTienTieuThu());
				stt++;
				tongTien += x.tinhTienTieuThu();
			}
		}

		System.out.println("------------------------------------------------------------------------------");
		System.out.printf("                                                      TỔNG TIỀN:   %,10d\n", tongTien);
		System.out.println("------------------------------------------------------------------------------");

	}

	public static void inDanhSachKhachHang() {
		System.out.println("\nDANH SÁCH KHÁCH HÀNG");
		System.out.println("----------------------------------------------------------------------");
		System.out.println(" STT HỌ TÊN                   ĐỊA CHỈ                  MÃ CÔNG TƠ     ");
		System.out.println("----------------------------------------------------------------------");

		int stt = 1;
		for (KhachHang x : dsKhachHang) {
			System.out.printf("  %-3s%-25s%-25s%-15s\n", stt, x.getTenKhachHang(), x.getDcKhachHang(),
					x.getMaCongToDien());
			stt++;
		}
		System.out.println("----------------------------------------------------------------------");
	}

	public static void initDataKhachHang() {
		// Tạo danh sách khách hàng
		dsKhachHang.add(new KhachHang("FFSE1701001", "Nguyễn Vân Anh", "Hải Châu", "DLDN01001"));
		dsKhachHang.add(new KhachHang("FFSE1701002", "Trần Anh Hà", "Yên Bái", "DLDN02018"));
		dsKhachHang.add(new KhachHang("FFSE1701003", "Nguyễn Thị Ly", "Quang Trung", "DLDN01003"));
		dsKhachHang.add(new KhachHang("FFSE1701004", "Chu Hoàng Hải", "Bạch Đằng", "DLDN03001"));
		dsKhachHang.add(new KhachHang("FFSE1701005", "Lý Chính Thắng", "Nguyễn Chí Thanh", "DLDN03002"));

		System.out.println("\nĐã nhập xong dữ liệu khách hàng!!!");
	}

	public static void initDataBienLai() {
		// Tạo dự liệu biên lai
		int temp = 0;
		for (KhachHang x : dsKhachHang) {
			temp += 15;
			dsBienLai.add(new BienLai(x, 1, 2018, 100 + temp, 150 + temp * 2));
			dsBienLai.add(new BienLai(x, 2, 2018, 150 + temp * 2, 180 + temp * 3));
			dsBienLai.add(new BienLai(x, 3, 2018, 180 + temp * 3, 200 + temp * 3 + temp));
		}
		System.out.println("\nĐã nhập xong dữ liệu biên lai!!!");
	}

	public static void ketThuc() {
		System.out.println("\nChương trình kết thúc, cám ơn các bạn!!!");
		System.exit(0);
	}

}
