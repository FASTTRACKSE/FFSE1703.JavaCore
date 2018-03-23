package MyMenu;

import java.util.Scanner;

public class MyMenu {

	public static Scanner myScanner = new Scanner(System.in);

	public static void main(String[] args) {
		MyMenu();
	}

	public static void MyMenu() {
		while (true) {
			System.out.println("LUA CHON CHUC NANG");
			System.out.println("1.Phep Cong");
			System.out.println("2.Phuong Trinh Bac 2");
			System.out.println("3.Tim min max Trong Mang");
			System.out.println("4.Ket thuc chuong trinh");
			System.out.println("LUA CHON CUA BAN");

			int myOption = myScanner.nextInt();
			if (myOption == 1) {
				Tong2so();
			} else if (myOption == 2) {
				GiaiPTb2();
			} else if (myOption == 3) {
				MinMax3so();
			} else if (myOption == 4) {
				Ketthuc();
			}
		}
	}

	public static void Tong2so() {
		System.out.println("Phep Cong");
		System.out.println("---------");
		int a, b, c;

		Scanner myInput = new Scanner(System.in);

		System.out.print("Nhap vao so a :");
		a = myInput.nextInt();

		System.out.print("Nhap vao so b :");
		b = myInput.nextInt();

		c = a + b;

		System.out.println("Tong cua " + a + " + " + b + " = " + c);
		myScanner.nextLine();
		System.out.println("An ENTER de ve menu chinh");
		myScanner.nextLine();
	}

	public static void GiaiPTb2() {
		System.out.println("Phuong Trinh Bac 2");
		System.out.println("------------------");

		double a, b, c, x, x1, x2, delta;

		System.out.print("Nhap a:");
		a = myScanner.nextDouble();

		System.out.print("Nhap b:");
		b = myScanner.nextDouble();

		System.out.print("Nhap c:");
		c = myScanner.nextDouble();

		delta = (b * b) - 4 * a * c;

		if (a == 0) {
			if (b == 0) {
				if (c != 0) {
					System.out.println("Phuong trinh vo nghiem");
				} else {
					System.out.println("Phuong trinh vo so nghiem");
				}

			} else {

				if (c == 0) {
					x = c / b;
					System.out.println("Phuong trinh co nghiem x = " + x);
				} else {
					x = -c / b;
					System.out.println("Phuong trinh co nghiem x = " + x);
				}

			}
		} else {

			if (delta > 0) {
				x1 = (-b + Math.sqrt(delta)) / (2 * a);
				x2 = (-b - Math.sqrt(delta)) / (2 * a);
				System.out.println("Phuong trinh co 2 nghiem phan biet x1, x2 là " + x1 + " và " + x2);
			} else if (delta == 0) {
				x = -b / 2 * a;
				System.out.println("Phuong trinh co nghiem kep x = " + x);
			} else if (delta < 0) {
				System.out.println("Phuong trinh vo nghiem");
				myScanner.nextLine();
				System.out.println("An ENTER de ve menu chinh");
				myScanner.nextLine();
			}
		}
	}

	public static void MinMax3so() {
		System.out.println("Tim min max Trong Mang");
		System.out.println("----------------------");

		int a, b, c;

		Scanner myInput = new Scanner(System.in);

		System.out.print("Nhap vao so a : ");
		a = myInput.nextInt();

		System.out.print("Nhap vao so b : ");
		b = myInput.nextInt();

		System.out.print("Nhap vao so c : ");
		c = myInput.nextInt();

		if (Math.min(a, b) > c) {
			System.out.printf("So nho nhat trong 3 so %d, %d, %d la %d \n", a, b, c, c);
		} else {
			System.out.printf("So nho nhat trong 3 so %d, %d, %d la %d \n", a, b, c, Math.min(a, b));
		}
		if (Math.max(a, b) < c) {
			System.out.printf("So lon nhat trong 3 so %d, %d, %d la %d \n", a, b, c, c);
		} else {
			System.out.printf("So lon nhat trong 3 so %d, %d, %d la %d \n", a, b, c, Math.max(a, b));
		}
		myScanner.nextLine();
		System.out.println("An ENTER de ve menu chinh");
		myScanner.nextLine();
	}

	public static void Ketthuc() {
		System.out.println("-----------------------");
		myScanner.nextLine();
		System.out.println("Cam on va chao tam biet");
		System.exit(0);

	}
}
