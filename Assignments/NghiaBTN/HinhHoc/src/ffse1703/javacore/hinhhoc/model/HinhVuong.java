package ffse1703.javacore.hinhhoc.model;

public class HinhVuong extends hinhHoc {
	private double canhA;

	public HinhVuong() {
	}
	public HinhVuong(double a) {
		canhA = a;
	}
	public double getcanhA() {
		return canhA;
	}

	public void setcanhA(double canhA) {
		this.canhA = canhA;
	}

	@Override
	public double getChuVi() {

		return canhA * 4;
	}

	@Override
	public double getDienTich() {

		return canhA * canhA;
	}
}
