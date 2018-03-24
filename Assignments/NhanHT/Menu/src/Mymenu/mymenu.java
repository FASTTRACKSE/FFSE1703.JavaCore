package Mymenu;

import java.util.Scanner;

public class mymenu {
	public static Scanner myInput = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myMenu();
	}

	public static void phepcong() {
		//
		System.out.println("<=====PHEP CONG=====> ");
		int a, b, c;
		Scanner myInput = new Scanner(System.in);

		System.out.print("Nhap vao so a : ");
		a = myInput.nextInt();
		System.out.print("Nhap vao so b : ");
		b = myInput.nextInt();
		c = a + b;
		System.out.println("Tong la : " + c);
		System.out.println("<----------------------------->");
		System.out.println("LUA CHON CUA BAN");
	}

	public static void giaiphuongtrinh() {
		System.out.println("<=====GIAI PHUONG TRINH BAC 2=====> ");
		//
		Scanner myInput = new Scanner(System.in);
		double a, b, c, kq, x, y;
		System.out.print("Nhap A : ");
		a = myInput.nextDouble();
		System.out.print("Nhap B : ");
		b = myInput.nextDouble();
		System.out.print("Nhap C : ");
		c = myInput.nextDouble();

		kq = (b * b) - 4 * a * c;
		if (a == 0) {
			if (b == 0) {
				System.out.println("Phuong trinh vo nghiem");
			} else {
				x = -c / b;
				System.out.println("Phuong trinh co nghiem " + x);
			}
		} else {
			if (kq == 0) {
				x = -b / 2 * a;
				System.out.println("Phuong trinh co nghiem kep la :" + x);
			} else if (kq > 0) {
				x = (-b + Math.sqrt(kq)) / (2 * a);
				y = (-b - Math.sqrt(kq)) / (2 * a);
				System.out.println("Phuong trinh co 2 nghiem :" + x + " va " + y);
			} else {
				System.out.println("Phuong trinh vo nghiem");
			}
		}
		System.out.println("<----------------------------->");
		System.out.println("LUA CHON CUA BAN");
	}

	public static void minmax() {
		System.out.println("<=====MIN MAX=====>");
		Scanner myInput = new Scanner(System.in);

		System.out.print("Nhap so phan tu cua mang: ");
		int a = myInput.nextInt();

		int arr[] = new int[a];

		int minvt = 0;
		int maxvt = 0;

		for (int i = 0; i < a; i++) {
			System.out.print("Nhap " + "[" + (i + 1) + "]");
			arr[i] = myInput.nextInt();
		}
		int min = arr[0];
		for (int i = 1; i < a; i++) {
			if (arr[i] < min) {
				min = arr[i];
				minvt = i;
			}
		}
		int max = arr[0];
		for (int i = 1; i < a; i++) {
			if (arr[i] > max) {
				max = arr[i];
				maxvt = i;
			}
		}
		System.out.print("nhung phan tu trong mang:");
		for (int i = 0; i < a; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.print("\n");
		System.out.println("So nho nhat la: " + min);
		System.out.println("So lon nhat la: " + max);
		System.out.println("Key nho nhat la: " + minvt);
		System.out.println("Key lon nhat la: " + maxvt);
		System.out.println("<----------------------------->");
		System.out.println("LUA CHON CUA BAN");
	}

	public static void ketthuc() {
		System.exit(0);
	}

	public static void myMenu() {
		
		System.out.println("<=====LUA CHON CHUC NANG=====>");
		System.out.println("|| 1.CHUONG TRINH PHEP CONG ||");
		System.out.println("|| 2.CHUONG TRINH GPTB2     ||");
		System.out.println("|| 3.MIN MAX                ||");
		System.out.println("|| 4.KET THUC CHUONG TRINH  ||");
		System.out.println("<============================>");
		System.out.println("      LUA CHON CUA BAN        ");
		while (true) {
			int option = myInput.nextInt();
			if (option == 1) {
				phepcong();
			} else if (option == 2) {
				giaiphuongtrinh();
			} else if (option == 3) {
				minmax();
			} else if (option == 4) {
				ketthuc();
			}
		}
	}
}
