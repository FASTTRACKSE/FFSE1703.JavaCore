package fasttrack.assignment6.model;


public class Vuong extends HinhHoc {
	private double CanhA;

	public Vuong(double canhA) {
		CanhA = canhA;

	}

	public Vuong() {

	}

	public double getCanhA() {
		return CanhA;
	}

	public void setCanhA(double canhA) {
		CanhA = canhA;
	}

	@Override
	public double getChuVi() {
		// TODO Auto-generated method stub
		return 4 * CanhA;
	}

	@Override
	public double getDienTich() {
		// TODO Auto-generated method stub
		return CanhA * CanhA;
	}

}