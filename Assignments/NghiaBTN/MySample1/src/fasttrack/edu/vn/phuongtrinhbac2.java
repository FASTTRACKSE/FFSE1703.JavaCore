package fasttrack.edu.vn;

import java.util.Scanner;

import java.lang.Math;
public class phuongtrinhbac2 {
	public static void main(String[] args) {
		int a,b,c;
		
		Scanner myInput = new Scanner(System.in);
		
		System.out.print("Nhap vao so a : ");
		a = myInput.nextInt();
		
		System.out.print("Nhap vao so b : ");
		b = myInput.nextInt();
		
		System.out.print("Nhap vao so c : ");
		c = myInput.nextInt();
		
		if(a==0) {
			System.out.println("khong phai phuong trinh bac 2");
		}
		else {
			double x =Math.pow(b, 2)-4*a*c;
			if( x < 0) {
				System.out.println("Phuong trinh vo nghiem ");}
			if(x > 0) {
				System.out.println("Phuong trinh co 2 nghiem ");
			}if(x==0) {
				System.out.println("Phuong trinh co nghiem kep");
					}
				}
		}
	}