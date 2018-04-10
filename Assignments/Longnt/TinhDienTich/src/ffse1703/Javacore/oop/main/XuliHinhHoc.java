package ffse1703.Javacore.oop.main;
import java.util.Scanner;
import ffse1703.Javacore.oop.model.*;

import java.util.ArrayList;
public class XuliHinhHoc {
	public static Scanner myInput = new Scanner(System.in);
	static ArrayList<HinhHoc> arrHinhHoc = new ArrayList<HinhHoc>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		menu();
	}
	public static void menu() {
		while (true) {
			System.out.println("Danh sach bai toan");
			System.out.println("1. Chu vi va dien tich hinh tron.");
			System.out.println("2. Chu vi va dien tich hinh chu nhat.");
			System.out.println("3. Chu vi va Dien tich hinh vuong.");
			System.out.println("4. in chu vi và dien tich cac hinh");
			System.out.println("5. Ket thuc");
			System.out.print("Vui long nhap so de chon: ");
			int x = myInput.nextInt();
			switch (x) {
			case 1:
				hinhTron();
				break;
			case 2:
				hinhChuNhat();
				break;
			case 3:
				hinhVuong();
				break;
			case 4:
				inSoDoCacHinh();
				break;
			case 5:
				ketThuc();
				break;
			}
		}
	}
	public static void hinhTron() {
		System.out.print("Nhap ban kinh hinh tron: ");
		double r = myInput.nextDouble();
		arrHinhHoc.add(new HinhTron(r));
		System.out.println("+---------------DANH SÁCH KHÁCH HÀNG-------------------+");
		System.out.println("| bán kính |   Chu vi    |   Diện tích      |");
		for (HinhHoc x : arrHinhHoc) {
			if (x instanceof HinhTron) {
			System.out.printf("%-15s%-15s%-20s \n", ((HinhTron) x).getR(), x.getChuVi(), x.getDienTich());
			}
		}
		myInput.nextLine();
		System.out.println();
		myInput.nextLine();
	}
	public static void hinhChuNhat() {
		System.out.print("Nhap chieu dai hinh chu nhat: ");
		double chieudai = myInput.nextDouble();
		System.out.print("Nhap chieu rong hinh chu nhat: ");
		double chieurong = myInput.nextDouble();
		arrHinhHoc.add(new HinhChuNhat(chieudai, chieurong));
		System.out.println("+---------------DANH SÁCH KHÁCH HÀNG-------------------+");
		System.out.println("| Chiều Dài |   Chiều Rộng    |   Chu Vi    |   Diện tích   |");
		for(HinhHoc x : arrHinhHoc) {
			if(x instanceof HinhChuNhat) {
				System.out.printf("%-20s%-20s%-20s%-20s \n",((HinhChuNhat) x).getChieudai(),((HinhChuNhat) x).getChieurong(), x.getChuVi(), x.getDienTich());
			}
		}
		myInput.nextLine();
		System.out.println();
		myInput.nextLine();
	}
	public static void hinhVuong() {
		System.out.println("Nhap canh hinh vuong: ");
		double canh=myInput.nextDouble();
		arrHinhHoc.add(new HinhVuong(canh));
		System.out.println("+---------------DANH SÁCH -------------------+");
		System.out.println("| Cạnh |   Chu Vi    |   Diện tích   |");
		for(HinhHoc x : arrHinhHoc) {
			if(x instanceof HinhVuong) {
				System.out.printf("%-10s%-20s%-10s \n", ((HinhVuong) x).getCanh(), x.getChuVi(), x.getDienTich());
			}
		}
		myInput.nextLine();
		System.out.println();
		myInput.nextLine();
	}
	public static void inSoDoCacHinh() {
		System.out.println("Danh sach so do cac hinh");
		System.out.println("+---------------DANH SÁCH KHÁCH HÀNG-------------------+");
		System.out.println("| kiểu Hình |   Thuộc tính   |   Chu Vi    |   Diện tích   |");
		for(HinhHoc x : arrHinhHoc) {
			if (x instanceof HinhTron) {
				System.out.printf("%-15s%-15s%-20s \n", ((HinhTron) x).getR(), x.getChuVi(), x.getDienTich());
				}
			else if (x instanceof HinhChuNhat) {
				System.out.printf("%-20s%-20s%-20s%-20s \n", ((HinhChuNhat) x).getChieudai(),((HinhChuNhat) x).getChieurong(), x.getChuVi(), x.getDienTich());
			}
			else if (x instanceof HinhVuong) {
			System.out.printf("%-10s%-20s%-10s \n", ((HinhVuong) x).getCanh(), x.getChuVi(), x.getDienTich());
		}
	}}
	
	public static void ketThuc() {
		System.out.println();
		System.out.println("Cam on ban da su dung chuong trinh!");
		System.exit(0);
	}

}
