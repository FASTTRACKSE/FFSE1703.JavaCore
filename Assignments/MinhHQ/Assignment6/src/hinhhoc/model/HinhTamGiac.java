package hinhhoc.model;

import java.lang.Math;

public class HinhTamGiac extends HinhHoc {
	public double canhA;
	public double canhB;
	public double canhC;

	public HinhTamGiac() {
		
	}
	
	public HinhTamGiac(double a,double b,double c) {
		canhA = a;
		canhB = b;
		canhC = c;
	}
	
	public double getCanhA() {
		return canhA;
	}

	public void setCanhA(double canhA) {
		this.canhA = canhA;
	}

	public double getCanhB() {
		return canhB;
	}

	public void setCanhB(double canhB) {
		this.canhB = canhB;
	}

	public double getCanhC() {
		return canhC;
	}

	public void setCanhC(double canhC) {
		this.canhC = canhC;
	}

	public double getChuVi() {
		return (canhA + canhB + canhC);
	}

	
	
	public double getDienTich() {
		double q = getChuVi()/2;
		return (Math.sqrt(q*(q-canhA)*(q-canhB)*(q-canhC)));
	}

	
}
