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
	public static int i;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mymenu();

	}

	public static void dientendiem() {

		System.out.print("Nhap so luong");
		a = scanner.nextInt();
		arrHoten = new String[a];
		arrDate = new String[a];
		arrDiemLP1 = new Double[a];
		arrDiemLP2 = new Double[a];
		arrDiemTB = new Double[a];

		for (i = 0; i < a; i++) {
			scanner.nextLine();
			System.out.println("Nhap ten sinh vien" + (i + 1) + ":");
			arrHoten[i] = scanner.nextLine();
			System.out.println("Ngay sinh" + (i + 1) + ":");
			arrDate[i] = scanner.nextLine();
			System.out.println("Nhap diem LP1 cua sinh vien thu" + (i + 1) + ":");
			arrDiemLP1[i] = scanner.nextDouble();
			System.out.println("Nhap diem LP2 cua sinh vien thu" + (i + 1) + ":");
			arrDiemLP2[i] = scanner.nextDouble();
			arrDiemTB[i] = (arrDiemLP1[i] + arrDiemLP2[i]) / 2;

		}
	}

	public static void indanhsach() {
		System.out.println("Danh Sach Sinh Vien");
		System.out.println("Ten SV" + "\t" + "Ngay Sinh" + "\t" + "DLP1" + "\t" + "DLP2" + "\t" + "DTB");

		for (int i = 0; i < a; i++) {

			System.out.println(arrHoten[i] + "\t" + arrDate[i] + "\t" + arrDiemLP1[i] + "\t" + arrDiemLP2[i] + "\t"
					+ arrDiemTB[i]);
		}

	}

	public static void ketthuc() {
		System.exit(0);
	}

	public static void top() {
		double max = arrDiemTB[0];
		double min = arrDiemTB[0];

		int tenmax = 0, maxdate = 0, tenmin = 0, mindate = 0;
		System.out.println("Sinh Vien Diem Cao Nhat va Diem Thap Nhat");
		System.out.println("Ten SV      " + "\t" + "Ngay Sinh" + "\t" + "DTB");

		for (int b = 1; b < a; b++) {
			if (max < arrDiemTB[b]) {
				max = arrDiemTB[b];
				tenmax = b;
				maxdate = b;

			}

			if (min > arrDiemTB[b]) {
				min = arrDiemTB[b];
				tenmin = b;
				mindate = b;
			}

		}
		System.out.println(arrHoten[tenmax] + "\t" + "\t" + arrDate[maxdate] + "\t" + "\t" + max);
		System.out.println(arrHoten[tenmin] + "\t" + "\t" + arrDate[mindate] + "\t" + "\t" + min);

	}

	public static void sosanh() {
		
		for (int i = 0; i < arrDiemTB.length - 1; i++) {
			for (int j = i + 1; j < arrDiemTB.length; j++) {
				if (arrDiemTB[i] < arrDiemTB[j]) {
					double cao = arrDiemTB[j];
					arrDiemTB[j] = arrDiemTB[i];
					arrDiemTB[i] = cao;
					cao = arrDiemLP1[j];
					arrDiemLP1[j] = arrDiemLP1[i];
					arrDiemLP1[i] = cao;
					cao = arrDiemLP2[j];
					arrDiemLP2[j] = arrDiemLP2[i];
					arrDiemLP2[i] = cao;
					String cao1 = arrDate[j];
					arrDate[j] = arrDate[i];
					arrDate[i] = cao1;
					cao1 = arrHoten[j];
					arrHoten[j] = arrHoten[i];
					arrHoten[i] = cao1;
				}
			}
		}
		System.out.println("Danh Sach Sinh Vien Tu Cao Den Thap");
		System.out.println("Ten SV" + "\t" + "Ngay Sinh" + "\t" + "DLP1" + "\t" + "DLP2" + "\t" + "DTB");

		for (int i = 0; i < a; i++) {

			System.out.println(arrHoten[i] + "\t" + arrDate[i] + "\t" + arrDiemLP1[i] + "\t" + arrDiemLP2[i] + "\t"
					+ arrDiemTB[i]);
		}
	}
	public static void abc() {
		for(int i=0;i<arrHoten.length - 1;i++) {
			for(int j=i+1;j<arrHoten.length;j++) {
				if(arrHoten[i].compareTo(arrHoten[j]) > 0) {
					String temp=arrHoten[j];
					arrHoten[j]=arrHoten[i];
					arrHoten[i]=temp;
					temp = arrDate[j];
					arrDate[j] = arrDate[i];
					arrDate[i] = temp;
					double cao = arrDiemTB[j];
					arrDiemTB[j] = arrDiemTB[i];
					arrDiemTB[i] = cao;
					cao = arrDiemLP1[j];
					arrDiemLP1[j] = arrDiemLP1[i];
					arrDiemLP1[i] = cao;
					cao = arrDiemLP2[j];
					arrDiemLP2[j] = arrDiemLP2[i];
					arrDiemLP2[i] = cao;
				
					
				}
			}
		}
		System.out.println("Danh Sach Sinh Vien ABC");
		System.out.println("Ten SV" + "\t" + "Ngay Sinh" + "\t" + "DLP1" + "\t" + "DLP2" + "\t" + "DTB");

		for (int i = 0; i < a; i++) {

			System.out.println(arrHoten[i] + "\t" + arrDate[i] + "\t" + arrDiemLP1[i] + "\t" + arrDiemLP2[i] + "\t"
					+ arrDiemTB[i]);
		}
	}

	public static void mymenu() {
		while (true) {
			System.out.println("---LUA CHON CHUC NANG---");
			System.out.println("_______________________________________" + "\n");
			System.out.println("1: Nhap ten sinh vien ");
			System.out.println("2: In danh sach");
			System.out.println("3: Top sinh vien");
			System.out.println("4: Ket thuc");
			System.out.println("5: In tu cao den thap");
			System.out.println("6: In theo thu tu ABC");
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
			} else if (input == 5) {
				sosanh();
			}else if(input==6) {
				abc();
			}
		}
	}
}
