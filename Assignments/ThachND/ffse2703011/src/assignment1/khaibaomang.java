package assignment1;
import java.util.Scanner;
public class khaibaomang {
		public static void main(String[] args) {
			Scanner myInput = new Scanner(System.in);
			
			int a;
		do {
			System.out.println("Nhập số phần tử cho mảng: ");
			a = myInput.nextInt();
		} while (a < 0);
		int arr[] = new int[a];
		    System.out.println("Nhập giá trị cho các phần tử của mảng: ");
	    for (int i = 0; i < a; i++) {
	        System.out.print("Nhập phần tử thứ " + i + ": ");
	        arr[i] = myInput.nextInt();
	    }
	    int max = arr[0];
	    int min = arr[0];
	    for (int i = 0; i < a; i++)
	    {
	    if(max<arr[i])
	    	max=arr[i];
	    if(min>arr[i])
	    	min=arr[i];
	    }
	    System.out.println("Số phần tử lớn nhất trong mảng là: " + max);
	    System.out.println("Số phần tử lớn nhất trong mảng là: " + min);
	}
}
