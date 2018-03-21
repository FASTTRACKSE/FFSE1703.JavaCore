package Fasttrack.edu.vn;
import java.util.Scanner;
public class Phuongtrinhbac2 {
	public static void main(String[] args) {
	int a, b, c;
	float x1,x2;
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
			x1 = (float) ((-b + Math.sqrt(x)) / (2*a));
			x2 = (float) ((-b - Math.sqrt(x)) / (2*a));
			System.out.println("Phương trình có 2 nghiệm là: "
                    + "x1 = " + x1 + " và x2 = " + x2);



		}if(x==0) {
			System.out.println("Phuong trinh co nghiem kep");
			x1 = (-b / (2 * a));
			 System.out.println("Phương trình có nghiệm kép: "
	                    + "x1 = x2 = " + x1);


				}
			}
	}
}