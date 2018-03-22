package Assignment2;
import java.util.Scanner;
public class baitap2 
{
	public static void main(String[] args) 
	{
	    int n;
	    int count = 0;
	    Scanner scanner = new Scanner(System.in); 
    	do {
	         System.out.println("Nhập vào số phần tử của mảng: ");
		     n = scanner.nextInt();
		   } while (n < 0);
	 	int arr[] = new int[n];
	 		 System.out.println("Nhập các phần tử cho mảng: ");
 		for (int i = 0; i < n; i++) 
 			{
			  System.out.print("Nhập phần tử thứ " + i + ": ");
			  arr[i] = scanner.nextInt();
 			}
		 //Đếm số lần xuất hiện của 1 phần tử 
		      System.out.println("Nhập vào 1 số nguyên bất kỳ: ");
		 int number = scanner.nextInt();
		 for (int i = 0; i < n; i++) 
		 {
		     if (arr[i] == number) {
		         count++;
		     }
		 }
		      System.out.println("Số phần tử " + number + " có trong mảng = " + count);
		 //tìm min & max
		 int max = arr[0];
		 int min = arr[0];
		 for (int i=0;i<n;i++)
		 {
		     if(max<arr[i])
			  max=arr[i];
		     if(min>arr[i])
		      min=arr[i];
		 }
		 System.out.println("Số phần tử lớn nhất trong mảng là : " + max);
		 System.out.println("Số phần tử nhỏ nhất trong mảng là : " + min);
	}
}

	
