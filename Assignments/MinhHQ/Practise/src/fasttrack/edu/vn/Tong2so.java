package fasttrack.edu.vn;

import java.util.Scanner;

public class Tong2so {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a, b, c;

		Scanner myInput = new Scanner(System.in);

		System.out.print("Nhập vào số a : ");
		a = myInput.nextInt();

		System.out.print("Nhập vào số b : ");
		b = myInput.nextInt();

		c = a + b;

		System.out.printf("Tổng của %d + %d = %d \n", a, b, c);
	}

}
