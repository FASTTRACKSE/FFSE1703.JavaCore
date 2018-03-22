package assigment2;

import java.util.Scanner;

public class vidu2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a;
		System.out.print("Nhap so phan tu cua mang: ");

		a = scanner.nextInt();

		int[] arr = new int[a];
		System.out.print("Nhap cac phan tu cua mang: \n");
		for (int i = 0; i < a; i++) {
			System.out.printf("arr" + "[" + (i+1) + "]" + "=");
			arr[i] = scanner.nextInt();
			}
		System.out.print("Cac phan tu cua mang: ");
		for (int i=0;i<a;i++) {
			System.out.print(arr[i]+" ");
			
		}
		System.out.print("\n");
        
		

		int max = arr[0];
		int keymax = 0;
		for (int b = 1; b < a; b++) {
			if (max < arr[b]) {
				max = arr[b];
				keymax = b;

			}

		}
		System.out.println("So lon nhat  :" + max + ". " + "Vi tri phan tu trong mang la :" + keymax);

		int min = arr[0];
		int keymin = 0;
		for (int b = 1; b < a; b++) {
			if (min > arr[b]) {
				min = arr[b];
				keymin = b;

			}

		}
		System.out.println("So nho nhat  :" + min + ". " + "Vi tri phan tu trong mang la :" + keymin);

	}
	
	

}
