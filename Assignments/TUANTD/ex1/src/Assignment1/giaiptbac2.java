package Assignment1;
import java.util.Scanner;
public class giaiptbac2 {
	public static void main(String[] args) {
		int a , b, c;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Nhập vào sô�? a:");
		a= scanner.nextInt();
		
		System.out.print("Nhập vào sô�? b:");
		b= scanner.nextInt();
		
		System.out.print("Nhập vào sô�? c:");
		c= scanner.nextInt();
		
		if (a==0 && b==0 && c==0) {
			System.out.println("Phương trình vô sô�? nghiệm!");
		}else {
			if(a==0 && b==0) {
				System.out.println("Phương trình vô nghiệm!");
			}else {
				if(a==0) {
					System.out.println("Phương trình co�? nghiệm bậc nhâ�?t x="+ (-c/b));
				}else {
					double delta;
					delta = b*b- 4*a*c;
					if(delta<0) {
						System.out.println("Phương trình vô nghiệm!");
					}else {
						if(delta==0) {
							System.out.println("Phương trình co�? nghiệm ke�?p x1=x2" + (-b/(2*a)));
						}else {
						System.out.println("Phương trình co�? hai nghiệm phân biệt x1=" + (-b+Math.sqrt(delta))/(2*a) + " và x2=" + (-b-Math.sqrt(delta))/(2*a));
					}
				}
			}
			}
	}
}
}