package ffse1703012;
import java.util.Scanner;
public class NhapDuLieu {

	public static void main(String[] args) {
			int a,b,c,min,max;
			
			Scanner scanner = new Scanner(System.in);
			System.out.print("Nhập vào số a:");
			a= scanner.nextInt();
			System.out.print("Nhập vào số b:");
			b= scanner.nextInt();
			System.out.print("Nhập vào số c:");
			c= scanner.nextInt();
			
			System.out.printf("Số lớn nhất là:%d \n", + Math.max(Math.max(a,b), c));
			System.out.printf("Số nhỏ nhất là:%d \n",+ Math.min(Math.min(a,b), c));
		}
		
	}


