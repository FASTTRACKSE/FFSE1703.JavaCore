package FFSE1702.main;

import java.util.Scanner;

import java.util.ArrayList;

import FFSE1702.model.*;

public class TienDien {

	public static Scanner Scanner = new Scanner(System.in);
	public static int n = 0;
	public static ArrayList<Bienlai> arrBienlai = new ArrayList<Bienlai>();
	public static ArrayList<KhachHang> arrKhachHang = new ArrayList<KhachHang>();

	public static void main(String[] args) {
		showCTrinh();
	}

	public static void nhapthongtinKH() {

		System.out.println("Nhập danh sách khách hàng : ");
		System.out.println("---------------------------");
		System.out.print("Số lượng khách hàng :");
		n = Scanner.nextInt();

		for (int i = 0; i < n; i++) {
			
			Scanner.nextLine();
			
			System.out.println("Nhập Mã khách hàng thứ "+(i+1)+" : ");
			String masoKH = Scanner.nextLine();
			
			System.out.println("Nhập Tên khách hàng thứ "+(i+1)+" : ");
			String tenKH = Scanner.nextLine();
			
			System.out.println("Nhập Địa Chỉ khách hàng thứ "+(i+1)+" : ");
			String Address = Scanner.nextLine();
			
			System.out.println("Nhập Mã Công Tơ của khách hàng thứ "+(i+1)+" : ");
			String masoCT = Scanner.nextLine();
			
			arrKhachHang.add(new KhachHang(masoKH,tenKH,Address,masoCT));

		}
		
		Scanner.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		Scanner.nextLine();
	}

	public static void nhapthongtinTT() {
		
		System.out.println("Nhập chỉ số điện tiêu thụ :");

		for (int i = 0; i < n; i++) {

			Scanner.nextLine();
			
			System.out.println("Tên Khách hàng : " +arrKhachHang.get(i).getTenKH());
			System.out.println("Mã Khách hàng : " +arrKhachHang.get(i).getMasoKH());
			System.out.println("Mã Công Tơ :" + arrKhachHang.get(i).getMasoCT());
			
			System.out.println("Nhập Chỉ Số Điện Cũ :");
			int chisotruoc=Scanner.nextInt();
			
			System.out.println("Nhập Chỉ Số Điện Mới :");
			int chisosau=Scanner.nextInt();
			
			arrBienlai.add(new Bienlai(arrKhachHang.get(i).getMasoKH(),
					arrKhachHang.get(i).getTenKH(),
					arrKhachHang.get(i).getAddress(),arrKhachHang.get(i).getMasoCT(),
					chisotruoc,chisosau));			
		}	
		
		Scanner.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		Scanner.nextLine();
	}

	public static void inbienlai() {
		
		System.out.println("Danh sách tính tiền điện của khách hàng ");
		System.out.println("-------------------------------------------------------------------------------------------------------------------");
		System.out.println("STT  MasoKH    TênKH           Địa chỉ     MasoCT  Chỉ số trước  Chỉ số sau     Tiền điện     ");
		System.out.println("-------------------------------------------------------------------------------------------------------------------");
		for (int i = 0; i < arrBienlai.size(); i++) {

			System.out.printf("%-5s%-10s%-16s%-12s%-12s%-14s%-12s%-14s\n",
					(i + 1),
					arrKhachHang.get(i).getMasoKH(),
					arrKhachHang.get(i).getTenKH(),
					arrKhachHang.get(i).getAddress(),
					arrKhachHang.get(i).getMasoCT(),
					arrBienlai.get(i).getChisotruoc(),
					arrBienlai.get(i).getChisosau(),
					arrBienlai.get(i).tienDien());
		}
		
		Scanner.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		Scanner.nextLine();
	}
	
public static void inkhachhang() {
		
		System.out.println("Danh sách tính tiền điện của khách hàng ");
		System.out.println("------------------------------------------------------");
		System.out.println("STT  MasoKH    TênKH           Địa chỉ     MasoCT  ");
		System.out.println("------------------------------------------------------");
		for (int i = 0; i < arrKhachHang.size(); i++) {

			System.out.printf("%-5s%-10s%-16s%-12s%-12s\n",
					(i + 1),
					arrKhachHang.get(i).getMasoKH(),
					arrKhachHang.get(i).getTenKH(),
					arrKhachHang.get(i).getAddress(),
					arrKhachHang.get(i).getMasoCT());}
		
		Scanner.nextLine();
		System.out.println("Ấn Enter để về menu chính");
		Scanner.nextLine();
	}

	public static void ketThuc() {
		System.out.println("Kết thúc chương trình!!!!!");
		System.exit(0);
	}

	public static void showCTrinh() {
		while (true) {
			System.out.println(">>         MENU QUẢN LÝ TIỀN ĐIỆN       <<");
			System.out.println("+----------------------------------------+");
			System.out.println("|1. Nhập thông tin khách hàng            |");
			System.out.println("|2. Nhập thông tin chỉ số tiêu thụ       |");
			System.out.println("|3. In biên lai tiền điện của các hộ     |");
			System.out.println("|4. In danh sách khách hàng              |");
			System.out.println("|5. Kết thúc chương trình                |");
			System.out.println("+----------------------------------------+");
			System.out.println(">>            Lựa chọn của bạn?         <<");
			int myOption = Scanner.nextInt();
			if (myOption == 1) {
				nhapthongtinKH();
			} else if (myOption == 2) {
				nhapthongtinTT();
			} else if (myOption == 3) {
				inbienlai();
			} else if (myOption == 4) {
				inkhachhang();
			} else if (myOption == 5) {
				ketThuc();
			}

		}
	}

}
