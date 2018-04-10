package HinhHoc.main;
import java.util.Scanner;

import HinhHoc.model.*;
public class QuanLy {
	public static Scanner sc = new Scanner(System.in);
	public static HinhHoc tinh1 = new HinhChuNhat();
	public static HinhHoc tinh2 = new HinhTron();
	public static HinhHoc tinh3 = new HinhTamGiac();
	public static void main(String[] args) {
		menu();

	}
	public static void menu() {
		 while(true) {
			 System.out.println("1.Hình chữ nhật");
			 System.out.println("2.Hình chữ tròn");
			 System.out.println("3.Hình chữ tam giác");	
			 System.out.println("Chọn chức năng");
			 int a = sc.nextInt();
			 if(a==1) {
				 menuCN(); 
			 }
			 if(a==2) {
				 menuTron(); 
			 }
			 if(a==3) {
				 menuTamGiac(); 
			 }
		 }
	 }
 	public static void menuCN() {
		 while(true) {
			 System.out.println("1.Diện tích hình chữ nhật ");
			 System.out.println("2.Chu vi hình chữ nhật");
			 System.out.println("3.Nhấn 3 để về menu");
			 System.out.println("Chọn chức năng");
			 int menuCN = sc.nextInt();
			 if(menuCN==1) {
				System.out.println("Nhập chiều dài :");
				double dai = sc.nextDouble();
				System.out.println("Nhập chiều rộng: ");
				double rong = sc.nextDouble();
				tinh1 = new HinhChuNhat(dai,rong);
				System.out.println("DIện tích hình chữ nhật là: " +tinh1.getDienTich() );
			 }
			 else if(menuCN==2) {
				 System.out.println("Nhập chiều dài :");
					double dai = sc.nextDouble();
					System.out.println("Nhập chiều rộng: ");
					double rong = sc.nextDouble();
					tinh1 = new HinhChuNhat(dai,rong);
					System.out.println("Chu vi hình chữ nhật là: " +tinh1.getChuVi() );
			 }
			 else{
				 menu();
			 }
		}
	}
	 public static void menuTron() {
		 while(true) {
			 System.out.println("1.Diện tích hình tròn ");
			 System.out.println("2.Chu vi hình tròn");
			 System.out.println("3.Nhấn 3 để về menu");
			 System.out.println("Chọn chức năng");
			 int menuTron = sc.nextInt();
			 if(menuTron==1) {
				 System.out.println("Nhập bán kinh :");
					double bankinh = sc.nextDouble();
					tinh2 = new HinhTron(bankinh);
					System.out.println("DIện tích hình tròn là: " +tinh2.getDienTich() );
			 }
			 else if(menuTron==2) {
				 System.out.println("Nhập bán kinh :");
					double bankinh = sc.nextDouble();
					tinh2 = new HinhTron(bankinh);
					System.out.println("Chu vi hình tròn là: " +tinh2.getChuVi() );
				  
			 }else {
				 menu();
			 }
		 }
	 }
	 public static void menuTamGiac() {
		 while(true) {
			 System.out.println("1.Diện tích hình tam giác ");
			 System.out.println("2.Chu vi hình tam giác");
			 System.out.println("3.Nhấn 3 để về menu");
			 System.out.println("Chọn chức năng");
			 int menuTG = sc.nextInt();
			 if(menuTG==1) {
				 System.out.println("Nhập cạnh A :");
					double canhA = sc.nextDouble();
					System.out.println("Nhập cạnh B: ");
					double canhB = sc.nextDouble();
					System.out.println("Nhập cạnh C: ");
					double canhC = sc.nextDouble();
					tinh3 = new HinhTamGiac(canhA,canhB,canhC);
					System.out.println("DIện tích hình tam giác là: " +tinh3.getDienTich() );
			 }
			 else if(menuTG==2) {
				 System.out.println("Nhập cạnh A :");
					double canhA = sc.nextDouble();
					System.out.println("Nhập cạnh B: ");
					double canhB = sc.nextDouble();
					System.out.println("Nhập cạnh C: ");
					double canhC = sc.nextDouble();
					tinh3 = new HinhTamGiac(canhA,canhB,canhC);
					System.out.println("DIện tích hình tam giác là: " +tinh3.getChuVi() );
			 }else {
				 menu();
			 }
		 }
	 }
}
