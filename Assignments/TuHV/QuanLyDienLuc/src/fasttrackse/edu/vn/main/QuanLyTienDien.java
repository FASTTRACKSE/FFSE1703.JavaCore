package fasttrackse.edu.vn.main;

import fasttrackse.edu.vn.model.*;

import java.util.Scanner;
import java.util.ArrayList;

public class QuanLyTienDien {

	public static Scanner Scanner = new Scanner(System.in);
	public static int n = 0;
	public static ArrayList<BienLai> arrBienLai = new ArrayList<BienLai>();
	public static ArrayList<KhachHang> arrKhachHang = new ArrayList<KhachHang>();

	public static void main(String[] args) {
		showCTrinh();
	}

	public static void nhapthongtinKH() {

		System.out.println("Nhập danh sách khách hàng : ");
		System.out.println("---------------------------");
		System.out.print("Số lượng khách hàng :");
		n = Scanner.nextInt();

		for (int i = 0; i < n; i++) {

			Scanner.nextLine();

			System.out.println("Nhập Mã khách hàng thứ " + (i + 1) + " : ");
			String MsKhachHang = Scanner.nextLine();

			System.out.println("Nhập Tên khách hàng thứ " + (i + 1) + " : ");
			String TenKhachHang = Scanner.nextLine();

			System.out.println("Nhập Địa Chỉ khách hàng thứ " + (i + 1) + " : ");
			String DiaChi = Scanner.nextLine();

			System.out.println("Nhập Mã Công Tơ của khách hàng thứ " + (i + 1) + " : ");
			int MsCongTo = Scanner.nextInt();

			arrKhachHang.add(new KhachHang(MsKhachHang, TenKhachHang, DiaChi, MsCongTo));

		}
		for (KhachHang x : arrKhachHang) {
			System.out.println(x.TenKhachHang);

		}
	}

	public static void nhapthongtinTT() {

		System.out.println("Nhập chỉ số điện tiêu thụ :");

		for (int i = 0; i < n; i++) {

			Scanner.nextLine();
			System.out.println("Tên Khách hàng : " + arrKhachHang.get(i).getTenKhachHang());
			System.out.println("Mã Khách hàng : " + arrKhachHang.get(i).getMsKhachHang());
			System.out.println("Mã Công Tơ :" + arrKhachHang.get(i).getMsCongTo());

			System.out.println("Nhập Chỉ Số Điện Cũ :");
			int chisotruoc = Scanner.nextInt();

			System.out.println("Nhập Chỉ Số Điện Mới :");
			int chisosau = Scanner.nextInt();

			Scanner.nextLine();

			arrBienLai.add(new BienLai(arrKhachHang.get(i).getMsKhachHang(), arrKhachHang.get(i).getTenKhachHang(),
					arrKhachHang.get(i).getDiaChi(), arrKhachHang.get(i).getMsCongTo(), chisotruoc, chisosau));
		}
	}

	public static void inbienlai() {

		System.out.println("Danh sách tính tiền điện của khách hàng ");
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------");
		System.out.println(
				"STT  MasoKH    TênKH           Địa chỉ         MasoCT  Chỉ số trước  Chỉ số sau  Tiền điện     ");
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------");
		for (int i = 0; i < n; i++) {

			System.out.printf("%-5s%-10s%-16s%-12s%-12s%-18s%-12s%-14s\n", (i + 1), arrBienLai.get(i).getMsKhachHang(),
					arrBienLai.get(i).getTenKhachHang(), arrBienLai.get(i).getDiaChi(), arrBienLai.get(i).getMsCongTo(),
					arrBienLai.get(i).getchiSoCu(), arrBienLai.get(i).getchiSoMoi(), arrBienLai.get(i).gettienDien());
		}
	}

	public static void inThongTinKH() {

		System.out.println("Danh sách tính tiền điện của khách hàng ");
		System.out.println("----------------------------------------------");
		System.out.println("STT  MasoKH    TênKH           Địa chỉ         MasoCT   ");
		System.out.println("-----------------------------------------------------");
		for (int i = 0; i < arrKhachHang.size(); i++) {

			System.out.printf("%-5s%-10s%-16s%-12s%-14s\n", (i + 1), arrKhachHang.get(i).getMsKhachHang(),
					arrKhachHang.get(i).getTenKhachHang(), arrKhachHang.get(i).getDiaChi(), arrKhachHang.get(i).getMsCongTo()

			);
		}
	}

	public static void ketThuc() {
		System.out.println("Kết thúc chương trình!!!!!");
		System.exit(0);
	}

	public static void showCTrinh() {
		while (true) {
			System.out.println(">>         MENU QUẢN LÝ TIỀN ĐIỆN       <<");
			System.out.println("+----------------------------------------+");
			System.out.println("|1. Nhập thông tin khách hàng            |");
			System.out.println("|2. Nhập thông tin chỉ số tiêu thụ       |");
			System.out.println("|3. In biên lai tiền điện của các hộ     |");
			System.out.println("|5. In thông tin khách hàng              |");
			System.out.println("|4. Kết thúc chương trình                |");
			System.out.println("+----------------------------------------+");
			System.out.println(">>            Lựa chọn của bạn?         <<");
			int myOption = Scanner.nextInt();
			if (myOption == 1) {
				nhapthongtinKH();
			} else if (myOption == 2) {
				nhapthongtinTT();
			} else if (myOption == 3) {
				inbienlai();
			} else if (myOption == 5) {
				inThongTinKH();
			} else if (myOption == 4) {
				ketThuc();
			}

		}
	}

}
