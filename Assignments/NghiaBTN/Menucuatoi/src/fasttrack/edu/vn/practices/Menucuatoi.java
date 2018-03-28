package fasttrack.edu.vn.practices;

import java.util.Scanner;

public class Menucuatoi {
	public static Scanner myScanner = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myMenu();
	}

	public static void phepCong() {
		int a, b, c;

		Scanner myInput = new Scanner(System.in);

		System.out.print("nhap vao so a : ");
		a = myInput.nextInt();

		System.out.print("nhap vao so b : ");
		b = myInput.nextInt();

		c = a + b;

		System.out.printf("Tong cua %d + %d = %d \n", a, b, c);
		myScanner.nextLine();
		System.out.println("Ấn enter để về menu chính");
		myScanner.nextLine();
	}

	public static void giaiPTB2() {
		int a, b, c;
		double x, x1, x2;

		System.out.print("Nhập vào số a : ");
		a = myScanner.nextInt();

		System.out.print("Nhập vào số b : ");
		b = myScanner.nextInt();

		System.out.print("Nhập vào số c : ");
		c = myScanner.nextInt();

		if (a == 0) {
			if (b == 0) {
				if (c == 0) {
					System.out.println("Phương trình có vô số nghiệm.");
				} else {
					System.out.println("Phương trình vô nghiệm.");
				}
			} else {
				System.out.println("Phương trình có 1 nghiệm là : " + -c / b);
			}

		} else {
			double denta = Math.pow(b, 2) - 4 * a * c;

			if (denta < 0) {
				System.out.println("Phương trình vô nghiệm ");
			} else if (denta > 0) {
				x1 = (-b + Math.sqrt(denta)) / (2 * a);
				x2 = (-b - Math.sqrt(denta)) / (2 * a);
				System.out.printf("Phương trình có 2 nghiệm : x1 = %.2f và x2 = %.2f \n", x1, x2);
			} else {
				x1 = -b / (2 * a);
				System.out.println("Phương trình có nghiệm kép là : x1 = x2 = " + x1);
			}
		}
		myScanner.nextLine();
		System.out.println("Ấn enter để về menu chính");
		myScanner.nextLine();
	}

	public static void xulymang() {
		int n, i, min, max;

		System.out.print("Nhập vào số lượng phần tử trong mảng a[] : ");
		n = myScanner.nextInt();

		int[] a = new int[n];

		for (i = 0; i < n; i++) {
			System.out.print("Nhập giá trị của phần tử  a[" + i + "] :");
			a[i] = myScanner.nextInt();
		}

		min = a[0];
		max = a[0];
		int x = 0, y = 0;

		for (i = 0; i < n; i++) {
			if (min > a[i]) {
				min = a[i];
				x = i + 1;
			}
		}

		System.out.println("Số nhỏ nhất trong " + n + " phần tử là :" + min);

		System.out.println("Là phần tử thứ " + x);

		for (i = 0; i < n; i++) {
			if (max < a[i]) {
				max = a[i];
				y = i + 1;
			}
		}

		System.out.println("Số lớn nhất trong " + n + " phần tử là :" + max);

		System.out.println("Là phần tử thứ " + y);
		myScanner.nextLine();
		System.out.println("Ấn enter để về menu chính");
		myScanner.nextLine();
	}

	public static void ketThuc() {
		System.out.println("4. Kết thúc chương trình");
		System.exit(0);
	}

	public static void myMenu() {
		while (true) {
			System.out.println("LỰA CHỌN CHỨC NĂNG");
			System.out.println("1. Chương trình phép cộng");
			System.out.println("2. Chương trình GPTB2");
			System.out.println("3. Chương trình tìm MIN MAX trong mảng");
			System.out.println("4. Kết thúc chương trình");
			System.out.println("Lựa chọn của bạn:");
			int myOption = myScanner.nextInt();
			if (myOption == 1) {
				phepCong();
			} else if (myOption == 2) {
				giaiPTB2();
			} else if (myOption == 3) {
				xulymang();
			} else if (myOption == 4) {
				ketThuc();	
			}
		}
	}

}
