package ffse1703022.main;

import ffse1703002.model.*;
import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyTienDien {
	public static Scanner scanner = new Scanner(System.in);
	public static int soLuong, stt = 0;
	public ArrayList<KhachHang> arrKhachHang = new ArrayList<KhachHang>();
	public ArrayList<BienLai> arrBienLai = new ArrayList<BienLai>();

	public static void main(String[] args) {
		QuanLyTienDien main = new QuanLyTienDien();
		main.myMenu();
	}

	public void nhapKH() {
		System.out.println("========  Thông tin các hộ sử dụng điện ======== ");

		System.out.println("Số lượng hộ gia đình");
		soLuong = scanner.nextInt();
		for (int i = 0; i < soLuong; i++) {
			KhachHang kh = new KhachHang();
			scanner.nextLine();
			System.out.println("Tên khách hàng" + " " + (i + 1));
			String tenKH = scanner.nextLine();
			System.out.println("Địa chỉ của khách hàng" + " " + (i + 1));
			String diaChi = scanner.nextLine();
			System.out.println("Mã khách hàng" + " " + (i + 1));
			String maKH = scanner.nextLine();

			System.out.println("Mã công tơ của khách hàng" + " " + (i + 1));
			String maCongTo = scanner.nextLine();

			arrKhachHang.add(new KhachHang(tenKH, maKH, diaChi, maCongTo));
		}

	}

	public void nhapChiSo() {
		while (true) {
			scanner.nextLine();
			System.out.println("Vui lòng nhập mã khách hàng: ");
			String maKH = scanner.nextLine();
			for (KhachHang x : arrKhachHang) {
				if (x.getMaKH().equals(maKH)) {
					System.out.println("Tên khách hàng            : " + x.getTenKH());
					System.out.println("Địa chỉ của khách hàng    : " + x.getDiaChi());
					System.out.println("Mã khách hàng             : " + x.getMaKH());
					System.out.println("Mã công tơ ủa khách hàng  : " + x.getMaCongTo());
					System.out.println("Tháng thu tiền");
					String thangChuKy = scanner.nextLine();
					System.out.println("Năm thu tiền");
					String namChuKy = scanner.nextLine();

					System.out.println("Chỉ số cũ");
					int chiSoCu = scanner.nextInt();
					System.out.println("Chỉ số mới");
					int chiSoMoi = scanner.nextInt();
					scanner.nextLine();

					arrBienLai.add(new BienLai(x.getTenKH(), x.getMaKH(), x.getDiaChi(), x.getMaCongTo(), chiSoCu,
							chiSoMoi, thangChuKy, namChuKy));
				}
			}
			System.out.println("Bạn có muốn nhập biên lai cho khách hàng khác? (Y/N)");
			String yn = scanner.nextLine();
			if (yn.equalsIgnoreCase("N")) {
				break;
			}
		}

	}

	public void inKH() {
		System.out.printf("| %-20s | %-20s | -%15s | %-15s | \n", "Tên", "Đia chỉ Khách Hàng", "Mã Khách Hàng",
				"Mã Công Tơ");
		for (KhachHang x : arrKhachHang) {
			System.out.printf("| %-20s | %-20s |-%15s | %-15s |\n", x.getTenKH(), x.getDiaChi(), x.getMaKH(),
					x.getMaCongTo());
		}

	}

	public void inBL() {
		subMenu();
	}

	public void inBLThang() {
		scanner.nextLine();
		System.out.println("Tháng thu tiền");
		String thangChuKy = scanner.nextLine();
		System.out.println("Năm thu tiền");
		String namChuKy = scanner.nextLine();
		System.out.println();
		System.out.printf("| %-20s | %-20s | %-15s | %-15s | %-15s | %-15s | %-15s | %-10s |%-10s |\n", "Tên",
				"Đia chỉ Khách Hàng", "Mã Khách Hàng", "Mã Công Tơ", "Chỉ Số Cũ", "Chỉ Số Mới", "Tháng", "Năm",
				"Tiền Điện");
		float sum=0;
		for (BienLai x : arrBienLai) {
			if (thangChuKy.equals(x.getThangChuKy()) && (namChuKy.equals(x.getNamChuKy()))) {
				System.out.println(x);
				sum+=x.tienDien();
			}
		}		System.out.printf("%70s: %s \n", "Tổng tiền", sum);

	}

	public void inBLNam() {
		scanner.nextLine();

		System.out.println("Năm thu tiền");
		String namChuKy = scanner.nextLine();
		System.out.println();
		System.out.printf("| %-20s | %-20s | %-15s | %-15s | %-15s | %-15s | %-15s | %-10s |%-10s |\n", "Tên",
				"Đia chỉ Khách Hàng", "Mã Khách Hàng", "Mã Công Tơ", "Chỉ Số Cũ", "Chỉ Số Mới", "Tháng", "Năm",
				"Tiền Điện");
		float sum = 0;
		for (BienLai x : arrBienLai) {
			if (namChuKy.equals(x.getNamChuKy())) {
				System.out.println(x);
				sum += x.tienDien();
			}
		}
		System.out.printf("%70s: %s \n", "Tổng tiền", sum);
	}

	public void inMotKH() {
		scanner.nextLine();
		System.out.println("Mã khách hàng");
		String maKH = scanner.nextLine();
		System.out.println("Năm thu tiền");
		String namChuKy = scanner.nextLine();
		System.out.println();
		System.out.printf("| %-20s | %-20s | %-15s | %-15s | %-15s | %-15s | %-15s | %-10s |%-10s |\n", "Tên",
				"Đia chỉ Khách Hàng", "Mã Khách Hàng", "Mã Công Tơ", "Chỉ Số Cũ", "Chỉ Số Mới", "Tháng", "Năm",
				"Tiền Điện");
		float sum = 0;
		for (BienLai x : arrBienLai) {
			if (namChuKy.equals(x.getNamChuKy())) {
				System.out.println(x);
				sum += x.tienDien();
			}
		}
		System.out.printf("%70s: %s \n", "Tổng tiền", sum);
	}

	public void inBLMa() {
		scanner.nextLine();
		System.out.println("Mã khách hàng");
		String maKH = scanner.nextLine();
		System.out.println("Tháng thu tiền");
		String thangChuKy = scanner.nextLine();
		System.out.println("Năm thu tiền");
		String namChuKy = scanner.nextLine();
		System.out.println();
		System.out.printf("| %-20s | %-20s | %-15s | %-15s | %-15s | %-15s | %-15s | %-10s |%-10s |\n", "Tên",
				"Đia chỉ Khách Hàng", "Mã Khách Hàng", "Mã Công Tơ", "Chỉ Số Cũ", "Chỉ Số Mới", "Tháng", "Năm",
				"Tiền Điện");
		float sum = 0;
		for (BienLai x : arrBienLai) {
			if (maKH.equalsIgnoreCase(x.getMaKH()) && thangChuKy.equals(x.getThangChuKy())
					&& (namChuKy.equals(x.getNamChuKy()))) {
				System.out.println(x);
				sum += x.tienDien();

			}
		}		System.out.printf("%70s: %s \n", "Tổng tiền", sum);

	}

	public void myMenu() {
		while (true) {
			System.out.println("---LUA CHON CHUC NANG---");
			System.out.println("_______________________________________" + "\n");
			System.out.println("1: Nhập thông tin các hộ sử dụng điện ");
			System.out.println("2: In Danh Sách Khách Hàng");
			System.out.println("3: Nhập Biên Lai");
			System.out.println("4: In Biên Lai ");

			System.out.println("_______________________________________" + "\n");
			int input = scanner.nextInt();
			if (input == 1) {
				nhapKH();

			} else if (input == 2) {
				inKH();
			} else if (input == 3) {
				nhapChiSo();
			} else if (input == 4) {
				inBL();
			}
		}

	}

	public void subMenu() {
		while (true) {
			System.out.println("---LUA CHON CHUC NANG---");
			System.out.println("_______________________________________" + "\n");
			System.out.println("1: In biên lai theo tháng ");
			System.out.println("2: In biên lai theo năm của tất cả ");
			System.out.println("3: In biên lai theo mã khách hàng");
			System.out.println("4: In biên lai 1 khách hàng trong năm");
			System.out.println("5: Trở về menu chính ");

			System.out.println("_______________________________________" + "\n");
			int input = scanner.nextInt();
			if (input == 1) {
				inBLThang();

			} else if (input == 2) {
				inBLNam();
			} else if (input == 3) {
				inBLMa();
			} else if (input == 5) {
				break;
			} else if (input == 4) {
				inMotKH();
			}
		}
		myMenu();
	}

}
