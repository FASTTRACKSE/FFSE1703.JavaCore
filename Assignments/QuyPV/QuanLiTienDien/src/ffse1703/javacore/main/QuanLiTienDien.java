package ffse1703.javacore.main;

import ffse1703.javacore.model.*;
import java.util.ArrayList;
import java.util.Scanner;

public class QuanLiTienDien {
	private ArrayList<KhachHang> arrKhachHang = new ArrayList<>();
	private ArrayList<BienLai> arrBienLai = new ArrayList<>();
	private Scanner myInput = new Scanner(System.in);
	private int soLuong, stt = 0;

	public static void main(String[] args) {
		QuanLiTienDien run = new QuanLiTienDien();
		run.myMenu();

	}

	// PHẦN MENU CHÍNH

	public void myMenu() {
		while (true) {
			System.out.println("---  lỰA CHỌN CHỨC NĂNG  ---");
			System.out.println("____________________________" + "\n");
			System.out.println("1. Nhập thông tin khách hàng.");
			System.out.println("2. Nhập thông tin biên lai.");
			System.out.println("3. In biên lai");
			System.out.println("4. In khách hàng");
			System.out.println("5. Kết thúc.");
			System.out.println("____________________________" + "\n");

			System.out.println("Nhập lựa chọn của bạn: ");
			int chose = Integer.parseInt(myInput.nextLine());
			if (chose == 1) {
				nhapKhachHang();
			} else if (chose == 2) {
				nhapBienLai();
			} else if (chose == 3) {
				meNuInBienLai();
			} else if (chose == 4) {
				inKhachHang();
			} else if (chose == 5) {
				ketThuc();
			}
		}
	}

	public void nhapKhachHang() {
		System.out.println("Nhập số lượng khách hàng: ");
		soLuong = Integer.parseInt(myInput.nextLine());

		for (int i = 0; i < soLuong; i++) {

			System.out.println("Nhập mã khách hàng: ");
			String maKhachHang = myInput.nextLine();

			System.out.println("Nhập họ tên khách hàng: ");
			String tenKhachHang = myInput.nextLine();

			System.out.println("Nhập địa chỉ khách hàng: ");
			String diaChi = myInput.nextLine();

			System.out.println("Nhập Mã công tơ: ");
			int maCongTo = Integer.parseInt(myInput.nextLine());

			arrKhachHang.add(new KhachHang(maKhachHang, tenKhachHang, diaChi, maCongTo));

		}

	}

	public void nhapBienLai() {
		// for (; stt < arrKhachHang.size(); stt++) {};
		
		System.out.println("Nhập tháng: ");
		String thang = myInput.nextLine();

		System.out.println("Nhập năm");
		String nam = myInput.nextLine();

		for (KhachHang x : arrKhachHang) {
			// x = arrMaKhachhang.get(i);
			// BienLai bienLai = new BienLai();
			System.out.println("Mã khách hàng: " + x.getMaKhachHang());
			System.out.println("Tên khách hàng: " + x.getTenKhachHang());
			System.out.println("Địa chỉ khách hàng: " + x.getDiaChi());
			System.out.println("Mã công tơ khách hàng: " + x.getMaCongTo());

			// bienLai.setMaKhachHang(arrKhachHang.get(stt).getMaKhachHang());
			// bienLai.setTenKhachHang(arrKhachHang.get(stt).getTenKhachHang());
			// bienLai.setDiaChi(arrKhachHang.get(stt).getDiaChi());
			// bienLai.setMaCongTo(arrKhachHang.get(stt).getMaCongTo());

			System.out.println("Nhập chỉ số cũ: ");
			// bienLai.setChiSoCu(Integer.parseInt(myInput.nextLine()));
			
			int chiSoCu = Integer.parseInt(myInput.nextLine());

			System.out.println("Nhập chỉ số mới: ");
			// bienLai.setChiSoMoi(Integer.parseInt(myInput.nextLine()));
			int chiSoMoi = Integer.parseInt(myInput.nextLine());

			arrBienLai.add(new BienLai(x.getMaKhachHang(), x.getTenKhachHang(), x.getDiaChi(), x.getMaCongTo(), chiSoCu,
					chiSoMoi, thang, nam));

		}

	}

	public void inKhachHang() {

		System.out.printf("| %-3s | | %-15s | | %-20s | | %-20s | | %-20s | \n", "STT", "Mã khách hàng",
				"Tên khách hàng", "Địa chỉ", "mã công tơ");

		for (int i = 0; i < arrKhachHang.size(); i++) {

			System.out.printf("| %-3s | | %-15s | | %-20s | | %-20s | | %-20s | \n", (i + 1),
					arrKhachHang.get(i).getMaKhachHang(), arrKhachHang.get(i).getTenKhachHang(),
					arrKhachHang.get(i).getDiaChi(), arrKhachHang.get(i).getMaCongTo());

		}
	}

