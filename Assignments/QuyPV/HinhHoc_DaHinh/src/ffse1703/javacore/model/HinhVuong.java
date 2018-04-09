package ffse1703.javacore.model;

public class HinhVuong extends HinhHoc {
	private double canhA;
	
	public HinhVuong() {
		//
	}
	
	public HinhVuong(double canhA) {
		super();
		this.canhA = canhA;
	}

	public double getCanhA() {
		return canhA;
	}

	public void setCanhA(double canhA) {
		this.canhA = canhA;
	}
	
	public double getChuVi() {
		return this.canhA * 4;
	}
	
	public double getDienTich() {
		return this.canhA * this.canhA;
	}
}
