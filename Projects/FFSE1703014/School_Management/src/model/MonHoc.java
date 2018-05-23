package model;

public class MonHoc {
	public String maSub, tenSub, tinChi, thoiLuong;
	public MonHoc() {
		
	}
	public MonHoc(String maSub, String tenSub, String tinchi, String thoiLuong) {
		this.maSub = maSub;
		this.tenSub = tenSub;
		this.tinChi = tinchi;
		this.thoiLuong = thoiLuong;
	}
	public String getMaSub() {
		return maSub;
	}
	public void setMaSub(String maSub) {
		this.maSub = maSub;
	}
	public String getTenSub() {
		return tenSub;
	}
	public void setTenSub(String tenSub) {
		this.tenSub = tenSub;
	}
	public String getTinChi() {
		return tinChi;
	}
	public void setTinChi(String tinChi) {
		this.tinChi = tinChi;
	}
	public String getThoiLuong() {
		return thoiLuong;
	}
	public void setThoiLuong(String thoiLuong) {
		this.thoiLuong = thoiLuong;
	}
}
