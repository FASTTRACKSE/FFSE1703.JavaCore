package Student2;

import java.util.Scanner;

public class importStudent {
	public static int size;
	public static myStudent[] Student = new myStudent[100];
	public static Scanner myScanner = new Scanner(System.in);

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		myMenu();

	}

	public static void themSv() {
		System.out.print("Nhap vao so số sinh viên cần thêm : ");
		size = myScanner.nextInt();

		for (int i = 0; i < size; i++) {
			Student[i] = new myStudent();
		}
		for (int i = 0; i < size; i++) {

			myScanner.nextLine();
			System.out.println("Nhập tên sinh viên thứ " + (i + 1) + " :");
			Student[i].setName(myScanner.nextLine());
			System.out.println("Nhập ngày sinh sinh viên thứ " + (i + 1) + " :");
			Student[i].setBirthday(myScanner.nextLine());
			System.out.println("Nhập điểm lp1 sinh viên thứ " + (i + 1) + " :");
			Student[i].setLp1(myScanner.nextDouble());
			System.out.println("Nhập điểm lp2 sinh viên thứ " + (i + 1) + " :");
			Student[i].setLp2(myScanner.nextDouble());
			System.out.println("Nhấn Enter để tiếp tục");
			System.out.println("______________________________");
			myScanner.nextLine();

		}
	}

	public static void dsSinhVien() {
		System.out.println("+-------------------------Danh sách sinh viên-----------------------+");
		System.out.println("|tên SV    |   ngày sinh   |  lp1   |  lp2  |  ĐTB  | xếp loại");
		for (int i = 0; i < size; i++) {
			System.out.println("|" + Student[i].getName() + "\t \t" + Student[i].getBirthday() + "\t \t"
					+ Student[i].getLp1() + " \t" + Student[i].getLp2() + "\t" + Student[i].getDtb() + "\t"
					+ Student[i].getXepLoai());
		}
		System.out.println("================================");

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
		System.out.println("|Tên sinh viên    |  ngày sinh      |    Điểm trung bình    |");
		System.out.println("|" + Student[vtmax].getName() + "\t" + Student[vtmax].getBirthday() + "\t" + max);
		System.out.println("+---------Sinh viên có điểm trung bình thấp nhất-------+");
		System.out.println("|Tên sinh viên    |  ngày sinh      |    Điểm trung bình    |");
		System.out.println("|" + Student[vtmin].getName() + "\t" + Student[vtmin].getBirthday() + "\t" + min);
		System.out.println("Nhấn Enter để về menu");
		myScanner.nextLine();
		System.out.println("============================================================");
		myScanner.nextLine();
	}

	public static void sapXepDtb() {

		System.out.println("+--------------Danh sách ss sinh viên--------------+");
		System.out.println("|tên SV                  |          ĐTB         |");
		for (int i = 0; i < size - 1; i++) {
			for (int j = i + 1; j < size; j++) {
				if (Student[i].getDtb() < Student[j].getDtb()) {
					myStudent[] temp = new myStudent[100];
					temp[i] = Student[j];
					Student[j] = Student[i];
					Student[i] = temp[i];
				}
			}

		}
		System.out.println("|tên SV    |   ngày sinh   |  lp1   |  lp2  |  ĐTB  | xếp loại");
		for (int i = 0; i < size; i++) {
			System.out.println("|" + Student[i].getName() + "\t \t" + Student[i].getBirthday() + "\t \t"
					+ Student[i].getLp1() + " \t" + Student[i].getLp2() + "\t" + Student[i].getDtb() + "\t"
					+ Student[i].getXepLoai());
		}
	}

	public static void ketThuc() {
		System.out.println("Cám ơn bạn đã sử dụng chương trình");
		System.exit(0);
	}

	public static void myMenu() {
		while (true) {
			System.out.println("+------LỰA CHỌN CHỨC NĂNG-------+");
			System.out.println("| 1. Thêm sinh viên             |");
			System.out.println("| 2. Danh sach sinh viên        |");
			System.out.println("| 3. Tốp sinh viên              |");
			System.out.println("| 4. Sắp xếp theo điểm TB       |");
			System.out.println("=================================");
			System.out.println("| 5. Kết thúc                   |");
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
				ketThuc();
			}

		}
	}
}
