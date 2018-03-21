package fasttrack.edu.vn;

import java.util.Scanner;

import java.lang.Math;
public class phuongtrinhbac2 {
	public static void main(String[] args) {
		int a,b,c;
		
		Scanner myInput = new Scanner(System.in);
		
		System.out.print("Nhập vào số a : ");
		a = myInput.nextInt();
		
		System.out.print("Nhập vào số b : ");
		b = myInput.nextInt();
		
		System.out.print("Nhập vào số c : ");
		c = myInput.nextInt();
		
		if(a==0) {
			System.out.println("không phải phương trình bậc 2");
		}
		else {
			double x =Math.pow(b, 2)-4*a*c;
			if( x < 0) {
				System.out.println("Phương trình vô nghiệm ");}
			if(x > 0) {
				System.out.println("Phương trình có 2 nghiệm ");
			}if(x==0) {
				System.out.println("Phương trình có nghiệm kép");
					}
				}
		}
	}