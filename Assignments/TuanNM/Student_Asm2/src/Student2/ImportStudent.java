package Student2;

import java.util.Scanner;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class ImportStudent {

	public static int size;
	public static SinhVien[] Student = new SinhVien[100];
	public static Scanner myScanner = new Scanner(System.in);
	static ArrayList<SinhVien> arrStudent = new ArrayList<SinhVien>();

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		myMenu();
	}

	public static void themSv() {
		System.out.print("Nhap vao so số sinh viên cần thêm : ");
		size = myScanner.nextInt();

		for (int i = 0; i < size; i++) {
			Student[i] = new SinhVien();
		}
		for (int i = 0; i < 15; i++) {
			try {
				myScanner.nextLine();
				System.out.println("Nhập tên sinh viên thứ " + (i + 1) + " :");
				String ten = myScanner.nextLine();
				Student[i].setName(ten);
				System.out.println("Nhập ngày sinh sinh viên thứ " + (i + 1) + " :");
				String ngaySinh = myScanner.nextLine();
				Student[i].setBirthday(ngaySinh);
				System.out.println("Nhập điểm lp1 sinh viên thứ " + (i + 1) + " :");
				Double lP1 = myScanner.nextDouble();
				Student[i].setLp1(lP1);
				System.out.println("Nhập điểm lp2 sinh viên thứ " + (i + 1) + " :");
				Double lP2 = myScanner.nextDouble();
				Student[i].setLp2(lP2);
				System.out.println("Nhấn Enter để tiếp tục");
				System.out.println("______________________________");
				myScanner.nextLine();
				SinhVien.tongSo();
				arrStudent.add(new SinhVien(ten, ngaySinh, lP1, lP2));
			} catch (Exception e) {
				System.out.println("Nhập sai. vui lòng nhập lại");
				myScanner.nextLine();
				myScanner.nextLine();
			}
		}
	}

	public static void dsSinhVien() {
		System.out.println("Tong so sinh vien la: " + SinhVien.toTal);
		System.out.println("+-------------------------Danh sách sinh viên-----------------------+");
		System.out.println("|tên SV    |   ngày sinh   |  lp1   |  lp2  |  ĐTB  | xếp loại");
		for (SinhVien x : arrStudent) {
			System.out.println("|" + x.getName() + "\t \t" + x.getBirthday() + "\t \t" + x.getLp1() + " \t" + x.getLp2()
					+ "\t" + x.getDtb() + "\t" + x.getXepLoai());
		}
		System.out.println("============================================================");

	}

	public static void topSinhVien() {
		System.out.println("Danh sách tốp sinh viên");
		Double max = Student[0].getDtb(), min = Student[0].getDtb();
		int vtmax = 0, vtmin = 0;
		for (int i = 0; i < size; i++) {
			if (max < Student[i].getDtb()) {
				max = Student[i].getDtb();
				vtmax = i;
			}
			if (min > Student[i].getDtb()) {
				min = Student[i].getDtb();
				vtmin = i;
			}
		}
		System.out.println("+---------Sinh viên có điểm trung bình cao nhất-------+");
		System.out.println("|Tên sinh viên  |  ngày sinh   |  Điểm trung bình  |");
		System.out.println("|" + Student[vtmax].getName() + "\t\t" + Student[vtmax].getBirthday() + "\t\t" + max);
		System.out.println("+---------Sinh viên có điểm trung bình thấp nhất-------+");
		System.out.println("|Tên sinh viên  |  ngày sinh   |  Điểm trung bình  |");
		System.out.println("|" + Student[vtmin].getName() + "\t\t" + Student[vtmin].getBirthday() + "\t\t" + min);
		System.out.println("Nhấn Enter để về menu");
		myScanner.nextLine();
		System.out.println("============================================================");
		myScanner.nextLine();
	}

	public static void sapXepDtb() {

		System.out.println("+--------------Danh sách ss sinh viên--------------+");


		Collections.sort(arrStudent, SinhVien.SVDTBComparator);
		System.out.println("|tên SV    |   ngày sinh   |  lp1   |  lp2  |  ĐTB  | xếp loại");
		for (SinhVien x : arrStudent) {
			System.out.println("|" + x.getName() + "\t \t" + x.getBirthday() + "\t \t" + x.getLp1() + " \t" + x.getLp2()
					+ "\t" + x.getDtb() + "\t" + x.getXepLoai());
		}
	}

	public static void sortName() {

		System.out.println("+--------------Danh sách ss sinh viên--------------+");
	
		Collections.sort(arrStudent, SinhVien.SVNameComparator);
		System.out.println("|tên SV    |   ngày sinh   |  lp1   |  lp2  |  ĐTB  | xếp loại");
		for (SinhVien x : arrStudent) {
			System.out.println("|" + x.getName() + "\t \t" + x.getBirthday() + "\t \t" + x.getLp1() + " \t" + x.getLp2()
					+ "\t" + x.getDtb() + "\t" + x.getXepLoai());
		}
	}

	public static void chinhSuaTen() {
		myScanner.nextLine();
		System.out.println("Nhập tên cần chỉnh sửa:");
		String ten = myScanner.nextLine();
		System.out.println("Nhập tên mới:");
		String tenNew = myScanner.nextLine();
		for (SinhVien x : arrStudent) {
			if (ten.equals(x.getName())) {
				x.setName(tenNew);
			}
		}
	}

	public static void timKiem() {
		myScanner.nextLine();
		System.out.println("Nhập tên cần tìm kiếm:");
		String ten = myScanner.nextLine();
		System.out.println("+-------------------------Danh sách sinh viên-----------------------+");
		System.out.println("|tên SV    |   ngày sinh   |  lp1   |  lp2  |  ĐTB  | xếp loại");
		for (SinhVien x : arrStudent) {
			if (ten.equals(x.getName())) {
				System.out.println("|" + x.getName() + "\t \t" + x.getBirthday() + "\t \t" + x.getLp1() + " \t"
						+ x.getLp2() + "\t" + x.getDtb() + "\t" + x.getXepLoai());
			}
		}
	}

	public static void xoaTen() {
		myScanner.nextLine();
		System.out.println("Nhập tên cần xóa");
		String ten = myScanner.nextLine();
		for (int i = 0; i < arrStudent.size(); i++) {
			for (SinhVien x : arrStudent) {
				if (ten.equals(x.getName())) {
					arrStudent.remove(x);
					i--;
					break;
				}
			}
		}
	}

	public static void xoaToanBo() {
		try {
			System.out.println("+------BẠN MUỐN XÓA TOÀN BỘ-----+");
			System.out.println("| 1. Đồng ý                     |");
			System.out.println("| 2. Không và quay lai          |");
			System.out.println("=================================");

			int option = myScanner.nextInt();
			if (option == 1) {
				arrStudent.clear();
			} else if (option == 2) {
				myMenu();
			}
		} catch (Exception e) {
			System.out.println("Vui lòng chọn 1 hoặc 2, vui lòng nhậ lại.!!");
			myScanner.nextLine();
		}
	}
	

	public static void ketThuc() {
		System.out.println("Cám ơn bạn đã sử dụng chương trình");
		System.exit(0);
	}

	public static void myMenu() {
		while (true) {
			try {
				System.out.println("+------LỰA CHỌN CHỨC NĂNG-------+");
				System.out.println("| 1. Thêm sinh viên             |");
				System.out.println("| 2. Danh sach sinh viên        |");
				System.out.println("| 3. Tốp sinh viên              |");
				System.out.println("| 4. Sắp xếp theo điểm TB       |");
				System.out.println("| 5. Sắp xếp theo tên           |");
				System.out.println("| 6. Chỉnh sửa tên              |");
				System.out.println("| 7. Tìm Kiếm                   |");
				System.out.println("| 8. Xóa theo tên               |");
				System.out.println("| 9. Xóa toàn bộ                |");
				System.out.println("=================================");
				System.out.println("| 0. Kết thúc                   |");
				System.out.println("+-------------------------------+");
				int option = myScanner.nextInt();
				if (option == 1) {
					themSv();
				} else if (option == 2) {
					dsSinhVien();
				} else if (option == 3) {
					topSinhVien();
				} else if (option == 4) {
					sapXepDtb();
				} else if (option == 5) {
					sortName();
				} else if (option == 6) {
					chinhSuaTen();
				} else if (option == 7) {
					timKiem();
				} else if (option == 8) {
					xoaTen();
				} else if (option == 9) {
					xoaToanBo();
				} else if (option == 0) {
					ketThuc();
				}
			} catch (Exception e) {
				System.out.println("Lựa chọn của bạn chưa đúng. Vui lòng nhập lại!!");
				myScanner.nextLine();
				myScanner.nextLine();
			}
		}
	}
}