	public static void ketThuc() {
		System.out.println("Cảm ơn bạn đã sử dụng chương trình của chúng tôi!!!");
		System.exit(0);
	}

	// PHẦN MENU IN BIÊN LAI

	public void meNuInBienLai() {
		while (true) {
			System.out.println("---  IN BIÊN LAI ---");
			System.out.println("____________________________" + "\n");
			System.out.println("1. In tất cả biên lai.");
			System.out.println("2. In biên lai theo mã khách hàng.");
			System.out.println("3. In biên lai theo tháng cá nhân.");
			System.out.println("4. In theo năm cá nhân.");
			System.out.println("5. Thống kê theo năm.");
			System.out.println("6. Thống kê theo tháng năm.");
			System.out.println("0. Trở về menu chính.");
			System.out.println("____________________________" + "\n");

			System.out.println("Lựa chọn chức năng in.");
			int choseIn = Integer.parseInt(myInput.nextLine());

			if (choseIn == 1) {
				inBienLaiFull();
			} else if (choseIn == 2) {
				inBienLaiMa();
			} else if (choseIn == 3) {
				inBienLaiThangNam();
			} else if (choseIn == 4) {
				inBienLaiNam();
			} else if (choseIn == 5) {
				thongKeTheoNam();
			} else if (choseIn == 6) {
				thongKeTheoThangNam();
			} else if (choseIn == 0) {
				break;
			}
		}

		myMenu();
	}

	public void inBienLaiFull() {
		// System.out.println("STT \t \t" + "Mã khách hàng \t \t" + "Tên khách hàng \t
		// \t" + "Địa chỉ \t \t"
		// + "Chỉ số cũ \t \t" + "Chỉ số mới \t \t" + "Thành tiền");

		System.out.printf("| %-3s | | %-15s | | %-20s | | %-20s | | %-15s | | %-15s | | %-15s | | %-15s | | %-10s | \n",
				"STT", "Mã khách hàng", "Tên khách hàng", "Địa chỉ", "Chỉ số cũ", "Chỉ số mới", "Tháng", "Năm",
				"Thành tiền");
		int i = 1;

		for (BienLai x : arrBienLai) {

			// System.out.println((i + 1) + "\t \t" + arrKhachHang.get(i).getMaKhachHang() +
			// "\t \t"
			// + arrKhachHang.get(i).getTenKhachHang() + "\t \t" +
			// arrKhachHang.get(i).getDiaChi() + "\t \t"
			// + arrBienLai.get(i).getChiSoCu() + "\t \t" + arrBienLai.get(i).getChiSoMoi()
			// + "\t \t"
			// + arrBienLai.get(i).soTienTra());

			System.out.printf(
					"| %-3s | | %-15s | | %-20s | | %-20s | | %-15s | | %-15s | | %-15s | | %-15s | | %-10s | \n", i,
					x.getMaKhachHang(), x.getTenKhachHang(), x.getDiaChi(), x.getChiSoCu(), x.getChiSoMoi(),
					x.getNgayThang(), x.getNam(), x.soTienTra());
			i++;

		}

	}

	public void inBienLaiMa() {
		String ma;
		System.out.println("Nhập mã khách hàng cần in: ");
		ma = myInput.nextLine();
		int i = 1;
		System.out.printf("| %-3s | | %-15s | | %-20s | | %-20s | | %-15s | | %-15s | | %-15s | | %-15s | | %-10s | \n",
				"STT", "Mã khách hàng", "Tên khách hàng", "Địa chỉ", "Chỉ số cũ", "Chỉ số mới", "Tháng", "Năm",
				"Thành tiền");
		for (BienLai x : arrBienLai) {
			if (ma.equals(x.getMaKhachHang())) {

				System.out.printf(
						"| %-3s | | %-15s | | %-20s | | %-20s | | %-15s | | %-15s | | %-15s | | %-15s | | %-10s | \n",
						i, x.getMaKhachHang(), x.getTenKhachHang(), x.getDiaChi(), x.getChiSoCu(), x.getChiSoMoi(),
						x.getNgayThang(), x.getNam(), x.soTienTra());
				i++;

			}
			// else {
			// System.out.println("Mã khách hàng không tồn tại!!!");
			// }
		}
	}

