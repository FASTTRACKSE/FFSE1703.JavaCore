package fasttrack.edu.vn.practices;

import java.io.Console;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class QLSinhViên {
	private int id;
	private String name;
	private int yearsv;
	private String address;
	private double LP1;
	private double LP2;
	private double LP3;
	/* điểm trung bình của sinh viên */
	private double gpa;
	private NumberFormat decimalFormat;

	// nhập thông tin
	public void inputIforSV() {
		Scanner input = new Scanner(System.in);
		System.out.println("Nhap Ten Sinh Vien:");
		name = input.nextLine();
		System.out.println("Dia Chi Sinh Vien:");
		address = input.nextLine();
		System.out.println("Nam Sinh Sinh Vien:");
		yearsv = input.nextInt();
		input.nextLine();
		System.out.println("Diem LP#1:");
		LP1 = input.nextDouble();
		System.out.println("Diem LP#2:");
		LP2 = input.nextDouble();
		System.out.println("Diem LP#3:");
		LP3 = input.nextDouble();
		gpa = (LP1 + LP2 + LP3) / 3;
	}

	// in thông tin
	public void outputIforSV() {
		System.out.println("Ten Sinh Vien : " + name + " sinh nam : " + yearsv + " Que quan : " + address + " LP#1: "
				+ LP1 + " LP#2 : " + LP2 + " LP#3 : " + LP3 + " DTB :" + gpa);
	}
	// sắp xếp

	public QLSinhViên() {
		//
	}

	public QLSinhViên(int id, String name, int yearsv, String address, double LP1, double LP2, double LP3, double gpa) {
		super();
		this.id = id;
		this.name = name;
		this.yearsv = yearsv;
		this.LP1 = LP1;
		this.LP2 = LP2;
		this.LP3 = LP3;
		this.address = address;
		this.gpa = gpa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYearsv() {
		return yearsv;
	}

	public void setYearsv(int yearsv) {
		this.yearsv = yearsv;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getLP1() {
		return LP1;
	}

	public void setLP1(double lP1) {
		LP1 = lP1;
	}

	public double getLP2() {
		return LP2;
	}

	public void setLP2(double lP2) {
		LP2 = lP2;
	}

	public double getLP3() {
		return LP3;
	}

	public void setLP3(double lP3) {
		LP3 = lP3;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

}
