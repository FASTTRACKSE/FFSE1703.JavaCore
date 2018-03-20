package fasttrack.edu.vn;

import java.util.Scanner;

public class GiaiPTbac2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a,b,c;
		Scanner myInput= new Scanner(System.in);
		
		System.out.print("Nhap vao so a: ");
		a = myInput.nextInt();
		while (a==0) {
			System.out.print("Nhap vao so a: ");
			a = myInput.nextInt();
		}
		
		System.out.print("Nhap vao so b: ");
		b = myInput.nextInt();
		
		System.out.print("Nhap vao so c: ");
		c = myInput.nextInt();
		float x,x1,x2,delta;
		delta = b*b-4*a*c;
		if (delta < 0) {
			System.out.println("Phuong trinh vo nghiem");
		} else if (delta == 0) {
			x=-b/(2*a);
			System.out.printf("Phuong trinh co nghiem duy nhat la %.2f",x);
		} else {
			x1 = (float)(-b-(Math.sqrt(delta)))/(2*a);
			x2 = (float)(-b+(Math.sqrt(delta)))/(2*a);
			System.out.printf("Phuong trinh co hai nghiem la %.2f va %.2f",x1,x2);
		}
	}
}
