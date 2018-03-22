package fasttrack.edu.vn;
import java.util.Scanner;

public class Timsolonnhattrongmang {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int a;
		int i;
		System.out.print("Nhap so phan tu cua mang= ");
		a = input.nextInt();
		int[] b = new int[a];
		for (i = 1; i <= a; i++) {
			System.out.println("Nhap so phan tu cua mang " + i + ":");
			b[i - 1] = input.nextInt();

		}
		int max=b[0];
		int min=b[0];
		int vitrimax=0;
		int vitrimin=0;
		
		for(i = 1; i <= a; i++) {
			if(max<b[i-1]) {
				max=b[i-1];
				vitrimax=i;
			}
			if(min>b[i-1]) {
				min=b[i-1];
				vitrimin=i;
			}
			
		}
	
		  System.out.println("max="+max+" vi tri thu"+" "+vitrimax);
	      System.out.println("min="+min+" vi tri thu"+" "+vitrimin);
	}
}