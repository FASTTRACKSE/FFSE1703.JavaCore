package Asm1;
import java.util.Scanner;
public class Assignment {
	public static void main(String[] args) {
		int a,b,c;
		Scanner input = new Scanner(System.in);
		double x1,x2,d;
		System.out.println("Tính phương trình bật 2 có dạng : A^2X + BX + C = 0");
		System.out.print("Nhập hệ số bậc 2 : A =");
		a = input.nextInt();
		System.out.print("Nhập hệ số bậc 1 :B=");
		b = input.nextInt();
		System.out.print("Nhập hệ số tự do :C=");
		c = input.nextInt();
		if (a==0) {
			if(b==0) {
				if(c==0) {
					System.out.print("Phương trình có vô số nghiệm");
				}else {
					System.out.print("Phương trình vô nghiệm");
				}
			}else {
				x1=-c/b;
				System.out.print("Phương trình có 1 nghiệm là :" + x1);
			}
		}else {
			d=b*b-4*a*c;
			if(d>0) {
				x1=(-b-Math.sqrt(d))/(2*a);
				x2=(-b+Math.sqrt(d))/(2*a);
				System.out.print("Phương trình có 2 nghiệm là :" + x1 + "," + x2);
			}else if(d==0){
				x1=(-b)/(2*a);
				System.out.print("Phương trình có nghiệm kép là :" + x1);
			}else {
				System.out.print("Phương trình vô nghiệm");
			}
		}
		
	}
}
