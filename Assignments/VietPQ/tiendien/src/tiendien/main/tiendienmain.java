package tiendien.main;

import tiendien.model.*;
import java.util.Scanner;
import java.util.ArrayList;

public class tiendienmain {
	public static Scanner myScanner = new Scanner(System.in);
	public static int n;
	static ArrayList<khachhang> arrayKhachhang = new ArrayList<khachhang>();
	static ArrayList<bienlai> arraybienlai = new ArrayList<bienlai>();

	public static void main(String[] args) {
		myMenu();
	}

	public static void nhapKhachHang() {
		System.out.print("Nhap so luong khach hang : ");
		n = myScanner.nextInt();
		String maSoKH;
		String tenKH, diaChi;
		String maCT;
		for (int i = 0; i < n; i++) {

			myScanner.nextLine();
			System.out.println("Nhap ma so khach hang thu " + (i + 1) + " :");
			maSoKH = myScanner.nextLine();
			System.out.println("Nhap ten khach hang thu " + (i + 1) + " :");
			tenKH = myScanner.nextLine();
			System.out.println("Nhap dia chikhach hang thu " + (i + 1) + " :");
			diaChi = myScanner.nextLine();
			System.out.println("Nhap ma cong to khach hang thu" + (i + 1) + " :");
			maCT = myScanner.nextLine();
			arrayKhachhang.add(new khachhang(maSoKH, tenKH, diaChi, maCT));
		}
	}

	public static void nhapBienLai() {
		Double chiSoMoi, chiSoCu;
		int thang, nam;
		System.out.println("Nhap bien lai cho thang :");
		thang = myScanner.nextInt();
		System.out.println("Nhap bien lai cho nam :");
		nam = myScanner.nextInt();
		for (int i = 0; i < arrayKhachhang.size(); i++) {
			System.out.println("Bien lai thang : " + thang + " nam " + nam + " :");
			myScanner.nextLine();
			System.out.println("Nhập Chỉ Số Cũ Của Khách Hàng " + arrayKhachhang.get(i).gettenkhachhang() + " :");
			chiSoCu = myScanner.nextDouble();
			System.out.println("Nhập Chỉ Số Mới Của Khách Hàng " + arrayKhachhang.get(i).gettenkhachhang() + " :");
			chiSoMoi = myScanner.nextDouble();
			arraybienlai.add(new bienlai(arrayKhachhang.get(i).getmakhachhang(),
					arrayKhachhang.get(i).gettenkhachhang(), arrayKhachhang.get(i).getSoNha(),
					arrayKhachhang.get(i).getMaCongTo(), chiSoCu, chiSoMoi, thang, nam));
		}
	}

	public static void inBienLai() {
		System.out.println(
				"+---------------------------------DANH SACH BIEN LAI CUA KHACH HANG------------------------------ --------+");
		System.out.println(
				"|  Ma KH  |   Ten KH     |     Đia chi  | Ma CT   | Chi so moi |Chi so cu | Tong tien  | Thang | Nam  |");
		for (bienlai x : arraybienlai) {
			System.out.printf("%-10s %-15s %-15s %-10s %-10s %-10s %-11s %-7s %-7s \n", x.getmakhachhang(),
					x.gettenkhachhang(), x.getSoNha(), x.getMaCongTo(), x.getChiSoMoi(), x.getChiSoCu(),
					x.getTienDien(), x.getThang(), x.getNam());
		}
		System.out.println("================================");
	}

	public static void BLTheoThang() {
		int thang, nam;
		System.out.println("Biên Lai Của Tháng :");
		thang = myScanner.nextInt();
		System.out.println("Biên Lai Của Năm :");
		nam = myScanner.nextInt();

		System.out.println(
				"+---------------------------------DANH SACH BIEN LAI TUNG THANG CUA KHACH HANG------------------------------ --------+");
		System.out.println(
				"|  Ma KH  |   Ten KH     |     Đia chi  | Ma CT   | Chi so moi |Chi so cu | Tong tien  | Thang | Nam  |");
		for (bienlai x : arraybienlai) {
			if (thang == x.getThang() && nam == x.getNam()) {
				System.out.printf("%-10s %-15s %-15s %-10s %-10s %-10s %-11s %-7s %-7s \n", x.getmakhachhang(),
						x.gettenkhachhang(), x.getSoNha(), x.getMaCongTo(), x.getChiSoMoi(), x.getChiSoCu(),
						x.getTienDien(), x.getThang(), x.getNam());
			}
			System.out.println("================================");
		}
	}
//IN Biên Lai Theo Năm
	public static void BLTheoNam() {
		int nam;

		System.out.println("Biên Lai Của Năm :");
		nam = myScanner.nextInt();

		System.out.println(
				"+---------------------------------DANH SACH BIEN LAI CA NAM CUA KHACH HANG------------------------------ --------+");
		System.out.println(
				"|  Ma KH  |   Ten KH     |     Đia chi  | Ma CT   | Chi so moi |Chi so cu | Tong tien  | Thang | Nam  |");
		for (bienlai x : arraybienlai) {
			if (nam == x.getNam()) {
				System.out.printf("%-10s %-15s %-15s %-10s %-10s %-10s %-11s %-7s %-7s \n", x.getmakhachhang(),
						x.gettenkhachhang(), x.getSoNha(), x.getMaCongTo(), x.getChiSoMoi(), x.getChiSoCu(),
						x.getTienDien(), x.getThang(), x.getNam());
			}
			System.out.println("================================");
		}
	}

