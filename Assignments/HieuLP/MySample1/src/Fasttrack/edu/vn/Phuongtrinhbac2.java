package Fasttrack.edu.vn;
import java.util.Scanner;
public class Phuongtrinhbac2 {
	int a, b, c;
	Scanner myInput = new Scanner(System.in);
	
	System.out.print("Nhap so a: ");
	a = myInput.nextInt();
	
	System.out.print("Nhap so b: ");
	b = myInput.nextInt();
	
	System.out.print("Nhap so c: ");
	c = myInput.nextInt();
	
	if(a==0) {
		System.out.println("Khong phai phuong trinh bac 2");
	}else {
		double x =Math.pow(b, 2)-4*a*c;
		if( x < 0) {
			System.out.println("Phuong trinh vo nghiem ");}
		if(x > 0) {
			System.out.println("Phuong trinh co 2 nghiem ");
		}if(x==0) {
			System.out.println("Phuong trinh co nghiem kep");
				}
			}
	}
}