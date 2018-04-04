package ffse1702010.edu.vn.model;

import java.util.Scanner;

public class HinhChuNhat extends AbstractHinhHoc {
	int ChieuDai;
	int ChieuRong;
	Scanner input=new Scanner(System.in);
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
		return ((this.ChieuDai+this.ChieuRong)*2);
	}
	
	public double getDienTich() {
		return (this.ChieuDai*this.ChieuRong);
	}



}
