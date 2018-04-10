package fasttrack.assignment6.model;

import java.lang.Math;

public class TamGiac extends HinhHoc {
	private double CanhA;
	private double CanhB;
	private double CanhC;

	public TamGiac(double a, double b, double c) {
		CanhA = a;
		CanhB = b;
		CanhC = c;
	}

	public TamGiac() {

	}

	public double getCanhA() {
		return CanhA;
	}

	public void setCanhA(double canhA) {
		CanhA = canhA;
	}

	public double getCanhB() {
		return CanhB;
	}

	public void setCanhB(double canhB) {
		CanhB = canhB;
	}

	public double getCanhC() {
		return CanhC;
	}

	public void setCanhC(double canhC) {
		CanhC = canhC;
	}

	@Override
	public double getChuVi() {
		// TODO Auto-generated method stub
		return (CanhA + CanhB + CanhC);
	}

	@Override
	public double getDienTich() {
		// TODO Auto-generated method stub
		double a = getChuVi() / 2;
		return (Math.sqrt(a * (a - CanhA) * (a - CanhB) * (a - CanhC)));
	}

}