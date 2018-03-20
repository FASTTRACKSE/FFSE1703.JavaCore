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
		
		System.out.print("Nhap vao so c : ");
		c = myInput.nextInt();
		
		System.out.printf("So nho nhat la %d, %d, %d la %d \n", a, b, c,Math.min(Math.min(a, b), c));
		System.out.printf("So lon nhat la %d, %d, %d la %d \n", a, b, c,Math.max(Math.max(a, b), c));
	}
}
