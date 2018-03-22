package assignment3;

import java.util.Scanner;

public class Menucuatoi {
	public static Scanner myScanner = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myMenu();
	}

	public static void tinhTong() {
		System.out.println("Chương trình tính tổng hai số");
		int a, b, c;

		Scanner myScanner = new Scanner(System.in);
		System.out.print("nhap vao so a :");
		a = myScanner.nextInt();
		System.out.print("nhap vao so b :");
		b = myScanner.nextInt();
		c = a + b;
		System.out.println(a + "+" + b + "=" + c);
		System.out.println("Nhấn Enter để về menu");
		myScanner.nextLine();
		System.out.println("================================");
		myScanner.nextLine();
	}

	public static void ptBacHai() {
		System.out.println("Chương trình tính phương trình bậc hai");
		int a, b, c;
		double denta, b2, x1, x2, candenta, x;
		Scanner myScanner = new Scanner(System.in);
		System.out.print("Nhập vào số a :");
		a = myScanner.nextInt();
		System.out.print("Nhập vào sô b :");
		b = myScanner.nextInt();
		System.out.print("Nhập vào số c :");
		c = myScanner.nextInt();
		System.out.println("Phương trình :" + a + "x2 +" + b + "x + " + c + " = 0");

		if (a == 0) {
			if (b == 0) {
				if (c == 0) {
					System.out.println("phương trình có vô số nghiệm");
				} else {
					System.out.println("phương trình có vô số nghiệm");
				}
			} else {
				x = -c / b;
				System.out.println("phương trình có 1 nghiệm =" + x);
			}

		} else {
			denta = b * b - 4 * a * c;
			if (denta > 0) {
				candenta = Math.sqrt(denta);
				x1 = (-b + candenta) / (2 * a);
				x2 = (-b - candenta) / (2 * a);
				System.out.println("phương trình có hai nghiệm phân biệt:");
				System.out.println("x1 = " + x1);
				System.out.println("x2 = " + x2);
			} else if (denta == 0) {
				x = -b / 2 * a;
				System.out.println("phương trình có 1 nghiệm kép =" + x);
			} else {
				System.out.println("phương trình vô nghiệm");
			}

		}
		System.out.println("Nhấn Enter để về menu");
		myScanner.nextLine();
		System.out.println("================================");
		myScanner.nextLine();
	}

	public static void timMaxMin() {
		System.out.println("Chương trình tìm mã min trong mảng");
		int size;
		Scanner myScanner = new Scanner(System.in);
		System.out.print("Nhap vao so phan tu mang : ");
		size = myScanner.nextInt();
		int[] mang = new int[size];
		for (int i = 0; i < size; i++) {
	
			System.out.print("Nhap phan tu thu " + (i+1) + " :");
			mang[i] = myScanner.nextInt();
		}
		System.out.print("gia tri cua mang :");
		for (int a = 0; a < mang.length; a++) {
			System.out.print(+mang[a] + "; ");
		}

		int max = mang[0], min = mang[0];
		int vtmax = 0, vtmin = 0;

		for (int c = 1; c < mang.length; c++) {
			if (max < mang[c]) {
				max = mang[c];
				vtmax = c;
			}
			if (min > mang[c]) {
				min = mang[c];
				vtmin = c;
			}
		}
		System.out.println("\nVị trí số lớn nhất thứ " + vtmax + " có giá trị :" + max);
		System.out.println("Vị trí số nhỏ nhất thứ " + vtmin + " có giá trị :" + min);
		System.out.println("Nhấn Enter để về menu");
		myScanner.nextLine();
		System.out.println("================================");
		myScanner.nextLine();
	}

	public static void ketThuc() {
		System.out.println("Cám ơn bạn đã sử dụng chương trình");
		System.exit(0);
	}

	public static void myMenu() {
		while (true) {
			System.out.println("+------LỰA CHỌN CHỨC NĂNG------+");
			System.out.println("| 1. Chương trình phép cộng     |");
			System.out.println("| 2. Giải phương trình bậc hai  |");
			System.out.println("| 3. Tìm min max trong mảng     |");
			System.out.println("=================================");
			System.out.println("| 4. Kết thúc                   |");
			System.out.println("+-------------------------------|");
			int option = myScanner.nextInt();
			if (option == 1) {
				tinhTong();
			} else if (option == 2) {
				ptBacHai();
			} else if (option == 3) {
				timMaxMin();
			} else if (option == 4) {
				ketThuc();
			}
		}
	}

}
