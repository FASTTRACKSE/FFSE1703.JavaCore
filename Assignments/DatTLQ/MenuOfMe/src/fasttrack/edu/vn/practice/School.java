package fasttrack.edu.vn.practice;

import java.util.Scanner;

public class School {

	public static Scanner scanner = new Scanner(System.in);
	public static String arrHoten[];
	public static String arrDate[];
	public static Double arrDiemLP1[];
	public static Double arrDiemLP2[];
	public static Double arrDiemTB[];
	public static int a;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mymenu();

	}

	public static void dientendiem() {
		int a;
		System.out.print("Nhap so luong");
		a = scanner.nextInt();
		 arrHoten = new String[a];
		 arrDate=new String[a];
		 arrDiemLP1 = new Double[a];
		 arrDiemLP2 = new Double[a];
		 arrDiemTB= new Double[a];

		for (int i = 0; i < a; i++) {
			scanner.nextLine();
			System.out.println("Nhap ten sinh vien" + (i + 1) + ":");
			arrHoten[i] = scanner.nextLine();
			System.out.println("Ngay sinh" + (i + 1) + ":");
			arrDate[i] = scanner.nextLine();
			System.out.println("Nhap diem LP1 cua sinh vien thu" + (i + 1) + ":");
			arrDiemLP1[i] = scanner.nextDouble();
			System.out.println("Nhap diem LP2 cua sinh vien thu" + (i + 1) + ":");
			arrDiemLP2[i] = scanner.nextDouble();
			arrDiemTB[i]=(arrDiemLP1[i]+arrDiemLP2[i])/2;
			scanner.nextLine();
			scanner.nextLine();
			

		}
	}

	public static void indanhsach() {
		System.out.println("Danh Sach Sinh Vien");
		System.out.println("Ten SV  |Ngay SInh    |   DLP1  |  DLP2  |   DTB   ");
		
		for (int i = 0; i <arrHoten.length; i++) {
				
			System.out.println(arrHoten[i]);	
		}

	}

	public static void ketthuc() {
		System.exit(0);
	}

	public static void top() {

	}

	public static void mymenu() {
		while (true) {
			System.out.println("---LUA CHON CHUC NANG---");
			System.out.println("_______________________________________" + "\n");
			System.out.println("1: Nhap ten sinh vien ");
			System.out.println("2: In danh sach");
			System.out.println("3: Top sinh vien");
			System.out.println("4: Ket thuc");
			System.out.println("_______________________________________" + "\n");

			int input = scanner.nextInt();
			if (input == 1) {
				dientendiem();
			} else if (input == 2) {
				indanhsach();
			} else if (input == 4) {
				ketthuc();
			} else if (input == 3) {
				top();
			}
		}
	}
}
