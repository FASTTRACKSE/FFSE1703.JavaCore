package fasttrack.edu.vn.practices;

import java.util.Scanner;

public class MenuCuaToi {

	public static Scanner myScanner = new Scanner(System.in);

	public static void main(String[] args) {
		myMenu();
	}

	public static void myMenu() {
		while (true) {
			try {
				System.out.println("\nLUA CHON CHUC NANG");
				System.out.println("1. Chuong trinh phep cong");
				System.out.println("2. Chuong trinh GPTB2");
				System.out.println("3. Chuong trinh tim MIN MAX trong mang");
				System.out.println("4. Ket thuc chuong trinh");
				System.out.print("Lua chon cua ban: ");

				int myOption = myScanner.nextInt();
				if (myOption == 1) {
					phepCong();
				} else if (myOption == 2) {
					giaiPTB2();
				} else if (myOption == 3) {
					xuLyMang();
				} else if (myOption == 4) {
					ketThuc();
				} else {
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.println("Chi duoc nhap tu 1 den 5, hay nhap lai nhe ban!!!");
				myScanner.nextLine();
			}
		}
	}

	public static void backToMainMenu() {
		myScanner.nextLine();
		System.out.println("An Enter de ve menu chinh");
		myScanner.nextLine();
	}

	public static void phepCong() {
		System.out.println("Bai toan tim tong 2 so");
		System.out.println("----------------------");
		int a, b, c;

		System.out.print("Nhap vao so a : ");
		a = myScanner.nextInt();

		System.out.print("Nhap vao so b : ");
		b = myScanner.nextInt();

		c = a + b;

		System.out.printf("Tong cua %d + %d = %d \n", a, b, c);
		backToMainMenu();
	}

	public static void giaiPTB2() {
		System.out.println("Bai toan Giai Phuong Trinh Bac 2");
		backToMainMenu();
	}

	public static void xuLyMang() {
		System.out.println("Bai toan tim MIN MAX trong mang");
		backToMainMenu();
	}

	public static void ketThuc() {
		System.out.println("Chuong trinh da ket thuc. Cam on cac ban!!!");
		System.exit(0);
	}

}
