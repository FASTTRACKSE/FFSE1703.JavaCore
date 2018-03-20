package fasttrack.edu.vn;

import java.util.Scanner;

public class MinMax3so {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a,b,c;
		Scanner myInput= new Scanner(System.in);
		
		System.out.print("Nhap vao so a: ");
		a = myInput.nextInt();
		
		System.out.print("Nhap vao so b: ");
		b = myInput.nextInt();
		
		System.out.print("Nhap vao so c: ");
		c = myInput.nextInt();
		
		System.out.printf("So nho nhat trong ba so %d ,%d ,%d la %d \n",a,b,c,Math.min(Math.min(a, b), c));
		System.out.printf("So lon nhat trong ba so %d ,%d ,%d la %d \n",a,b,c,Math.max(Math.max(a, b), c));
	}

}
