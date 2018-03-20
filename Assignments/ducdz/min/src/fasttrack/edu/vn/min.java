package fasttrack.edu.vn;
import java.util.Scanner;

public class min {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a,b,c;
		Scanner myInput = new Scanner(System.in);
		System.out.print("Nhap vao so a : ");
		a = myInput.nextInt();
		System.out.print("Nhap vao so b : ");
		b = myInput.nextInt();
		System.out.print("So nho nhat : "+Math.min(a, b));
	}
}