package ffse1703012;

import java.util.Scanner;

public class PhuongTrinhBac2 {

	public static void main(String[] args) {
		int a , b, c;
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhập vào số a:");
		a= scanner.nextInt();
		System.out.print("Nhập vào số b:");
		b= scanner.nextInt();
		System.out.print("Nhập vào số c:");
		c= scanner.nextInt();
		if (a==0 && b==0 && c==0) {
			System.out.println("Phương trình vô số nghiệm");
		}else {
			if(a==0 && b==0) {
				System.out.println("Phương trình vô nghiệm");
			}else {
				if(a==0) {
					System.out.println("Phương trình có nghiệm bậc nhất x="+ (-c/b));
				}else {
					double delta;
					delta = b*b- 4*a*c;
					if(delta<0) {
						System.out.println("Phương trình vô nghiệm!");
					}else{
						if(delta==0) {
							System.out.println("Phương trình có nghiệm kép x1=x2" + (-b/(2*a)));
						}else {
						System.out.println("Phương trình có hai nghiệm phân biệt x1=" + (-b+Math.sqrt(delta))/(2*a) + " và x2=" + (-b-Math.sqrt(delta))/(2*a));
					}
				}
			}
			}
	}

}
}
