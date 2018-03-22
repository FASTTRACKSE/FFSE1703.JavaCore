package assignment;

import java.util.Scanner;

public class Mang {

	public static void main(String[] args) {
		Scanner myInput = new Scanner(System.in);
		
		// khai báo biến
		int size, max, min, vtMax, vtMin;
		
		// nhập số phần tử cho mảng
		System.out.print("Nhập số phần tử cho mảng: ");
		size = myInput.nextInt();
		// khởi tạo mảng
		int array[] = new int[size];
		
		// nhập giá trị vào mảng
		for (int i = 0; i < size; i++) {
			System.out.print("Nhập vào phần tử " + (i + 1) + ":" + " ");
			array[i] = myInput.nextInt();
		}

		for (int a = 0; a < size; a++) {
			System.out.println("Phần tử " + a + " là: " + array[a]);
		}
		
		// khởi tạo giá trị ban đầu cho biến
		max = array[0];
		min = array[0];
		vtMax = 0;
		vtMin = 0;
		
		// khởi tạo max = phần tử vị trí số 0 sau đó so sánh với từng phần tử trong
		// mảng. lấy giá trị lớn nhất
		for (int b = 1; b < size; b++) {
			if (max < array[b]) {
				vtMax = b;
				max = array[b];

			}
		}

		System.out.println("Số lớn nhất là: " + max + ". " + "Vị trí phần tử trong mảng: " + vtMax);
		// khởi tạo min = phần tử vị trí số 0 sau đó so sánh với từng phần tử trong
		// mảng. lấy giá trị nhỏ nhất
		for (int c = 1; c < size; c++) {
			if (min > array[c]) {
				vtMin = c;
				min = array[c];

			}
		}

		System.out.println("Số nhỏ nhất là: " + min + ". " + "Vị trí phần tử trong mảng: " + vtMin);
	}

}
