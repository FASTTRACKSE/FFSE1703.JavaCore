package fasttrack.edu.vn;

import java.util.Scanner;
import java.util.Random;

public class MinMaxMang {

	public static void main(String[] args) {
		Scanner myInput= new Scanner(System.in);
		
		// Nhap so luong phan tu cua mang
		System.out.print("Nhap so luong phan tu mang: ");
		int[]a = new int[myInput.nextInt()];
		
		// Nhap gioi han cho mang
		System.out.print("Cac phan tu mang nam trong doan tu 0 den ");
		int x = myInput.nextInt();
		
		// Tao phan tu mang random
		Random rd = new Random();
		for (int i = 0; i < a.length; i++) {
			 a[i] = rd.nextInt(x+1);
		}
		
		// In ra cac phan tu cua mang
		System.out.print("Cac phan tu cua mang : ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.print("\n");
		
		// Tim phan tu lon nhat va nho nhat cua mang roi in ra
		int max=a[0],min=a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i]>max) {
				max = a[i];
			}
			if (a[i]<min) {
				min = a[i];
			}
		}
		System.out.println("So lon nhat cua mang la: "+ max);
		System.out.println("So nho nhat cua mang la: "+ min);
		
		// Tim vi tri so lon nhat
		System.out.print("So lon nhat cua mang nam o vi tri ");
		for (int i = 0; i < a.length; i++) {
			if (a[i]==max) {
				System.out.print(i+1+" ");
			}
		}
		System.out.print("\n");
		
		// Tim vi tri so nho nhat
		System.out.print("So nho nhat cua mang nam o vi tri ");
		for (int i = 0; i < a.length; i++) {
			if (a[i]==min) {
				System.out.print(i+1+" ");
			}
		}
		
	}

}
