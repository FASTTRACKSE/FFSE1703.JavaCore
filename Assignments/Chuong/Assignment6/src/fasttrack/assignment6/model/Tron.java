package fasttrack.assignment6.model;

public class Tron extends HinhHoc {
	private double Bankinh;

	public Tron(double Bankinh) {
		this.Bankinh = Bankinh;
	}
	
	public Tron() {

	}

	public double getBankinh() {
		return Bankinh;
	}

	public void setBankinh(double bankinh) {
		Bankinh = bankinh;
	}

	@Override
	public double getChuVi() {
		// TODO Auto-generated method stub
		return Bankinh * 2 * 3.14;
	}

	@Override
	public double getDienTich() {
		// TODO Auto-generated method stub
		return Bankinh * Bankinh * 3.14;
	}

}