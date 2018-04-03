package hinhhoc.model;

public class HinhChuNhat extends HinhHoc{
	public double Chieudai;
	public double Chieurong;
	
	public double getChieudai() {
		return Chieudai;
	}
	public void setChieudai(double chieudai) {
		Chieudai = chieudai;
	}
	public double getChieurong() {
		return Chieurong;
	}
	
	public HinhChuNhat() {
		
	}
	
	public HinhChuNhat(double cd, double cr) {
		Chieudai = cd;
		Chieurong = cr;
	}
	
	public void setChieurong(double chieurong) {
		Chieurong = chieurong;
	}
	public double getChuVi() {
		return (Chieudai + Chieurong)*2;
	}
	@Override
	public double getDienTich() {
		return (Chieudai*Chieurong);
	}
	
}
