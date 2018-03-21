package fasttrack.edu.vn;
import java.util.Scanner;
public class Tong2so {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a,b,c;
		
		Scanner myInput = new Scanner(System.in);
		
		System.out.print("nhap vao so a : ");
		a = myInput.nextInt();
		
		System.out.print("nhap vao so b : ");
		b = myInput.nextInt();
		
		c = a +b;
		
		System.out.printf("Tong cua %d + %d = %d \n", a ,b ,c );
	}


}