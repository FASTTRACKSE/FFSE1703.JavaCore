package assignment;
import java.util.Scanner;
public class Sosanh {

	public static void main(String[] args) {
		Scanner myInput = new Scanner(System.in);
		int a, b, c, d;
		
		
		 System.out.print("Nhập Vào số thứ 1: ");
		 a = myInput.nextInt();
		 
		 System.out.print("Nhập Vào số thứ 2: ");
		 b = myInput.nextInt();
		 
		 System.out.print("Nhập Vào số thứ 3: ");
		 c = myInput.nextInt();
		 
		 // TÌM SỐ LỚN NHẤT
		 
		 if (a > b && a > c) {
			 System.out.println("Số lớn nhất là: " + a);
		}
		 else if (b > a && b > c) {
			 System.out.println("Số lớn nhất là: " + b);
		}
		 else {
			 System.out.println("Số lớn nhất là: " + c);
		 }
		 
		 // TÌM SỐ NHỎ NHẤT
		 
		 if (a < b && a < c) {
			 System.out.println("Số nhỏ nhất là: " + a);
		}
		 else if (b < a && b < c) {
			 System.out.println("Số nhỏ nhất là: " + b);
		}
		 else {
			 System.out.println("Số nhỏ nhất là: " + c);
		 }
//		x = Math.max(a, b);
//		y = Math.max(x, c);
		
		


	}

}
