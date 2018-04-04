package HinhHoc.model;

public class HinhTron extends HinhHoc{
	public double BanKinh;
	public HinhTron() {
		
	}
	public HinhTron(double bankinh) {
		this.BanKinh = bankinh;
	}
	public double getBanKinh() {
		return BanKinh;
	}
	public void setBanKinh(double banKinh) {
		BanKinh = banKinh;
	}
	
	public double getChuVi() {
		return (BanKinh*2*3.14);
}
	public double getDienTich() {
		return (BanKinh*BanKinh*3.14);
	}
}
