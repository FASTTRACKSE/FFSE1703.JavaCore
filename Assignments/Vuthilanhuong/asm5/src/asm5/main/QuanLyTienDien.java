package asm5.main;

import java.util.Scanner;
import java.util.ArrayList;
import asm5.model.*;

public class QuanLyTienDien {
	public static ArrayList<KhachHang> arrkh = new ArrayList<KhachHang>();
	public static ArrayList<BienLai> arrbl = new ArrayList<BienLai>();
	public static Scanner sc = new Scanner(System.in);
	public static Scanner sc1 = new Scanner(System.in);
	public static int stt = 0;
	public static 	int tongtien= 0;
	public static void main(String[] args) {

		menu();

	}

	public static void ThongTinKhach() {
		System.out.println("Bạn muốn nhập bao nhiêu khách  hàng");
		int a = sc.nextInt();

		for (int i = 0; i < a; i++) {
			sc.nextLine();
			System.out.println("Mã người sử dụng");
			String maK = sc.nextLine();
			System.out.println("Tên người sử dụng");
			String tenK = sc.nextLine();
			System.out.println("Địa chỉ người sử dụng");
			String diaChi = sc.nextLine();
			System.out.println("Mã công tơ của người sử dụng");
			String maCto = sc.nextLine();
			arrkh.add(new KhachHang(maK, tenK, diaChi, maCto));
		}

	}

	public static void TienThu() {
		System.out.println("BẢN BIÊN LAI");
		System.out.println("Nhập tháng: ");
		int thangCk = sc.nextInt();
		System.out.println("Nhập năm: ");
		int namCk = sc.nextInt();
		for (KhachHang x : arrkh) {
			System.out.println("Mã khách hàng:" + x.getMaK());
			System.out.println("Tên khách hàng:" + x.getTenK());
			System.out.println("Địa chỉ khách hàng:" + x.getTenK());
			System.out.println("Mã công tơ khách hàng:" + x.getTenK());
			System.out.print("Chỉ số mới: ");
			int soMoi = sc.nextInt();

			System.out.print("Chỉ số cũ: ");
			int soCu = sc.nextInt();

			arrbl.add(new BienLai(x.getMaK(), x.getTenK(), x.getDiaChi(), x.getMaCto(), soCu, soMoi, thangCk, namCk));

		}
	}

	public static void Intt() {
		System.out.printf("%-15s | %-20s | %-20s | %-20s |  \n", "Mã Khách", "Tên khách", "Địa chỉ", "Mã công tơ");
		for (BienLai x : arrbl) {
			System.out.printf("%-15s | %-20s | %-20s | %-20s | \n", x.getMaK(), x.getTenK(), x.getDiaChi(),
					x.getMaCto());
		}
	}

	public static void Inbl() {
		System.out.printf("%-15s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | \n", "Mã Khách", "Tên khách",
				"Địa chỉ", "Mã công tơ", "Số cũ", "Số mới", "Tính tiền");
		for (int i = 0; i < arrbl.size(); i++) {
			BienLai bl = new BienLai();
			bl = arrbl.get(i);

			System.out.printf("%-15s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | \n", bl.getMaK(), bl.getTenK(),
					bl.getDiaChi(), bl.getMaCto(), bl.getSoCu(), bl.getSoMoi(), bl.tinhTien());
		}
	}

	// MENU CHINH

	public static void menu() {
		while (true) {
			System.out.println("1.Nhập thông tin khách hàng");
			System.out.println("2.Nhập thông tin tiên tiêu thụ");
			System.out.println("3.In thông tin tiên thu điện ");
			System.out.println("4.In thông tin khách hàng");
			int a = sc.nextInt();
			if (a == 1) {
				ThongTinKhach();

			}
			if (a == 2) {
				TienThu();

			}
			if (a == 3) {
				menuinbienlai();
			}
			if (a == 4) {
				Intt();
			}

		}

	}

	// MENU IN BIEN LAI

