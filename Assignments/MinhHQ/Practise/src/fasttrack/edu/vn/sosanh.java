package fasttrack.edu.vn;

import java.util.Scanner;

public class sosanh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a, b, c, x, y;

		Scanner myInput = new Scanner(System.in);

		System.out.print("Nhập vào số a : ");
		a = myInput.nextInt();

		System.out.print("Nhập vào số b : ");
		b = myInput.nextInt();

		System.out.print("Nhập vào số c : ");
		c = myInput.nextInt();

		x = Math.min(a, Math.min(c, b));

		y = Math.max(a, Math.max(c, b));

		System.out.println("Số nhỏ nhất trong 3 số là :" + x);

		System.out.println("Số lớn nhất trong 3 số là :" + y);

	}

}
