package fasttrack.edu.vn.assignment;

import java.util.Scanner;

public class HeThongMenu {
	public static Scanner myScanner = new Scanner(System.in);

	public static void main(String[] args) {
		showMenu();
	}
	
	public static void showMenu() {
		int answer;
		while (true) {
			System.out.println("+-------------------------------------+");
			System.out.println("|               MENU                  |");
			System.out.println("+-------------------------------------+");
			System.out.println("| 1. Bài toán tính tổng               |");
			System.out.println("| 2. Xử lý mảng và tính toán          |");
			System.out.println("| 3. Thoát khỏi chương trình          |");
			System.out.println("+-------------------------------------+");
			System.out.println("| Nhập lựa chọn của bạn?              |");
	
			answer = myScanner.nextInt();
			if (answer == 1) {
				tinhTong();
			}
			else if (answer == 2) {
				xuLyMang();
			}
			else if (answer == 3) {
				System.out.println("Chương trình kết thúc. Cám ơn và tạm biệt các bạn!");
				System.exit(0);
				break;
			}
		}
	}

	public static void xuLyMang() {
		System.out.println("Bài toán xử lý mảng");
		System.out.println("-------------------------");

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
        myScanner.nextLine(); // Nhận ký tự Enter từ nextInt ở trên
		System.out.print("\nEnter để về menu chính\n");
		myScanner.nextLine();
	}
	
	public static void tinhTong() {
		int a, b, c;
		
		Scanner myInput = new Scanner(System.in);
		
		System.out.println("Bài toán tính tổng hai số");
		System.out.println("-------------------------");
		System.out.print("Nhap vao so a : ");
		a = myInput.nextInt();
		
		System.out.print("Nhap vao so b : ");
		b = myInput.nextInt();
		
		c = a + b;
		
		System.out.printf("Tong cua %d + %d = %d \n", a, b, c);
        myScanner.nextLine(); // Nhận ký tự Enter từ nextInt ở trên
		System.out.print("\nEnter để về menu chính\n");
		myScanner.nextLine();		
	}

}
