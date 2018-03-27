package fasttrackse.edu.vn;

import java.util.Scanner;

public class menu {
	public static Scanner input = new Scanner(System.in);
	public static qlysv sv = new qlysv();
	public static qlysv[] danhsachsv;
	public static int n, i;

	public static void main(String[] args) {
		meNu();
	}

	public static void meNu() {
		while (true) {
			System.out.println(">>              MENU CUA TOI           <<");
			System.out.println("+----------------------------------------+");
			System.out.println("|1. Nhap danh sach sinh vien             |");
			System.out.println("|2. in danh sach sinh vien               |");
			System.out.println("|3. top hoc sinh                         |");
			System.out.println("|4. sap xep                              |");
			System.out.println("|5. ket thuc chuong trinh                |");
			System.out.println("+----------------------------------------+");
			System.out.println(">>            BAN CHON SO MAY?          <<");
			int a;
			a = input.nextInt();
			if (a == 1) {
				System.out.println("Nhap Vao So Luong SV");
				n = input.nextInt();
				danhsachsv = new qlysv[n];
				for (int i = 0; i < danhsachsv.length; i++) {
					danhsachsv[i] = new qlysv();// tao o nho de luu tt sv
					danhsachsv[i].nhaptt();
				}
			} else if (a == 2) {
				hienthi();
			} else if (a == 3) {
				top();
			} else if (a == 4) {
				sapxep();
			} else if (a == 5) {
			}
		}
	}

	public static void hienthi() {
		System.out.println(">>                   DANH SACH SINH VIEN		         <<");
		System.out.println("+------- ----------- ---------- ---------- -------- ------- ------- ----+");
		System.out.println("stt		ten		lp1		lp2		dtb		xeploai");
		for (int i = 0; i < danhsachsv.length; i++) {
			System.out.print((i + 1) + "		" + danhsachsv[i].getHoten() + "		" + danhsachsv[i].getLp1()
					+ "		" + danhsachsv[i].getLp2() + "		" + danhsachsv[i].dtb());
			danhsachsv[i].xeploai();
			System.out.print("\n");
		}

	}

	public static void top() {
		Double max = danhsachsv[0].dtb();
		int vitri = 1;
		for (i = 0; i < n; i++) {
			if (max < danhsachsv[i].dtb()) {
				max = danhsachsv[i].dtb();
				vitri = i;
			}
		}
		System.out.println("Học sinh có kết quả học tập cao nhất là :" + "**" + danhsachsv[vitri].getHoten() + "**");

	}

	public static void sapxep() {
		qlysv[] temp = new qlysv[n];
		for (i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (danhsachsv[i].dtb() < danhsachsv[j].dtb()) {
					temp[i] = danhsachsv[j];
					danhsachsv[j] = danhsachsv[i];
					danhsachsv[i] = temp[i];
				}
			}
		}

	}
}
