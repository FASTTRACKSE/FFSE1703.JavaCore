package fasttrack.assignment4.model;

import java.util.Scanner;

public class SinhVien {
	public static Scanner myScanner = new Scanner(System.in);
	private String Name;
	private String Date;
	private double Lp1;
	private double Lp2;
	public static int TongSV = 0;
	
	public SinhVien(String Name, String Date, double Lp1, double Lp2) {
		this.Name = Name;
		this.Date = Date;
		this.Lp1 = Lp1;
		this.Lp2 = Lp2;
	}
	public static void tinhTongSV() {
		TongSV++;
	}
	public SinhVien() {
		
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public double getLp1() {
		return Lp1;
	}
	public void setLp1(double lp1) {
		Lp1 = lp1;
	}
	public double getLp2() {
		return Lp2;
	}
	public void setLp2(double lp2) {
		Lp2 = lp2;
	}
	public double getDTBM() {
		return ((this.Lp1 + this.Lp2) / 2);
	}
	
	public String XepLoai() {
		if (getDTBM() <= 4.9) {
			return "Yếu";
		} else if (getDTBM() <= 6.9) {
			return "Trung Bình";
		} else if (getDTBM() <= 8.4) {
			return "Khá";
		} else {
			return "Giỏi";
		}
	}
	
	
}