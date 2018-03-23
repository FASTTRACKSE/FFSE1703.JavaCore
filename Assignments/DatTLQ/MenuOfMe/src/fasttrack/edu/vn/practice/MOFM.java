package fasttrack.edu.vn.practice;

import java.util.Scanner;

public class MOFM {
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myMenu();
	}

	public static void phepCong() {
		System.out.println("Bai toan phep cong");
		int a, b, c;

		System.out.print("Nhap vao so a:");
		a = scanner.nextInt();

		System.out.print("Nhap vao so b:");
		b = scanner.nextInt();

		c = a + b;
		System.out.println("Ket qua:" + c);
		System.out.println("---------------");
	}

	public static void Gptb2() {
		double a, b, c, x, y, d;

		Scanner scanner = new Scanner(System.in);

		System.out.print("Nhap vao so a:");
		a = scanner.nextDouble();

		System.out.print("Nhap vao so b:");
		b = scanner.nextDouble();

		System.out.print("Nhap vao so c:");
		c = scanner.nextDouble();

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
				System.out.print("Phuong trinh vo nghiem");
			}

		}
		System.out.println("---------------");

	}

	public static void MinMax() {
		Scanner scanner = new Scanner(System.in);
		int a;
		System.out.print("Nhap so phan tu cua mang: ");

		a = scanner.nextInt();

		int[] arr = new int[a];
		System.out.print("Nhap cac phan tu cua mang: \n");
		for (int i = 0; i < a; i++) {
			System.out.printf("arr" + "[" + (i + 1) + "]" + "=");
			arr[i] = scanner.nextInt();
		}
		System.out.print("Cac phan tu cua mang: ");
		for (int i = 0; i < a; i++) {
			System.out.print(arr[i] + " ");

		}
		System.out.print("\n");

		int max = arr[0];
		int keymax = 0;

		for (int b = 1; b < a; b++) {
			if (max < arr[b]) {
				max = arr[b];
				keymax = b;

			}

		}
		System.out.println("So lon nhat  :" + max + ". " + "Vi tri phan tu trong mang la :" + keymax);

		int min = arr[0];
		int keymin = 0;
		for (int b = 1; b < a; b++) {
			if (min > arr[b]) {
				min = arr[b];
				keymin = b;

			}

		}
		System.out.println("So nho nhat  :" + min + ". " + "Vi tri phan tu trong mang la :" + keymin);
		System.out.println("---------------");
	}

	public static void ketThuc() {
		System.exit(0);

	}

	public static void myMenu() {

		System.out.println("---LUA CHON CHUC NANG---");
		System.out.println("_______________________________________"+"\n");
		System.out.println("||1: Chuong trinh phep cong           ||");
		System.out.println("||2: Chuong trinh GPTB2               ||");
		System.out.println("||3: Chuong trinh  MIN MAX trong mang ||");
		System.out.println("||4: Ket thuc chuong trinh            ||");
		System.out.println("_______________________________________"+"\n");
		while (true) {
			System.out.print("----LUA CHON CUA BAN----");

			int input = scanner.nextInt();
			if (input == 1) {
				phepCong();
			} else if (input == 2) {
				Gptb2();
			} else if (input == 3) {
				MinMax();
			} else if (input == 4) {
				ketThuc();
			}

		}
	}
}
