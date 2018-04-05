package ffse1703.javacore.model;

public class HinhChuNhat extends HinhHoc{
	private double chieuDai, chieuRong;
	
	public HinhChuNhat() {
		//
	}
	
	public HinhChuNhat(double chieuDai, double chieuRong) {
		super();
		this.chieuDai = chieuDai;
		this.chieuRong = chieuRong;
	}
	
	public double getDienTich() {
		return this.chieuDai * this.chieuRong;
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

	public double getChuVi() {
		return (this.chieuDai + this.chieuRong) * 2;
	}
	
}
