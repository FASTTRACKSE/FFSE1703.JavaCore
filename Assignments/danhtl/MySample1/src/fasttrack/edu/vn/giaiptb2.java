package fasttrack.edu.vn;
import java.util.Scanner;
import java.lang.Math;
public class giaiptb2 {
	public static void main (String[] args) { 
		int a , b , c;
		Scanner myInput = new Scanner(System.in);
		System.out.print("nhap vao so a : ");
		a = myInput.nextInt();
		System.out.print("nhap vao so b : ");
		b = myInput.nextInt();
		System.out.print("nhap vao so c : ");
		c = myInput.nextInt();
	if(a==0) {
		System.out.println("vi a=0  pt tro thanh pt bac 1");
	}else {
		double x =Math.pow(b, 2)-4*a*c;
		if( x < 0) {
			System.out.println("phuong trinh vo nghiem ");}
		if(x > 0) {
			System.out.println("phuong trinh co 2 nghiem ");
		}if(x==0) {
			System.out.println("phuong trinh co nghiem kep");
				}
			}
	}
}
