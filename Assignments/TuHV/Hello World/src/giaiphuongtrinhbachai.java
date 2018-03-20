import java.util.Scanner;
import java.lang.Math;

public class giaiphuongtrinhbachai {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a, b, c;
		Scanner myInput = new Scanner(System.in);
		System.out.print("nhap vao so a : ");
		a = myInput.nextInt();
		System.out.print("nhap vao so b : ");
		b = myInput.nextInt();
		System.out.print("nhap vao so c : ");
		c = myInput.nextInt();
		
		if (a==0) {
			System.out.print("vi phuong trinh bac hai la a khac 0");
		}
			double x ;
			x=Math.pow(b,2)- 4*a*c;
				if (x < 0) {
					System.out.println("Phuong trinh vo nghiem ");}
				if (x>0) {
					System.out.println("phuong trinh co 2 nghiem");}
				if (x==0) {
					System.out.println("phuong trinh co nghiem kep");}
		
	
}

}

