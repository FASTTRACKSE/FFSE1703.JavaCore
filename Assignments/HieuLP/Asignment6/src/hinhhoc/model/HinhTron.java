package hinhhoc.model;

import hinhhoc.main.*;

public class HinhTron extends HinhHoc {
	public double Bankinh;

	public HinhTron(double Bankinh) {
		this.Bankinh = Bankinh;
	}

	public double getChuvi() {

		return Bankinh * 2 * 3.14;
	}

	public double getDientich() {

		return Bankinh * Bankinh * 3.14;
	}

	public double getBankinh() {
		return Bankinh;
	}

	public void setBankinh(double bankinh) {
		Bankinh = bankinh;
	}

	public HinhTron() {

	}


}
