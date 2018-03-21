package fasttrack.edu.vn;

import java.util.Scanner;

public class vonglap {
	public static void main(String[] args) {
		int n,i,min,max;
		Scanner myInput = new Scanner(System.in);
		
		
		
		System.out.print("Nhập vào số lượng phần tử trong mảng a[] : ");
		n = myInput.nextInt();
		int[] a= new int[n];
		for(i=0; i<n ;i++) {
			System.out.println("Nhập giá trị của phần tử  a["+ i +"] :");
			a[i] = myInput.nextInt();
		}
		
		min=a[0];
		max=a[0];
		
		for(i=0;i<n;i++) {
			if(min>a[i]) {
				min=a[i];
				int x= i+1;
			}
		}
		System.out.println("Số nhỏ nhất trong "+ n +" phần tử là :"+ min);
		System.out.println("là phần tử thứ ");
		for(i=0;i<n;i++) {
			if(max<a[i]) {
				max=a[i];
			}
			int y=i;
		}
		System.out.println("Số lớn nhất trong "+ n +" phần tử là :"+ max);
		
		
		
		
	}
}
