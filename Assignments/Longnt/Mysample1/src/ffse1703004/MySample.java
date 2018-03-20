package ffse1703004;

import java.util.Scanner;

public class MySample {
	public static void main(String[] args) {
		int a, b, c, x, y, e, f;
		
		Scanner myInput = new Scanner(System.in);
		System.out.println("nhap so a :");
		a = myInput.nextInt();
		System.out.println("nhap so b :");
		b = myInput.nextInt();
		System.out.println("nhap so c :");
		c = myInput.nextInt();
		x=Math.max(a,b);
		y=Math.max(x,c);
		
		e=Math.min(a,b);
		f=Math.min(e,c);
		
		System.out.println("so lon nhat la:" + y );
		
		System.out.println("so nho nhat la:" + f );
	}

}

