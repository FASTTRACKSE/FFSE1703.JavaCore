package ffse1703.javacore.hinhhoc.model;

public class HinhTamGiac extends hinhHoc {
	private double canhA;
	private double canhB;
	private double canhC;

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

	@Override
	public double getChuVi() {
		// TODO Auto-generated method stub

		return canhA + canhB + canhC;
	}

	@Override
	public double getDienTich() {
		// TODO Auto-generated method stub
		double q = getChuVi() / 2;
		return (Math.sqrt(q * (q - canhA) * (q - canhB) * (q - canhC)));
	}

}
