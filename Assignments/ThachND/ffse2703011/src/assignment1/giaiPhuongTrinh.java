package assignment1;
import java.util.Scanner;
public class giaiPhuongTrinh {
	public static void main(String[] args) {
		Scanner myInput = new Scanner(System.in);
		double a, b, c, x1, x2, delta, x;
		
		System.out.print("Nhập a:");
		a = myInput.nextDouble();
		System.out.print("Nhập b:");
		b = myInput.nextDouble();
		System.out.print("Nhập c:");
		c = myInput.nextDouble();
		
	//tính delta
		delta = (b*b) - 4*a*c;
		
		if (a == 0) {
			if (b == 0 ) {
				if (c == 0)
			System.out.println("Phương trình vô nghiệm");
		}
		else {
			x = -c/b;
			System.out.println("Phương trình vô số nghiệm");
		}
	}
		else {
			
			if (delta < 0) {
				x1 = (-b+Math.sqrt(delta))/(2*a);
				x2 = (-b+Math.sqrt(delta))/(2*a);
				System.out.println("Phương trình có nghiệm phân biệt x1 = "+x1);
				System.out.println("Phương trình có nghiệm phân biệt x1 = "+x2);
			}
			else {
				System.out.println("Phương trình có nghiệm kép x1=x2 "+(-b/(2*a)));
			}
		}
	}
}
