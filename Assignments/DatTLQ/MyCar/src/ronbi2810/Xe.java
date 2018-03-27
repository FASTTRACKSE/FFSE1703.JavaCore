package ronbi2810;
import java.util.Scanner;

public class Xe {
	public static Scanner scanner = new Scanner(System.in);
	public static int a;
	public static int i;

	static Car[] mycar;
	public static void main(String[] arg) {
		
		mymenu();
		
	}
	public static void dientendiem() {
		System.out.print("Nhap so xe");
		a = scanner.nextInt();
		mycar=new Car[a];
		for(i=0;i<mycar.length;i++) {
			scanner.nextLine();
			System.out.println("Nhap ten xe" + (i + 1) + ":");
			mycar[i].setCarMaker(scanner.nextLine());
			System.out.println("Nhap ma xe" + (i + 1) + ":");
			mycar[i].setCarModel(scanner.nextLine());
		}
	}
	public static void indanhsach() {
		
	}
	public static void mymenu() {
		while (true) {
			System.out.println("---LUA CHON CHUC NANG---");
			System.out.println("_______________________________________" + "\n");
			System.out.println("1: Nhap ten xe ");
			System.out.println("2: In danh sach");
			

			int input = scanner.nextInt();
			if (input == 1) {
				dientendiem();
			} else if (input == 2) {
				indanhsach();
			}
		}
}
}
