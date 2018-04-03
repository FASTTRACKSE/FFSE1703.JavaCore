package ffse1702.edu.vn.main;

import java.util.ArrayList;
import ffse1702.edu.vn.model.*;
import java.util.Scanner;

public class QuanLyTienDien {
	public static Scanner input = new Scanner(System.in);
	public static int n;
	public static ArrayList<BienLai> arrBienLai = new ArrayList<BienLai>();
	public static ArrayList<KhachHang> arrKhachHang = new ArrayList<KhachHang>();

	public static void main(String[] args) {
		meNu();
	}

	public static void nhapkhachhang() {
		System.out.println("1 Nhập vào số lượng các hộ sử dụng điện");
		n = input.nextInt();
		input.nextLine();

		for (int i = 0; i < n; i++) {
			KhachHang x = new KhachHang();
			input.nextLine();

			System.out.print("Khách hàng thứ  " + (i + 1));
			System.out.print("\n");

			System.out.println("Mã số khách hàng: ");
			String makhachang = input.nextLine();
			System.out.println("Nhập tên khách hàng: ");
			String tenkhachhang = input.nextLine();
			System.out.println("Nhập địa chỉ: ");
			String diachi = input.nextLine();
			System.out.println("Mã công tơ: ");
			Double macongto = input.nextDouble();
			x.setTenkhachhang(tenkhachhang);
			x.setMakhachhang(makhachang);
			x.setDiachi(diachi);
			x.setMacongto(macongto);

			arrKhachHang.add(x);

		}

	}

	public static void nhapbienlai() {
		input.nextLine();
		for (int i = 0; i < n; i++) {
			BienLai y = new BienLai();

			System.out.println("CHỉ số củ: ");
			Double chisocu = input.nextDouble();
			System.out.println("Chỉ số mới: ");
			Double chisomoi = input.nextDouble();
			System.out.println("THANG: ");
			int thang = input.nextInt();
			System.out.println("NAM: ");
			int nam = input.nextInt();
			y.setchisocu(chisocu);
			y.setchisomoi(chisomoi);
			y.setThang(thang);
			y.setNam(nam);
			arrBienLai.add(y);

		}

	}

	public static void inbienlai() {
		System.out.println(">>                            DANH SACH BIEN LAI       		         <<");
		System.out
				.println("+------- ----------- ---------- ---------- -------- ------- ------- --------- - ------ ---+");
		System.out.println("stt		MACONGTO		CHISOMOI		 CHISOCU		TIEN");
		for (int i = 0; i < n; i++) {
			System.out.println((i + 1) + "		" + arrKhachHang.get(i).getMacongto() + "			"
					+ arrBienLai.get(i).getchisomoi() + "			" + arrBienLai.get(i).getchisomoi() + "			"
					+ arrBienLai.get(i).tinhtien());
		}

	}

	public static void inkhachhang() {
		System.out.println(">>                            DANH SACH KHACH HANG       		         <<");
		System.out
				.println("+------- ----------- ---------- ---------- -------- ------- ------- --------- - ------ ---+");
		System.out.println("stt		masokhachhang		tenkhacnhhang		diachi		macongto	");
		for (int i = 0; i < n; i++) {

			System.out.println((i + 1) + "		" + arrKhachHang.get(i).getMakhachhang() + "			"
					+ arrKhachHang.get(i).getTenkhachhang() + "			" + arrKhachHang.get(i).getDiachi() + "		"
					+ arrKhachHang.get(i).getMacongto());

		}
	}

	public static void ketThuc() {
		System.out.println("++++++ Chương trình kết thúc+++++++");
		System.exit(0);

	}

	public static void meNu() {
		while (true) {

			System.out.println(">>              MENU CUA TOI           <<");
			System.out.println("+----------------------------------------+");
			System.out.println("|1. Nhap danh sach khach hang              |");
			System.out.println("|2. Nhap danh sach bien lai                |");
			System.out.println("|3. in khach hang                          |");
			System.out.println("|4. in bien lai                            |");
			System.out.println("|5. ket thuc chuong trinh                  |");
			System.out.println("+----------------------------------------+");
			System.out.println(">>            chon di?         <<");
			int a;
			a = input.nextInt();
			if (a == 1) {
				nhapkhachhang();
			} else if (a == 2) {
				nhapbienlai();
			} else if (a == 3) {
				inkhachhang();
			} else if (a == 4) {
				meNuCon();
			} else if (a == 5) {
				ketThuc();
			}
		}
	}

	public static void meNuCon() {
		while (true) {

			System.out.println(">>              MENU CON           <<");
			System.out.println("+----------------------------------------+");
			System.out.println("|1. IN BIEN LAI THEO NAM                  |");
			System.out.println("|2. IN BIEN LAI THEO THANG                |");
			int b;
			b = input.nextInt();
			if (b == 1) {
				inTheoNam();
			} else if (b == 2) {
				inTheoThang();
			} else {
			}
		}
	}

	public static void inTheoNam() {
		int nam;
		System.out.println("Nhap so nam can in bien lai");
		nam = input.nextInt();
		System.out.println(
				"+---------------------------------DANH SACH BIEN LAI THEO NAM------------------------------ --------+");
		System.out.println("stt		masokhachhang		tenkhacnhhang		diachi		macongto	nam");
		for (int i = 0; i < n; i++) {
			if (nam == arrBienLai.get(i).getNam()) {
				System.out.println((i + 1) + "		" + arrKhachHang.get(i).getMakhachhang() + "			"
						+ arrKhachHang.get(i).getTenkhachhang() + "			" + arrKhachHang.get(i).getDiachi()
						+ "		" + arrKhachHang.get(i).getMacongto() + "		" + arrBienLai.get(i).getNam());

			}

		}

	}

	public static void inTheoThang() {
		int thang;
		System.out.println("Nhap so nam can in bien lai");
		thang = input.nextInt();
		System.out.println(
				"+---------------------------------DANH SACH BIEN LAI THEO NAM------------------------------ --------+");
		System.out.println("stt		masokhachhang		tenkhacnhhang		diachi		macongto	nam");
		for (int i = 0; i < n; i++) {
			if (thang == arrBienLai.get(i).getNam()) {
				System.out.println((i + 1) + "		" + arrKhachHang.get(i).getMakhachhang() + "			"
						+ arrKhachHang.get(i).getTenkhachhang() + "			" + arrKhachHang.get(i).getDiachi()
						+ "		" + arrKhachHang.get(i).getMacongto() + "		" + arrBienLai.get(i).getThang());

			}

		}

	}

}
