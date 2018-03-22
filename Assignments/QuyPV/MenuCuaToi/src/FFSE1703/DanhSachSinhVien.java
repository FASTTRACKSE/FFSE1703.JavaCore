package FFSE1703;

import java.util.Scanner;

public class DanhSachSinhVien {

	public static Scanner myInput = new Scanner(System.in);
	public static int soLuong;
	public static String arrHoTen[];
	public static double arrDiemLP1[];
	public static double arrDiemLP2[];
	public static double arrDTB[];

	public static void main(String[] args) {
		myMenu();

	}

	public static void myMenu() {
		System.out.println("---  lỰA CHỌN CHỨC NĂNG  ---");
		System.out.println("____________________________" + "\n");
		System.out.println("1. Nhập thông tin sinh viên.");
		System.out.println("2. In thông tin sinh viên.");
		System.out.println("3. Top sinh viên.");
		System.out.println("4. Kết thúc.");
		System.out.println("____________________________" + "\n");
		while (true) {
			System.out.print("Nhập lựa chọn của bạn: ");
			int myChose = myInput.nextInt();
			if (myChose == 1) {
				nhap();
			} else if (myChose == 2) {
				in();
			} else if (myChose == 3) {
				top();
			} else if (myChose == 4) {
				ketThuc();
			}
		}
	}

	public static void nhap() {
		System.out.print("Vui lòng nhập số lượng sinh viên: ");
		soLuong = myInput.nextInt();
		arrHoTen = new String[soLuong];
		arrDiemLP1 = new double[soLuong];
		arrDiemLP2 = new double[soLuong];
		arrDTB = new double[soLuong];
		for (int i = 0; i < soLuong; i++) {
			myInput.nextLine();
			System.out.println("Nhập tên sinh viên");
			arrHoTen[i] = myInput.nextLine();
			System.out.println("Nhập điểm LP1");
			arrDiemLP1[i] = myInput.nextDouble();
			System.out.println("Nhập điểm LP2");
			arrDiemLP2[i] = myInput.nextDouble();

			arrDTB[i] = (arrDiemLP1[i] + arrDiemLP2[i]) / 2;
		}

	}

	public static void in() {
		System.out.println("STT        " + "Họ Và tên       " + "Điểm LP1         " + "Điểm LP2         " + "ĐTB");
		for (int i = 0; i < soLuong; i++) {

			System.out.println((i + 1) + "     " + arrHoTen[i] + "            " + arrDiemLP1[i] + "                "
					+ arrDiemLP2[i] + "                " + arrDTB[i]);
		}
	}

	public static void top() {
		double max, min;
		int vtMax, vtMin;

		max = arrDTB[0];
		min = arrDTB[0];

		vtMax = 0;
		vtMin = 0;
		for (int i = 1; i < soLuong; i++) {

			if (max < arrDTB[i]) {
				max = arrDTB[i];
				vtMax = i;

			}
			if (min > arrDTB[i]) {
				min = arrDTB[i];
				vtMin = i;
			}

		}
		System.out.println("Sinh viên có số điểm cao nhất: " + arrHoTen[vtMax] + " với " + max);
		System.out.println("Sinh viên có số điểm thấp nhất: " + arrHoTen[vtMin] + " với " + min);

	}

	public static void ketThuc() {
		System.out.println("Cảm ơn bạn đã sử dụng chương trình của chúng tôi!!!");
		System.exit(0);
	}

}
