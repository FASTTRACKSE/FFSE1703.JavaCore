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
		int max = mang[0], min = mang[0];
		int vtmax = 0, vtmin = 0;

		for (int c = 1; c < mang.length; c++) {
			if (max < mang[c]) {
				max = mang[c];
				vtmax = c;
			}
		}
		for (int j = 1; j < mang.length; j++) {
			if (min > mang[j]) {
				min = mang[j];
				vtmin = j;
			}
		}
		System.out.println("\nVị trí số lớn nhất thứ " + vtmax + " có giá trị :" + max);
		System.out.println("Vị trí số nhỏ nhất thứ " + vtmin + " có giá trị :" + min);
	}
 }
