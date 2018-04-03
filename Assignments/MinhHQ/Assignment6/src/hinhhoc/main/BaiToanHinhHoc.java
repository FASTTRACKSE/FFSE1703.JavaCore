package hinhhoc.main;

import hinhhoc.model.*;
import java.util.Scanner;

public class BaiToanHinhHoc {
	public static Scanner scanner = new Scanner(System.in);
	public static HinhTron Tron = new HinhTron();
	public static HinhChuNhat CNhat = new HinhChuNhat();
	public static HinhTamGiac TamGiac = new HinhTamGiac();
	
	public static void main(String[] args) {
		
		
	}
public static void HinhTroncvdt() {
		System.out.print("Nhập bán kính hình tròn :");
		double n = scanner.nextDouble();
		Tron.setBankinh(n);
		System.out.println("Chu vi hình tròn là : " + Tron.getChuVi());
		System.out.println("Diện tích hình tròn là : " + Tron.getDienTich());
}
		
public static void HinhChuNhatcvdt() {
		System.out.print("Nhập chiều dài hình chữ nhật :");
		double cd = scanner.nextDouble();
		CNhat.setChieudai(cd);
		
		System.out.print("Nhập chiều rộng hình chữ nhật :");
		double cr = scanner.nextDouble();
		CNhat.setChieurong(cr);
		
		System.out.println("Chu vi hình chữ nhật là : " + CNhat.getChuVi());
		System.out.println("Diện tích hình chữ nhật là : " + CNhat.getDienTich());
	}
		
public static void HinhTamGiaccvdt() {
			System.out.println("Nhập độ dài 3 cạnh của hình tam giác :");
			System.out.print("Nhập độ dài cạnh a :");
			double a = scanner.nextDouble();
			TamGiac.setCanhA(a);
			
			System.out.print("Nhập độ dài cạnh b :");
			double b = scanner.nextDouble();
			TamGiac.setCanhB(b);
			
			System.out.print("Nhập độ dài cạnh c :");
			double c = scanner.nextDouble();
			TamGiac.setCanhC(c);
			
			System.out.println("Chu vi hình chữ nhật là : " + TamGiac.getChuVi());
			System.out.println("Diện tích hình chữ nhật là : " + TamGiac.getDienTich());
			
			}

}
