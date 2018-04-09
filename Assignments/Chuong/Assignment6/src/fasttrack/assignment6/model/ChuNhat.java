package fasttrack.assignment6.model;

public class ChuNhat extends HinhHoc{
	public double Dai;
	public double Rong;
	
	public double getChieudai() {
		return Dai;
	}
	public void setChieudai(double chieudai) {
		Dai = chieudai;
	}
	public double getChieurong() {
		return Rong;
	}
	
	public ChuNhat() {
		
	}
	
	public ChuNhat(double dai, double rong) {
		Dai = dai;
		Rong = rong;
	}
	
	public void setChieurong(double rong) {
		Rong = rong;
	}
	public double getChuVi() {
		return (Dai + Rong)*2;
	}
	@Override
	public double getDienTich() {
		return (Dai * Rong);
	}
	
}
