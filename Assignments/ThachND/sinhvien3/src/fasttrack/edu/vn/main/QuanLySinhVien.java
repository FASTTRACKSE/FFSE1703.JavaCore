package fasttrack.edu.vn.main;

import fasttrack.edu.vn.model.SinhVien;
import fasttrack.edu.vn.io.SerializeFileFactory;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class QuanLySinhVien {
	public static QuanLySinhVien arrSv[] = new QuanLySinhVien[100];
	public static Scanner myInput = new Scanner(System.in);
	public static ArrayList<SinhVien> arr = new ArrayList<SinhVien>();
	private static int a;
	public static int i;
	public static int sortDTB[];
	public static int sortName[];

	public static void main(String[] args) {
		File file = new File("D:/FFSE1703.JavaCore/Assignments/ThachND/sinhvien3/dulieusinhvien.txt");
		if (file.exists()) {
			ArrayList<SinhVien> arrSvFile = SerializeFileFactory.docFile("dulieusinhvien.txt");
			arr = arrSvFile;
		}
		myMenu();

	}

	public static void nhapTen() {
		String ten;
		String ngaySinh;
		double diem1;
		double diem2;
		int t;
		System.out.println("<=====NHAP SINH VIEN=====>");
		System.out.println("Nhập số lượng");
	    t =myInput.nextInt();
		
		try {
			
			for (int i = 0; i < t; i++) {
				myInput.nextLine();
				System.out.println("Nhập Họ Và Tên Sinh Viên");
				 ten = myInput.nextLine();
				System.out.println("Nhap Ngay Sinh");
				 ngaySinh = myInput.nextLine();
				System.out.println("Nhap Diem LP1");
				 diem1 = Double.parseDouble(myInput.nextLine());
				System.out.println("Nhap Diem LP2");
				 diem2 = Double.parseDouble(myInput.nextLine());
				arr.add(new SinhVien(ten, ngaySinh, diem1, diem2));
			}
				boolean checked = SerializeFileFactory.luuFile(arr, "dulieusinhvien.txt");
				if (checked == true) {
					System.out.println("Đã lưu thông tin của " + t + " sinh viên");
				} else {
					System.out.println("Lưu thất bại");
				}

		} catch (Exception e) {
			System.out.println("         Nhập sai định dạng !!!");
			System.out.println("         Vui lòng nhập lại");
		}

	}

	public static void in() {
		System.out.println(" Name   " + "\t" + "\t" + "Date" + "\t" + "\t" + "DiemLP1" + "\t" + "\t" + "DiemLP2" + "\t"
				+ "\t" + "DiemTB");

		for (SinhVien x : arr) {
			System.out.println((i + 1) + " " + x.getSvName() + "\t" + x.getSvDate() + "\t" + "\t" + x.getSvDiemlp1()
					+ "\t" + "\t" + x.getSvDiemlp2() + "\t" + "\t" + x.getSvDiemtb());
		}
	}

	public static void docFile() {
		int i = 1;
		
		System.out.println("Danh sách sinh viên nhập vào là: ");
		System.out.println("STT " + " \t " + " Name " + "\t" + "Date " + "\t" + "\t" + "DiemLP1" + "\t" + "\t" + "DiemLP2" + "\t"
				+ "\t" + "DiemTB");
		for (SinhVien x : arr) {
			System.out.print((i++) + "\t");
			System.out.printf("%5s %5s %-15s %-10s %10s  \n", x.getSvName(), x.getSvDate(), x.getSvDiemlp1(),
					x.getSvDiemlp2(), x.getSvDiemtb());
		}
	}

	public static void suaTen() {
		System.out.println("Nhập tên cần sửa: ");
		String ten = myInput.nextLine();
		System.out.println("Nhập tên mới: ");
		String newten = myInput.nextLine();
		for (SinhVien x : arr) {
			if ((x.getSvName()).equals(ten)) {
				x.setSvName(newten);
			}
		}
	}

	public static void xoaTen() {
		System.out.println("Nhập tên cần xóa: ");
		String ten = myInput.nextLine();
		for (int i = 0; i < arr.size(); i++)
			;
		for (SinhVien x : arr) {
			if ((x.getSvName()).equals(ten)) {
				arr.remove(x);
				break;
			}
		}
	}

	public static void timKiem() {
		System.out.println("<----TÌM KIẾM SINH VIÊN---->");
		System.out.println("Nhập tên cần tìm kiếm: ");
		String ten = myInput.nextLine();

		for (SinhVien x : arr) {
			if ((x.getSvName()).equals(ten)) {
				System.out.println((i + 1) + " " + x.getSvName() + "    " + "\t" + x.getSvDate() + "\t"
						+ x.getSvDiemlp1() + "\t" + "\t" + x.getSvDiemlp2() + "\t" + "\t" + x.getSvDiemtb());
			}
		}
	}

	public static void ketThuc() {
		System.exit(0);
	}

	public static void myMenu() {
		while (true) {
			System.out.println("<======LỰA CHỌN CHỨC NĂNG======>");
			System.out.println("|| 1.NHẬP TÊN SINH VIÊN   \t||");
			System.out.println("|| 2.IN TÊN SINH VIÊN     \t||");
			System.out.println("|| 3.ĐỌC FILE SINH VIÊN   \t||");
			System.out.println("|| 4.SỬA TÊN SINH VIÊN    \t||");
			System.out.println("|| 5.XÓA TÊN SINH VIÊN    \t||");
			System.out.println("|| 6.TÌM KIÊM SINH VIÊN	  \t||");
			System.out.println("|| 0.KẾT THÚC CHƯƠNG TRÌNH\t||");
			System.out.println("<===============================>");
			System.out.println("      LỰA CHỌN CỦA BẠN        ");
			int option = Integer.parseInt(myInput.nextLine());
			if (option == 1) {
				nhapTen();
			} else if (option == 2) {
				in();
			} else if (option == 3) {
				docFile();
			} else if (option == 4) {
				suaTen();
			} else if (option == 5) {
				xoaTen();
			} else if (option == 6) {
				timKiem();
			} else if (option == 0) {
				ketThuc();
			} else {
				try {
					throw new Exception();
				} catch (Exception e) {
					System.out.println("Chỉ nhập từ 1->6");
				}
			}
		}
	}
}
