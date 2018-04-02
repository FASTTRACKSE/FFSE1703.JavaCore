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
			System.out.println("         |=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=|");
			System.out.println("         |--5.Kết thúc chương trình------|");
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
		System.out.println("NHẬP CHỈ SỐ TIỀN ĐIỆN CỦA KHÁCH HÀNG");
		System.out.println("====================================");
		for (; STT < arrKhachHang.size(); STT++) {
			System.out.println("Tên Khách hàng : " + arrKhachHang.get(STT).getTenKhachhang());
			System.out.println("Địa chỉ : " + arrKhachHang.get(STT).getDiaChi());
			System.out.println("Mã Khách hàng : " + arrKhachHang.get(STT).getMasoKhachhang());
			System.out.println("Mã Công Tơ :" + arrKhachHang.get(STT).getMaCongto());
			System.out.println("Nhập Chỉ Số Điện Cũ :");
			int chiSoCu = input.nextInt();
			System.out.println("Nhập Chỉ Số Điện Mới :");
			int chiSoMoi = input.nextInt();
			input.nextLine();
			arrBienLai
					.add(new BienLai(arrKhachHang.get(STT).getMasoKhachhang(), arrKhachHang.get(STT).getTenKhachhang(),
							arrKhachHang.get(STT).getDiaChi(), arrKhachHang.get(STT).getMaCongto(), chiSoCu, chiSoMoi));
		}
	}

	public static void inBienlai() {
		System.out.println("                           DANH SÁCH TẤT CẢ KHÁCH HÀNG                                ");
		System.out.println("________________________________________________________________________________________");
		System.out.println(" STT | Mã    | Tên      |    Địa Chỉ   |   Mã Công Tơ |  Chỉ số cũ  |Chỉ số mới | Tiền");
		int STT = 1;
		for (int i = 0; i < arrBienLai.size(); i++) {

			System.out.printf("%-5s%-10s%-16s%-12s%-12s%-14s%-12s%-14s\n", (i + 1),
					arrKhachHang.get(i).getMasoKhachhang(), arrKhachHang.get(i).getTenKhachhang(),
					arrKhachHang.get(i).getDiaChi(), arrKhachHang.get(i).getMaCongto(), arrBienLai.get(i).getChisoCu(),
					arrBienLai.get(i).getChisoMoi(), arrBienLai.get(i).getTienDien());
		}

	}

	public static void ketThuc() {
		System.out.println("Kết thúc chương trình");
		System.out.println("======================");
		System.out.println("=======Cảm ơn======");
		System.exit(0);
	}

}