package model;

public class QuanLiMonHocCuaLopModel {
	private String maLop,maMh;
	public QuanLiMonHocCuaLopModel() {
	}
	public QuanLiMonHocCuaLopModel(String maLop,String maMh) {
		this.maLop = maLop;
		this.maMh = maMh;
	}
	public String getMalop() {
		return maLop;
	}
	public void setMalop(String maLop) {
		this.maLop = maLop;
	}
	public String getMaMh() {
		return maMh;
	}
	public void setMaMh(String maMh) {
		this.maMh = maMh;
	}
	
}
