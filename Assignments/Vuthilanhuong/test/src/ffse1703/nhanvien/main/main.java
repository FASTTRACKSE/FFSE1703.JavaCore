package ffse1703.nhanvien.main;
import ffse1703.nhanvien.model.*;
import java.util.Scanner;
import java.util.ArrayList;
public class main {
	public static Scanner sc = new Scanner(System.in);
	public static ArrayList<Nhanvien> arrnv = new ArrayList<Nhanvien>();
	public static ArrayList<Quanly> arrql = new ArrayList<Quanly>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			menu();
	}
	public static void dsnv() {
		System.out.println("Bạn muốn nhập bao nhiêu nhân viên");
		int a = sc.nextInt();
		for(int i=0; i<a; i++) {
			sc.nextLine();
			System.out.println("Mã số nhân viên thứ " +(i+1));
			String maSo=sc.nextLine();
			System.out.println("Tên nhân viên thứ " +(i+1));
			String tenNv=sc.nextLine();
			System.out.println("Ngày sinh nhân viên thứ " +(i+1));
			String nSinh=sc.nextLine();
			System.out.println("Lương nhân viên thứ " +(i+1));
			Double luongNv=sc.nextDouble();
			arrnv.add(new Nhanvien(maSo, tenNv, nSinh, luongNv));
		}
		
		
	}
	public static void dsql() {
		System.out.println("Bạn muốn nhập bao nhiêu quản lý");
		int a = sc.nextInt();
		for(int i=0; i<a; i++) {
			sc.nextLine();
			System.out.println("Mã số quản lý thứ " +(i+1));
			String maSo=sc.nextLine();
			System.out.println("Tên quản lý thứ " +(i+1));
			String tenNv=sc.nextLine();
			System.out.println("Ngày sinh quản lý thứ " +(i+1));
			String nSinh=sc.nextLine();
			System.out.println("Lương quản lý thứ " +(i+1));
			Double luongNv=sc.nextDouble();
			System.out.println("Lương trách nhiệm quản lý thứ " +(i+1));
			Double trachNhiem=sc.nextDouble();
			arrql.add(new Quanly(maSo, tenNv, nSinh, luongNv, trachNhiem));
		}
	}
	public static void in() {
		System.out.println("Chức vụ  Mã số  Tên  Ngày sinh  Lương   Thuế   ");
		for(Nhanvien Nhanvien : arrnv) {
			System.out.println("Nhân viên"+Nhanvien.toString());
		}
		for(Quanly Quanly : arrql) {
			System.out.println("Quản Lý"+Quanly.toString());
		}
	}
	public static void caothap() {
		
	}
	public static void menu() {
		while(true) {
		System.out.println("1. Nhập danh sách nhân viên");
		System.out.println("2. Nhập danh sách quản lí");
		System.out.println("3. In danh sách nhân viên");
		System.out.println("4. Nhân viên có lương cao nhất và thấp nhất");
		System.out.println("5. Kết thúc");
		System.out.println(" Chọn Chức Năng Bạn Muốn Nhập");
		int a= sc.nextInt();
		if(a==1) {
			dsnv();
		}
		if(a==2) {
			dsql();
		}
		if(a==3) {
			in();
		}
		if(a==4) {
			caothap();
		}
		}
	}
}
