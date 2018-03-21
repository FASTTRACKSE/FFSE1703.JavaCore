package assignment;
import java.util.Scanner;
public class Giaiphuongtrinh {

	public static void main(String[] args) {
		Scanner myInput = new Scanner(System.in);
		
		double a, b, c, x, x1, x2, delta;
		
		System.out.print("Nhập a:");
		a = myInput.nextDouble();
		
		System.out.print("Nhập b:");
		b = myInput.nextDouble();
		
		System.out.print("Nhập c:");
		c = myInput.nextDouble();
		
		
		
//		tính delta
		delta = (b*b) - 4*a*c;
		
		if (a == 0) {
			if (b == 0) {
				if (c != 0) {
					System.out.println("Phương trình vô nghiệm");
				}
				else {
					System.out.println("Phương trình vô số nghiệm");
				}
				
			}
			else {
				x = -c/b;
				System.out.println("Phương trình có nghiệm x =" + x);
			}
		}
		else {
			
			if (delta > 0 ) {
				x1 = (-b + Math.sqrt(delta))/(2*a);
				x2 = (-b - Math.sqrt(delta))/(2*a);
				System.out.println("Phương trình có 2 nghiệm phân biệt x1, x2 là " + x1 + " và " + x2);
			}
			else if (delta == 0) {
				x = -b/2*a;
				System.out.println("Phương trình có nghiệm kép x = " + x);
			}
			else if (delta < 0) {
				System.out.println("Phương trình vô nghiệm");
			}
			
		}

	}

}
