package assignment_day3;

import java.util.Scanner;

public class solonnhattrongmang {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size;

		Scanner myInput = new Scanner(System.in);
		System.out.print("Nhap vao so phan tu mang : ");
		size = myInput.nextInt();
		int[] mang = new int[size];
		for (int i = 0; i < size; i++) {
			System.out.print("Nhap phan tu thu " + i + " :");
			mang[i] = myInput.nextInt();
		}
		System.out.print("gia tri cua mang :");
		for (int a = 0; a < mang.length; a++) {
			System.out.print(+mang[a] + "; ");
		}
		int max = mang[0];

		for (int c = 1; c < mang.length; c++) {
			if (max < mang[c]) {
				max = mang[c];
				
			}
		}
		
		System.out.println("\n Gia tri lon nhat la:"+max);

	}

}
