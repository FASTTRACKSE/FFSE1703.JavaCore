package HinhHoc.model;

 public class HinhTamGiac extends HinhHoc {
	private double canhA;
	private double canhB;
	private double canhC;
	public HinhTamGiac() {
		
	}
	public HinhTamGiac(double A, double B, double C) {
		this.canhA = A;
		this.canhB = B;
		this.canhC = C;
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
		return (canhA+canhB+canhC);
	}
	public double getDienTich() {
		double p = (canhA+canhB+canhC)/2;
		return (Math.sqrt(p*(p-canhA)*(p-canhB)*(p-canhC)));
	}
}
