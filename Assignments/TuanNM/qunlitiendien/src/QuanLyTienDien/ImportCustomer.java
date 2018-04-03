package QuanLyTienDien;

import java.util.Scanner;

import java.util.ArrayList;

public class ImportCustomer {
	public static Scanner myScanner = new Scanner(System.in);
	public static int size;
	static ArrayList<KhachHang> arrayKhachHang = new ArrayList<KhachHang>();
	static ArrayList<BienLai> arrayBienLai = new ArrayList<BienLai>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myMenu();

	}

	public static void themKH() {
		System.out.print("Nhap số lượng khách hàng: ");
		size = myScanner.nextInt();
		String maSoKH;
		String tenKH, diaChi;
		String maCT;
		for (int i = 0; i < size; i++) {

			myScanner.nextLine();
			System.out.println("Nhập mã số khách hàng " + (i + 1) + " :");
			maSoKH = myScanner.nextLine();
			System.out.println("Nhập tên khách hàng " + (i + 1) + " :");
			tenKH = myScanner.nextLine();
			System.out.println("Nhập địa chỉ khach hàng " + (i + 1) + " :");
			diaChi = myScanner.nextLine();
			System.out.println("Nhập mã công tơ khách hàng" + (i + 1) + " :");
			maCT = myScanner.nextLine();
			arrayKhachHang.add(new KhachHang(maSoKH, tenKH, diaChi, maCT));
		}
	}

	public static void themBL() {

		Double chiSoMoi, chiSoCu;
		int thang, nam;
		System.out.println("Nhập biên lai tháng :");
		thang = myScanner.nextInt();
		System.out.println("Nhập biên lai năm :");
		nam = myScanner.nextInt();
		for (int i = 0; i < arrayKhachHang.size(); i++) {
			System.out.println("biên lai tháng : " + thang + " năm " + nam + " :");
			myScanner.nextLine();
			System.out.println("Nhập chỉ số mới của khách hàng " + arrayKhachHang.get(i).getTenKH() + " :");
			chiSoMoi = myScanner.nextDouble();
			System.out.println("Nhập chỉ số cũ của khách hàng" + arrayKhachHang.get(i).getTenKH() + " :");
			chiSoCu = myScanner.nextDouble();

			arrayBienLai.add(new BienLai(arrayKhachHang.get(i).getMaKH(), arrayKhachHang.get(i).getTenKH(),
					arrayKhachHang.get(i).getDiaChi(), arrayKhachHang.get(i).getMaCT(), chiSoCu, chiSoMoi, thang, nam));
		}
	}

	public static void bienLai() {
		Double total = 0.0;
		System.out.println(
				"+---------------------------------Danh sách biên lai Khách hàng------------------------------ --------+");
		System.out.println(
				"|  mã số  |   tên KH     |     Địa chỉ  | Mã Ct   | Chỉ số mới |Chỉ Số Cũ | tiền Diện  | tháng | năm  |");
		for (BienLai x : arrayBienLai) {
			System.out.printf("%-10s %-15s %-15s %-10s %-10s %-10s %-11s %-7s %-7s \n", x.getMaKH(), x.getTenKH(),
					x.getDiaChi(), x.getMaCT(), x.getChiSoMoi(), x.getChiSoCu(), x.getTienDien(), x.getThang(),
					x.getNam());
			total += x.getTienDien();
		}
		System.out.printf("Tổng tiền điện" + ":%98s \n", total + " VNđ");
	}

	public static void inBienLaiThang() {
		int thang, nam;
		Double total = 0.0;
		System.out.println("Biên lai tháng :");
		thang = myScanner.nextInt();
		System.out.println("Biên lai năm :");
		nam = myScanner.nextInt();

		System.out.println(
				"+---------------------------------Danh sách biên lai Khách hàng------------------------------ --------+");
		System.out.println(
				"|  mã số  |   tên KH     |     Địa chỉ  | Mã Ct   | Chỉ số mới |Chỉ Số Cũ | tiền Diện  | tháng | năm  |");
		for (BienLai x : arrayBienLai) {
			if (thang == x.getThang() && nam == x.getNam()) {
				System.out.printf("%-10s %-15s %-15s %-10s %-10s %-10s %-11s %-7s %-7s \n", x.getMaKH(), x.getTenKH(),
						x.getDiaChi(), x.getMaCT(), x.getChiSoMoi(), x.getChiSoCu(), x.getTienDien(), x.getThang(),
						x.getNam());
				total += x.getTienDien();
			}
		}
		System.out.printf("Tổng tiền điện tháng " + thang + " năm " + nam + ":%98s \n", total + "VNĐ");
	}

	public static void inBienLaiNam() {
		int nam;

		System.out.println("Biên lai năm :");
		nam = myScanner.nextInt();
		Double total = 0.0;
		System.out.println(
				"+---------------------------------Danh sách biên lai Khách hàng------------------------------ --------+");
		System.out.println(
				"|  mã số  |   tên KH     |     Địa chỉ  | Mã Ct   | Chỉ số mới |Chỉ Số Cũ | tiền Diện  | tháng | năm  |");
		for (BienLai x : arrayBienLai) {

			if (nam == x.getNam()) {
				System.out.printf("%-10s %-15s %-15s %-10s %-10s %-10s %-11s %-7s %-7s \n", x.getMaKH(), x.getTenKH(),
						x.getDiaChi(), x.getMaCT(), x.getChiSoMoi(), x.getChiSoCu(), x.getTienDien(), x.getThang(),
						x.getNam());
				total += x.getTienDien();
			}

		}
		System.out.printf("Tổng tiền điện năm " + nam + "%80s \n", total + "VNđ");
	}

	public static void inToanBo() {
		String maKH;
		int thang, nam;
		Double total = 0.0;
		myScanner.nextLine();
		System.out.println("Biên lai Mã Khách Hàng :");
		maKH = myScanner.nextLine();
		System.out.println(
				"+---------------------------------Danh sách biên lai Khách hàng------------------------------ --------+");
		System.out.println(
				"|  mã số  |   tên KH     |     Địa chỉ  | Mã Ct   | Chỉ số mới |Chỉ Số Cũ | tiền Diện  | tháng | năm  |");
		for (BienLai x : arrayBienLai) {

			if (maKH.equals(x.getMaKH())) {
				System.out.printf("%-10s %-15s %-15s %-10s %-10s %-10s %-11s %-7s %-7s \n", x.getMaKH(), x.getTenKH(),
						x.getDiaChi(), x.getMaCT(), x.getChiSoMoi(), x.getChiSoCu(), x.getTienDien(), x.getThang(),
						x.getNam());
				total += x.getTienDien();
			}

		}
		System.out.printf("Tổng tiền điện " + "%80s \n", total + "VNđ");
	}

	public static void inChiTiet() {
		String maKH;
		int thang, nam;
		Double total = 0.0;
		myScanner.nextLine();
		System.out.println("Biên lai Mã Khách Hàng :");
		maKH = myScanner.nextLine();
		System.out.println("Biên lai tháng :");
		thang = myScanner.nextInt();
		System.out.println("Biên lai năm :");
		nam = myScanner.nextInt();
		for (BienLai x : arrayBienLai) {
			if (thang == x.getThang() && nam == x.getNam() && maKH.equals(x.getMaKH())) {
				System.out.println("    +--------BIÊN LAI TIỀN ĐIỆN----------+");
				System.out.println("    |____________________________________|");
				System.out.printf("     |-Mã khách hàng :" + "%20s \n", x.getMaKH() + "|");
				System.out.printf("     |-Tên Khách Hàng:" + "%20s \n", x.getTenKH() + "|");
				System.out.printf("     |-Địa chỉ       :" + "%20S \n", x.getDiaChi() + "|");
				System.out.printf("     |-Mã Công Tơ    :" + "%20s \n", x.getMaCT() + "|");
				System.out.println("    |====================================|");
				System.out.printf("     |-Tháng         :" + "%20s \n", x.getThang() + "|");
				System.out.printf("     |-Năm           :" + "%20s \n", x.getNam() + "|");
				System.out.printf("     |-Mã chỉ Số mới :" + "%20s \n", x.getChiSoMoi() + "|");
				System.out.printf("     |-Mã chỉ Số mới :" + "%20s \n", x.getChiSoMoi() + "|");
				System.out.printf("     |-Mã chỉ Số cũ: :" + "%20s \n", x.getChiSoCu() + "|");
				System.out.println("    |====================================|");
				System.out.printf("     |-Tiền điện :    " + "%20s \n", x.getTienDien() + "|");
			}

		}
	}

	public static void thongKeToanBo() {
		Double total = 0.0;
		int thang1, nam1, thang2, nam2;
		myScanner.nextLine();
		System.out.println("Biên lai từ tháng :");
		thang1 = myScanner.nextInt();
		System.out.println("Biên lai từ năm :");
		nam1 = myScanner.nextInt();
		System.out.println("Biên lai đến tháng :");
		thang2 = myScanner.nextInt();
		System.out.println("Biên lai đến năm :");
		nam2 = myScanner.nextInt();
		System.out.println(
				"+---------------------------------Danh sách biên lai Khách hàng------------------------------ --------+");
		System.out.println(
				"|  mã số  |   tên KH     |     Địa chỉ  | Mã Ct   | Chỉ số mới |Chỉ Số Cũ | tiền Diện  | tháng | năm  |");
		for (BienLai x : arrayBienLai) {
			if (thang1 <= x.getThang() && nam1 <= x.getNam()) {
				if (thang2 >= x.getThang() && nam2 >= x.getNam()) {
					System.out.printf("%-10s %-15s %-15s %-10s %-10s %-10s %-11s %-7s %-7s \n", x.getMaKH(),
							x.getTenKH(), x.getDiaChi(), x.getMaCT(), x.getChiSoMoi(), x.getChiSoCu(), x.getTienDien(),
							x.getThang(), x.getNam());
					total += x.getTienDien();
				}
			}

		}
		System.out.printf("Tổng tiền điện " + "%80s \n", total + "VNđ");
	}

	public static void thongKeMaKH() {
		Double total = 0.0;
		int thang1, nam1, thang2, nam2;
		String maKH;
		myScanner.nextLine();
		System.out.println("Biên lai Mã Khách Hàng :");
		maKH = myScanner.nextLine();
		System.out.println("Biên lai từ tháng :");
		thang1 = myScanner.nextInt();
		System.out.println("Biên lai từ năm :");
		nam1 = myScanner.nextInt();
		System.out.println("Biên lai đến tháng :");
		thang2 = myScanner.nextInt();
		System.out.println("Biên lai đến năm :");
		nam2 = myScanner.nextInt();
		System.out.println(
				"+---------------------------------Danh sách biên lai Khách hàng------------------------------ --------+");
		System.out.println(
				"|  mã số  |   tên KH     |     Địa chỉ  | Mã Ct   | Chỉ số mới |Chỉ Số Cũ | tiền Diện  | tháng | năm  |");
		for (BienLai x : arrayBienLai) {
			if (thang1 <= x.getThang() && nam1 <= x.getNam() && maKH.equals(x.getMaKH())) {
				if (thang2 >= x.getThang() && nam2 >= x.getNam()) {
					System.out.printf("%-10s %-15s %-15s %-10s %-10s %-10s %-11s %-7s %-7s \n", x.getMaKH(),
							x.getTenKH(), x.getDiaChi(), x.getMaCT(), x.getChiSoMoi(), x.getChiSoCu(), x.getTienDien(),
							x.getThang(), x.getNam());
					total += x.getTienDien();
				}
			}

		}
		System.out.printf("Tổng tiền điện " + "%80s \n", total + "VNđ");

	}

	public static void danhSachKH() {
		System.out.println("+---------------Danh sách Khách hàng-------------------+");
		System.out.println("|  mã số  |    tên KH    |   Địa chỉ    |   Mã CT      |");
		for (KhachHang x : arrayKhachHang) {
			System.out.printf("%-10s%-15s%-15s%-15s \n", x.getMaKH(), x.getTenKH(), x.getDiaChi(), x.getMaCT());
		}
		System.out.println("================================");
	}

	public static void inBienLaiMaKH() {
		while (true) {
			System.out.println("+--------LỰA CHỌN In Biên Lai-------+");
			System.out.println("| 1. In toàn bộ                     |");
			System.out.println("| 2. In chi tiết                    |");
			System.out.println("====================================");
			System.out.println("| 0. Quay lại                       |");
			System.out.println("+-----------------------------------+");
			int option = myScanner.nextInt();
			if (option == 1) {
				inToanBo();
			} else if (option == 2) {
				inChiTiet();
			} else if (option == 0) {
				break;
			}
			myScanner.nextLine();
			System.out.println("Nhấn Enter để tiếp tục");
			System.out.println("______________________________");
		
		}
	}

	public static void inBienLaiThongKe() {
		while (true) {
			System.out.println("+--------LỰA CHỌN In Biên Lai-------+");
			System.out.println("| 1. Thống kê tất cả khách hàng     |");
			System.out.println("| 2. Thống kê theo mã KH            |");
			System.out.println("====================================");
			System.out.println("| 0. Quay lại                       |");
			System.out.println("+-----------------------------------+");
			int option = myScanner.nextInt();
			if (option == 1) {
				thongKeToanBo();
			} else if (option == 2) {
				thongKeMaKH();
			} else if (option == 0) {
				break;
			}
			myScanner.nextLine();
			System.out.println("Nhấn Enter để tiếp tục");
			System.out.println("______________________________");
			
		}
	}

	public static void danhSachBienLai() {
		while (true) {
			System.out.println("+--------LỰA CHỌN In Biên Lai-------+");
			System.out.println("| 1. In theo tháng,năm              |");
			System.out.println("| 2. In theo năm                    |");
			System.out.println("| 3. In theo mã khách hàng          |");
			System.out.println("| 4. Thống kê trong khoảng thời gian|");
			System.out.println("| 5. In toàn bộ biên lai            |");
			System.out.println("====================================");
			System.out.println("| 0. Trở về Menu chính              |");
			System.out.println("+-----------------------------------+");
			int option = myScanner.nextInt();
			if (option == 1) {
				inBienLaiThang();
			} else if (option == 2) {
				inBienLaiNam();
			} else if (option == 3) {
				inBienLaiMaKH();
			} else if (option == 4) {
				inBienLaiThongKe();
			} else if (option == 5) {
				bienLai();
			} else if (option == 0) {
				break;
			}
			myScanner.nextLine();
			System.out.println("Nhấn Enter để tiếp tục");
			System.out.println("______________________________");
		
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
			System.out.println("=================================");
			System.out.println("| 5. Kết thúc                   |");
			System.out.println("+-------------------------------+");
			int option = myScanner.nextInt();
			if (option == 1) {
				themKH();
			} else if (option == 2) {
				themBL();
			} else if (option == 3) {
				danhSachBienLai();
			} else if (option == 4) {
				danhSachKH();
			} else if (option == 5) {
				ketThuc();
			}
			myScanner.nextLine();
			System.out.println("Nhấn Enter để tiếp tục");
			System.out.println("______________________________");
		
		}
	}

}
