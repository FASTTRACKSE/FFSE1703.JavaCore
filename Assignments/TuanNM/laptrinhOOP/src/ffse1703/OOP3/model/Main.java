package ffse1703.OOP3.model;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static Scanner myScanner = new Scanner(System.in);
	public static int sizeNv,sizeQl;
	static ArrayList<NhanVien> arrayNhanVien = new ArrayList<NhanVien>();
	static ArrayList<QuanLy> arrayQuanLy = new ArrayList<QuanLy>();



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myMenu();
	}
	public static void themNv() {
		System.out.print("Nhap vao so số nhân viên cần thêm : ");
		sizeNv = myScanner.nextInt();
		int maSo;
		String tenNv,ngaySinh;
		Double luong;

		for (int i = 0; i < sizeNv; i++) {

			myScanner.nextLine();
			System.out.println("Nhập mã sô nhân vien " + (i + 1) + " :");
			maSo = myScanner.nextInt();
			System.out.println("Nhập tên nhân viên thứ " + (i + 1) + " :");
			tenNv = myScanner.nextLine();
			System.out.println("Nhập ngày sinh nhân viên thứ " + (i + 1) + " :");
			ngaySinh = myScanner.nextLine();
			System.out.println("Nhập lương nhân viên thứ thứ " + (i + 1) + " :");
			luong = myScanner.nextDouble();
			arrayNhanVien.add(new NhanVien(maSo,tenNv,ngaySinh,luong ));

			System.out.println("Nhấn Enter để tiếp tục");
			System.out.println("______________________________");
			myScanner.nextLine();

		}
	}
	public static void themQl() {
		System.out.print("Nhap vao số Quản lý cần thêm : ");
		sizeQl = myScanner.nextInt();
		int maSo;
		String tenNv,ngaySinh;
		Double luong;

		for (int i = 0; i < sizeQl; i++) {

			myScanner.nextLine();
			System.out.println("Nhập mã sô Quản lí " + (i + 1) + " :");
			maSo = myScanner.nextInt();
			System.out.println("Nhập tên Quản lí thứ " + (i + 1) + " :");
			tenNv = myScanner.nextLine();
			System.out.println("Nhập ngày sinh Quản lí thứ " + (i + 1) + " :");
			ngaySinh = myScanner.nextLine();
			System.out.println("Nhập lương Quản lí thứ thứ " + (i + 1) + " :");
			luong = myScanner.nextDouble();
			System.out.println("Nhập lương Quản lí thứ thứ " + (i + 1) + " :");
			luong = myScanner.nextDouble();
			arrayNhanVien.add(new NhanVien(maSo,tenNv,ngaySinh,luong));

			System.out.println("Nhấn Enter để tiếp tục");
			System.out.println("______________________________");
			myScanner.nextLine();

		}
	}
	public static void dsNhanVien() {
		System.out.println("+-------------------------Danh sách nhân viên-----------------------+");
		System.out.println("|  mã số  |   tên NV   |ngày sinh   | lương  ");
		for (NhanVien nhanVien:arrayNhanVien) {
			System.out.println("|" +nhanVien.getMaSoNv() + "\t \t" +nhanVien.getTenNv() + "\t \t"
					+ nhanVien.getNamSinh()+ nhanVien.getLuong());
		}
		System.out.println("================================");

	}
	public static void dsQuanLi() {
		System.out.println("+-------------------------Danh sách quản lí-----------------------+");
		System.out.println("|  mã số  |   tên NV   |ngày sinh   | lương  ");
		for (QuanLy quanLy:arrayQuanLy) {
			System.out.println("|" +quanLy.getMaSoNv() + "\t \t" +quanLy.getTenNv() + "\t \t"
					+ quanLy.getNamSinh()+ quanLy.getLuong());
		}
		System.out.println("================================");

	}
	public static void myMenu() {
		while (true) {
			System.out.println("+------LỰA CHỌN CHỨC NĂNG-------+");
			System.out.println("| 1. Thêm sinh viên             |");
			System.out.println("| 2. Danh sach sinh viên        |");
			System.out.println("| 3. Tốp sinh viên              |");
			System.out.println("| 4. Sắp xếp theo điểm TB       |");
			System.out.println("| 5. Sắp xếp theo tên           |");
			System.out.println("=================================");
			System.out.println("| 6. Kết thúc                   |");
			System.out.println("+-------------------------------+");
			int option = myScanner.nextInt();
			if (option == 1) {
				themNv();
			}else if (option == 2) {
				dsSinhVien();
			} else if (option == 3) {
				topSinhVien();
			} else if (option == 4) {
				sapXepDtb();
			} else if (option == 5) {
				sortName();
			} else if (option == 6) {
				ketThuc();
			}
		}
	}
}
