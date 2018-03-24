import java.util.Scanner;
public class Bai3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner myInput = new Scanner(System.in);
		
		System.out.print("Nhap so phan tu cua mang: ");
		int a = myInput.nextInt();
		
		int arr[] = new int[a];
		
		int minvt = 0;
		int maxvt = 0;
		
		for(int i=0;i<a;i++) {
			System.out.print("Nhap " + "["+ (i +1)+"]");
			 arr[i] = myInput.nextInt();
		}
		int min = arr[0];
		for(int i = 1; i < a; i++) {
			if(arr[i]<min) {
				min = arr[i];
				minvt=i;
			}
		}
		int max = arr[0];
		for(int i = 1; i < a; i++) {
			if(arr[i]>max) {
				max = arr[i];
				maxvt=i;
			}
		}
		System.out.print("nhung phan tu trong mang:");
		for(int i=0;i<a;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.print("\n");
		System.out.println("So nho nhat la: "+ min);
		System.out.println("So lon nhat la: "+ max);
		System.out.println("Key nho nhat la: "+ minvt);
		System.out.println("Key lon nhat la: "+ maxvt);

	}

}
