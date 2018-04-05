package fasttrackse.edu.vn.hinhhoc.model;

import fasttrackse.edu.vn.hinhhoc.main.*;

public class HinhChuNhat extends HinhHoc {
	private int ChieuDai;
	private int ChieuRong;

	public HinhChuNhat() {

	}

	public HinhChuNhat(int ChieuDai, int ChieuRong) {
		this.ChieuDai = ChieuDai;
		this.ChieuRong = ChieuRong;
	}

	public int getChieuDai() {
		return ChieuDai;
	}

	public void setChieuDai(int chieuDai) {
		ChieuDai = chieuDai;
	}

	public int getChieuRong() {
		return ChieuRong;
	}

	public void setChieuRong(int chieuRong) {
		ChieuRong = chieuRong;
	}

	public double getChuVi() {
		
		return ((ChieuDai + ChieuRong) * 2);
		
	}

	public double getDienTich() {
		
		return  (ChieuDai * ChieuRong);
	}

}
