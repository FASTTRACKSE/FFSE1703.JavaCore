package model;

public class MonHocTheoLop {
	public String maMH, tenMH;
	public MonHocTheoLop() {
		
	}
	public MonHocTheoLop(String maMH, String tenMH) {
		this.maMH = maMH;
		this.tenMH = tenMH;
	}
	public String getMaMH() {
		return maMH;
	}
	public void setMaMH(String maMH) {
		this.maMH = maMH;
	}
	public String getTenMH() {
		return tenMH;
	}
	public void setTenMH(String tenMH) {
		this.tenMH = tenMH;
	}
}
