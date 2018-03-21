package fasttrack.edu.vn;
import java.util.Scanner;
import java.lang.Math;
public class giaiptb2 {
	public static void main (String[] args) { 
		double a , b , c, x1, x2;
		Scanner myInput = new Scanner(System.in);
		System.out.print("nhap vao so a : ");
		a = myInput.nextInt();
		System.out.print("nhap vao so b : ");
		b = myInput.nextInt();
		System.out.print("nhap vao so c : ");
		c = myInput.nextInt();
	if(a==0) {
		if(b==0) {
			if(c==0) {
				System.out.println("phương trình vô số nghiệm");
		              }
			    else {
				      System.out.println("phương trình vô  nghiệm");
			         }
		         }
	         else { 
		         System.out.println("phương trình có nghiệm là : " + -c/b);
		            }
	         
	
	} else  {
		double denta =Math.pow(b, 2)-4*a*c;
		if( denta < 0) {
			System.out.println("phương trình vô  nghiệm ");}
	    else if (denta > 0) {
	    	x1 = (-b + Math.sqrt(denta))/(2*a);
	    	x2 = (-b - Math.sqrt(denta))/(2*a);
			System.out.println("phương trình có 2 nghiệm là : x1 = "+ x1 +" và x2 = "+ x2);
		}else if(denta==0) {
			x1 = x2 = -b/2*a;
			System.out.println("Phương trình có nghiệm kép là : x1 = x2 =" + x1);
				}
			}
	}
}
