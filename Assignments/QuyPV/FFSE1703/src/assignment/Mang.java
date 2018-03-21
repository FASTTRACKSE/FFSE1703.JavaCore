package assignment;
import java.util.Scanner;
public class Mang {

	public static void main(String[] args) {
		Scanner myInput = new Scanner(System.in);
		
		int size, max, min;
		
		System.out.print("Nhập số phần tử cho mảng: ");
		size = myInput.nextInt();
		
		int array[] = new int[size];
		
		for(int i = 0; i < size; i++) {
			System.out.print("Nhập vào phần tử " + (i+1) + ":" + " ");
			array[i] = myInput.nextInt();
		}
		
		
		for(int a = 0; a < size; a++) {
			System.out.println("Phần tử " + a + " là: " + array[a]);
		}
		
		max = array[0];
		
		for(int b = 1; b < size; b++) {
			if(max < array[b]) {
				max = array[b];
				System.out.println("Số lớn nhất là: " + max);
			}
		}

	}

}
