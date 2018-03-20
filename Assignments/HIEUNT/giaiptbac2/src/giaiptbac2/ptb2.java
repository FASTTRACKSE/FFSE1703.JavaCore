package giaiptbac2;
import java.util.Scanner;
import java.lang.Math;
public class ptb2 {

	public static void main(String[] args) {
		
		
		    double a,b,c,x1,x2;
		    double delta;
		    Scanner input = new Scanner(System.in);
		    System.out.print("Nhap a= ");
		    a=input.nextFloat();
		    System.out.print("Nhap b= ");
		    b=input.nextFloat();
		    System.out.print("Nhap c= ");
		    c=input.nextFloat();
		      if(a==0){
		        if(b==0){
		          if(c==0){
		            System.out.println("Phuong trinh vo so nghiem ");
		          }
		          else{
		            System.out.println("Phuong trinh vo nghiem ");
		          }
		        }
		        else{
		          x1=(-c)/b;
		          System.out.println("Phuong trinh co nghiem duy nhat : " + x1);
		        }
		      }
		      else{
		        delta= (b*b)-(4*a*c);
		        if(delta<0){
		          System.out.println("Phuong trinh vo nghiem");
		        }
		        if(delta==0){
		          x1= -b/(2*a);
		          System.out.println("Phuong trinh co nghiem duy nhat" +x1);
		        }
		        if(delta>0){
		          x1=(-b+Math.sqrt(delta))/(2*a);
		          x2=(-b-Math.sqrt(delta))/(2*a);
		          System.out.println("Phuong trinh co 2 nghiem" );
		          System.out.println(x1);
		          System.out.println(x2);
		        }
		      }
		  }
		 
		

	}


