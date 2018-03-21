package fasttrack.edu.vn;

import java.util.Scanner;

public class Giaiphuongtrinhbachai2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a, b, c;
		Scanner myInput = new Scanner(System.in);
		System.out.print("nhap vao so a : ");
		a = myInput.nextInt();
		System.out.print("nhap vao so b : ");
		b = myInput.nextInt();
		System.out.print("nhap vao so c : ");
		c = myInput.nextInt();
		
		if (a==0) {
		
		  if (b==0) {
		
		    if (c==0) 
			   System.out.println("Phương trình vô số nghiệm ");
			   else
				   System.out.println("Phương trình vô nghiệm");
		    }
		    else
		    	System.out.println("Phương trình có 1 nghiệm la x = "+(-c/b));
		  }
		  else 
		  {
			double x1 ;
			double x2 ;
			double delta=Math.pow(b, 2)-4*a*c;
			if (delta<0)
				System.out.println("Phương trình vô nghiệm");
			else if (delta>0) {
				x1=(-b+Math.sqrt(delta))/(2*a);
				x2=(-b-Math.sqrt(delta))/(2*a);
				System.out.println("Phương trình có 1 nghiệm x1 = "+x1);
				System.out.println("Phương trình có 1 nghiệm x2 = "+x2);
			}
			else
				System.out.println("Phương trình có nghiệm kép x1=x2= "+(-b/(2*a)));
		  }
		
}


	}


