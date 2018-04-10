package fasttrack.assignment5.main;

import fasttrack.assignment5.model.*;
import java.util.Scanner;
import java.util.ArrayList;

public class TienDien {
	public static Scanner input = new Scanner(System.in);
	static ArrayList<BienLai> arrBienLai = new ArrayList<BienLai>();
	static ArrayList<KhachHang> arrKhachHang = new ArrayList<KhachHang>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (;;) {
			System.out.println(">>              MENU CUA TOI           <<");
			System.out.println("+----------------------------------------+");
			System.out.println("|1. Nhap thong tin khach hang               |");
			System.out.println("|2. Nhap thong tin bien lai                 |");
			System.out.println("|3. in thong tin khach hang                 |");
			System.out.println("|4. In hoa don khach hang                   |");
			System.out.println("|5. ket thuc chuong trinh                   |");
			System.out.println("+----------------------------------------+");
			System.out.println(">>            chọn chức năng.         <<");
			int myOption = input.nextInt();
			if (myOption == 1) {
				nhapKH();
			} else if (myOption == 2) {
				nhapthongtinTT();
			} else if (myOption == 3) {
				inBienLai();
			} else if (myOption == 4) {
				ketThuc();
			}
		}
	}

	public static void nhapKH() {
		System.out.print("Nhập số lượng khách hàng :");
		int c = input.nextInt();
		for (int i = 0; i < c; i++) {
			input.nextLine();
			BienLai a = new BienLai();
			
			System.out.print("Nhập mã số khách hàng : " + (i + 1));
			int maSo = input.nextInt();
			a.setMaKH(maSo);

			System.out.println("Nhập tên khách hàng : " + (i + 1)); 
			String ten = input.nextLine();
			a.setTenKH(ten);
			
			System.out.print("Nhập địa chỉ khách hàng : " + (i + 1));
			String dc = input.nextLine();
			a.setDiaChi(dc);

			System.out.print("Nhập mã số công tơ : " + (i + 1));
			int soCT = input.nextInt();
			a.setMaCongTo(soCT);


			arrBienLai.add(a);
		}
		
	}
	public static void nhapBienLai() {
		BienLai a = new BienLai();
		
		for(int i =0 ; i< arrKhachHang.size() ; i++) {
			
			System.out.print("Mã khách hàng : " + arrKhachHang.get(i).getMaKH());
			System.out.print("Tên khách hàng : " + arrKhachHang.get(i).getTenKH());
			System.out.print("Mã số công tơ : " + arrKhachHang.get(i).getMaCongTo());
			
			System.out.print("Nhập mã số công tơ củ : "  );
			int cTC = input.nextInt();
			a.setChiSoCu(cTC);
			
			System.out.print("Nhập mã số công tơ mới : "  );
			int ctm = input.nextInt();
			a.setChiSoMoi(ctm);
			
			arrBienLai.add(a);
		}
		input.nextInt();
	}
	public static void nhapthongtinTT() {
		BienLai a = new BienLai();
		System.out.print("Nhập Tháng : ");
		a.thang = input.nextInt();

		System.out.print("Nhập Năm : ");
		a.nam = input.nextInt();
		
		for (int i = 0; i < arrKhachHang.size(); i++) {

		input.nextLine();

		System.out.println("Tên Khách hàng : " + arrKhachHang.get(i).getTenKH());
		System.out.println("Mã Khách hàng : " + arrKhachHang.get(i).getMaKH());
		System.out.println("Mã Công Tơ :" + arrKhachHang.get(i).getMaCongTo());
		
		a.setMaKH(arrKhachHang.get(i).getMaKH());
		a.setTenKH(arrKhachHang.get(i).getTenKH());
		a.setMaCongTo(arrKhachHang.get(i).getMaCongTo());
		
		System.out.println("Nhập Chỉ Số Điện Đầu Kỳ :");
		int cTC = input.nextInt();
		a.setChiSoCu(cTC);
		System.out.println("Nhập Chỉ Số Điện Cuối Kỳ :");
		int ctm = input.nextInt();
		a.setChiSoMoi(ctm);
		arrBienLai.add(a);
		 
		}

		input.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		input.nextLine();
		}

	public static void inThongTinKH() {

		System.out.println("Danh sách tính tiền điện của khách hàng ");
		System.out.println("------------------------------------------------------");
		System.out.println("STT  MasoKH    TênKH           Địa chỉ     MasoCT  ");
		System.out.println("------------------------------------------------------");
		for (int i = 0; i < arrBienLai.size(); i++) {

			System.out.printf("%-5s%-10s%-16s%-12s%-12s\n", (i + 1), arrBienLai.get(i).getMaKH(),
					arrBienLai.get(i).getTenKH(), arrBienLai.get(i).getDiaChi(), arrBienLai.get(i).getMaCongTo());
		}

	}

	public static void inBL() {

		System.out.println("Danh sách tính tiền điện của khách hàng ");
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------");
		System.out.println(
				"STT  MasoKH    TênKH           Địa chỉ     MasoCT  Chỉ số trước  Chỉ số sau     Tiền điện     ");
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------");
		for (int i = 0; i < arrBienLai.size(); i++) {

			System.out.printf("%-5s%-10s%-16s%-12s%-12s%-14s%-12s%-14s\n", (i + 1), arrBienLai.get(i).getMaKH(),
					arrBienLai.get(i).getTenKH(), arrBienLai.get(i).getDiaChi(), arrBienLai.get(i).getMaCongTo(),
					arrBienLai.get(i).getChiSoCu(), arrBienLai.get(i).getChiSoMoi(), arrBienLai.get(i).tinhTien());
		}
	}

	public static void ketThuc() {
		System.out.println("Kết Thúc Chương Trình!!! ");
		System.exit(0);
	}

	public static void inBienLai() {
		System.out.println(">>              MENU BIEN LAI           <<");
		System.out.println("+----------------------------------------+");
		System.out.println("|1. In biên lai trong 1 năm                 |");
		System.out.println("|2. In biên lai trong tháng                 |");
		System.out.println("|3. In biên lai theo khách hàng             |");
		System.out.println("|4. Quay lại menu chính                     |");
		System.out.println("+----------------------------------------+");
		System.out.println(">>            chọn chức năng.         <<");
		int myOption = input.nextInt();
		if (myOption == 1) {
			inBL();
		} else if (myOption == 2) {
			inThongTinKH();
		} else if (myOption == 3) {
			inBienLai();
		} else if (myOption == 4) {
			ketThuc();
		}


	}

}