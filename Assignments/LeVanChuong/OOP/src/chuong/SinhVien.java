package chuong;
 
 
 
import java.util.Scanner;

public class SinhVien {
	public static Scanner input = new Scanner(System.in);

	public String hoten;
	public String day;
	public Double lp1;
	public Double lp2;
	public Double dtb;
	public int n;

	public SinhVien() {
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public Double getLp1() {
		return lp1;
	}

	public void setLp1(Double lp1) {
		this.lp1 = lp1;
	}

	public Double getLp2() {
		return lp2;
	}

	public void setLp2(Double lp2) {
		this.lp2 = lp2;
	}

	public double dtb() {
		return ((this.lp1) + (this.lp2)) / 2;
	}

	public SinhVien(String ht, String days, Double lp11, Double lp22, Double dtbb) {
		hoten = ht;
		day = days;
		lp1 = lp11;
		lp2 = lp22;
		dtb = dtbb;
	}

	public void nhaptt() {
		System.out.println("Ho ten:");
		hoten = input.nextLine();
		System.out.println("ngay sinh:");
		day = input.nextLine();
		System.out.println("lp1");
		lp1 = input.nextDouble();
		System.out.println("lp2");
		lp2 = input.nextDouble();
		input.nextLine();
	}

	public void xeploai() {
		if (this.dtb() >= 8.5 && this.dtb() <= 10) {
			System.out.println("		GIOI");
		} else if (this.dtb() >= 7 && this.dtb() <= 8.4) {
			System.out.println("		Kha");
		} else if (this.dtb() >= 5 && this.dtb() <= 6.9) {
			System.out.println("		Trung Binh");
		} else {
			System.out.println("		Kem");
		}
	}
}