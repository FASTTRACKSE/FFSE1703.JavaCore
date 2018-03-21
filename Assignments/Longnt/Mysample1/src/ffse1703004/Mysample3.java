package ffse1703004;

import java.util.Scanner;

public class Mysample3 {
	public static void main(String[] args) {
		double a, b, c, x, delta ,x1,x2;
		
		Scanner myInput = new Scanner(System.in);
		System.out.println("nhap so a :");
		a = myInput.nextInt();
		System.out.println("nhap so b :");
		b = myInput.nextInt();
		System.out.println("nhap so c :");
		c = myInput.nextInt();
		   if (a == 0) {
	            if (b == 0) {
	                System.out.println("Phương trình vô nghiệm!");
	            } else  {
	                System.out.println("Phương trình có một nghiệm: "
	                        + "x = " + (-c / b));
	            }} 
		   else {
    delta = (b*b) - (4*a*c);
    x1 = (-b +Math.sqrt(delta))/2*a;
    x2 = (-b -Math.sqrt(delta))/2*a;
if (delta < 0) {  System.out.println("Phương trình vô nghiệm!");
} else if (delta == 0) {
	System.out.println("Phương trình có nghiệm kép x =" + (-b/(2*a)));
} else  {
	System.out.println("phương trình có 2 nghiệm là " + "x1:  = " + x1 + " và x2 = " + x2);
}}}}
		  
