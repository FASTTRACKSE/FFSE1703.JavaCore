package HinhHoc_model;

public class HinhTron extends HinhHoc {
	public static double bankinh;

	public HinhTron() {
		super();
	}

	public HinhTron(double chuvi, double dientich, double bankinh) {
		super(chuvi, dientich);
		this.bankinh = bankinh;
	}

	public void setbanKinh(double bankinh) {
		this.bankinh = bankinh;
	}

	public double getbanKinh() {
		return this.bankinh;
	}

	public void tinhChuvi(double bankinh) {
		chuvi = (bankinh * 2) * 3.14;
	}

	public void tinhDientich(double bankinh) {
		dientich = (bankinh * bankinh) * 3.14;
	}

	public double getChuvihinhtron() {
		return this.chuvi;
	}

	public double getDientichhinhtron() {
		return this.dientich;
	}
}
