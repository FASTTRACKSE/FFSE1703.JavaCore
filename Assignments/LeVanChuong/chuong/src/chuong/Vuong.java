package chuong;

import java.util.Scanner;

public class Vuong extends ChuNhat {
	public Vuong(int canh) {
		super(canh, canh);
	}
	
	void  xuat() {
		System.out.println("Canh: "+super.getDai());
		System.out.println("Chu vi: "+this.getChuVi());
		System.out.println("Dien tich: "+this.getDienTich());
	}
	public static void magin(String arg[]) {
		System.out.print("Nhap chieu dai: ");
		Scanner scan = new Scanner(System.in);
		int dai = scan.nextInt();
		
		System.out.print("Nhap chieu rong: ");
		int rong = scan.nextInt();
		
		ChuNhat cn = new ChuNhat(dai, rong);
		cn.xuat();
		
		System.out.println("----Hinh Vuong---");
		System.out.println("Nhap canh hinh vuong");
		int canh = scan.nextInt();
		
		Vuong vuong = new Vuong(canh);
		vuong.xuat();
	}
}

