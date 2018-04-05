package ffse1702.quanlytiendien.main;

import java.util.Scanner;
import java.util.ArrayList;

import ffse1702.quanlytiendien.model.*;

public class TienDien {
	public static Scanner input = new Scanner(System.in);
	public static ArrayList<KhachHang> arrKhachHang = new ArrayList<KhachHang>();
	public static ArrayList<BienLai> arrBienLai = new ArrayList<BienLai>();
	public static int STT = 0, Size = 0;

	public static void main(String[] args) {
		myMenu();
	}

	public static void myMenu() {
		while (true) {

			System.out.println("        ___________________________________");
			System.out.println("         |-------CHỌN LỰA CHỨC NĂNG------|");
			System.out.println("         |=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=|");
			System.out.println("         |  1.Nhập Danh Sách Khách Hàng  |");
			System.out.println("         |  2.Nhập Danh Sách Tiền Điện   |");
			System.out.println("         |  3.In Biên Lai Khách Hàng     |");
			System.out.println("         |                               |");
			System.out.println("         |=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=|");
			System.out.println("         |--4.Kết thúc chương trình------|");
			System.out.println("         |_______________________________|");
			System.out.print("     Nhập chức năng mà bạn muốn thực hiện :");
			int act = input.nextInt();
			if (act == 1) {
				nhapThongtinkhachhang();
			} else if (act == 2) {
				nhapThongtintiendien();
			} else if (act == 3) {
				inBienlai();
			} else if (act == 4) {
				ketThuc();
			}
			input.nextLine();
			System.out.println("     =====================================");
			System.out.println("        -----Nhập ENTER để tiếp tục-----");
			input.nextLine();
		}
	}

	public static void nhapThongtinkhachhang() {
		System.out.println("     THÊM KHÁCH HÀNG VÀO DANH SÁCH  ");
		System.out.println(" ___________________________________");
		System.out.println("     Bạn nhập bao nhiêu Khách Hàng ?");
		Size = input.nextInt();
		for (int i = 0; i < Size; i++) {
			input.nextLine();
			System.out.println("Nhập Mã khách hàng thứ " + (i + 1) + " : ");
			String masoKhachhang = input.nextLine();
			System.out.println("Nhập Tên khách hàng thứ " + (i + 1) + " : ");
			String tenKhachhang = input.nextLine();
			System.out.println("Nhập Địa Chỉ khách hàng thứ " + (i + 1) + " : ");
			String diaChi = input.nextLine();
			System.out.println("Nhập Mã Công Tơ của khách hàng thứ " + (i + 1) + " : ");
			String maCongto = input.nextLine();
			arrKhachHang.add(new KhachHang(masoKhachhang, tenKhachhang, diaChi, maCongto));

		}

	}

	public static void nhapThongtintiendien() {
		System.out.print("Nhập chỉ số điện tiêu thụ của Tháng : ");
		int ngayThang = input.nextInt();

		System.out.print("Trong năm : ");
		int nam = input.nextInt();

		for (int i = 0; i < arrKhachHang.size(); i++) {

			input.nextLine();

			System.out.println("Tên Khách hàng : " + arrKhachHang.get(i).getTenKhachhang());
			System.out.println("Mã Khách hàng : " + arrKhachHang.get(i).getMasoKhachhang());
			System.out.println("Mã Công Tơ :" + arrKhachHang.get(i).getMaCongto());

			System.out.println("Nhập Chỉ Số Điện Đầu Kỳ :");
			int chisoCu = input.nextInt();

			System.out.println("Nhập Chỉ Số Điện Cuối Kỳ :");
			int chisoMoi = input.nextInt();

			arrBienLai.add(new BienLai(arrKhachHang.get(i).getMasoKhachhang(), 
									   arrKhachHang.get(i).getTenKhachhang(),
									   arrKhachHang.get(i).getDiaChi(),
									   arrKhachHang.get(i).getMaCongto(), 
									   chisoCu,
									   chisoMoi,
									   ngayThang,
									   nam));
	}
	}

	public static void inBienlai() {
		while (true) {

			System.out.println("        ___________________________________");
			System.out.println("         |--CHỌN CHỨC NĂNG IN BIÊN LAI---|");
			System.out.println("         |===============================|");
			System.out.println("         |  5.In biên lai theo chu kì    |");
			System.out.println("         |  6.In biên lai theo mã        |");
			System.out.println("         |  7.In theo năm                |");
			System.out.println("         |  8. Quay lại                  |");
			System.out.println("         |===============================|");
			System.out.print("     Nhập chức năng mà bạn muốn thực hiện :");
			int act = input.nextInt();
			if (act == 5) {
				inTheochuki();
			} else if (act == 6) {
				inTheoma();
			} else if (act == 7) {
				inTheonam();
			} else if (act == 8) {
				myMenu();
			}
			input.nextLine();
			System.out.println("     =====================================");
			System.out.println("        -----Nhập ENTER để tiếp tục-----");
			input.nextLine();
		}

	}

