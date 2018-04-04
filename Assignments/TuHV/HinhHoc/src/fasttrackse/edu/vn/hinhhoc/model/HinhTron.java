package fasttrackse.edu.vn.hinhhoc.model;

import fasttrackse.edu.vn.hinhhoc.main.*;

public class HinhTron extends HinhHoc {
	private int BanKinh;

	public HinhTron() {

	}

	public HinhTron(int BanKinh) {
		this.BanKinh = BanKinh;
	}

	public int getBanKinh() {
		return BanKinh;
	}

	public void setBanKinh(int banKinh) {
		BanKinh = banKinh;
	}

	public double getChuVi() {
		
		return (BanKinh * 2 * 3.14);

	}

	public double getDienTich() {

		return  (BanKinh * BanKinh * 3.14);

	}

}
