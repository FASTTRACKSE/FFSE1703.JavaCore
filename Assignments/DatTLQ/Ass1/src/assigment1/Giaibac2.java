package assigment1;

import java.util.Scanner;

public class Giaibac2 {
	public static void main(String[] args) {
		double a, b, c, x, y, d;

		Scanner myInput = new Scanner(System.in);

		System.out.print("Nhap vao so a:");
		a = myInput.nextDouble();

		System.out.print("Nhap vao so b:");
		b = myInput.nextDouble();

		System.out.print("Nhap vao so c:");
		c = myInput.nextDouble();

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

	}
}
