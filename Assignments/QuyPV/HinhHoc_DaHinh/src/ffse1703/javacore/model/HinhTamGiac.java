package ffse1703.javacore.model;

public class HinhTamGiac extends HinhHoc {
	private double canhA, canhB, canhC;

	public HinhTamGiac() {
		//
	}

	public HinhTamGiac(double canhA, double canhB, double canhC) {
		super();
		this.canhA = canhA;
		this.canhB = canhB;
		this.canhC = canhC;
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

		return this.canhA + this.canhB + this.canhC;

	}

	public double nuaChuVi() {
		return (this.canhA + this.canhB + this.canhC) / 2;

	}

	public double getDienTich() {
		return Math.sqrt(nuaChuVi() * (nuaChuVi() - this.canhA) * (nuaChuVi() - this.canhB) * (nuaChuVi() - this.canhC));

	}

}
