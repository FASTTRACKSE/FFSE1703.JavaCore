package ffse1703.javacore.model;

public class HinhTron extends HinhHoc {
	private double banKinh;

	public HinhTron() {
		//
	}
	
	public HinhTron(double banKinh) {
		super();
		this.banKinh = banKinh;
	}

	
	public double getBanKinh() {
		return banKinh;
	}


	public void setBanKinh(double banKinh) {
		this.banKinh = banKinh;
	}


	public double getChuVi() {
		return this.banKinh * 2 * 3.14;
		
	}

	public double getDienTich() {
		return (this.banKinh * this.banKinh) * 3.14;
		
	}
}
