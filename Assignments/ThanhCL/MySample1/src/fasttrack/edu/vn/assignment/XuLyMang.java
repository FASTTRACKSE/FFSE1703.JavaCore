package fasttrack.edu.vn.assignment;

import java.util.Scanner;

public class XuLyMang {
	public static Scanner myScanner = new Scanner(System.in);

	public static void main(String[] args) {
		int total = 0;
		for (;;) {
			try {
				// Nhập số phần tử của mảng
				System.out.print("Nhập số phần tử mảng: ");
				total = myScanner.nextInt();
				if (total <= 0) {
					System.out.println("Hãy nhập số lớn hơn 0!");
					continue;
				}
				break;
			} catch (Exception er) {
				System.out.println("Hãy nhập một số!");
				myScanner.nextLine();
			}
		}
		
		int minNumber, minPosition, maxNumber, maxPosition;

		int[] myArray = new int[total];

		// Nhập giá trị của mảng
		for (int i = 0; i < total; i++) {
			System.out.printf("Nhập giá trị phần tử %d: ", i + 1);
			myArray[i] = myScanner.nextInt();
		}

		// In giá trị của mảng
		for (int i = 0; i < total; i++) {
			System.out.printf("\nGiá trị phần tử %d : %d", i + 1, myArray[i]);
		}

		// Tìm giá trị lớn nhất và nhỏ nhất của mảng qua việc duyệt mảng

		// Gán min, max là phần tử đầu tiên
		minNumber = myArray[0];
		minPosition = 0;
		maxNumber = myArray[0];
		maxPosition = 0;

		// Duyệt từ phần tử thứ 2
		for (int i = 1; i < total; i++) {
			// Nếu giá trị min lớn hơn giá trị phần tử đang duyệt
			if (minNumber > myArray[i]) {
				minNumber = myArray[i];
				minPosition = i;
			}

			// Nếu giá trị max nhỏ hơn giá trị phần tử đang duyệt
			if (maxNumber < myArray[i]) {
				maxNumber = myArray[i];
				maxPosition = i;
			}
		}

		// In kết quả tìm min max trong mảng
		System.out.printf("\n\nGiá trị NHỎ nhất trong mảng là phần tử %d : %d\n", minPosition + 1,
				myArray[minPosition]);
		System.out.printf("Giá trị LỚN nhất trong mảng là phần tử %d : %d\n", maxPosition + 1, myArray[maxPosition]);

	}

}
