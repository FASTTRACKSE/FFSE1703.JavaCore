package hinhhoc.model;

import hinhhoc.main.*;

public class HinhVuong extends HinhHoc {
	public double CanhA;

	public HinhVuong(double canhA) {
		CanhA = canhA;

	}

	public HinhVuong() {

	}

	@Override
	public double getChuvi() {

		return 4 * CanhA;
	}

	@Override
	public double getDientich() {

		return CanhA * CanhA;
	}

	public double getCanhA() {
		return CanhA;
	}

	public void setCanhA(double canhA) {
		CanhA = canhA;
	}

}
