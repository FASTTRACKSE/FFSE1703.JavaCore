import java.util.Scanner;
public class Bai3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner myInput = new Scanner(System.in);
		
		System.out.print("Nhap so phan tu cua mang: ");
		int a = myInput.nextInt();
		
		int arr[] = new int[a];
		
		for(int i=0;i<a;i++) {
			System.out.print("Nhap " + "["+ i +"]");
			 arr[i] = myInput.nextInt();
		}
		int min = arr[0];
		for(int i = 0; i < arr.length; i++) {
			if(arr[i]<min) {
				min = arr[i];
				
			}
		}
		int max = arr[0];
		for(int i = 0; i < arr.length; i++) {
			if(arr[i]>max) {
				max = arr[i];
				
			}
		}
		System.out.println("So nho nhat la: "+ min);
		System.out.println("So lon nhat la: "+ max);
	}

}
