package fasttrack.assignment6.model;

public class ChuNhat extends HinhHoc {
	private double Chieudai;
	private double Chieurong;

	public ChuNhat(double chieudai, double chieurong) {

		Chieudai = chieudai;
		Chieurong = chieurong;
	}

	public ChuNhat() {

	}

	public double getChieudai() {
		return Chieudai;
	}

	public void setChieudai(double chieudai) {
		Chieudai = chieudai;
	}

	public double getChieurong() {
		return Chieurong;
	}

	public void setChieurong(double chieurong) {
		Chieurong = chieurong;
	}

	@Override
	public double getChuVi() {
		// TODO Auto-generated method stub
		return (Chieudai + Chieurong) * 2;
	}

	@Override
	public double getDienTich() {
		// TODO Auto-generated method stub
		return Chieudai * Chieurong;
	}
	
}