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
			int chiSoCu = Scanner.nextInt();

	
			System.out.println("Nhập Chỉ Số Điện Mới :");
			int chiSoMoi = Scanner.nextInt();
			
			System.out.println("Nhập  tháng  :");
			int Thang = Scanner.nextInt();

			System.out.println("Nhập  năm  :");
			int Nam = Scanner.nextInt();

			Scanner.nextLine();

			arrBienLai.add(new BienLai(arrKhachHang.get(i).getMsKhachHang(), arrKhachHang.get(i).getTenKhachHang(),
					arrKhachHang.get(i).getDiaChi(), arrKhachHang.get(i).getMsCongTo(), chiSoMoi, chiSoCu, Thang,
					Nam));
		}
		Scanner.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		Scanner.nextLine();
	}

	public static void inbienlai() {

		while (true) {
			System.out.println(">>         MENU QUẢN LÝ TIỀN ĐIỆN       <<");
			System.out.println("+----------------------------------------+");
			System.out.println("|1. In biên lai theo tháng               |");
			System.out.println("|2. In biên lai theo năm                 |");
			System.out.println("|3. In biên lai theo mã số khách hàng     |");
			System.out.println("|4. Kết thúc chương trình                |");
			System.out.println("+----------------------------------------+");
			System.out.println(">>            Lựa chọn của bạn?         <<");
			int myOption = Scanner.nextInt();
			if (myOption == 1) {
				inTheoThang();
			} else if (myOption == 2) {
				inTheoNam();
			} else if (myOption == 3) {
				inTheoMaSo();
			} else if (myOption == 4) {
				ketThuc();
			}

		}
	}

	public static void inTheoThang() {

		Scanner.nextLine();
		System.out.println("nhập mã khách hàng cần in biên lai : ");
		String MsKhachHang = Scanner.nextLine();

		System.out.println("Nhập tháng cần in biên lai khách hàng : ");
		int thang = Scanner.nextInt();

		System.out.println("Nhập năm cần in biên lai khách hàng : ");
		int nam = Scanner.nextInt();

		System.out.println("Biên lai của khách hàng có mã khách hàng là : " + MsKhachHang);
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------");
		System.out.println(
				"|STT  |MasoKH    |TênKH           |Địa chỉ     |MasoCT      |Thời gian   |Chỉ số Đầu Kỳ  |Chỉ số Cuối Kỳ  |Tiền điện     ");
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------");
		int i = 0;
		for (int k = 0; k < arrBienLai.size(); k++) {
			if (MsKhachHang.equals(arrBienLai.get(k).getMsKhachHang()) && thang == arrBienLai.get(k).getThang()
					&& nam == arrBienLai.get(k).getNam()) {
				System.out.printf("|%-5s|%-10s|%-16s|%-12s|%-12s|%-1s/%-11s|%-15s|%-16s|%,10d\n", 
						(i + 1),
						arrBienLai.get(k).getMsKhachHang(), 
						arrBienLai.get(k).getTenKhachHang(),
						arrBienLai.get(k).getDiaChi(), 
						arrBienLai.get(k).getMsCongTo(), 
						arrBienLai.get(k).getThang(),
						arrBienLai.get(k).getNam(), 
						arrBienLai.get(k).getchiSoMoi(),
						arrBienLai.get(k).getchiSoCu(),
						arrBienLai.get(k).gettienDien());
				i = i + 1;
			}

		}

		Scanner.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		Scanner.nextLine();
	}

	public static void inTheoNam() {

		System.out.print("Nhập năm cần in biên lai khách hàng : ");
		int nam = Scanner.nextInt();

		System.out.println("Danh sách tính tiền điện của khách hàng trong năm : " + nam);
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------");
		System.out.println(
				"|STT  |MasoKH    |TênKH           |Địa chỉ     |MasoCT      |Thời gian   |Chỉ số Đầu Kỳ  |Chỉ số Cuối Kỳ  |Tiền điện     ");
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------");
		int n = 1;
		for (int k = 0; k < arrBienLai.size(); k++) {
			if (nam == arrBienLai.get(k).getNam()) {

				System.out.printf("|%-5s|%-10s|%-16s|%-12s|%-12s|%-1s/%-11s|%-15s|%-16s|%,10d\n",
						n,
						arrBienLai.get(k).getMsKhachHang(), 
						arrBienLai.get(k).getTenKhachHang(),
						arrBienLai.get(k).getDiaChi(), 
						arrBienLai.get(k).getMsCongTo(), 
						arrBienLai.get(k).getThang(),
						arrBienLai.get(k).getNam(), 
						arrBienLai.get(k).getchiSoMoi(),
						arrBienLai.get(k).getchiSoCu(),
						arrBienLai.get(k).gettienDien());
				n += 1;
			}
		}
		Scanner.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		Scanner.nextLine();

	}

	public static void inTheoMaSo() {
		Scanner.nextLine();
		System.out.println("nhập mã khách hàng cần in biên lai : ");
		String maKH = Scanner.nextLine();

		System.out.println("Nhập tháng cần in biên lai khách hàng : ");
		int thang = Scanner.nextInt();

		System.out.println("Nhập năm cần in biên lai khách hàng : ");
		int nam = Scanner.nextInt();

		System.out.println("Biên lai của khách hàng có mã khách hàng là : " + maKH);
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------");
		System.out.println(
				"|STT  |MasoKH    |TênKH           |Địa chỉ     |MasoCT      |Thời gian   |Chỉ số Đầu Kỳ  |Chỉ số Cuối Kỳ  |Tiền điện     ");
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------");
		int i = 0;
		for (int k = 0; k < arrBienLai.size(); k++) {
			if (maKH.equals(arrBienLai.get(k).getMsKhachHang()) && thang == arrBienLai.get(k).getThang()
					&& nam == arrBienLai.get(k).getNam()) {
				System.out.printf("|%-5s|%-10s|%-16s|%-12s|%-12s|%-1s/%-11s|%-15s|%-16s|%,10d\n", 
						(i + 1),
						arrBienLai.get(k).getMsKhachHang(), 
						arrBienLai.get(k).getTenKhachHang(),
						arrBienLai.get(k).getDiaChi(), 
						arrBienLai.get(k).getMsCongTo(), 
						arrBienLai.get(k).getThang(),
						arrBienLai.get(k).getNam(), 
						arrBienLai.get(k).getchiSoMoi(),
						arrBienLai.get(k).getchiSoCu(),
						arrBienLai.get(k).gettienDien());
				i = i + 1;
			}

		}
		Scanner.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		Scanner.nextLine();

	}

	public static void inThongTinKH() {

		System.out.println("Danh sách tính tiền điện của khách hàng ");
		System.out.println("----------------------------------------------");
		System.out.println("STT  MasoKH    TênKH           Địa chỉ         MasoCT   ");
		System.out.println("-----------------------------------------------------");
		for (int i = 0; i < arrKhachHang.size(); i++) {

			System.out.printf("%-5s%-10s%-16s%-12s%-14s\n", (i + 1),
					arrKhachHang.get(i).getMsKhachHang(),
					arrKhachHang.get(i).getTenKhachHang(),
					arrKhachHang.get(i).getDiaChi(),
					arrKhachHang.get(i).getMsCongTo()

			);
		}
		Scanner.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		Scanner.nextLine();
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
