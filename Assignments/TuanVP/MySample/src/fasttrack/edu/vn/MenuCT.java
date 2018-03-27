package fasttrack.edu.vn;

import java.util.Random;
import java.util.Scanner;

public class MenuCT {
	private static Scanner myInput= new Scanner(System.in);
	public static void main(String[] args) {
		menu();
	}
		public static void menu() {
			while (true) {
				int x ;
				System.out.println("Xin chon bai toan.");
				System.out.println("1. Bai toan tinh tong.");
				System.out.println("2. Bai toan giai phuong trinh bac 2.");
				System.out.println("3. Bai toan tim so lon nhat va nho nhat.");
				System.out.println("0. Thoat.");
				System.out.print("Vui long nhap so de chon bai toan: ");
				x = myInput.nextInt();
				if (x==1) {
					tinhtong();
				} else if (x==2) {
					giaipt();
				} else if (x==3) {
					min_max();
				} else if (x==0) {
					exit();
				}
			}
		}
	
	public static void tinhtong() {
		int a,b,c;
		System.out.print("Nhap vao so a: ");
		a = myInput.nextInt();
		System.out.print("Nhap vao so b: ");
		b = myInput.nextInt();
		c = a + b;
		System.out.printf("Tong cua %d + %d la %d \n",a,b,c);
		
		//Thoat
		myInput.nextLine();
		System.out.print("\n");
		myInput.nextLine();
	}
	
	public static void giaipt() {
		int a,b,c;
		System.out.print("Nhap vao so a: ");
		a = myInput.nextInt();
		
		System.out.print("Nhap vao so b: ");
		b = myInput.nextInt();
		
		System.out.print("Nhap vao so c: ");
		c = myInput.nextInt();
		System.out.println("Giai phuong trinh "+a+"x2 + "+b+"x + "+c+" = 0");
		if (a==0) {
			if (b==0) {
				if (c==0) {
					System.out.println("Phuong trinh vo so nghiem");
				} else {
					System.out.println("Phuong trinh vo nghiem");
				}
			} else {
				if (c==0) {
					System.out.println("Phuong trinh co 1 nghiem x=0");
				} else {
					System.out.println("Phuong trinh vo nghiem");
				}
			}
		} else {
			float x,x1,x2,delta;
			delta = b*b-4*a*c;
			if (delta < 0) {
				System.out.println("Phuong trinh vo nghiem");
			} else if (delta == 0) {
				x=-b/(2*a);
				System.out.printf("Phuong trinh co nghiem kep la x= %.2f",x);
			} else {
				x1 = (float)(-b-(Math.sqrt(delta)))/(2*a);
				x2 = (float)(-b+(Math.sqrt(delta)))/(2*a);
				System.out.printf("Phuong trinh co hai nghiem la x1= %.2f va x2= %.2f",x1,x2);
			}
		}
		// Thoat
		myInput.nextLine();
		System.out.print("\n");
		myInput.nextLine();	
	}
	public static void min_max() {
		// Nhap so luong phan tu cua mang
		System.out.print("Nhap so luong phan tu mang: ");
		int[]a = new int[myInput.nextInt()];
		
		// Nhap gioi han cho mang
		System.out.print("Cac phan tu mang nam trong doan tu 0 den ");
		int x = myInput.nextInt();
		
		// Tao phan tu mang random
		Random rd = new Random();
		for (int i = 0; i < a.length; i++) {
			 a[i] = rd.nextInt(x+1);
		}
		
		// In ra cac phan tu cua mang
		System.out.print("Cac phan tu cua mang : ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.print("\n");
		
		// Tim phan tu lon nhat va nho nhat cua mang roi in ra
		int max=a[0],min=a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i]>max) {
				max = a[i];
			}
			if (a[i]<min) {
				min = a[i];
			}
		}
		System.out.println("So lon nhat cua mang la: "+ max);
		System.out.println("So nho nhat cua mang la: "+ min);
		
		// Tim vi tri so lon nhat
		System.out.print("So lon nhat cua mang nam o vi tri ");
		for (int i = 0; i < a.length; i++) {
			if (a[i]==max) {
				System.out.print(i+1+" ");
			}
		}
		System.out.print("\n");
		
		// Tim vi tri so nho nhat
		System.out.print("So nho nhat cua mang nam o vi tri ");
		for (int i = 0; i < a.length; i++) {
			if (a[i]==min) {
				System.out.print(i+1+" ");
			}
		}
		// Thoat
		myInput.nextLine();
		System.out.print("\n");
		myInput.nextLine();	
	}
	public static void exit() {
		System.out.print("\n");
		System.out.println("Cam on ban da su dung chuong trinh cua chung toi");
		System.exit(0);
	}

}
