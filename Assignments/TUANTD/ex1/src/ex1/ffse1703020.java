package ex1;
import java.util.Scanner;
public class ffse1703020 {
	public static void main(String[] args) {
		int a, b, c;
		Scanner myInput = new Scanner(System.in);
		
		System.out.print("Nhap vao so a : ");
		a = myInput.nextInt();
		
		System.out.print("Nhap vao so b : ");
		b = myInput.nextInt();
		
		c = a + b;
		
		System.out.printf("Tong cua %d + %d = %d \n", a, b, c);
	}
}
