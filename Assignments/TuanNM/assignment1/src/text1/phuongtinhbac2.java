package text1;
import java.util.Scanner;
public class phuongtinhbac2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a,b,c;
		double denta,b2,x1,x2,candenta,x;
		
		Scanner myInput = new Scanner(System.in);
		System.out.print("nhap vao so a :");
		a= myInput.nextInt();
		System.out.print("nhap vao so b :");
		b= myInput.nextInt();	
		System.out.print("nhap vao so c :");
		c= myInput.nextInt();
		System.out.println("phuong trinh :"+a+"x2 +"+b+"x + "+c+" = 0");
		
		if(a==0) {
			if(b==0) {
				System.out.println("phuong trinh vo nghiem");
			}else {
				x= -c/b;
				System.out.println("phương trình có 1 nghiem =" +x);
			}
		}
		if(a!= 0) {
			b2 = Math.pow(b,2);
			denta = b2-4*a*c;
			System.out.println("denta ="+denta);
			candenta = Math.sqrt(denta);
			
			if(denta > 0) {
				x1 = (-b+candenta)/2*a;
				x2 = (-b-candenta)/2*a;
				System.out.println("x1 = "+x1);
				System.out.println("x2 = "+ x2);
			}else if(denta ==0) {
				x = -b/2*a;
				System.out.println("phương trình có 1 nghiem kep =" +x);
			}else {
				System.out.println("phương trình vo nghiem");
			}
		}
		
		
		
		
		
		
	}

}
