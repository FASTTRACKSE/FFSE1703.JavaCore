package fasttrack.edu.vn;
import java.util.Scanner;

public class Tong2so {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a, b, c, x , y;
		Scanner myInput = new Scanner(System.in);
		System.out.print("nhap vao so a : ");
		a = myInput.nextInt();
		System.out.print("nhap vao so b : ");
		b = myInput.nextInt();
		System.out.print("nhap vao so c : ");
		c = myInput.nextInt();
		x = Math.min(a, Math.min(b, c));
		y = Math.max(a, Math.max(b,c));
		
		System.out.println("so nho nhat trong ba so la :" + x );
		System.out.printf("so lon nhat trong ba so la :" + y);
}
}
