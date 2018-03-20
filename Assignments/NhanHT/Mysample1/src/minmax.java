	import java.util.Scanner;
public class minmax {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a,b,c,x,y,e,f;
		Scanner myInput = new Scanner(System.in);
		
		System.out.print("Nhap vao so a : ");
		a = myInput.nextInt();
		System.out.print("Nhap vao so b : ");
		b = myInput.nextInt();
		System.out.print("Nhap vao so c : ");
		c = myInput.nextInt();
		
		x=Math.min(a,b);
		y=Math.min(x,c);
		
		e=Math.max(a,b);
		f=Math.max(e,c);
		
		System.out.println("so nho nhat la : "+ y);
		System.out.println("so lon nhat la : "+ f);
		
	}

}
