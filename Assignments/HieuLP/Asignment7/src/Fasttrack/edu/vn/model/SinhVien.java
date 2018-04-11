package Fasttrack.edu.vn.model;

import java.util.Scanner;

import Fasttrack.edu.vn.main.NhapSV;

public class SinhVien {

	public static Scanner myScanner = new Scanner(System.in);
	private String Name;
	private String Date;
	private double Lp1;
	private double Lp2;
	static public  int tongSV = 0;

	public SinhVien(String name, String day, double Lp1, double Lp2) {
		this.Name = name;
		this.Date = day;
		this.Lp1 = Lp1;
		this.Lp2 = Lp2;
	}
	static public void tinhTongSV() {
		 tongSV++;
		}

	public SinhVien() {

	}


	public void setName(String name) {
		this.Name = name;
	}

	public String getName() {
		return this.Name;
	}

	public void setDate(String name) {
		this.Date = name;
	}

	public String getDate() {
		return this.Date;
	}

	public void setLp1(double Lp1) {
		this.Lp1 = Lp1;
	}

	public double getLp1() {
		return this.Lp1;
	}

	public void setLp2(double Lp2) {
		this.Lp2 = Lp2;
	}

	public double getLp2() {
		return this.Lp2;
	}

	public double getTBM() {
		return ((this.Lp1 + this.Lp2) / 2);
	}

	public String XepLoai() {
		if (getTBM() <= 4.9) {
			return "Yáº¿u";
		} else if (getTBM() >= 5.0 && getTBM() <= 6.9) {
			return "Trung BÃ¬nh";
		} else if (getTBM() >= 7 && getTBM() <= 8.4) {
			return "KhÃ¡";
		} else {
			return "Giá»�i";
		}
	}

}