package ffse1703022.main;

import ffse1703002.model.*;
import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyTienDien {
	public static Scanner scanner = new Scanner(System.in);	
	public static int soLuong;

	public static void main(String[] args) {

		myMenu();
	}

	public static void nhapKH() {
		System.out.println("Số lượng hộ gia đình");
		soLuong=scanner.nextInt();
		KhachHang kh = new KhachHang();
		System.out.println("Ten Khach Hang");
		kh.setTenKH(scanner.nextLine());
		ArrayList<KhachHang> arrKhachHang = new ArrayList<KhachHang>();
		arrKhachHang.add(kh);
		
	}

	public static void nhapChiSo() {

	}

	public static void in() {

	}

	public static void myMenu() {
		while (true) {
			System.out.println("---LUA CHON CHUC NANG---");
			System.out.println("_______________________________________" + "\n");
			System.out.println("1: Nhập thông tin các hộ sử dụng điện ");
			System.out.println("2: Nhập thông tin các chỉ số điện");
			System.out.println("3: In danh sach thu tiền ");
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
