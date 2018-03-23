package practices;

import java.util.Scanner;

public class MenuCuaToi {
	public static Scanner myScanner = new Scanner(System.in);

	public static void main(String[] args) {
		myMenu();
	}
	
	public static void phepCong() {
		System.out.println("Phep cong");
		int a, b, c;
		Scanner myScanner = new Scanner(System.in);
		System.out.println("nhap so a :");
		a = myScanner.nextInt();
		System.out.println("nhap so b :");
		b = myScanner.nextInt();
		c = a + b;
		System.out.printf("tong cua %d + %d = %d \n", a, b, c);
	}

	public static void giaiPTB2() {
		System.out.println("Phuong trinh bac 2");
		double a, b, c, x, y, d;

		Scanner myScanner = new Scanner(System.in);

		System.out.print("Nhap vao so a:");
		a = myScanner.nextDouble();

		System.out.print("Nhap vao so b:");
		b = myScanner.nextDouble();

		System.out.print("Nhap vao so c:");
		c = myScanner.nextDouble();

		d = (b * b) - 4 * a * c;
		if (a == 0) {
			if (b == 0) {

				if (c == 0) {
					System.out.print("Phuong trinh vo so nghiem");
				} else {
					System.out.print("Phuong trinh vo nghiem");
				}
			} else {
				x = -c / b;
				System.out.print("Phuong trinh co nghiem la:" + x);

			}
		} else {
			if (d == 0) {
				x = -b / 2 * a;
				System.out.print("Phuong trinh co nghiem kep la:" + x);
			} else if (d > 0) {
				x = (-b - Math.sqrt(d)) / (2 * a);
				y = (-b + Math.sqrt(d)) / (2 * a);
				System.out.println("Phuong trinh co 2 nghiem" + "\n" + x + "\n" + y);

			} else {
				System.out.println("Phuong trinh vo nghiem");
				System.out.println("<----------------->");
			}

		}
	}

	public static void xuLyMang() {
		System.out.println("Min Max");
		int a;
		do {
			System.out.println("Nhập số phần tử cho mảng: ");
			a = myScanner.nextInt();
		} while (a < 0);
		int arr[] = new int[a];
		System.out.println("Nhập giá trị cho các phần tử của mảng: ");
		for (int i = 0; i < a; i++) {
			System.out.print("Nhập phần tử thứ " + i + ": ");
			arr[i] = myScanner.nextInt();
		}
		int max = arr[0];
		int min = arr[0];
		for (int i = 0; i < a; i++) {
			if (max < arr[i])
				max = arr[i];
			if (min > arr[i])
				min = arr[i];
		}
		System.out.println("Số phần tử lớn nhất trong mảng là: " + max);
		System.out.println("Số phần tử nhỏ nhất trong mảng là: " + min);
		System.out.println("<--------------->");
		
	}

	public static void ketThuc() {
		System.out.println("Kết Thúc");
		System.exit(0);
	}

	public static void myMenu() {
		while (true) {
			System.out.println("LUA CHON CHUC NANG: ");
			System.out.println("1. Chuong trinh phep cong");
			System.out.println("2. Chuong trinh GPTB2");
			System.out.println("3. Chuong trinh tim MIN MAX trong mang");
			System.out.println("4. Ket thuc chuong trinh");
			System.out.println("Lua chon cua ban: ");

			int myOption = myScanner.nextInt();
			if (myOption == 1) {
				phepCong();
			} else if (myOption == 2) {
				giaiPTB2();
			} else if (myOption == 3) {
				xuLyMang();
			} else if (myOption == 4) {
				ketThuc();
			}
		}
	}
}

