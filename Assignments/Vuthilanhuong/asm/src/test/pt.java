package test;
import java.util.Scanner; 
public class pt {
	 public static void main(String args[]){
		 Scanner sc = new Scanner(System.in);
		 //pt: ax^2+bx+c=0
		
		 double a,b,c,x1,x2,x,delta;
		 System.out.print("Nhập hệ số bậc 2, a = ");
	        a = sc.nextInt();
	        System.out.print("Nhập hệ số bậc 1, b = ");
	        b = sc.nextInt();
	        System.out.print("Nhập hằng số tự do, c = ");
	        c = sc.nextInt();
	        if (a == 0) {
	            if (b == 0) {
	            	if (c==0) {
	            		System.out.println("Phương trình vô số nghiệm!");
	            	}else {
	            		System.out.println("Phương trình vô nghiệm!");
	            	}
	            } else {
	                System.out.println("Phương trình có một nghiệm: "
	                        + "x = " + (-c / b));
	            }
	            }else {
	            	delta = (b*b) - (4*a*c);
	            	if (delta >0) {
	            		x1=(-b+Math.sqrt(delta))/(2*a);
	            		x2=(-b-Math.sqrt(delta))/(2*a);
	            		System.out.println("Phương trình có 2 nghiệm: " +x1 + "," +x2);
	            	}else if (delta==0){
	            		x1=(-b/(2*a));
	            		System.out.println("Phương trình có nghiệm kép: " +x1 );
	            	}else {
	            		System.out.println("Phương trình vô nghiệm!");
	            	}
	            }
	return;
	 }
	 }
	  

