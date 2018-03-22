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
			  System.out.print("Nhập phần tử thứ " + (i + 1) + ": ");
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
		 int vitri1=1, vitri2=1;
		 for (int i=1;i<n;i++)
		 {
		     if(max<arr[i])
		     {
			   max    = arr[i];
		       vitri1 = i + 1;
		     }
		     if(min>arr[i]) 
		     {
		       min    = arr[i];
		       vitri2 = i + 1;
		      }
		 }
		 System.out.println("Số phần tử lớn nhất trong mảng là : " + max + " và nằm ở vị trí thứ "+ vitri1 +" của mảng");
		 System.out.println("Số phần tử nhỏ nhất trong mảng là : " + min + " và nằm ở vị trí thứ "+ vitri2 +" của mảng");
	}
}

	
