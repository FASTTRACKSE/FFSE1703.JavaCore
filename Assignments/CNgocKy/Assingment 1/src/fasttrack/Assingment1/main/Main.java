package fasttrack.Assingment1.main;

import java.util.Scanner;

import java.lang.Math;

public class Main {

	public static void main(String[] args) {
		int a, b, c;
		double x, x1, x2;

		Scanner myInput = new Scanner(System.in);

		System.out.print("Nhập vào số a : ");
		a = myInput.nextInt();

		System.out.print("Nhập vào số b : ");
		b = myInput.nextInt();

		System.out.print("Nhập vào số c : ");
		c = myInput.nextInt();

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
	}
}
