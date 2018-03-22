package fasttrack.edu.vn;

import java.util.Scanner;

public class Tong2So {

	public static void main(String[] args) {
		// T0D0 Auto-generated method stub
		int a,b,c;
		
		Scanner myInput = new Scanner(System.in);
		
		System.out.print("Nhap vao so a :");
		a = myInput.nextInt();
		
		System.out.print("Nhap vao so b :");
		b = myInput.nextInt();
		
		c = a + b;
		
		System.out.print("Tong cua " + a + " + " + b + " = " + c);
	}
}