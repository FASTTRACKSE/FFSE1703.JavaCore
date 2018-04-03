package hinhhoc.model;

public class HinhChuNhat extends HinhHoc {
	public static double chieuDai,chieuRong,chuVi,dienTich;
	public HinhChuNhat() {
		// TODO Auto-generated constructor stub
	}
	public HinhChuNhat (double chieuDai,double chieuRong) {
		this.chieuDai = chieuDai;
		this.chieuRong = chieuRong;
	}
	public void setDaiRong(double chieuDai,double chieuRong) {
		this.chieuDai = chieuDai;
		this.chieuRong = chieuRong;
	}
	public double getChuVi() {
		chuVi = (chieuDai + chieuRong) * 2;
		return chuVi;
	}
	public double getDienTich() {
		dienTich = chieuRong * chieuDai;
		return dienTich;
	}
}
