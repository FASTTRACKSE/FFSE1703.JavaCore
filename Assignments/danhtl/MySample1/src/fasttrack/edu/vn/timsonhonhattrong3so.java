package fasttrack.edu.vn;
import java.util.Scanner;
public class timsonhonhattrong3so {
	public static void main (String[] args) {
		int a, b, c, x, y;
		Scanner myInput = new Scanner(System.in);
		System.out.print("nhap vao so a : ");
		a = myInput.nextInt();
		System.out.print("nhap vao so b : ");
		b = myInput.nextInt();
		System.out.print("nhap vao so c : ");
		c = myInput.nextInt();
		x = Math.min(a ,Math.min( c , b));
	System.out.println("so nhat  trong 3 so la :" + x);
}
}