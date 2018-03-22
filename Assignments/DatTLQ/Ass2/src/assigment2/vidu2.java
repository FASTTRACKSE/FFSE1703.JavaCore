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
			System.out.printf("a[%d] = ", i);
			arr[i] = scanner.nextInt();
			
		}
		System.out.print("Các phần tử của mảng: ");
        show(arr);
		

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
	public static void show(int[]arr) {
		for (int i=0;i<arr.length;i++) {
			System.out.println(arr[i] + " ");
        
		}
	}

}
