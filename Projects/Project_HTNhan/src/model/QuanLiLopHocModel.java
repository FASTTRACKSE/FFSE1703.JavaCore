package model;

public class QuanLiLopHocModel {
	private String maLop,tenLop,namHoc;
	public QuanLiLopHocModel() {
		// TODO Auto-generated constructor stub
	}
	public QuanLiLopHocModel(String maLop,String tenLop,String namHoc) {
		this.maLop = maLop;
		this.tenLop = tenLop;
		this.namHoc = namHoc; 
	}
	public String getMaLop() {
		return maLop;
	}
	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}
	public String getTenLop() {
		return tenLop;
	}
	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}
	public String getNamHoc() {
		return namHoc;
	}
	public void setNamHoc(String namHoc) {
		this.namHoc = namHoc;
	}
	
}
