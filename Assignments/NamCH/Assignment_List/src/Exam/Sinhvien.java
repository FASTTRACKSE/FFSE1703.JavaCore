package Exam;
import java.util.Scanner;
public class Sinhvien {
	public static Scanner input= new Scanner(System.in);
	String[][] SV ;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	public static void nhapsv() {
		
	}
	public static void inds() {
		
	}
	public static void ketthuc() {
		System.exit(0);
	}
	public static void myMenu() {
		while (true) {
		System.out.println("____________________________");
		System.out.println("|==========================|");
		System.out.println("|----CHỌN LỰA CHỨC NĂNG----|");
		System.out.println("|--------------------------|");
		System.out.println("|--1.Nhập danh sinh viên---|");
		System.out.println("|-2.In danh sách sinh vien-|");
		System.out.println("|-----3.Top sinh viên------|");
		System.out.println("|==========================|");
		System.out.println("|--4.Kết thúc chương trình-|");
		System.out.println("____________________________");
		System.out.print("Nhập chức năng mà bạn muốn thực hiện :");
		int a = input.nextInt();
		if (a==1) {
			nhapsv();
		}else if(a==2) {
			inds();
		}else {
			ketthuc();
		}
	}
	}

}
