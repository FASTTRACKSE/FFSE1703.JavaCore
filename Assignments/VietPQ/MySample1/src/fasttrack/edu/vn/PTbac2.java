package fasttrack.edu.vn;

import java.util.Scanner;

public class PTbac2 {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);

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
			}

		}

	}

}