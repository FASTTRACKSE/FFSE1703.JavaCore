package HinhHoc.model;

 public class HinhChuNhat extends HinhHoc{
	private double Chieudai;
	private double Chieurong;
	public HinhChuNhat() {
		
	}
	public HinhChuNhat(double ChieuDai, double ChieuRong) {
		this.Chieudai = ChieuDai;
		this.Chieurong = ChieuRong;
	}
	public double getChieudai() {
		return Chieudai;
	}
	public void setChieudai(double chieudai) {
		this.Chieudai = chieudai;
	}
	public double getChieurong() {
		return Chieurong;
	}
	public void setChieurong(double chieurong) {
		Chieurong = chieurong;
	}
	public double getChuVi() {
		return (Chieudai+Chieurong)*2;
	}
	public double getDienTich() {
		return (Chieudai*Chieurong);
	}
}
