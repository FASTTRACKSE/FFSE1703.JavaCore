package FFSE1703;

import java.util.Scanner;

public class MenuCuaToi {
	public static Scanner myInput = new Scanner(System.in);

	public static void main(String[] args) {

		myMenu();

	}

	public static void myMenu() {
		
		System.out.println("---  lỰA CHỌN CHỨC NĂNG  ---");
		System.out.println("____________________________" + "\n");
		System.out.println("1. Phép công.");
		System.out.println("2. Giải phương trình bậc 2.");
		System.out.println("3. Tìm min, max trong mảng.");
		System.out.println("4. Kết thúc.");
		System.out.println("____________________________" + "\n");
		while (true) {
			System.out.print("Nhập lựa chọn của bạn: ");
			int myChose = myInput.nextInt();

			if (myChose == 1) {
				phepCong();
			} else if (myChose == 2) {
				giaiPhuongTrinhBac2();
			} else if (myChose == 3) {
				timMinMaxTrongMang();
			} else if (myChose == 4) {
				ketThuc();
			}
		}

	}

	public static void phepCong() {
		System.out.println("Phép cộng");
		System.out.println("-----------------");
		int a, b, c;

		Scanner myInput = new Scanner(System.in);

		System.out.print("Nhap Vào số thứ 1: ");
		a = myInput.nextInt();

		System.out.print("Nhap Vào số thứ 2: ");
		b = myInput.nextInt();

		c = a + b;
		System.out.println("Tổng của " + a + " và " + b + " là:" + c);
		myInput.nextLine();
	}

	public static void giaiPhuongTrinhBac2() {
		System.out.println("Giải phương trình bậc 2");
		System.out.println("-----------------");
		Scanner myInput = new Scanner(System.in);

		double a, b, c, x, x1, x2, delta;

		System.out.print("Nhập a:");
		a = myInput.nextDouble();

		System.out.print("Nhập b:");
		b = myInput.nextDouble();

		System.out.print("Nhập c:");
		c = myInput.nextDouble();

		// tính delta
		delta = (b * b) - 4 * a * c;

		if (a == 0) {
			if (b == 0) {
				if (c != 0) {
					System.out.println("Phương trình vô nghiệm");
				} else {
					System.out.println("Phương trình vô số nghiệm");
				}

			} else {
				// tránh trường hợp x = -0.0

				if (c == 0) {
					x = c / b;
					System.out.println("Phương trình có nghiệm x = " + x);
				} else {
					x = -c / b;
					System.out.println("Phương trình có nghiệm x = " + x);
				}

			}
		} else {

			if (delta > 0) {
				x1 = (-b + Math.sqrt(delta)) / (2 * a);
				x2 = (-b - Math.sqrt(delta)) / (2 * a);
				System.out.println("Phương trình có 2 nghiệm phân biệt x1, x2 là " + x1 + " và " + x2);
			} else if (delta == 0) {
				x = -b / 2 * a;
				System.out.println("Phương trình có nghiệm kép x = " + x);
			} else if (delta < 0) {
				System.out.println("Phương trình vô nghiệm");
			}

		}

	}

	public static void timMinMaxTrongMang() {
		System.out.println("Tìm min,max");
		System.out.println("-----------------");
		Scanner myInput = new Scanner(System.in);

		// khai báo biến
		int size, max, min, vtMax, vtMin;

		// nhập số phần tử cho mảng
		System.out.print("Nhập số phần tử cho mảng: ");
		size = myInput.nextInt();
		// khởi tạo mảng
		int array[] = new int[size];

		// nhập giá trị vào mảng
		for (int i = 0; i < size; i++) {
			System.out.print("Nhập vào phần tử " + (i + 1) + ":" + " ");
			array[i] = myInput.nextInt();
		}

		for (int a = 0; a < size; a++) {
			System.out.println("Phần tử " + a + " là: " + array[a]);
		}

		// khởi tạo giá trị ban đầu cho biến
		max = array[0];
		min = array[0];
		vtMax = 0;
		vtMin = 0;

		// khởi tạo max = phần tử vị trí số 0 sau đó so sánh với từng phần tử trong
		// mảng. lấy giá trị lớn nhất
		for (int b = 1; b < size; b++) {
			if (max < array[b]) {
				vtMax = b;
				max = array[b];

			}
		}

		System.out.println("Số lớn nhất là: " + max + ". " + "Vị trí phần tử trong mảng: " + vtMax);
		// khởi tạo min = phần tử vị trí số 0 sau đó so sánh với từng phần tử trong
		// mảng. lấy giá trị nhỏ nhất
		for (int c = 1; c < size; c++) {
			if (min > array[c]) {
				vtMin = c;
				min = array[c];

			}
		}

		System.out.println("Số nhỏ nhất là: " + min + ". " + "Vị trí phần tử trong mảng: " + vtMin);
	}

	public static void ketThuc() {
		System.out.println("Cảm ơn bạn đã sử dụng chương trình của chúng tôi!!!");
		System.exit(0);

	}

}
