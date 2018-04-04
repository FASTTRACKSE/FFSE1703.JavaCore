package hinhhoc.model;

public class HinhChuNhat extends HinhHoc {
	
	double chieuDai;
	double chieuRong;
	public HinhChuNhat(double chieuDai,double chieuRong) {
		
		this.chieuDai=chieuDai;
		this.chieuRong=chieuRong;
		
	}
	public HinhChuNhat() {
		super();
	}
	public double getChuVi() {
		return 2*(this.chieuDai+this.chieuRong);
	}
	public double getDienTich() {
		return (this.chieuDai*this.chieuRong);
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
	
}
