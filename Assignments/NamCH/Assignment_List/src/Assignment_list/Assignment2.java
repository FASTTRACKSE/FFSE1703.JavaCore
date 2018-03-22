package Assignment_list;
import java.util.Scanner;
public class Assignment2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size,max=0,min=0,a=0,b=0,dem=1;
		Scanner input = new Scanner(System.in);
		System.out.print("Bạn muốn so sánh bao nhiêu số :");
		size = input.nextInt();
		int[] array= new int[size];
		
		for (int i=0;i < size ;i++) {
			System.out.print("Nhập số cần so sánh thứ " +dem +":");
			array[i]=input.nextInt();
			min = array[i];			
			dem++;
		}
		System.out.print("các số được so sánh là :");
		for (int j=0; j<size ;j++) {
			if (max <= array[j]) {
				max = array[j];
				a=j+1;
			}
			if (min >= array[j]) {
				min = array[j];
				b=j+1;
			}
			
			System.out.print(array[j] + "\t");
		}
		System.out.println("\nSố lớn nhất tìm được là số : "+max + " vị trí thứ " +a +" trong các số");
		System.out.println("Số lớn nhất tìm được là số : "+min + " vị trí thứ " +b +" trong các số");
	}
}
