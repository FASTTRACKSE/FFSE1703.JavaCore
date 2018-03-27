package assignment3;

import java.util.Scanner;

public class dsSinhVien {
	public static Scanner myScanner = new Scanner(System.in);
	public static String[] tenSv= {"Ngô Minh Tuấn","Phạm Văn Quý","Hồ Thanh Nhân","Tống Lê Quốc Đạt"};
	public static String[] ngaySinh= {"18/08/1999","28/05/199","04/02/1998","06/03/1996"};
	public static Double[] lp1 = {9.0,7.0,9.0,5.0};
	public static Double[] lp2 = {8.0,7.0,9.0,7.0};
	public static Double[] đTb = {8.5,7.0,9.0,6.0};
	public static Double[] viTri;
	public static int size = 4;

	public static void main(String[] args) {
		myMenu();

	}

	public static void themSv() {
		System.out.println("Thêm sinh viên");
		int size;
		System.out.print("Nhap vao so số sinh viên cần thêm : ");
		size = myScanner.nextInt();
		tenSv = new String[size];
		ngaySinh = new String[size];
		lp1 = new Double[size];
		lp2 = new Double[size];
		đTb = new Double[size];
		for (int i = 0; i < size; i++) {
			myScanner.nextLine();
			System.out.println("Nhập tên sinh viên thứ " + (i + 1) + " :");
			tenSv[i] = myScanner.nextLine();
			System.out.println("Nhập ngày sinh sinh viên thứ " + (i + 1) + " :");
			ngaySinh[i] = myScanner.nextLine();
			System.out.println("Nhập điểm lp1 sinh viên thứ " + (i + 1) + " :");
			lp1[i] = myScanner.nextDouble();
			System.out.println("Nhập điểm lp2 sinh viên thứ " + (i + 1) + " :");
			lp2[i] = myScanner.nextDouble();
			đTb[i] = (lp1[i] + lp2[i]) / 2;
			System.out.println("Nhấn Enter để tiếp tục");
			System.out.println("______________________________");
			myScanner.nextLine();

		}
	}

	public static void dsSinhVien() {
		System.out.println("+--------------Danh sách sinh viên--------------+");
		System.out.println("|tên SV        |  ngày sinh |  lp1    |  lp2     |  ĐTB      |");
		for (int i = 0; i < size; i++) {
			System.out.println("|" + tenSv[i] + "            " + ngaySinh[i] + "      " + lp1[i] + "        "+ lp2[i] + "         " + đTb[i]);
		}
		System.out.println("================================");
		System.out.println("Nhấn Enter để về menu");
		myScanner.nextLine();

		myScanner.nextLine();
	}

	public static void topSinhVien() {
		System.out.println("Danh sách tốp sinh viên");
		Double max = đTb[0], min = đTb[0];
		int vtmax = 0, vtmin = 0;
		for (int i = 0; i < tenSv.length; i++) {
			if (max < đTb[i]) {
				max = đTb[i];
				vtmax = i;
			}
			if (min > đTb[i]) {
				min = đTb[i];
				vtmin = i;
			}
		}
		System.out.println("+---------Sinh viên có điểm trung bình cao nhất-------+");
		System.out.println("|Tên sinh viên    |  ngày sinh      |    Điểm trung bình    |");
		System.out.println("|" + tenSv[vtmax] + "               " + ngaySinh[vtmax] + "                   " + max);
		System.out.println("+---------Sinh viên có điểm trung bình thấp nhất-------+");
		System.out.println("|Tên sinh viên    |  ngày sinh      |    Điểm trung bình    |");
		System.out.println("|" + tenSv[vtmin] + "        " + ngaySinh[vtmin] + "                   " + min);
		System.out.println("Nhấn Enter để về menu");
		myScanner.nextLine();
		System.out.println("============================================================");
		myScanner.nextLine();
	}

	public static void sapXepDtb() {
		
		System.out.println("+--------------Danh sách ss sinh viên--------------+");
		System.out.println("|tên SV                  |          ĐTB         |");
		for (int i = 0; i < đTb.length - 1; i++) {
			for (int j = i + 1; j < đTb.length; j++) {
				if (đTb[i] < đTb[j]) {
					Double temp;
					temp = đTb[j];
					đTb[j] = đTb[i];
					đTb[i] = temp;
					
					temp = lp1[j];
					lp1[j] = lp1[i];
					lp1[i] = temp;
					
					temp = lp2[j];
					lp2[j] = lp2[i];
					lp2[i] = temp;
					
					String temps;
					temps = tenSv[j];
					tenSv[j] = tenSv[i];
					tenSv[i] = temps;
					
					temps = ngaySinh[j];
					tenSv[j] = tenSv[i];
					tenSv[i] = temps;
				}
			}
			
		}
		for (int i = 0; i < size; i++) {
			System.out.println("|" + tenSv[i] + "            " + ngaySinh[i] + "      " + lp1[i] + "        "+ lp2[i] + "         " + đTb[i]);
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
