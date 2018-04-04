package hinhhoc.model;

import java.util.Scanner;

public class HinhTamGiac extends HinhHoc {
	public static double canhA,canhB,canhC,p,chuVi,dienTich; 
	public HinhTamGiac() {
		// TODO Auto-generated constructor stub
	}
	public HinhTamGiac(double canhA,double canhB,double canhC) {
		this.canhA = canhA;
		this.canhB = canhB;
		this.canhC = canhC;
	}
	public void setCanh(double canhA,double canhB,double canhC) {
		this.canhA = canhA;
		this.canhB = canhB;
		this.canhC = canhC;
	}
	public double getChuVi() {
		chuVi = canhA + canhB + canhC;
		return chuVi;
	}
	public double getDienTich() {
		p = (canhA + canhB + canhC)/2;
		dienTich = Math.sqrt(p*(p-canhA)*(p-canhB)*(p-canhC));
		return dienTich;
	}
}
