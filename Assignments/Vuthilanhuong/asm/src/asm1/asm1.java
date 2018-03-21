package asm1;
import java.util.Scanner;
public class asm1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int a,b,c;
			Scanner sc = new Scanner(System.in);
			double x1,x2,d;
			System.out.println("phương trình bậc 2 có dạng: ax^2+bx+c=0");
			System.out.print("nhập hệ số a:");
			a = sc.nextInt();
			
			System.out.print("nhập hệ số b:");
			b = sc.nextInt();
			
			System.out.print("nhập hệ số c:");
			c = sc.nextInt();
			if(a==0) {
				if(b==0) {
					if(c!=0) {
						System.out.println("phương trinh vô nghiệm");
					}else {
						System.out.println("phương trinh vô số nghiệm");
					}
				}else {
					x1 = (-c/b);
					System.out.println("phương trinh có 1 nghiệm là:" +x1);
				}
			}else {
				d=b*b-4*a*c;
				if(d>0) {
						x1=(-b+Math.sqrt(d))/(2*a);
						x2=(-b-Math.sqrt(d))/(2*a);
						System.out.println("phương trinh có 2 nghiệm là:" +x1 +"," +x2);
				}else if(d<0) {
					System.out.println("phương trinh có vô nghiệm" );
				}else {
					x1 = (-b)/(2*a);
					System.out.println("phương trinh có nghiệm kép là:" );
				}
				
			}
	}

}
