package ffse1703.javacore.hinhhoc.model;

public class HinhTron extends hinhHoc {
	private double BanKinh;

	public HinhTron() {
	}
	public HinhTron(double bankinh) {
		this.BanKinh = bankinh;
	}

	public double getBanKinh() {
		return BanKinh;
	}

	public void setBanKinh(double BanKinh) {
		this.BanKinh = BanKinh;
	}

	@Override
	public double getChuVi() {
		// TODO Auto-generated method stub
		return (this.BanKinh * 2 * 3.14);
	}

	@Override
	public double getDienTich() {
		// TODO Auto-generated method stub
		return (this.BanKinh * this.BanKinh * 3.14);
	}

}
