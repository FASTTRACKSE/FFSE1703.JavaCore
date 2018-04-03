package bcc;

import java.util.Scanner;
public class Bancuuchuong {
	public static void main(String[] args) {
		        Scanner nc = new Scanner(System.in);
		         System.out.println("nhap vao 1 so: ");
	int so1 = nc.nextInt();
	for (int i=1; i<11; i++) {
		System.out.println(so1 + "x" + i + "=" + so1 * i + "\t");
	}
	}

}

