package sinhvien.main;
import java.util.Scanner;
import sinhvien.model.*;
import java.util.ArrayList;

public class QuanLiSinhVien {
	public static int soluong;
	public static ArrayList<SinhVien> arrSinhVien = new ArrayList<>();
	public static Scanner myInput = new Scanner(System.in);
	
	public static void main(String[] args) {
		myMenu();

	}
	public static void nhapTen() {
		System.out.println("<=====NHAP SINH VIEN=====>");
		System.out.println("Nhap so luong");
		soluong = Integer.parseInt(myInput.nextLine());
		for(int i = 0 ;i < soluong;i++) {
			
			System.out.println("Nhap Ten Sinh Vien"+ "["+(+i+1)+"]: ");
			String SvName = myInput.nextLine();
			System.out.println("Nhap Ngay Sinh"+"["+(+i+1)+"]: ");
			String SvDate = myInput.nextLine();
			System.out.println("Nhap Diem LP1"+"["+(+i+1)+"]: ");
			double SvDiemlp1 = Double.parseDouble(myInput.nextLine());
			System.out.println("Nhap Diem LP2"+"["+(+i+1)+"]: ");
			double SvDiemlp2 = Double.parseDouble(myInput.nextLine());
			
			arrSinhVien.add(new SinhVien(SvName,SvDate,SvDiemlp1,SvDiemlp2));
			
			SinhVien.TongSo();
		}
		System.out.println("So Luong Sinh Vien Da Nhap Vao: "+ SinhVien.tongso);
	}
	public static void inDanhSach() {
		System.out.printf("|%-20s|%-15s|%-10s|%-20s|\n","Ten Sinh Vien","Ngay Sinh","Diem LP1","Diem LP2");
		for (SinhVien x: arrSinhVien) {
			System.out.printf("|%-20s|%-15s|%-10s|%-20s|\n",x.getSvName(),x.getSvDate(),x.getSvDiemlp1(),x.getSvDiemlp2());
		}
	}
	public static void doiTen() {
		System.out.println("DOI TEN SINH VIEN");
		System.out.println("Nhap Ten Sinh Vien Cu: ");
		String oldName = myInput.nextLine();
		System.out.println("Nhap Ten Sinh Vien Moi: ");
		String newName = myInput.nextLine();
		for (SinhVien x: arrSinhVien) {
			if(oldName.equals(x.getSvName())) {
				x.setSvName(newName);
			}
		}
	}

	public static void xoaTen() {
		System.out.println("XOA SINH VIEN THEO TEN");
		System.out.println("Nhap Ten Sinh Vien Can Xoa: ");
		String SvName = myInput.nextLine();
		for(SinhVien x: arrSinhVien) {
			if(x.getSvName().equals(SvName)) {
				arrSinhVien.remove(x);
				break;
			}
			
		}
	
	}
	public static void timTen() {
		System.out.println("TIM KIEM TEN SINH VIEN");
		System.out.println("Nhap Ten SInh Vien Can Tim: ");
		String seachName = myInput.nextLine();
		for(SinhVien x: arrSinhVien) {
			if(x.getSvName().equals(seachName)) {
				System.out.println("Ten Sinh Vien Can Tim: "+x.getSvName());
			}
		}
	}
	public static void ketThuc() {
		System.exit(0);
	}
	public static void myMenu() {
	while (true) {
		try {
			System.out.println("<======LUA CHON CHUC NANG======>");
			System.out.println("|| 1.NHAP TEN SINH VIEN        ||");
			System.out.println("|| 2.DANH SACH SINH VIEN       ||");
			System.out.println("|| 3.DOI TEN 1 SINH VIEN       ||");
			System.out.println("|| 4.XOA SINH VIEN THEO TEN    ||");
			System.out.println("|| 5.TIM KIEM TEN SINH VIEN    ||");
			System.out.println("|| 6.KET THUC CHUONG TRINH     ||");
			System.out.println("<===============================>");
			System.out.println("      LUA CHON CUA BAN        ");
			int option = Integer.parseInt(myInput.nextLine());
			if (option == 1) {
				nhapTen();
			} else if (option == 2) {
				inDanhSach();
			} else if (option == 3) {
				doiTen();
			} else if (option == 4) {
				xoaTen();
			} else if (option == 5) {
				timTen();
			}else if (option == 6) {
				ketThuc();
			}
		}catch(Exception e) {
				    System.out.println("Chi duoc nhap tu 1 den 4, hay nhap lai nhe ban!!!");

                   myInput.nextLine();
				}
			}
		}
	}


