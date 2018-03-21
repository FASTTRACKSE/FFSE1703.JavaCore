package text1;
	import java.util.Scanner;
	public class tinhtong {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a,b,c,d;
		double e;
		Scanner myInput = new Scanner(System.in);
		System.out.print("nhap vao so a :");
		a= myInput.nextInt();
		System.out.print("nhap vao so b :");
		b= myInput.nextInt();	
		c = Math.min(a,b);
		d = Math.max(a,b);
		
		System.out.println("Gia tri nho nhat : "+c);
		System.out.println("Gia tri lon nhat : "+d);
		System.out.println("can bac hai cua so lon nhat : "+e);
	}
}
