package fasstrack.edu.vn;


import java.util.Scanner;

public class Giaiptbac2 {

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
		System.out.println("Giai phuong trinh "+a+"x2 + "+b+"x + "+c+" = 0");
		if (a==0) {
			if (b==0) {
				if (c==0) {
					System.out.println("Phuong trinh vo so nghiem");
				} else {
					System.out.println("Phuong trinh vo nghiem");
				}
			} else {
				if (c==0) {
					System.out.println("Phuong trinh co 1 nghiem x=0");
				} else {
					System.out.println("Phuong trinh vo nghiem");
				}
			}
		} else {
			float x,x1,x2,delta;
			delta = b*b-4*a*c;
			if (delta < 0) {
				System.out.println("Phuong trinh vo nghiem");
			} else if (delta == 0) {
				x=-b/(2*a);
				System.out.printf("Phuong trinh co nghiem kep la x= %.2f",x);
			} else {
				x1 = (float)(-b-(Math.sqrt(delta)))/(2*a);
				x2 = (float)(-b+(Math.sqrt(delta)))/(2*a);
				System.out.printf("Phuong trinh co hai nghiem la x1= %.2f va x2= %.2f",x1,x2);
			}
		}
	}
}
