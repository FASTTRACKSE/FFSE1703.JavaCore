package fasttrack.edu.vn.mycar;

import java.util.Scanner;

public class Qlsinhvien {
	public static Sinhvien arrSv[] = new Sinhvien[100];
	public static Scanner myInput = new Scanner(System.in);
	public static int a;

	public static void main(String[] args) {
		myMenu();

	}

	public static void nhapten() {
		System.out.println("<=====NHAP SINH VIEN=====>");
		System.out.println("Nhap so luong");
		a = myInput.nextInt();
		for (int i = 0; i < a; i++) {
			arrSv[i] = new Sinhvien();
			myInput.nextLine();
			System.out.println("Nhap Ho Va Ten Sinh Vien");
			arrSv[i].setSvName(myInput.nextLine());
			System.out.println("Nhap Ngay Sinh");
			arrSv[i].setSvDate(myInput.nextLine());
			System.out.println("Nhap Diem LP1");
			arrSv[i].setSvDiemlp1(myInput.nextDouble());
			System.out.println("Nhap Diem LP2");
			arrSv[i].setSvDiemlp2(myInput.nextDouble());
		}

	}

	public static void topsinhvien() {

	}

	public static void indanhsach() {
		System.out.println("   Name         " + "\t" + "Date" + "\t" + "\t" + "DiemLP1" + "\t" + "\t" + "DiemLP2" + "\t"
				+ "\t" + "DiemTB");
		for (int i = 0; i < a; i++) {
			System.out.println((i + 1) + " " + arrSv[i].getSvName() + "    " + "\t" + arrSv[i].getSvDate() + "\t"
					+ arrSv[i].getSvDiemlp1() + "\t" + "\t" + arrSv[i].getSvDiemlp2() + "\t" + "\t"
					+ arrSv[i].getSvDiemtb());
		}
	}

	public static void sapxep() {

	}

	public static void sapxepten() {

	}

	public static void ketthuc() {
		System.exit(0);
	}

	public static void myMenu() {
		while (true) {
			System.out.println("<=====LUA CHON CHUC NANG=====>");
			System.out.println("|| 1.NHAP TEN SINH VIEN      ||");
			System.out.println("|| 2.DANH SACH SINH VIEN     ||");
			System.out.println("|| 3.SAP XEP TU CAO DEN THAP ||");
			System.out.println("|| 4.KET THUC CHUONG TRINH   ||");
			System.out.println("<============================>");
			System.out.println("      LUA CHON CUA BAN        ");
			int option = myInput.nextInt();
			if (option == 1) {
				nhapten();
			} else if (option == 2) {
				indanhsach();
			} else if (option == 3) {
				sapxep();
			} else if (option == 4) {
				ketthuc();
			}
		}
	}
}
