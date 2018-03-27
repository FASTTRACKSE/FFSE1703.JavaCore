package sinhvien;

import java.util.Scanner;

public class Nhapstu {
	static myStudent  arrStu[];
	public static Scanner scanner= new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Nhap so luong");
		int a=scanner.nextInt();
		
		arrStu=new myStudent[a];
		for(int i=0;i<a;i++) {
			myStudent sv = new myStudent();
			sv.nhap();
			arrStu[i]=sv;
			
		}
		System.out.println("Danh Sach Sinh Vien");
		System.out.println("Name             " + "\t" + "Date    " + "\t" + "DiemLP1     " + "\t" + "DiemLP2" + "\t" + "DTB");
	for(int i=0;i<a;i++) {
		System.out.println(arrStu[i].getStuName() + "\t" + "\t" + arrStu[i].getStuDate() + "\t"
				+ arrStu[i].getDLP1() + "\t" + "\t" + arrStu[i].getDLP2() + "\t" + arrStu[i].DTB());
	arrStu[i].xeploai();
	}
	
	
	}

}