	public void inBienLaiThangNam() {
		double tongTien = 0;
		String thang, nam;
		System.out.println("Nhập tháng cần in: ");
		thang = myInput.nextLine();
		System.out.println("Nhập năm cần in: ");
		nam = myInput.nextLine();
		int i = 1;
		System.out.printf("| %-3s | | %-15s | | %-20s | | %-20s | | %-15s | | %-15s | | %-15s | | %-15s | | %-10s | \n",
				"STT", "Mã khách hàng", "Tên khách hàng", "Địa chỉ", "Chỉ số cũ", "Chỉ số mới", "tháng", "Năm",
				"Thành tiền");
		for (BienLai x : arrBienLai) {
			if (thang.equals(x.getNgayThang()) && nam.equals(x.getNam())) {

				System.out.printf(
						"| %-3s | | %-15s | | %-20s | | %-20s | | %-15s | | %-15s | | %-15s | | %-15s | | %-10s | \n",
						i, x.getMaKhachHang(), x.getTenKhachHang(), x.getDiaChi(), x.getChiSoCu(), x.getChiSoMoi(),
						x.getNgayThang(), x.getNam(), x.soTienTra());
				i++;
				tongTien += x.soTienTra();
			}
		}
		System.out.printf("%-50s \n", "Tổng tiền: " + tongTien);
	}

	public void inBienLaiNam() {
		double tongTien = 0;
		String nam, maKhachHang;
		System.out.println("Nhập mã khách hàng");
		maKhachHang = myInput.nextLine();
		System.out.println("Nhập năm cần in: ");
		nam = myInput.nextLine();
		int i = 1;
		System.out.printf("| %-3s | | %-15s | | %-20s | | %-20s | | %-15s | | %-15s | | %-15s | | %-15s | | %-10s | \n",
				"STT", "Mã khách hàng", "Tên khách hàng", "Địa chỉ", "Chỉ số cũ", "Chỉ số mới", "tháng", "Năm",
				"Thành tiền");
		for (BienLai x : arrBienLai) {
			if (nam.equals(x.getNam()) && maKhachHang.equals(x.getMaKhachHang())) {
				System.out.printf(
						"| %-3s | | %-15s | | %-20s | | %-20s | | %-15s | | %-15s | | %-15s | | %-15s | | %-10s | \n",
						i, x.getMaKhachHang(), x.getTenKhachHang(), x.getDiaChi(), x.getChiSoCu(), x.getChiSoMoi(),
						x.getNgayThang(), x.getNam(), x.soTienTra());
				i++;
				tongTien += x.soTienTra();
			}

		}

		System.out.printf("%-50s \n", "Tổng tiền: " + tongTien);
	}
	
	public void thongKeTheoNam() {
		double tongTien = 0;
		String nam;
		System.out.println("Nhập năm cần in: ");
		nam = myInput.nextLine();
		int i = 1;
		System.out.printf("| %-3s | | %-15s | | %-20s | | %-20s | | %-15s | | %-15s | | %-15s | | %-15s | | %-10s | \n",
				"STT", "Mã khách hàng", "Tên khách hàng", "Địa chỉ", "Chỉ số cũ", "Chỉ số mới", "tháng", "Năm",
				"Thành tiền");
		for (BienLai x : arrBienLai) {
			if (nam.equals(x.getNam())) {
				System.out.printf(
						"| %-3s | | %-15s | | %-20s | | %-20s | | %-15s | | %-15s | | %-15s | | %-15s | | %-10s | \n",
						i, x.getMaKhachHang(), x.getTenKhachHang(), x.getDiaChi(), x.getChiSoCu(), x.getChiSoMoi(),
						x.getNgayThang(), x.getNam(), x.soTienTra());
				i++;
				tongTien += x.soTienTra();
			}

		}

		System.out.printf("%-50s \n", "Tổng tiền: " + tongTien);
	}
	
	public void thongKeTheoThangNam() {
		double tongTien = 0;
		String nam, thang;
		System.out.println("Nhập năm cần in: ");
		nam = myInput.nextLine();
		System.out.println("Nhập tháng cần in: ");
		thang = myInput.nextLine();
		int i = 1;
		System.out.printf("| %-3s | | %-15s | | %-20s | | %-20s | | %-15s | | %-15s | | %-15s | | %-15s | | %-10s | \n",
				"STT", "Mã khách hàng", "Tên khách hàng", "Địa chỉ", "Chỉ số cũ", "Chỉ số mới", "tháng", "Năm",
				"Thành tiền");
		for (BienLai x : arrBienLai) {
			if (nam.equals(x.getNam()) && thang.equals(x.getNgayThang()) ) {
				System.out.printf(
						"| %-3s | | %-15s | | %-20s | | %-20s | | %-15s | | %-15s | | %-15s | | %-15s | | %-10s | \n",
						i, x.getMaKhachHang(), x.getTenKhachHang(), x.getDiaChi(), x.getChiSoCu(), x.getChiSoMoi(),
						x.getNgayThang(), x.getNam(), x.soTienTra());
				i++;
				tongTien += x.soTienTra();
			}

		}

		System.out.printf("%-50s \n", "Tổng tiền: " + tongTien);
	}

}