	public static void menuinbienlai() {
		while (true) {
			System.out.println("0.Menu chính");
			System.out.println("1.In tất cả");
			System.out.println("2.In theo tháng");
			System.out.println("3.In thông tin theo năm");
			System.out.println("4.In thông tin theo mã");
			int a = sc.nextInt();
			if (a == 0) {
				menu();
			}
			if (a == 1) {
				inTatCa();
			}
			if (a == 2) {
				thongKeTheoThangNam();
			}
			if (a == 3) {
				thogKeTheoNam();
			}
			if (a == 4) {
				inTheoMa();
			}
		}
	}

	public static void thogKeTheoNam() {
	
		System.out.println("Biên lai theo năm");
		System.out.println("nhập năm");
		int nhapNam = sc.nextInt();

		System.out.printf("%-15s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s \n", "Mã Khách", "Tên khách",
				"Địa chỉ", "Mã công tơ", "Số cũ", "Số mới", "Năm", "Tính tiền");
		for (BienLai x : arrbl) {
			if (nhapNam == x.getNamCk()) {
				System.out.printf("%-15s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s  \n", x.getMaK(),
						x.getTenK(), x.getDiaChi(), x.getMaCto(), x.getSoCu(), x.getSoMoi(), x.getNamCk(),
						x.tinhTien());
				tongtien  += x.tinhTien();
			}
		}
		System.out.println("-----------------------------");
		System.out.println("Tổng tiền:"+tongtien);
	}

	public static void thongKeTheoThangNam() {
		System.out.println("Biên lai theo tháng năm");
		System.out.println("Nhập tháng");
		int nhapthang = sc.nextInt();
		System.out.println("Nhập năm");
		int nhapnam = sc.nextInt();
		System.out.printf("%-15s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s| %-20s \n", "Mã Khách",
				"Tên khách", "Địa chỉ", "Mã công tơ", "Số cũ", "Số mới", "Tháng", "Năm", "Tính tiền");
		for (BienLai x : arrbl) {
			if (nhapnam == x.getNamCk() && nhapthang == x.getThangCk()) {
				System.out.printf("%-15s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s| %-20s  \n",
						x.getMaK(), x.getTenK(), x.getDiaChi(), x.getMaCto(), x.getSoCu(), x.getSoMoi(), x.getThangCk(),
						x.getNamCk(), x.tinhTien());
				tongtien  += x.tinhTien();
			}
		}
		System.out.println("-----------------------------");
		System.out.println("Tổng tiền:"+tongtien);
	}

	public static void inTheoMa() {
		System.out.println("In theo mã");
		System.out.println("Nhập mã");
		String nhapMa = sc1.nextLine();
		System.out.printf("%-15s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s| %-20s \n", "Mã Khách",
				"Tên khách", "Địa chỉ", "Mã công tơ", "Số cũ", "Số mới", "Tháng", "Năm", "Tính tiền");
		for (BienLai x : arrbl) {
			if (nhapMa.equals(x.getMaK())) {
				System.out.printf("%-15s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s| %-20s \n", x.getMaK(),
						x.getTenK(), x.getDiaChi(), x.getMaCto(), x.getSoCu(), x.getSoMoi(), x.getThangCk(),
						x.getNamCk(), x.tinhTien());
				tongtien  += x.tinhTien();
			}
		}
		System.out.println("-----------------------------");
		System.out.println("Tổng tiền:"+tongtien);
	}

	public static void inTatCa() {
		System.out.println("In tất cả");
		System.out.printf("%-15s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s \n", "Mã Khách",
				"Tên khách", "Địa chỉ", "Mã công tơ", "Số cũ", "Số mới", "Tháng", "Năm", "Tính tiền");
		for (BienLai x : arrbl) {
			System.out.printf("%-15s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s| %-20s  \n", x.getMaK(),
					x.getTenK(), x.getDiaChi(), x.getMaCto(), x.getSoCu(), x.getSoMoi(), x.getThangCk(), x.getNamCk(),
					x.tinhTien());
			tongtien  += x.tinhTien();
		}
		System.out.println("-----------------------------");
		System.out.println("Tổng tiền:"+tongtien);
	}
	
}
