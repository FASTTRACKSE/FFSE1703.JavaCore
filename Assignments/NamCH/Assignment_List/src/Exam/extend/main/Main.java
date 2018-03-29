package Exam.extend.main;
import Exam.extend.model.*;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
	public static Scanner input= new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	public static void addNv() {
		
	}
	public static void addQl() {
		
	}
	public static void printNv() {
			
		}
	public static void printQl() {
		
	}
	public static void printThue() {
		
	}
	public static void sorfThue() {
		
	}
	public static void sorfName() {
		
	}
	public static void end() {
		
	}

	public static void myMenu() {
		while(true) {
			System.out.println("         ____________________________");
			System.out.println("         |==========================|");
			System.out.println("         |----CHỌN LỰA CHỨC NĂNG----|");
			System.out.println("         |--------------------------|");
			System.out.println("         |-----1.Nhập Nhân viên-----|");
			System.out.println("         |------2.Nhập Quản Lý------|");
			System.out.println("         |--3.Danh Sách Nhân Viên---|");
			System.out.println("         |---4.Danh Sách Quản lý----|");
			System.out.println("         |-5.Lương tất cả theo thuế-|");
			System.out.println("         |----7.Sắp xếp theo Tên----|");
			System.out.println("         |==========================|");
			System.out.println("         |--8.Kết thúc chương trình-|");
			System.out.println("         |__________________________|");
			System.out.print("     Nhập chức năng mà bạn muốn thực hiện :");
			int act = input.nextInt();
			if(act ==1) {
				addNv();
			}else if(act ==2) {
				addQl();
			}else if(act==3) {
				printNv();
			}else if(act==4) {
				printQl();
			}else if(act==5) {
				printThue();
			}else if(act==6) {
				sorfThue();
			}else if(act==7) {
				sorfName();
			}else {
				end();
			}
		}
	}


}
