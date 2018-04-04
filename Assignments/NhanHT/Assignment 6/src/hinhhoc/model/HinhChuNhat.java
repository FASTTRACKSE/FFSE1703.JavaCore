package hinhhoc.model;

public class HinhChuNhat extends HinhHoc{
	public double chieuDai, chieuRong;
	public HinhChuNhat() {
		
	}
	public HinhChuNhat(double chieuDai, double chieuRong) {
		super();
		this.chieuDai = chieuDai;
		this.chieuRong = chieuRong;
	}
	
	public double getChieuDai() {
		return chieuDai;
	}
	public void setChieuDai(double chieuDai) {
		this.chieuDai = chieuDai;
	}
	public double getChieuRong() {
		return chieuRong;
	}
	public void setChieuRong(double chieuRong) {
		this.chieuRong = chieuRong;
	}
	//

	public double getChuVi() {
		return 2*(this.chieuDai+this.chieuRong);
	}
	public double getDienTich() {
		return this.chieuDai*this.chieuRong;
	}
}
