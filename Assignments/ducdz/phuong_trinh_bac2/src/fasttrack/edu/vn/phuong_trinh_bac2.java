package fasttrack.edu.vn;
import java.util.Scanner;
import java.lang.Math;
public class phuong_trinh_bac2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a,b,c;
		Scanner myInput = new Scanner(System.in);
		System.out.println("Nhap so a: ");
		a = myInput.nextInt();
		System.out.println("Nhap so b: ");
		b = myInput.nextInt();
		System.out.println("Nhap so c: ");
		c = myInput.nextInt();
		if(a==0) {
			if(b==0) {
				if(c==0) {
					System.out.println("Phuong trinh vo so nghiem");
				}
				else {
				System.out.println("phuong trinh vo nghiem");
				}
			}
			else {
				int x = -c/b;
				System.out.print("phuong trinh co nghiem la : " + x);
			}
		}
		else {
			double delta = (b*b)-(4*(a*c));
			System.out.println(delta);
			if(delta < 0) {
				
				System.out.println("Phuong trinh vo nghiem !");
			}
			else if(delta > 0) {
				double x1 = (-b+(Math.sqrt(delta))/2*a);
				double x2 = (-b-(Math.sqrt(delta))/2*a);
				System.out.println("Phuong trinh co nghiem x1 : "+x1);
				System.out.println("Phuong trinh co nghiem x2 : "+x2);
			}
			else {
				int x = -b/2*a;
				System.out.println("Phuong trinh co nghiem kep la: "+x);
			}
		}
	}
}
