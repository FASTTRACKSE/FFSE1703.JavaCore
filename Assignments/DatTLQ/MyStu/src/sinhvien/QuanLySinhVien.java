package sinhvien;

import java.util.Scanner;



public class QuanLySinhVien {
	
	public static Scanner scanner = new Scanner(System.in);
	public static int a;
	public static int i;
	public static int sortByDTB[];
	public static int sortByABC[];


	public static Student arrStu[];
	public static void main(String[] arg) {
		
		mymenu();
		
	}
	public static void nhapsinhvien() {
		System.out.print("Nhap so sinh vien");
		a = scanner.nextInt();
		arrStu=new Student[a];
		
		for(i=0;i<a;i++) {
			arrStu[i] =new Student();

			scanner.nextLine();
			System.out.println("Nhap ten sinh vien" + (i + 1) + ":");
			
			arrStu[i].setStuName(scanner.nextLine());
			System.out.println("Nhap ngay sinh" + (i + 1) + ":");
			arrStu[i].setStuDate(scanner.nextLine());
			System.out.println("Nhap diem LP1" + ":");
			arrStu[i].setDLP1(scanner.nextInt());
			System.out.println("Nhap diem LP2" + ":");
			arrStu[i].setDLP2(scanner.nextInt());
		
			
		}
	}
	public static void indanhsach() {
		System.out.println("Danh Sach Sinh Vien");
		// tự chỉnh lại cái ni cho đều nữa
		System.out.println("Name " + "\t" + "Date" + "\t" + "DiemLP1" + "\t" + "DiemLP2" + "\t" + "DTB"+"\t"+"XepLoai");
		
		for(int i=0;i<a;i++) {
			System.out.printf("| %-20s | %-10s | %4s | %4s | %4s | %5s |\n", arrStu[i].getStuName(), arrStu[i].getStuDate(), arrStu[i].getDLP1(), arrStu[i].getDLP2(), arrStu[i].DTB(), arrStu[i].Xeploai());
		
		}
	}
	public static void topmin() {

		double max = arrStu[0].DTB(), min = arrStu[0].DTB();
		int keymax=0,keymin=0;
		for (int b = 1; b < a; b++) {
			if (max < arrStu[b].DTB()) {
				max = arrStu[b].DTB();
				 keymax=b;
			}
			if (min > arrStu[b].DTB()) {
				min = arrStu[b].DTB();
				keymin=b;
			}

		}
		System.out.println("Diem TB Cao Nhat:" +arrStu[keymax].getStuName()
				+arrStu[keymax].getStuDate()+ max);
		System.out.println("Diem TB Thap Nhat:"+arrStu[keymin].getStuName()
				+arrStu[keymin].getStuDate() + min);
	}
	public static void maxmin() {
		sortByDTB = new int[a];
		for (int i = 0; i < a; i++) {
			sortByDTB[i] = i;
		}
		for (int i = 0; i < a - 1; i++) {
			for (int j = i + 1; j < a; j++) {
				if (arrStu[sortByDTB[i]].DTB() > arrStu[sortByDTB[j]].DTB()) {
					int temp = sortByDTB[j];
					sortByDTB[j] = sortByDTB[i];
					sortByDTB[i] = temp;
				}
			}

		}

		System.out.println(
				"STT \t" + "Họ Và tên \t" + "Ngày sinh \t" + "Điểm LP1 \t" + "Điểm LP2 \t" + "ĐTB \t" + "Xếp loại");
		for (int i = 0; i < a; i++) {

			System.out.println((i + 1) + " \t" + arrStu[sortByDTB[i]].getStuName() + " \t \t"
					+ arrStu[sortByDTB[i]].getStuDate() + "\t" + arrStu[sortByDTB[i]].getDLP1() + " \t \t"
					+ arrStu[sortByDTB[i]].getDLP2() + " \t \t" + arrStu[sortByDTB[i]].DTB() + "\t"
					+ arrStu[sortByDTB[i]].Xeploai());

		}
	}
	public static void abc() {
		
	}
	public static void mymenu() {
		while (true) {
			System.out.println("---LUA CHON CHUC NANG---");
			System.out.println("_______________________________________" + "\n");
			System.out.println("1: Nhap ten sinh vien ");
			System.out.println("2: In danh sach");
			System.out.println("3: In sinh vien cao diem va tha");
			System.out.println("4: In sinh vien DTB tu cao den thap");
			System.out.println("5: In sinh vien DTB theo ABC");
			System.out.println("_______________________________________" + "\n");
			


			int input = scanner.nextInt();
			if (input == 1) {
				nhapsinhvien();
			} else if (input == 2) {
				indanhsach();
			}else if (input == 3) {
				topmin();
			}else if (input == 4) {
				maxmin();
			}else if (input == 5) {
				abc();
			}
		}
}
	
	
	

}
