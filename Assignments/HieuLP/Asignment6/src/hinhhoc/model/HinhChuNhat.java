package hinhhoc.model;

import hinhhoc.main.*;

public class HinhChuNhat extends HinhHoc {
	public double Chieudai;
	public double Chieurong;

	public HinhChuNhat(double chieudai, double chieurong) {

		Chieudai = chieudai;
		Chieurong = chieurong;
	}

	public HinhChuNhat() {

	}

	public double getChuvi() {
		return (Chieudai + Chieurong) * 2;

	}

	public double getDientich() {
		// TODO Auto-generated method stub
		return Chieudai * Chieurong;
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

}
