package HinhHoc.modle;

public class HinhTron extends HinhHoc {	
	private int banKinh;
	public HinhTron() {
		
	}
	public HinhTron(int banKinh) {
		this.banKinh=banKinh;
	}
	public int getBanKinh() {
		return banKinh;
	}
	
	public void setBanKinh(int banKinh) {
		this.banKinh = banKinh;
	}
	
	public double getChuVi() {
		return (2*3.14*banKinh);
	}
	
	public double getDienTich() {
		return (3.14*banKinh*banKinh);		
	}
}