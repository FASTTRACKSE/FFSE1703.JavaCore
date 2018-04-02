package FFSE1702.main;

import java.util.Scanner;

import java.util.ArrayList;

import FFSE1702.model.*;

public class TienDien {

	public static Scanner Scanner = new Scanner(System.in);
	public static int n = 0, thang, nam;
	public static ArrayList<Bienlai> arrBienlai = new ArrayList<Bienlai>();
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
			String masoKH = Scanner.nextLine();

			System.out.println("Nhập Tên khách hàng thứ " + (i + 1) + " : ");
			String tenKH = Scanner.nextLine();

			System.out.println("Nhập Địa Chỉ khách hàng thứ " + (i + 1) + " : ");
			String Address = Scanner.nextLine();

			System.out.println("Nhập Mã Công Tơ của khách hàng thứ " + (i + 1) + " : ");
			String masoCT = Scanner.nextLine();

			arrKhachHang.add(new KhachHang(masoKH, tenKH, Address, masoCT));

		}

		Scanner.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		Scanner.nextLine();
	}

	public static void nhapthongtinTT() {

		System.out.print("Nhập chỉ số điện tiêu thụ của Tháng : ");
		thang = Scanner.nextInt();

		System.out.print("trong năm : ");
		nam = Scanner.nextInt();

		for (int i = 0; i < arrKhachHang.size(); i++) {

			Scanner.nextLine();

			System.out.println("Tên Khách hàng : " + arrKhachHang.get(i).getTenKH());
			System.out.println("Mã Khách hàng : " + arrKhachHang.get(i).getMasoKH());
			System.out.println("Mã Công Tơ :" + arrKhachHang.get(i).getMasoCT());

			System.out.println("Nhập Chỉ Số Điện Đầu Kỳ :");
			int chisotruoc = Scanner.nextInt();

			System.out.println("Nhập Chỉ Số Điện Cuối Kỳ :");
			int chisosau = Scanner.nextInt();

			arrBienlai.add(new Bienlai(arrKhachHang.get(i).getMasoKH(), arrKhachHang.get(i).getTenKH(),
					arrKhachHang.get(i).getAddress(), arrKhachHang.get(i).getMasoCT(), chisotruoc, chisosau, thang,
					nam));
		}

		Scanner.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		Scanner.nextLine();
	}

	public static void inbienlaitheonam() {

		System.out.print("Nhập năm cần in biên lai khách hàng : ");
		nam = Scanner.nextInt();

		System.out.println("Danh sách tính tiền điện của khách hàng trong năm : " + nam);
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------");
		System.out.println(
				"|STT  |MasoKH    |TênKH           |Địa chỉ     |MasoCT      |Thời gian   |Chỉ số Đầu Kỳ  |Chỉ số Cuối Kỳ  |Tiền điện     ");
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------");
		int n = 1;
		for (int k = 0; k < arrBienlai.size(); k++) {
			if (nam == arrBienlai.get(k).getNam()) {

				System.out.printf("|%-5s|%-10s|%-16s|%-12s|%-12s|%-1s/%-11s|%-15s|%-16s|%,10d\n",
						n,
						arrKhachHang.get(k).getMasoKH(),
						arrKhachHang.get(k).getTenKH(),
						arrKhachHang.get(k).getAddress(),
						arrKhachHang.get(k).getMasoCT(),
						arrBienlai.get(k).getThang(),
						arrBienlai.get(k).getNam(),
						arrBienlai.get(k).getChisoDauKy(),
						arrBienlai.get(k).getChisoCuoiKy(), 
						arrBienlai.get(k).tienDien());
				n += 1;
			}
		}

		Scanner.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		Scanner.nextLine();
	}

	public static void inbienlaitheothang() {

		System.out.println("Nhập tháng cần in biên lai khách hàng : ");
		thang = Scanner.nextInt();
		System.out.println("Nhập năm cần in biên lai khách hàng : ");
		nam = Scanner.nextInt();
		System.out.println("Danh sách tính tiền điện của khách hàng trong tháng : " + thang + " năm :" + nam);
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------");
		System.out.println(
				"|STT  |MasoKH    |TênKH           |Địa chỉ     |MasoCT      |Thời gian   |Chỉ số Đầu Kỳ  |Chỉ số Cuối Kỳ  |Tiền điện     ");
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------");
		int i = 0;
		for (int k = 0; k < arrBienlai.size(); k++) {
			if (thang == arrBienlai.get(k).getThang() && nam == arrBienlai.get(k).getNam()) {

				System.out.printf("|%-5s|%-10s|%-16s|%-12s|%-12s|%-1s/%-11s|%-15s|%-16s|%,10d\n",
						(i + 1),
						arrKhachHang.get(k).getMasoKH(),
						arrKhachHang.get(k).getTenKH(),
						arrKhachHang.get(k).getAddress(),
						arrKhachHang.get(k).getMasoCT(),
						arrBienlai.get(k).getThang(),
						arrBienlai.get(k).getNam(),
						arrBienlai.get(k).getChisoDauKy(),
						arrBienlai.get(k).getChisoCuoiKy(),
						arrBienlai.get(k).tienDien());
				i = i + 1;
			}
		}

	}

	public static void inbienlaitheomaKH() {
		Scanner.nextLine();
		System.out.println("nhập mã khách hàng cần in biên lai : ");
		String maKH = Scanner.nextLine();

		System.out.println("Nhập tháng cần in biên lai khách hàng : ");
		thang = Scanner.nextInt();

		System.out.println("Nhập năm cần in biên lai khách hàng : ");
		nam = Scanner.nextInt();

		System.out.println("Biên lai của khách hàng có mã khách hàng là : " + maKH);
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------");
		System.out.println(
				"|STT  |MasoKH    |TênKH           |Địa chỉ     |MasoCT      |Thời gian   |Chỉ số Đầu Kỳ  |Chỉ số Cuối Kỳ  |Tiền điện     ");
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------");
		int i = 0;
		for (int k = 0; k < arrBienlai.size(); k++) {
			if (maKH.equals(arrBienlai.get(k).getMasoKH()) && thang == arrBienlai.get(k).getThang()
					&& nam == arrBienlai.get(k).getNam()) {
				System.out.printf("|%-5s|%-10s|%-16s|%-12s|%-12s|%-1s/%-11s|%-15s|%-16s|%,10d\n", 
						(i + 1),
						arrKhachHang.get(k).getMasoKH(), 
						arrKhachHang.get(k).getTenKH(),
						arrKhachHang.get(k).getAddress(), 
						arrKhachHang.get(k).getMasoCT(), 
						arrBienlai.get(k).getThang(),
						arrBienlai.get(k).getNam(), 
						arrBienlai.get(k).getChisoDauKy(),
						arrBienlai.get(k).getChisoCuoiKy(),
						arrBienlai.get(k).tienDien());
				i = i + 1;
			}

		}

	}

	public static void inkhachhang() {

		System.out.println("Danh sách tính tiền điện của khách hàng ");
		System.out.println("------------------------------------------------------");
		System.out.println("STT  MasoKH    TênKH           Địa chỉ     MasoCT  ");
		System.out.println("------------------------------------------------------");
		for (int i = 0; i < arrKhachHang.size(); i++) {

			System.out.printf("%-5s%-10s%-16s%-12s%-12s\n",
					(i + 1),
					arrKhachHang.get(i).getMasoKH(),
					arrKhachHang.get(i).getTenKH(),
					arrKhachHang.get(i).getAddress(),
					arrKhachHang.get(i).getMasoCT());
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
			System.out.println("|4. In danh sách khách hàng              |");
			System.out.println("|5. Kết thúc chương trình                |");
			System.out.println("+----------------------------------------+");
			System.out.println(">>            Lựa chọn của bạn?         <<");
			int myOption = Scanner.nextInt();
			if (myOption == 1) {
				nhapthongtinKH();
			} else if (myOption == 2) {
				nhapthongtinTT();
			} else if (myOption == 3) {
				inbienlai();
			} else if (myOption == 4) {
				inkhachhang();
			} else if (myOption == 5) {
				ketThuc();
			}

		}
	}

	public static void inbienlai() {
		while (true) {
			System.out.println(">>         IN BIÊN LAI TIỀN ĐIỆN        <<");
			System.out.println("+----------------------------------------+");
			System.out.println("|1. In biên lai theo mã khách hàng       |");
			System.out.println("|2. Thống kê tiền điện trong tháng       |");
			System.out.println("|3. Thống kê tiền điện tiêu thụ trong năm|");
			System.out.println("|4. Quay lại menu chính                  |");
			System.out.println("+----------------------------------------+");
			System.out.println(">>            Lựa chọn của bạn?         <<");
			int myOption = Scanner.nextInt();
			if (myOption == 1) {
				inbienlaitheomaKH();
			} else if (myOption == 2) {
				inbienlaitheothang();
			} else if (myOption == 3) {
				inbienlaitheonam();
			} else if (myOption == 4) {
				showCTrinh();
			}

		}
	}

}
