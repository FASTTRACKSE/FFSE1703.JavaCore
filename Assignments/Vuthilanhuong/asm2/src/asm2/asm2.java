package asm2;
import java.util.Scanner;
public class asm2 {
	public static void main(String[] args){
		int dai, max=0,min=0,dem=1,a=0,b=0;
		Scanner sc = new Scanner(System.in);
		System.out.print("bạn muốn so sánh bao nhiêu số: ");
		dai= sc.nextInt();
		int[]mang = new int[dai];
		for (int i=0; i<dai; i++) {
			System.out.print("nhập số thứ " +dem +" : ");
			mang[i]=sc.nextInt();
			min = mang[i];
			dem++;
		}
		System.out.print("các số cần so sánh là: ");
		for(int j=0; j<dai; j++) {
			if (max <= mang[j]) {
				max=mang[j];
				a=j+1;
			}
			if (min >= mang[j]) {
				min=mang[j];
				b=j+1;
			}
			System.out.print(mang[j] + "\t");
		}
		System.out.println("\nsố lớn nhất là: "+ max + " vị trí thứ " +a);
		System.out.println("số nhỏ nhất là: "+ min + " vị trí thứ " +b);
		 
	}
	

}
