package fasttrack.edu.vn.practices;

import java.util.Scanner;

public class Menu {
	public static Scanner myScanner = new Scanner(System.in);

	public static void main(String[] args) {
		myMenu();
	}

	public static void phepcong() {
		System.out.println("Phép cộng ");
		System.out.println("<---------------------->");
		myScanner.nextLine();
		System.out.println("ẤN Enter để về Menu chính ");
		myScanner.nextLine();
	}

	public static void giaiptbac2() {
		System.out.println("Giải Phương Trình Bậc 2 ");
		System.out.println("<---------------------->");
		int a, b, c;

		Scanner scanner = new Scanner(System.in);

		System.out.print("Nhập vào số a:");
		a = scanner.nextInt();

		System.out.print("Nhập vào số b:");
		b = scanner.nextInt();

		System.out.print("Nhập vào số c:");
		c = scanner.nextInt();

		if (a == 0 && b == 0 && c == 0) {
			System.out.println("Phương trình vô số nghiệm!");
		} else {
			if (a == 0 && b == 0) {
				System.out.println("Phương trình vô nghiệm!");
			} else {
				if (a == 0) {
					System.out.println("Phương trình có nghiệm bậc nhất x=" + (-c / b));
				} else {
					double delta;
					delta = b * b - 4 * a * c;
					if (delta < 0) {
						System.out.println("Phương trình vô nghiệm!");
					} else {
						if (delta == 0) {
							System.out.println("Phương trình có nghiệm kép x1=x2" + (-b / (2 * a)));
						} else {
							System.out.println(
									"Phương trình có hai nghiệm phân biệt x1=" + (-b + Math.sqrt(delta)) / (2 * a)
											+ " và x2=" + (-b - Math.sqrt(delta)) / (2 * a));
						}
					}
				}
			}
		}
		myScanner.nextLine();
		System.out.println("ẤN Enter để về Menu chính ");
		myScanner.nextLine();
	}

	public static void xulimang() {
		System.out.println("Tìm Min & Max Trong Mảng ");
		System.out.println("<----------------------->");
		int n;
		int count = 0;
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("Nhập vào số phần tử của mảng: ");
			n = scanner.nextInt();
		} while (n < 0);
		int arr[] = new int[n];
		System.out.println("Nhập các phần tử cho mảng: ");
		for (int i = 0; i < n; i++) {
			System.out.print("Nhập phần tử thứ " + (i + 1) + ": ");
			arr[i] = scanner.nextInt();
		}
		// Đếm số lần xuất hiện của 1 phần tử
		System.out.println("Nhập vào 1 số nguyên bất kỳ: ");
		int number = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			if (arr[i] == number) {
				count++;
			}
		}
		System.out.println("Số phần tử " + number + " có trong mảng = " + count);
		// tìm min & max
		int max = arr[0];
		int min = arr[0];
		int vitri1 = 1, vitri2 = 1;
		for (int i = 1; i < n; i++) {
			if (max < arr[i]) {
				max = arr[i];
				vitri1 = i + 1;
			}
			if (min > arr[i]) {
				min = arr[i];
				vitri2 = i + 1;
			}
		}
		System.out
				.println("Số phần tử lớn nhất trong mảng là : " + max + " và nằm ở vị trí thứ " + vitri1 + " của mảng");
		System.out
				.println("Số phần tử nhỏ nhất trong mảng là : " + min + " và nằm ở vị trí thứ " + vitri2 + " của mảng");
		myScanner.nextLine();
		
		System.out.println("ẤN Enter để về Menu chính ");
		myScanner.nextLine();
	}

	public static void ketthuc() {
		System.out.println("Chương Trình Này Đã Kết Thúc! ");
		myScanner.nextLine();
		System.out.println("ẤN Enter để về Menu chính ");
		myScanner.nextLine();
	}

	public static void myMenu() {
		while (true) {
			System.out.println(" ");
			System.out.println("Lựa Chọn Chức Năng: ");
			System.out.println("1. Chương Trình Phép Cộng");
			System.out.println("2. Chương Trình Giải Phương Trình Bậc 2 ");
			System.out.println("3. Chương Trình Tìm Min & Max Trong Mảng ");
			System.out.println("4. Kết Thúc Chương Trình! ");
			System.out.println("Lựa Chọn Của Bạn: ");

			int myOption = myScanner.nextInt();
			if (myOption == 1) {
				phepcong();
			} else if (myOption == 2) {
				giaiptbac2();
			} else if (myOption == 3) {
				xulimang();
			} else if (myOption == 4) {
				ketthuc();
			}
		}
	}
}
