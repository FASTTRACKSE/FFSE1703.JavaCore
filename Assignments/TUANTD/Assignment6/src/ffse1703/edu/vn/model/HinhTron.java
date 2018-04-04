package ffse1703.edu.vn.model;


public class HinhTron extends HinhHoc {	
	private double banKinh;
	public HinhTron() {
		
	}
	public HinhTron(double banKinh) {
		this.banKinh=banKinh;
	}
	public double getBanKinh() {
		return banKinh;
	}
	
	public void setBanKinh(double banKinh) {
		this.banKinh = banKinh;
	}
	
	public double getChuVi() {
		return 2*3.14*banKinh;		
	}
	
	public double getDienTich() {
		return 3.14*banKinh*banKinh;		
	}
}
