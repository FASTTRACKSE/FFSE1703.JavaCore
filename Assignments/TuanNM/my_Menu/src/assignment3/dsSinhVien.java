package assignment3;

import java.util.Scanner;

public class dsSinhVien {
	public static Scanner myScanner = new Scanner(System.in);
	public static String[] tenSv;
	public static Double[] lp1, lp2,đTb;

	public static void main(String[] args) {
		myMenu();

	}

	public static void themSv() {
		System.out.println("Thêm sinh viên");
		int size;
		System.out.print("Nhap vao so số sinh viên cần thêm : ");
		size = myScanner.nextInt();
		tenSv = new String[size];
		lp1 = new Double[size];
		lp2 = new Double[size];
		đTb = new Double[size];
		for (int i = 0; i < size; i++) {
			myScanner.nextLine();
			System.out.println("Nhap nhập tên sinh viên thứ " + (i + 1) + " :");
			tenSv[i] = myScanner.nextLine();
			System.out.println("Nhap nhập điểm lp1 sinh viên thứ " + (i + 1) + " :");
			lp1[i] = myScanner.nextDouble();
			System.out.println("Nhap nhập điểm lp2 sinh viên thứ " + (i + 1) + " :");
			lp2[i] = myScanner.nextDouble();
			đTb[i] = (lp1[i]+lp2[i])/2;
			System.out.println("Nhấn Enter để tiếp tục");
			System.out.println("______________________________");
			myScanner.nextLine();
			myScanner.nextLine();
		}
	}

	public static void dsSinhVien() {
		System.out.println("+--------------Danh sách sinh viên--------------+");

		System.out.println("|tên SV        |  lp1    |  lp2     |  ĐTB      |");
		for (int i = 0; i < tenSv.length; i++) {
			System.out.println("|"+tenSv[i] + "            " + lp1[i] +"           "+ lp2[i]+"         "+đTb[i]);
		}
		System.out.println("================================");
		System.out.println("Nhấn Enter để về menu");
		myScanner.nextLine();

		myScanner.nextLine();
	}

	public static void topSinhVien() {
		System.out.println("Danh sách tốp sinh viên");
		Double max = đTb[0];
		int vtmax =0;
		for(int i = 0;i < tenSv.length;i++) {
			if(max < đTb[i]) {
				max= đTb[i];
				vtmax =i;
			}
		}
		System.out.println("+---------Sinh viên có điểm trung bình cao nhất-------+");
		System.out.println("|Tên sinh viên                |    Điểm trung bình    |");
		System.out.println("|"+tenSv[vtmax]+"                           "+max);
		System.out.println("Nhấn Enter để về menu");
		myScanner.nextLine();
		System.out.println("================================");
		myScanner.nextLine();
	}

	public static void ketThuc() {
		System.out.println("Cám ơn bạn đã suử dụng chương trình");
		System.exit(0);
	}

	public static void myMenu() {
		while (true) {
			System.out.println("+------LỰA CHỌN CHỨC NĂNG------+");
			System.out.println("| 1. Thêm sinh viên             |");
			System.out.println("| 2. Danh sach sinh viên        |");
			System.out.println("| 3. Tốp sinh viên              |");
			System.out.println("=================================");
			System.out.println("| 4. Kết thúc                   |");
			System.out.println("+-------------------------------|");
			int option = myScanner.nextInt();
			if (option == 1) {
				themSv();
			} else if (option == 2) {
				dsSinhVien();
			} else if (option == 3) {
				topSinhVien();
			} else if (option == 4) {
				ketThuc();
			}
		}
	}

}
