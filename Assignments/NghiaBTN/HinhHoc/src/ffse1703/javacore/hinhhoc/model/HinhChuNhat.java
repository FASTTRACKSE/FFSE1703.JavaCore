package ffse1703.javacore.hinhhoc.model;

public class HinhChuNhat extends hinhHoc {
	private Double ChieuDai;
	private Double ChieuRong;

	public HinhChuNhat() {
	}

	public HinhChuNhat(double cd, double cr) {
		ChieuDai = cd;
		ChieuRong = cr;
	}
	public Double getChieuDai() {
		return ChieuDai;
	}

	public void setChieuDai(Double ChieuDai) {
		this.ChieuDai = ChieuDai;
	}

	public Double getChieuRong() {
		return ChieuRong;
	}

	public void setChieuRong(Double ChieuRong) {
		this.ChieuRong = ChieuRong;
	}

	@Override
	public double getChuVi() {

		return (ChieuDai + ChieuRong) * 2;
	}

	@Override
	public double getDienTich() {

		return (ChieuDai * ChieuRong);
	}
}
