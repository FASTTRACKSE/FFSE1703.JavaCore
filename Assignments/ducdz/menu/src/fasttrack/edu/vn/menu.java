package fasttrack.edu.vn;

import java.util.Scanner;

public class menu {
	public static Scanner myScanner = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myMenu();
	}

	public static void myMenu() {
		while (true) {
			System.out.println("");
			System.out.println("Moi ban lua chon chuc nang");
			System.out.println("1. Chuong trinh phep cong");
			System.out.println("2. Chuong trinh giai phuong trinh bac 2");
			System.out.println("3. Chuong trinh tim min max trong mang");
			System.out.println("4. Ket thuc chuong trinh");
			System.out.print("Lua chon cua ban : ");
			int myOption = myScanner.nextInt();
			if (myOption == 1) {
				phepcong();
			}
			if (myOption == 2) {
				giaiptbac2();
			}
			if (myOption == 3) {
				minmaxmang();
			}
			if (myOption == 4) {
				ketthuc();
			}
		}
	}

	public static void phepcong() {
		int a, b, c;
		System.out.print("Nhap so a : ");
		a = myScanner.nextInt();
		System.out.print("Nhap so b : ");
		b = myScanner.nextInt();
		c = a + b;
		System.out.println("Tong cua " + a + " va " + b + " : " + c);
		myScanner.nextLine();
		System.out.println("An Enter de ve menu chinh");
		myScanner.nextLine();
	}

	public static void giaiptbac2() {
		int a, b, c;
		System.out.println("Nhap so a: ");
		a = myScanner.nextInt();
		System.out.println("Nhap so b: ");
		b = myScanner.nextInt();
		System.out.println("Nhap so c: ");
		c = myScanner.nextInt();
		double delta = b * b - 4 * a * c;
		if (a == 0) {
			if (b == 0) {
				System.out.println("phuong trinh vo nghiem");
			} 
			else {
				int x = -c / b;
				System.out.print("phuong trinh co nghiem la : " + x);
			}
		}
		if (delta < 0) {
			System.out.println("phuong trinh vo nghiem");
		} else {
			if (delta == 0) {
				int x = -b / 2 * a;
				System.out.println("phuong trinh co nghiem kep : " + x);
			}
			if (delta > 0) {
				double x1 = (-b + (Math.sqrt(delta)) / 2 * a);
				double x2 = (-b - (Math.sqrt(delta)) / 2 * a);
				System.out.println("Phuong trinh co nghiem x1 : " + x1);
				System.out.println("Phuong trinh co nghiem x2 : " + x2);
			}
		}
		myScanner.nextLine();
		System.out.println("An Enter de ve menu chinh");
		myScanner.nextLine();
	}

	public static void minmaxmang() {
		int x;
		System.out.print("Nhap so phan tu cua mang :");
		x = myScanner.nextInt();
		int a[] = new int[x];
		for (int i = 0; i < x; i++) {
			System.out.print("Gia tri cua phan tu " + (i + 1) + " : ");
			a[i] = myScanner.nextInt();
		}
		int max;
		int min;
		max = a[0];
		min = a[0];
		int vi_tri_max = 0;
		int vi_tri_min = 1;
		for (int i = 0; i < x; i++) {
			if (max < a[i]) {
				max = a[i];
				vi_tri_max = i + 1;
			}
		}
		for (int i = 0; i < 0; i++) {
			if (min > a[i]) {
				min = a[i];
				vi_tri_min = i + 1;
			}
		}
		System.out.println("Gia tri lon nhat : " + max);
		System.out.println("Gia tri nho nhat : " + min);
		System.out.println("Vi tri nho nhat : " + vi_tri_min);
		System.out.println("Vi tri lon nhat : " + vi_tri_max);
		myScanner.nextLine();
		System.out.println("An Enter de ve menu chinh");
		myScanner.nextLine();
	}

	public static void ketthuc() {
		System.out.print("Chuong trinh da ket thuc. Cam on ban !");
		System.exit(0);
	}
}
