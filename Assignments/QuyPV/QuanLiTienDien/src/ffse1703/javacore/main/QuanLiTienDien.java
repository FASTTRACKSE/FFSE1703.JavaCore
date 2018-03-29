package ffse1703.javacore.main;

import ffse1703.javacore.model.*;
import java.util.ArrayList;
import java.util.Scanner;

public class QuanLiTienDien {
	public static ArrayList<KhachHang> arrKhachHang = new ArrayList<>();
	public static ArrayList<BienLai> arrBienLai = new ArrayList<>();
	public static Scanner myInput = new Scanner(System.in);
	public static int soLuong, stt = 0;

	public static void main(String[] args) {
		myMenu();

	}

	public static void myMenu() {
		System.out.println("---  lỰA CHỌN CHỨC NĂNG  ---");
		System.out.println("____________________________" + "\n");
		System.out.println("1. Nhập thông tin khách hàng.");
		System.out.println("2. Nhập thông tin biên lai.");
		System.out.println("3. In thông tin khách hàng");
		System.out.println("4. Kết thúc.");
		System.out.println("____________________________" + "\n");

		while (true) {
			System.out.println("Nhập lựa chọn của bạn: ");
			int chose = Integer.parseInt(myInput.nextLine());
			if (chose == 1) {
				nhapKhachHang();
			} else if (chose == 2) {
				nhapBienLai();
			} else if (chose == 3) {
				in();
			} else if (chose == 4) {
				ketThuc();
			}
		}
	}

	public static void nhapKhachHang() {
		System.out.println("Nhập số lượng khách hàng: ");
		soLuong = Integer.parseInt(myInput.nextLine());
		

		for (int i = 0; i < soLuong; i++) {
			KhachHang khachhang = new KhachHang();
			System.out.println("Nhập mã khách hàng: ");
			khachhang.setMaKhachHang(myInput.nextLine());

			System.out.println("Nhập họ tên khách hàng: ");
			khachhang.setTenKhachHang(myInput.nextLine());

			System.out.println("Nhập địa chỉ khách hàng: ");
			khachhang.setDiaChi(myInput.nextLine());

			System.out.println("Nhập Mã công tơ: ");
			khachhang.setMaCongTo(Integer.parseInt(myInput.nextLine()));

			arrKhachHang.add(khachhang);
			
			
		}
		for(int i = 0; i <soLuong; i++) {
		System.out.println(arrKhachHang.get(i).getTenKhachHang());
		}
	}

	public static void nhapBienLai() {
		for (; stt < arrKhachHang.size(); stt++) {
			BienLai bienLai = new BienLai();
			System.out.println("Mã khách hàng: " + arrKhachHang.get(stt).getMaKhachHang());
			System.out.println("Tên khách hàng: " + arrKhachHang.get(stt).getTenKhachHang());
			System.out.println("Địa chỉ khách hàng: " + arrKhachHang.get(stt).getDiaChi());
			System.out.println("Mã công tơ khách hàng: " + arrKhachHang.get(stt).getMaCongTo());

			System.out.println("Nhập chỉ số cũ: ");
			bienLai.setChiSoCu(Integer.parseInt(myInput.nextLine()));

			System.out.println("Nhập chỉ số mới: ");
			bienLai.setChiSoMoi(Integer.parseInt(myInput.nextLine()));

			arrBienLai.add(bienLai);
		}
		
		
	}

	
	public static void in() {
		System.out.println("STT \t \t" + "Mã khách hàng \t \t" + "Tên khách hàng \t \t" + "Địa chỉ \t \t"
				+ "Chỉ số cũ \t \t" + "Chỉ số mới \t \t" + "Thành tiền");
		for (int i = 0; i < arrKhachHang.size(); i++) {
			System.out.println((i + 1) + "\t \t" + arrKhachHang.get(i).getMaKhachHang()
					+ "\t \t" + arrKhachHang.get(i).getTenKhachHang() + "\t \t" + arrKhachHang.get(i).getDiaChi()
					+ "\t \t" + arrBienLai.get(i).getChiSoCu() + "\t \t" + arrBienLai.get(i).getChiSoMoi() + "\t \t" + arrBienLai.get(i).soTienTra());
		}
	}

	public static void ketThuc() {

	}

}
