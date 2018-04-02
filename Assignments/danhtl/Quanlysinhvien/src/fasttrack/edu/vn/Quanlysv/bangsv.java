package fasttrack.edu.vn.Quanlysv;

import java.util.Scanner;

public class bangsv {
	public static Scanner myScanner = new Scanner(System.in);
	private String Name;
	private String Date;
	private double Lp1;
	private double Lp2;

	public bangsv(String name, String day, double Lp1, double Lp2) {
		this.Name = name;
		this.Date = day;
		this.Lp1 = Lp1;
		this.Lp2 = Lp2;
	}

	public bangsv() {

	}

	public void Input() {
		myScanner.nextLine();
		System.out.print("Tên Sinh Viên :");
		this.Name = myScanner.nextLine();

		System.out.print("Ngày sinh  :");
		this.Date = myScanner.nextLine();

		System.out.print("Điểm môn LP1 :");
		this.Lp1 = myScanner.nextDouble();

		System.out.print("Điểm môn LP2 :");
		this.Lp2 = myScanner.nextDouble();

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
			return "kém";
		} else if (getTBM() <= 6.9) {
			return "Trung Bình";
		} else if (getTBM() <= 8.4) {
			return "Khá";
		} else {
			return "Giỏi";
		}
	}

}