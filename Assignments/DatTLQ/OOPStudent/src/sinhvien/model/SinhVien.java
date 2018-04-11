package sinhvien.model;

import java.util.Scanner;
import java.io.Serializable;


public class SinhVien implements Serializable{
	public String stuName;
	public String stuDate;
	public double DLP1;
	public double DLP2;

	public SinhVien(String stuName,String stuDate,double DLP1,double DLP2) {
		this.stuName=stuName;
		this.stuDate=stuDate;
		this.DLP1=DLP1;
		this.DLP2=DLP2;
		
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuDate() {
		return stuDate;
	}

	public void setStuDate(String stuDate) {
		this.stuDate = stuDate;
	}

	public double getDLP1() {
		return DLP1;
	}

	public void setDLP1(double dLP1) {
		DLP1 = dLP1;
	}

	public double getDLP2() {
		return DLP2;
	}

	public void setDLP2(double dLP2) {
		DLP2 = dLP2;
	}

	public double getDTB() {
		return ((this.DLP1) + (this.DLP2)) / 2;
	}

	public String getXeploai() {
		if (this.getDTB() >= 8.5 && this.getDTB() <= 10) {
			return "gioi";
		} else if (this.getDTB() >= 7 && this.getDTB() <= 8.4) {
			return "Kha";
		} else if (this.getDTB() >= 5 && this.getDTB() <= 6.9) {
			return "Trung Binh";
		} else {
			return "Kem";
		}
	}
	public String toString() {
		return String.format("| %-20s | %-20s | %-15s | %-15s | %-15s | %-15s |",
				this.getStuName(), this.getStuDate(), this.getDLP1(),
				this.getDLP2(),this.getDTB(), this.getXeploai()
				);
	}
}