	public static void inTheochuki() {
		System.out.println("Nhập tháng cần in biên lai khách hàng : ");
		int ngayThang = input.nextInt();
		System.out.println("Nhập năm cần in biên lai khách hàng : ");
		int nam = input.nextInt();
		System.out.println("Danh sách tính tiền điện của khách hàng trong tháng : " + ngayThang + " năm :" + nam);
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------");
		System.out.println(
				"|STT  |MasoKH    |TênKH           |Địa chỉ     |MasoCT      |Thời gian   |Chỉ số Đầu Kỳ  |Chỉ số Cuối Kỳ  |Tiền điện ");
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------");
		int i = 0;
		for (int k = 0; k < arrBienLai.size(); k++) {
			if (ngayThang == arrBienLai.get(k).getngayThang() && nam == arrBienLai.get(k).getnam()) {

				System.out.printf("|%-5s|%-10s|%-16s|%-12s|%-12s|%-1s/%-11s|%-15s|%-16s|%,10d\n", (i + 1),
						arrBienLai.get(k).getMasoKhachhang(), 
						arrBienLai.get(k).getTenKhachhang(),
						arrBienLai.get(k).getDiaChi(), 
						arrBienLai.get(k).getMaCongto(),
						arrBienLai.get(k).getngayThang(),
						arrBienLai.get(k).getnam(),
						arrBienLai.get(k).getChisoCu(),
						arrBienLai.get(k).getChisoMoi(), 
						arrBienLai.get(k).getTienDien());
				i = i + 1;
			}
		}
	}

	public static void inTheoma() {
		input.nextLine();
		System.out.println("nhập mã khách hàng cần in biên lai : ");
		String masoKhachhang = input.nextLine();

		System.out.println("Nhập tháng cần in biên lai khách hàng : ");
		int ngayThang = input.nextInt();

		System.out.println("Nhập năm cần in biên lai khách hàng : ");
		int nam = input.nextInt();

		System.out.println("Biên lai của khách hàng có mã khách hàng là : " + masoKhachhang);
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------");
		System.out.println(
				"|STT  |MasoKH    |TênKH           |Địa chỉ     |MasoCT      |Thời gian   |Chỉ số Đầu Kỳ  |Chỉ số Cuối Kỳ  |Tiền điện     ");
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------");
		int i = 0;
		for (int k = 0; k < arrBienLai.size(); k++) {
			if (masoKhachhang.equals(arrBienLai.get(k).getMasoKhachhang())
					&& ngayThang == arrBienLai.get(k).getngayThang() && nam == arrBienLai.get(k).getnam()) {
				System.out.printf("|%-5s|%-10s|%-16s|%-12s|%-12s|%-1s/%-11s|%-15s|%-16s|%,10d\n", (i + 1),
						arrBienLai.get(k).getMasoKhachhang(),
						arrBienLai.get(k).getTenKhachhang(),
						arrBienLai.get(k).getDiaChi(), 
						arrBienLai.get(k).getMaCongto(),
						arrBienLai.get(k).getngayThang(), 
						arrBienLai.get(k).getnam(),
						arrBienLai.get(k).getChisoCu(),
						arrBienLai.get(k).getChisoMoi(),
						arrBienLai.get(k).getTienDien());
				i = i + 1;
			}

		}
	}

	public static void inTheonam() {

		System.out.print("Nhập năm cần in biên lai khách hàng : ");
		int nam = input.nextInt();

		System.out.println("Danh sách tính tiền điện của khách hàng trong năm : " + nam);
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------");
		System.out.println(
				"|STT  |MasoKH    |TênKH           |Địa chỉ     |MasoCT      |Thời gian   |Chỉ số Đầu Kỳ  |Chỉ số Cuối Kỳ  |Tiền điện     ");
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------");
		int n = 1;
		for (int k = 0; k < arrBienLai.size(); k++) {
			if (nam == arrBienLai.get(k).getnam()) {

				System.out.printf("|%-5s|%-10s|%-16s|%-12s|%-12s|%-1s/%-11s|%-15s|%-16s|%,10d\n", n,
						arrBienLai.get(k).getMasoKhachhang(),
						arrBienLai.get(k).getTenKhachhang(),
						arrBienLai.get(k).getDiaChi(),
						arrBienLai.get(k).getMaCongto(),
						arrBienLai.get(k).getngayThang(),
						arrBienLai.get(k).getnam(),
						arrBienLai.get(k).getChisoCu(),
						arrBienLai.get(k).getChisoMoi(),
						arrBienLai.get(k).getTienDien());
				n += 1;
			}

		}
	}

	public static void ketThuc() {
		System.out.println("Kết thúc chương trình");
		System.out.println("======================");
		System.out.println("=======Cảm ơn======");
		System.exit(0);
	}

}