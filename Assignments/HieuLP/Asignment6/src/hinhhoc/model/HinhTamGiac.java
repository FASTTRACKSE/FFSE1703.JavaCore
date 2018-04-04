package hinhhoc.model;

import hinhhoc.main.*;

public class HinhTamGiac extends HinhHoc {
	public double CanhA;
	public double CanhB;
	public double CanhC;

	public HinhTamGiac(double a, double b, double c) {
		CanhA = a;
		CanhB = b;
		CanhC = c;
	}

	public HinhTamGiac() {

	}

	public double getChuvi() {

		return (CanhA + CanhB + CanhC);
	}

	@Override
	public double getDientich() {
		double a = getChuvi() / 2;
		return (Math.sqrt(a * (a - CanhA) * (a - CanhB) * (a - CanhC)));
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

}
