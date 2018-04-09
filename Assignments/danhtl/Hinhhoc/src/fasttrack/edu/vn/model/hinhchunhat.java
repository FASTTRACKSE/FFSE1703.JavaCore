package fasttrack.edu.vn.model;

import fasttrack.edu.vn.main.*;

public class hinhchunhat extends Hinhhoc {

	private int chieudai;
	private int chieurong;

	public hinhchunhat() {

	}

	public hinhchunhat(int chieudai, int chieurong) {
		this.chieudai = chieudai;
		this.chieurong = chieurong;
	}

	public int getChieudai() {
		return chieudai;
	}

	public void setChieudai(int chieudai) {
		this.chieudai = chieudai;
	}

	public int getChieurong() {
		return chieurong;
	}

	public void setChieurong(int chieurong) {
		this.chieurong = chieurong;
	}

	@Override
	public double getChuVi() {

		return (chieudai + chieurong) * 2;
	}

	public double getDienTich() {

		return (chieudai * chieurong);
	}

}