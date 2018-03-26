package Fasttrack.edu.vn;

import java.util.Scanner;

public class Menu {
	
	public static Scanner myScanner = new Scanner(System.in);

	public static void main(String[] args) {
		myMenu();
	}

	public static void myMenu() {
		while (true) {
			System.out.println(" __________________________________________ ");
			System.out.println("|                 <MENU>                   |");
			System.out.println("|__________________________________________|");
			System.out.println("| Chức năng :                              |");
			System.out.println("|-1. Chương trình cộng                     |");
			System.out.println("|-2. Giải phương trình bậc 2               |");
			System.out.println("|-3. Tìm MIN MAX trong mảng                |");
			System.out.println("|-4. Ket thuc chuong trinh                 |");
			System.out.println("|__________________________________________|");
			System.out.println("|Lựa chọn chức năng bạn muốn?              |");
			System.out.println("|__________________________________________|");

			
			int myOption = myScanner.nextInt();
			if (myOption == 1) {
				phepCong();
			} else if (myOption == 2) {
				giaiPTB2();
			} else if (myOption == 3) {
				xuliMang();
			} else if (myOption == 4) {
				ketThuc();
			}
		}
	}

	public static void phepCong() {
		System.out.println("Bài toán tìm tổng 2 số");
		// TODO Auto-generated method stub
		int a, b, c;
		Scanner myInput = new Scanner(System.in);
		System.out.print("Nhập vào số a : ");
		a = myInput.nextInt();
		System.out.print("Nhập vào số b ");
		b = myInput.nextInt();
		c = a + b;
		System.out.printf("Tổng của %d + %d = %d \n", a, b, c);
		
		myScanner.nextLine();
		System.out.println("Nhấn Enter để về menu chính");
		myScanner.nextLine();

	}

	public static void giaiPTB2() {
		System.out.println("Giải phương trình bậc 2");
		int a, b, c;
		float x1, x2;
		Scanner myInput = new Scanner(System.in);

		System.out.print("Nhập vào số a: ");
		a = myInput.nextInt();

		System.out.print("Nhập vào số b: ");
		b = myInput.nextInt();

		System.out.print("Nhập vào số c: ");
		c = myInput.nextInt();

		if (a == 0) {
			System.out.println("Không phải phương trình bậc  2");
		} else {
			double x = Math.pow(b, 2) - 4 * a * c;
			if (x < 0) {
				System.out.println("Phương trình vô nghiệm ");
			}
			if (x > 0) {
				System.out.println("Phương trình có 2 nghiệm");
				x1 = (float) ((-b + Math.sqrt(x)) / (2 * a));
				x2 = (float) ((-b - Math.sqrt(x)) / (2 * a));
				System.out.println("Phương trình có 2 nghiệm là: " + "x1 = " + x1 + " và x2 = " + x2);

			}
			if (x == 0) {
				System.out.println("Phương trình vô nghiệm");
				x1 = (-b / (2 * a));
				System.out.println("Phương trình có nghiệm kép: " + "x1 = x2 = " + x1);
			}
		}
		myScanner.nextLine();
		System.out.println("Nhấn Enter để về menu chính");
		myScanner.nextLine();

	}

	public static void xuliMang() {
		System.out.println("Xử lí mảng");
		Scanner input = new Scanner(System.in);
		int a;
		int i;
		System.out.print("Nhập vào phần tử của mảng = ");
		a = input.nextInt();
		int[] b = new int[a];
		for (i = 1; i <= a; i++) {
			System.out.println("Nhập số phần tử của mảng " + i + ":");
			b[i - 1] = input.nextInt();
		}
		int max = b[0];
		int min = b[0];
		int vitrimax = 1;
		int vitrimin = 1;

		for (i = 1; i <= a; i++) {
			if (max < b[i - 1]) {
				max = b[i - 1];
				vitrimax = i;
			}
			if (min > b[i - 1]) {
				min = b[i - 1];
				vitrimin = i;
			}
		}
		System.out.println("Max = " + max + " Vị trí thứ" + " " + vitrimax);
		System.out.println("Min = " + min + " Vị trí thứ" + " " + vitrimin);
		
		myScanner.nextLine();
		System.out.println("Nhấn Enter để về menu chính");
		myScanner.nextLine();

	}

	public static void ketThuc() {
		System.out.println("Kết thúc chương trình");
		System.exit(0);
	}

}



