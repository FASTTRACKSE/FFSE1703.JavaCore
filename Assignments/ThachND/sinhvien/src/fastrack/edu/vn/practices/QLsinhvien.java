package fastrack.edu.vn.practices;

import java.util.Scanner;
import java.util.ArrayList;
public class QLsinhvien {
	public static SinhVien arrSv[] = new SinhVien[100];
	public static Scanner myInput = new Scanner(System.in);
	public static ArrayList<SinhVien> arr = new ArrayList<>();
	private static int a;
	public static int i;
	public static int sortDTB[];
	public static int sortName[];
	public static void main(String[] args) {
		myMenu();

	}

	public static void nhapten() {
		System.out.println("<=====NHAP SINH VIEN=====>");
		System.out.println("Nhap so luong");
		a = Integer.parseInt(myInput.nextLine());
		for (int i = 0; i < a; i++) {
			
			
			System.out.println("Nhập Họ Và Tên Sinh Viên");
			String ten = myInput.nextLine();
			System.out.println("Nhap Ngay Sinh");
			String ngaysinh = myInput.nextLine();
			System.out.println("Nhap Diem LP1");
			double diem1 = Double.parseDouble(myInput.nextLine());
			System.out.println("Nhap Diem LP2");
			double diem2 = Double.parseDouble(myInput.nextLine());
			
			arr.add(new SinhVien(ten,ngaysinh,diem1,diem2));
			
		}

	}

	public static void in() {
		System.out.println(" Name   " + "\t" + "\t" + "Date" + "\t" + "\t" + "DiemLP1" + "\t" + "\t" + "DiemLP2" + "\t"
				+ "\t" + "DiemTB");

		for (SinhVien x : arr) {
			System.out.println((i + 1) + " " + x.getSvName() + "\t" + x.getSvDate() + "\t" + "\t"
					+ x.getSvDiemlp1() + "\t" + "\t" + x.getSvDiemlp2() + "\t" + "\t" + x.getSvDiemtb());
		}
	}
	
	public static void suaten() {
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
		

	public static void xoaten() {
		System.out.println("Nhập tên cần xóa: ");
		String ten = myInput.nextLine();
		for(int i = 0; i < arr.size(); i++);
		for(SinhVien x : arr) {
			if ((x.getSvName()).equals(ten)) {
				arr.remove(x);
				break;
			}
		}
	}
	public static void timkiem() {
		System.out.println("<----TÌM KIẾM SINH VIÊN---->");
		System.out.println("Nhập tên cần tìm kiếm: ");
		String ten = myInput.nextLine();
		
		for(SinhVien x : arr) {
			if ((x.getSvName()).equals(ten)) {
				System.out.println((i + 1) + " " + x.getSvName() + "    " + "\t" + x.getSvDate() + "\t"
						+ x.getSvDiemlp1() + "\t" + "\t" + x.getSvDiemlp2() + "\t" + "\t"
						+ x.getSvDiemtb());
			}
		}
	}

	public static void ketthuc() {
		System.exit(0);
	}

	public static void myMenu() {
		while (true) {
			System.out.println("<======LỰA CHỌN CHỨC NĂNG======>");
			System.out.println("|| 1.NHẬP TÊN SINH VIÊN   \t||");
			System.out.println("|| 2.IN TÊN SINH VIÊN     \t||");
			System.out.println("|| 3.SỬA TÊN SINH VIÊN    \t||");
			System.out.println("|| 4.XÓA TÊN SINH VIÊN    \t||");
			System.out.println("|| 5.TÌM KIÊM SINH VIÊN	  \t||");
			System.out.println("|| 0.KẾT THÚC CHƯƠNG TRÌNH\t||");
			System.out.println("<===============================>");
			System.out.println("      LỰA CHỌN CỦA BẠN        ");
			int option = Integer.parseInt(myInput.nextLine());
			if (option == 1) {
				nhapten();
			} else if (option == 2) {
				in();
			} else if (option == 3) {
				suaten();
			} else if (option == 4) {
				xoaten();
			} else if (option == 5) {
				timkiem();
			} else if (option == 0) {
				ketthuc();
			} else {
                try {
					throw new Exception();
				} catch (Exception e) {
					System.out.println("Chỉ nhập từ 1->5");
				}
			}
		} 
	}
}
