package model;

public class QuanLiMonHocCuaLopModel {
	private String maLop,maMh;
	public QuanLiMonHocCuaLopModel() {
		// TODO Auto-generated constructor stub
	}
	public QuanLiMonHocCuaLopModel(String maLop,String maMh) {
		// TODO Auto-generated constructor stub
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
