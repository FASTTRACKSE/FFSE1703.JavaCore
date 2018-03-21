package fasstrack.edu.vn;

import java.util.Scanner;

public class MinMaxMang {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Nhap so luong phan tu mang: ");
		Scanner myInput= new Scanner(System.in);
		int[]a = new int[myInput.nextInt()];
		for (int i = 0; i < a.length; i++) {
			System.out.print("Nhap vao so thu "+(i+1)+": ");
			 a[i] = myInput.nextInt();
		}
		System.out.print("Cac phan tu cua mang : ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.print("\n");
		int max=a[0],min=a[0];
		int vitri1=1,vitri2=1;
		for (int i = 1; i < a.length; i++) {
			if (a[i]>max) {
				max = a[i];
				vitri1 = i+1;
			}
			if (a[i]<min) {
				min = a[i];
				vitri2 = i+1;
			}
		}
		System.out.println("So lon nhat cua mang la "+ max + " va nam o vi tri thu "+ vitri1 +" cua mang");
		System.out.println("So nho nhat cua mang la "+ min + " va nam o vi tri thu "+ vitri2 +" cua mang");
		
	}

}
