package test;
import java.util.Scanner; 
public class sum {
	public static void main(String args[]){
		int a,b,c, d,e;
		Scanner inp = new Scanner(System.in);
		System.out.print("nhap so a:");
		a=inp.nextInt();
		System.out.print("nhap so b:");
		b=inp.nextInt();
		System.out.print("nhap so c:");
		c=inp.nextInt();
		d = Math.min(a, b);
		d = Math.min(d,c);
		e = Math.max(a, b);
		e = Math.max(e,c);
		System.out.println("gia tri nho nhat:"+ d);
		System.out.println("gia tri lon nhat:"+ e); 
		
	   }
	
}
