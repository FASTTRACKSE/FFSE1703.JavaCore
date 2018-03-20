import java.util.Scanner;

public class Tong2So {
	public static void main(String[] args) {
		int a, b, c;
		a = 5;
		b = 10;
		c = a + b;
		System.out.println("Tong cua "  +  a +  " + " + b + " = " + c );
		Scanner myInput = new Scanner(System.in);
		System.out.println("nhap so a :");
		a = myInput.nextInt();
		System.out.println("nhap so b :");
		b = myInput.nextInt();
		c = a + b;
		System.out.printf("tong cua %d + %d = %d \n",a ,b, c);
	}

}
