
import java.util.Scanner;

public class phuongTrinhBacHai {
	public static Scanner input = new Scanner(System.in);
	public static String[] arrsv;
	public static String[] day;
	public static Double[] arrlp1;
	public static Double[] arrlp2;
	public static Double[] dtb;
	public static int sv, i, j, n = 0;
	public static int[] arrsortbyname;

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
		day = new String[sv];
		dtb = new Double[sv];

		input.nextLine();
		for (i = 1; i <= sv; i++) {
			System.out.println("Nhap ten sv thu " + i);
			arrsv[i - 1] = input.nextLine();
			System.out.println("Nhap diem lp1=:");
			arrlp1[i - 1] = input.nextDouble();
			System.out.println("Nhap diem lp2=:");
			arrlp2[i - 1] = input.nextDouble();
			System.out.println("Nhap ngay sinh=:");
			input.nextLine();
			day[i - 1] = input.nextLine();
			dtb[i - 1] = ((arrlp1[i - 1] + arrlp2[i - 1]) / 2);
		}
	}

	public static void in() {
		int i = 1;
		System.out.println(">>                            DANH SACH SINH VIEN                 <<");
		System.out
				.println("+------- ----------- ---------- ---------- -------- ------- ------- --------- - ------ ---+");
		System.out.println("stt ten lp1 lp2 dtb ngaysinh");
		for (i = 1; i <= sv; i++) {
			System.out.println((i) + " " + arrsv[i - 1] + " " + arrlp1[i - 1] + " " + arrlp2[i - 1] + " " + dtb[i - 1]
					+ " " + day[i - 1]);

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
		System.out.println("ten hoc sinh top 1 :" + arrsv[vitri - 1]);
	}

	public static void sapxep() {
		Double temp;
		String a;
		for (int i = 0; i < sv - 1; i++) {
			for (int j = i + 1; j < sv; j++) {
				if (dtb[i] < dtb[j]) {
					temp = dtb[i];
					dtb[i] = dtb[j];
					dtb[j] = temp;
					a = arrsv[i];
					arrsv[i] = arrsv[j];
					arrsv[j] = a;
					temp = arrlp1[i];
					arrlp1[i] = arrlp1[j];
					arrlp1[j] = temp;
					temp = arrlp2[i];
					arrlp2[i] = arrlp2[j];
					arrlp2[j] = temp;
					a = day[i];
					day[i] = day[j];
					day[j] = a;
				}
			}
		}
		System.out.println("Sap xep DONE!");
	}

	public static void ketThuc() {
		System.out.println("ket thuc!!!!!");
		System.exit(0);
	}

	public static void meNu() {
		while (true) {

			System.out.println(">>              MENU CUA TOI           <<");
			System.out.println("+----------------------------------------+");
			System.out.println("|1. Nhap danh sach sinh vien               |");
			System.out.println("|2. in danh sach sinh vien                 |");
			System.out.println("|3. top hoc sinh |");
			System.out.println("|4. sap xep abc  |");
			System.out.println("|5. ket thuc chuong trinh                  |");
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
				sapxep();
			} else {
				ketThuc();
			}
		}
	}

}
