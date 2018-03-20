package text1;
import java.util.Scanner;
public class sum {

	public static void main(String[] args) {
		int a, b, c, d, e;
		
		Scanner input = new Scanner(System.in);
		System.out.print("Nhap so a :");
		a = input.nextInt();
		System.out.print("Nhap so b :");
		b = input.nextInt();
		System.out.print("Nhap so c :");
		c = input.nextInt();
		d=Math.min(a,b);
		d=Math.min(d,c);
		e=Math.max(a,b);
		e=Math.max(e,c);
		System.out.println("Giá trị nhỏ nhất :" +d);
		System.out.println("giá trị lớn nhất :" +e);
	}
}
