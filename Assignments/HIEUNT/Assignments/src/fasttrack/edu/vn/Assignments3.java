package fasttrack.edu.vn;

import java.util.Scanner;

public class Assignments3 {
	public static Scanner input = new Scanner(System.in);
	public static String[] arrsv;
	public static Double[] arrlp1;
	public static Double[] arrlp2;
	public static Double[] dtb;
	public static int sv, i = 0;

	public static void main(String[] args) {
		meNu();
	}

	public static void nhapten() {
		System.out.println("nhap tong so sinh vien:");
		sv = input.nextInt();
		int i;
		arrsv = new String[sv];
		arrlp1 = new Double[sv];
		arrlp2 = new Double[sv];
		dtb = new Double[sv];
		for (i = 1; i <= sv; i++) {
			input.nextLine();
			System.out.println("Nhap ten sv thu " + i);
			arrsv[i - 1] = input.nextLine();
			System.out.println("Nhap diem lp1=:");
			arrlp1[i - 1] = input.nextDouble();
			System.out.println("Nhap diem lp2=:");
			arrlp2[i - 1] = input.nextDouble();

		}
	}

	public static void in() {
		int i = 1;
		System.out.println(">>                   DANH SACH SINH VIEN		         <<");
		System.out.println("+------- ----------- ---------- ---------- -------- ------- ------- ----+");
		System.out.println("stt		ten		lp1		lp2		dtb");
		for (i = 1; i <= sv; i++) {
			dtb[i - 1] = ((arrlp1[i - 1] + arrlp2[i - 1]) / 2);
			System.out.println((i) + "		" + arrsv[i - 1] + "		" + arrlp1[i - 1] + "		" + arrlp2[i - 1]
					+ "		" + dtb[i - 1]);

		}

	}

	public static void top() {
		Double max = dtb[0];
		int vitri = 1;
		for (i = 1; i <= sv; i++) {
			if (max < dtb[i - 1]) {
				max = dtb[i - 1];
				vitri = i;
			}
		}
		System.out.println(arrsv[vitri - 1]);
	}

	public static void ketThuc() {
		System.out.println("Kết thúc chương trình!!!!!");
		System.exit(0);
	}

	public static void meNu() {
		while (true) {

			System.out.println(">>              MENU CUA TOI           <<");
			System.out.println("+----------------------------------------+");
			System.out.println("|1. Nhap danh sach sinh vien               |");
			System.out.println("|2. in danh sach sinh vien |");
			System.out.println("|3. top hoc sinh |");
			System.out.println("|4. ket thuc chuong trinh                |");
			System.out.println("+----------------------------------------+");
			System.out.println(">>            chon di?         <<");
			int a;
			a = input.nextInt();
			if (a == 1) {
				nhapten();
			} else if (a == 2) {
				in();
			} else if (a == 3) {
				top();
			} else if (a == 4) {
				ketThuc();
			}
		}
	}

}
