package hinhhoc.model;

public class HinhTron extends HinhHoc {
	public double Bankinh;
	
	public double getBankinh() {
		return Bankinh;
	}

	public void setBankinh(double bankinh) {
		Bankinh = bankinh;
	}

	public HinhTron() {
		
	}
	
	public HinhTron(double Bankinh) {
		this.Bankinh = Bankinh;
	}
	
	public double getChuVi() {
		return (this.Bankinh*2*3.14);
	}
	
	public double getDienTich() {
		return (this.Bankinh*this.Bankinh*3.14);
	}
	
}
