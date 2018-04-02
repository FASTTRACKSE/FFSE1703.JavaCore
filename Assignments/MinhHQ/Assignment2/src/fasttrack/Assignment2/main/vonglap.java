package fasttrack.Assignment2.main;

import java.util.Scanner;

public class vonglap {
	public static void main(String[] args) {
		
		int n, i, min, max;

		Scanner myInput = new Scanner(System.in);

		System.out.print("Nhập vào số lượng phần tử trong mảng a[] : ");
		n = myInput.nextInt();

		int[] a = new int[n];

		for (i = 0; i < n; i++) {
			System.out.print("Nhập giá trị của phần tử  a[" + (i + 1) + "] :");
			a[i] = myInput.nextInt();
		}

		min = a[0];
		max = a[0];
		int x = 1, y = 1;

		for (i = 0; i < n; i++) {
			if (min > a[i]) {
				min = a[i];
				x = i + 1;
			}
			if (max < a[i]) {
				max = a[i];
				y = i + 1;
			}
		}

		System.out.println("Số nh�? nhất trong " + n + " phần tử là :" + min);

		System.out.println("Là phần tử thứ " + x);

		System.out.println("Số lớn nhất trong " + n + " phần tử là :" + max);

		System.out.println("Là phần tử thứ " + y);	
		}
	}
