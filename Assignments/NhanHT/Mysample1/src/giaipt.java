	import java.util.Scanner;
public class giaipt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Scanner myInput = new Scanner(System.in);
		double a,b,c,kq,x,y; 
		System.out.print("Nhap A : ");
		a = myInput.nextDouble();
		System.out.print("Nhap B : ");
		b = myInput.nextDouble();
		System.out.print("Nhap C : ");
		c = myInput.nextDouble();
		
		kq = (b*b)-4*a*c;
		if(a==0) {
			if(b==0) {
				System.out.print("Phuong trinh vo nghiem");
			}else {
				x=-c/b;
				System.out.print("Phuong trinh co nghiem " + x);
			}
		}else {
		if(kq==0) {
			x=-b/2*a;
			System.out.print("Phuong trinh co nghiem kep la :"+x);
		}else if(kq>0) {
			x=(-b+Math.sqrt(kq))/(2*a);
			y=(-b-Math.sqrt(kq))/(2*a);
			System.out.print("Phuong trinh co 2 nghiem :"+ x +" va " + y);
		}else {
			System.out.print("Phuong trinh vo nghiem");
			}
		}
	}
}
