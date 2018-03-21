package fasttrack.edu.vn;
import java.util.Scanner;
public class phuong_trinh_bac2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a,b,c;
		Scanner myInput = new Scanner(System.in);
		System.out.println("Nhap so a:");
		a = myInput.nextInt();
		System.out.println("Nhap so b:");
		b = myInput.nextInt();
		System.out.println("Nhap so c:	");
		c = myInput.nextInt();
		double delta = b*b-4*a*c;
		if(delta<0 && b==0) {
			System.out.println("phuong trinh vo nghiem");
		}
		if(delta==0) {
			int x = -b/2*a;
			System.out.println("phuong trinh co nghiem kep : "+x);
		}
		if(delta>0) {
			double x1 = (-b+(Math.sqrt(delta))/2*a);
			double x2 = (-b-(Math.sqrt(delta))/2*a);
			System.out.println("Phuong trinh co nghiem x1 : "+x1);
			System.out.println("Phuong trinh co nghiem x2 : "+x2);
		}
	}

}
