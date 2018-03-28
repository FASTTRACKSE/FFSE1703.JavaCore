package FFSE1703;

import java.util.Scanner;

public class DanhSachSinhVien {

	public static Scanner myInput = new Scanner(System.in);
	public static int soLuong;
	public static String arrHoTen[];
	public static double arrDiemLP1[];
	public static double arrDiemLP2[];
	public static double arrDTB[];
	public static String arrNgaySinh[];
	public static int sortByDTB[];
	public static int sortByABC[];

	public static void main(String[] args) {

		myMenu();

	}

	public static void myMenu() {
		System.out.println("---  lỰA CHỌN CHỨC NĂNG  ---");
		System.out.println("____________________________" + "\n");
		System.out.println("1. Nhập thông tin sinh viên.");
		System.out.println("2. In thông tin sinh viên.");
		System.out.println("3. Top sinh viên.");
		System.out.println("4. Sắp xếp theo abc.");
		System.out.println("5. Xếp loại học lực.");
		System.out.println("6. Kết thúc.");
		System.out.println("____________________________" + "\n");
		while (true) {
			System.out.print("Nhập lựa chọn của bạn: ");
			int myChose = myInput.nextInt();
			if (myChose == 1) {
				nhap();
			} else if (myChose == 2) {
				inTheoDiemTB();
			} else if (myChose == 3) {
				top();
			} else if (myChose == 4) {
				inTheoABC();
			} else if (myChose == 5) {
				xepLoai();
			} else if (myChose == 6) {
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
		arrNgaySinh = new String[soLuong];
		for (int i = 0; i < soLuong; i++) {
			myInput.nextLine();
			System.out.println("Nhập tên sinh viên");
			arrHoTen[i] = myInput.nextLine();
			System.out.println("Nhập ngày tháng năm sinh");
			arrNgaySinh[i] = myInput.nextLine();
			System.out.println("Nhập điểm LP1");
			arrDiemLP1[i] = myInput.nextDouble();
			System.out.println("Nhập điểm LP2");
			arrDiemLP2[i] = myInput.nextDouble();

			arrDTB[i] = (arrDiemLP1[i] + arrDiemLP2[i]) / 2;
		}

	}

	public static void inTheoDiemTB() {
		sortByDTB = new int[soLuong];
		for (int i = 0; i < soLuong; i++) {
			sortByDTB[i] = i;
		}
		for (int i = 0; i < arrDTB.length - 1; i++) {
			for (int j = i + 1; j < arrDTB.length; j++) {
				// arrHoTen[i].compareTo(arrHoTen[j])
				if (arrDTB[sortByDTB[i]] > arrDTB[sortByDTB[j]]) {
					int temp = sortByDTB[j];
					sortByDTB[j] = sortByDTB[i];
					sortByDTB[i] = temp;

				}
			}
		}

		System.out.println("STT \t" + "Họ Và tên \t" + "Ngày sinh \t" + "Điểm LP1 \t" + "Điểm LP2 \t" + "ĐTB");
		for (int i = 0; i < soLuong; i++) {

			System.out.println((i + 1) + " \t" + arrHoTen[sortByDTB[i]] + " \t \t" + arrNgaySinh[sortByDTB[i]] + "\t"
					+ arrDiemLP1[sortByDTB[i]] + " \t\t" + arrDiemLP2[sortByDTB[i]] + " \t\t" + arrDTB[sortByDTB[i]]);
		}
	}

	public static void inTheoABC() {
		sortByABC = new int[soLuong];
		for(int i = 0; i < soLuong; i++) {
			sortByABC[i] = i;
		}
		
		for (int i = 0; i < soLuong - 1; i++) {
			for (int j = i + 1; j < soLuong; j++) {
				if (arrHoTen[sortByABC[i]].compareTo(arrHoTen[sortByABC[j]]) > 0) {
		
					int temp = sortByABC[i];
					sortByABC[i] = sortByABC[j];
					sortByABC[j] = temp;

				}
			}
		}

		System.out.println("STT \t" + "Họ Và tên \t" + "Ngày sinh \t" + "Điểm LP1 \t" + "Điểm LP2 \t" + "ĐTB");

		for (int i = 0; i < soLuong; i++) {

			System.out.println((i + 1) + " \t" + arrHoTen[sortByABC[i]] + " \t \t" + arrNgaySinh[sortByABC[i]] + "\t" + arrDiemLP1[sortByABC[i]]
					+ " \t\t" + arrDiemLP2[sortByABC[i]] + " \t\t" + arrDTB[sortByABC[i]]);
		}
	}
	
	public static void xepLoai() {
		int gioi, kha, trungBinh, yeu;
		gioi = 0;
		kha = 0;
		trungBinh = 0;
		yeu = 0;
		for(int i = 0; i < soLuong; i++) {
			if(arrDTB[i] >= 8.5) {
				gioi = i;
				System.out.println("Học sinh giỏi: " + arrHoTen[gioi]);
			}
			else if(arrDTB[i] >= 7 && arrDTB[i] < 8.5) {
				kha = i;
				System.out.println("Học sinh khá: " + arrHoTen[kha]);
			}
			else if(arrDTB[i] >= 5 && arrDTB[i] < 7) {
				trungBinh = i;
				System.out.println("Học sinh TB: " + arrHoTen[trungBinh]);
			}
			else if(arrDTB[i] < 5) {
				yeu = i;
				System.out.println("Học sinh yếu: " + arrHoTen[yeu]);
			}
		}
		
	}

	public static void sapXep() {
		double temp = arrDTB[0];
		for (int i = 0; i < arrDTB.length - 1; i++) {
			for (int j = i + 1; j < arrDTB.length; j++) {
				if (arrDTB[i] > arrDTB[j]) {
					temp = arrDTB[j];
					arrDTB[j] = arrDTB[i];
					arrDTB[i] = temp;
				}
			}
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
		for (int i = 0; i < soLuong; i++) {

			if (max == arrDTB[i]) {
				max = arrDTB[i];
				vtMax = i;
				System.out.println("Sinh viên có số điểm cao nhất: " + arrHoTen[vtMax] + " với " + max);
			}
			if (min == arrDTB[i]) {
				min = arrDTB[i];
				vtMin = i;
				System.out.println("Sinh viên có số điểm thấp nhất: " + arrHoTen[vtMin] + " với " + min);
			}

		}

	}

	public static void ketThuc() {
		System.out.println("Cảm ơn bạn đã sử dụng chương trình của chúng tôi!!!");
		System.exit(0);
	}

}