	public static void BLTheoMaKH() {
		String maKH;
		int thang, nam;
		myScanner.nextLine();
		System.out.println("Biên Lai Mã Khách Hàng :");
		maKH = myScanner.nextLine();
		System.out.println("Biên Lai Của tháng :");
		thang = myScanner.nextInt();
		System.out.println("Biên Lai Của Năm :");
		nam = myScanner.nextInt();

		System.out.println(
				"+---------------------------------BIEN LAI CUA KHACH HANG--------------------------------------+");
		System.out.println(
				"|  Ma KH  |   Ten KH     |     Đia chi  | Ma CT   | Chi so moi |Chi so cu | Tong tien  | Thang | Nam  |");
		for (bienlai x : arraybienlai) {
			if (maKH.compareTo(x.getmakhachhang()) == 0) {
				System.out.printf("%-10s %-15s %-15s %-10s %-10s %-10s %-11s %-7s %-7s \n", x.getmakhachhang(),
						x.gettenkhachhang(), x.getSoNha(), x.getMaCongTo(), x.getChiSoMoi(), x.getChiSoCu(),
						x.getTienDien(), x.getThang(), x.getNam());
			}
		}
		System.out.println("<==============================>");
	}
	//sửa
	public static void edit() {
		System.out.println("Tên Khách Hàng Cần Sửa :");
		String TenKhachHang = myScanner.next();
		System.out.println("Tên Khách Hàng Mới :");
		String newTenKhachHang = myScanner.next();
		for (khachhang x : arrayKhachhang) {
			if ((x.gettenkhachhang()).equals(TenKhachHang)) {
				x.settenkhachhang(newTenKhachHang);
			}
		}
	}
	//xóa
	public static void delete() {
		System.out.println("Tên Khách Hàng Cần Xóa :");
		String tenkhachhang = myScanner.next();
		
		for (khachhang x : arrayKhachhang) {
			if ((x.gettenkhachhang()).equals(tenkhachhang)) {
			arrayKhachhang.remove(x);
			break;
			}
		}
	}
//In Danh Sách Khách Hàng
	public static void danhSachKH() {
		System.out.println("+---------------DANH SÁCH KHÁCH HÀNG-------------------+");
		System.out.println("| Ma KH |    Ten KH    |   Đia chi    |   Ma CT      |");
		for (khachhang x : arrayKhachhang) {
			System.out.printf("%-10s%-15s%-15s%-15s \n", x.getmakhachhang(), x.gettenkhachhang(), x.getSoNha(),
					x.getMaCongTo());
		}
		System.out.println("================================");
	}
//In Danh Sách Biên Lai
	public static void danhSachBienLai() {
		while (true) {
			System.out.println("+------LỰA CHỌN KIỂU IN BIÊN LAI-------+");
			System.out.println("| 1. IN Theo Ngày/Tháng/Năm            |");
			System.out.println("| 2. IN Theo Năm                       |");
			System.out.println("| 3. IN Theo Mã Của Khách Hàng         |");
			System.out.println("| 4. IN Toàn Bộ Biên Lai               |");
			System.out.println("<======================================>");
			System.out.println("| 6. Kết Thúc                          |");
			System.out.println("<================######================>");
			int option = myScanner.nextInt();
			if (option == 1) {
				BLTheoThang();
			} else if (option == 2) {
				BLTheoNam();
			} else if (option == 3) {
				BLTheoMaKH();
			} else if (option == 4) {
				inBienLai();
			} else if (option == 6) {
				ketThuc();
			} 
			System.out.println("Nhấn Enter để tiếp tục");
			System.out.println("______________________________");
			myScanner.nextLine();
		}
	}

	public static void ketThuc() {
		System.out.println("**********THANK YOU!*********");
		System.exit(0);
	}
//Menu 
	public static void myMenu() {
		while (true) {
			System.out.println("+------LỰA CHỌN CHỨC NĂNG-------+");
			System.out.println("| 1. Nhập Số Lượng Khách Hàng   |");
			System.out.println("| 2. Nhập Chỉ Số Điện Hằng Tháng|");
			System.out.println("| 3. IN Biên Lai Cho Khách Hàng |");
			System.out.println("| 4. IN Danh Sách Khách Hàng    |");
			System.out.println("| 5. IN Danh Sách Biên Lai      |");
			System.out.println("=================================");
			System.out.println("| 6.  Sửa Tên Khách Hàng        |");
			System.out.println("| 7.  Xóa Tên Khách Hàng        |");
			System.out.println("| 8.  Kết Thúc                  |");
			
			System.out.println("+-------------------------------+");
			int option = myScanner.nextInt();
			if (option == 1) {
				nhapKhachHang();
			} else if (option == 2) {
				nhapBienLai();
			} else if (option == 3) {
				inBienLai();
			} else if (option == 4) {
				danhSachKH();
			} else if (option == 5) {
				danhSachBienLai();
			} else if (option == 6) {
				edit();
			}else if (option == 7) {
				delete();
			}else if (option == 8) {
				
				ketThuc();
			}
			System.out.println("Nhấn Enter để tiếp tục");
			System.out.println("______________________________");
			myScanner.nextLine();
		}
	}

}