package fasttrack.edu.vn;

import java.util.Scanner;

public class MinMax3so {

	public static void main(String[] args) {
		// T0D0 Auto-generated method stub
		int a,b,c;
		
		Scanner myInput = new Scanner(System.in);
		
		System.out.print("Nhap vao so a : ");
		a = myInput.nextInt();
		
		System.out.print("Nhap vao so b : ");
		b = myInput.nextInt();
		
		System.out.print("Nhap vao so c : ");
		c = myInput.nextInt();

		if (Math.min(a, b) > c) {
			System.out.printf("So nho nhat trong 3 so %d, %d, %d la %d \n", a, b, c, c);
		}else {
			System.out.printf("So nho nhat trong 3 so %d, %d, %d la %d \n", a, b, c, Math.min(a, b));
		}
		if (Math.max(a, b) < c) {
			System.out.printf("So lon nhat trong 3 so %d, %d, %d la %d \n", a, b, c, c);
		}else {
			System.out.printf("So lon nhat trong 3 so %d, %d, %d la %d \n", a, b, c,  Math.max(a, b));
		}
	}
}