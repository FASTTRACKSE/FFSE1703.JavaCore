package hinhhoc.model;

public class HinhTron extends HinhHoc {
	public static double banKinh,chuVi,dienTich;
	public HinhTron() {
		// TODO Auto-generated constructor stub
	}
	public HinhTron(double banKinh) {
		this.banKinh = banKinh;
	}
	public void setBanKinh(double banKinh) {
		this.banKinh = banKinh;
	}
	public double getChuVi() {
		chuVi = 2 * banKinh *Math.PI;
		return chuVi;
	}
	public double getDienTich() {
		dienTich = banKinh * banKinh * Math.PI;
		return dienTich;
	}
}
