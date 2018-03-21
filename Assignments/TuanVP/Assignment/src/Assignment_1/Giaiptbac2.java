package Assignment_1;


import java.util.Scanner;

public class Giaiptbac2 {

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
		System.out.println("Giai phuong trinh "+a+"x2 + "+b+"x + "+c+" = 0");
		double x,x1,x2,delta;
		delta = b*b-4*a*c;
		if (b==0) {
			if ((-c/a)<0) {
				System.out.println("Phuong trinh vo nghiem");
			} else if ((-c/a)==0) {
				x=0;
			} else {
				x1= (double)Math.sqrt(-c/a);
				x2= -(double)Math.sqrt(-c/a);
				System.out.printf("Phuong trinh co 2 nghiem la x1= %.2f va x2= %.2f",x1,x2);
			}
		} else {
			if (delta < 0) {
				System.out.println("Phuong trinh vo nghiem");
			} else if (delta == 0) {
				x=-b/(2*a);
				System.out.printf("Phuong trinh co nghiem kep la x= %.2f",x);
			} else {
				x1 = (double)(-b-(Math.sqrt(delta)))/(2*a);
				x2 = (double)(-b+(Math.sqrt(delta)))/(2*a);
				System.out.printf("Phuong trinh co hai nghiem la x1= %.2f va x2= %.2f",x1,x2);
			}
		}
	}
}
