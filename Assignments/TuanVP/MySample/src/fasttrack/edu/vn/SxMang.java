package fasttrack.edu.vn;

import java.util.Random;
import java.util.Scanner;

public class SxMang {

	public static void main(String[] args) {
		Scanner myInput= new Scanner(System.in);
		int az,za;
		
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
		System.out.print("Mang goc : ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.print("\n");
		
		// Sap xep tu be den lon
		for (int i = 0; i < a.length; i++) {
			for (int j = i+1; j < a.length; j++) {
				if (a[i]>a[j]) {
					az=a[i];
					a[i]=a[j];
					a[j]=az;
				}
			}
		}
		System.out.print("Mang sap xep tu be den lon : ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.print("\n");
		
		// Sap xep tu lon den be
		for (int i = 0; i < a.length; i++) {
			for (int j = i+1; j < a.length; j++) {
				if (a[i]<a[j]) {
					az=a[i];
					a[i]=a[j];
					a[j]=az;
				}
			}
		}
		System.out.print("Mang sap xep tu lon den be : ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
	}

}
