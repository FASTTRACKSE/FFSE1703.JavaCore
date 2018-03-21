package assignment;
import java.util.Scanner;
public class Tinhtong {

	public static void main(String[] args) {
		int a, b, c;
		
		Scanner myInput = new Scanner(System.in);
		
		 System.out.print("Nhap Vào số thứ 1: ");
		 a = myInput.nextInt();
		 
		 System.out.print("Nhap Vào số thứ 2: ");
		 b = myInput.nextInt();
		 
		
		 
		 c = a+b;
		 System.out.println("Tổng của " + a + " và " + b + " là:" + c);
		 System.out.printf("Tổng của %d và %d là:%d \n", a,b,c);
		
	

	}

}
