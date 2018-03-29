package ffse1703022.main;

import ffse1703002.model.*;
import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyTienDien {
	public static Scanner scanner = new Scanner(System.in);
	public static int soLuong, stt = 0;
	public static ArrayList<KhachHang> arrKhachHang = new ArrayList<KhachHang>();
	public static ArrayList<BienLai> arrBienLai = new ArrayList<BienLai>();

	public static void main(String[] args) {

		myMenu();
	}

	public static void nhapKH() {
		System.out.println("========  Thông tin các hộ sử dụng điện ======== ");

		System.out.println("Số lượng hộ gia đình");
		soLuong = scanner.nextInt();
		for (int i = 0; i < soLuong; i++) {
			KhachHang kh = new KhachHang();
			scanner.nextLine();
			System.out.println("Tên khách hàng" + " " + (i + 1));
			kh.setTenKH(scanner.nextLine());
			System.out.println("Địa chỉ của khách hàng" + " " + (i + 1));
			kh.setDiaChi(scanner.nextLine());
			System.out.println("Mã khách hàng" + " " + (i + 1));
			kh.setMaKH(scanner.nextLine());

			System.out.println("Mã công tơ của khách hàng" + " " + (i + 1));
			kh.setMaCongTo(scanner.nextLine());

			arrKhachHang.add(kh);
		}

	}

	public static void nhapChiSo() {
		for (; stt < arrKhachHang.size(); stt++) {
			System.out.println("Tên khách hàng" + " " + (stt + 1) + ":" + arrKhachHang.get(stt).getTenKH());
			System.out.println("Địa chỉ của khách hàng" + " " + (stt + 1) + ":" + arrKhachHang.get(stt).getDiaChi());
			System.out.println("Mã khách hàng" + " " + (stt + 1) + ":" + arrKhachHang.get(stt).getMaKH());
			System.out
					.println("Mã công tơ ủa khách hàng" + " " + (stt + 1) + ":" + arrKhachHang.get(stt).getMaCongTo());

			BienLai bl = new BienLai();

			System.out.println("Chỉ số cũ");
			bl.setChiSoCu(scanner.nextInt());
			System.out.println("Chỉ số mới");
			bl.setChiSoMoi(scanner.nextInt());
			scanner.nextLine();
			System.out.println("Tháng thu tiền");
			bl.setDate(scanner.nextLine());

			arrBienLai.add(bl);

		}
	}

	public static void in() {
		System.out.printf("| %-20s | %-20s | %15s | %-15s | %-15s | %-15s | %-15s | %-10s |\n", "Tên",
				"Đia chỉ Khách Hàng", "Mã Khách Hàng", "Mã Công Tơ", "Chỉ Số Cũ", "Chỉ Số Mới", "Tháng", "Tiền Điện");
		for (int i = 0; i < arrKhachHang.size(); i++) {
			System.out.printf("| %-20s | %-20s | %15s | %-15s | %-15s | %-15s | %-15s | %-10s |\n",
					arrKhachHang.get(i).getTenKH(), arrKhachHang.get(i).getDiaChi(), arrKhachHang.get(i).getMaKH(),
					arrKhachHang.get(i).getMaCongTo(), arrBienLai.get(i).getChiSoCu(), arrBienLai.get(i).getChiSoMoi(),
					arrBienLai.get(i).Date, arrBienLai.get(i).tienDien());
			scanner.nextLine();
		}
		
	}

	public static void myMenu() {
		while (true) {
			System.out.println("---LUA CHON CHUC NANG---");
			System.out.println("_______________________________________" + "\n");
			System.out.println("1: Nhập thông tin các hộ sử dụng điện ");
			System.out.println("2: Nhập thông tin các chỉ số điện");
			System.out.println("3: In danh sach thu tiền ");
			System.out.println("_______________________________________" + "\n");
			int input = scanner.nextInt();
			if (input == 1) {
				nhapKH();
			} else if (input == 2) {
				nhapChiSo();
			} else if (input == 3) {
				in();
			}
		}

	}
}
