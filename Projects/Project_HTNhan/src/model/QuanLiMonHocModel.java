package model;

public class QuanLiMonHocModel {
	private String maMH,tenMH,tinChiMH,thoiGianMH;
	public QuanLiMonHocModel() {
		// TODO Auto-generated constructor stub
	}
	public QuanLiMonHocModel(String maMH ,String tenMH,String tinChiMH,String thoiGianMH) {
		this.maMH = maMH;
		this.tenMH = tenMH;
		this.tinChiMH = tinChiMH;
		this.thoiGianMH = thoiGianMH;
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
	public String getTinChiMH() {
		return tinChiMH;
	}
	public void setTinChiMH(String tinChiMH) {
		this.tinChiMH = tinChiMH;
	}
	public String getThoiGianMH() {
		return thoiGianMH;
	}
	public void setThoiGianMH(String thoiGianMH) {
		this.thoiGianMH = thoiGianMH;
	}
	
}
