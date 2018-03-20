package fasttrack.edu.vn;

import java.util.Scanner;

public class sosanh {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a,b,c,x,y;
		
		Scanner myInput = new Scanner(System.in);
		
		System.out.print("nhap vao so a : ");
		a = myInput.nextInt();
		
		System.out.print("nhap vao so b : ");
		b = myInput.nextInt();
		
		System.out.print("nhap vao so c : ");
		c = myInput.nextInt();
		
		x = Math.min(a, Math.min(c, b));
		
		y = Math.max(a, Math.max(c, b));
		
		System.out.println("So nho nhat trong 3 so la :" +  x);
		
		System.out.println("So lon nhat trong 3 so la :" +  y);
		
		
	}

}
