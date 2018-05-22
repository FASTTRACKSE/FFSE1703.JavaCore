package model;

public class SinhVien {
	public String maSV, tenSV, diaChi, phuong, quan, tinhTP, dienThoai,email,lop;
	public SinhVien() {
		
	}
	public SinhVien(String maSV, String tenSV,String diaChi, String phuong, String quan, String tinhTP, String dienThoai, String email, String lop) {
	this.maSV = maSV;
	this.tenSV = tenSV;
	this.diaChi = diaChi;
	this.phuong = phuong;
	this.quan = quan;
	this.tinhTP = tinhTP;
	this.dienThoai = dienThoai;
	this.email = email;
	this.lop = lop;
	}
	public String getMaSV() {
		return maSV;
	}
	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}
	public String getTenSV() {
		return tenSV;
	}
	public void setTenSV(String tenSV) {
		this.tenSV = tenSV;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getPhuong() {
		return phuong;
	}
	public void setPhuong(String phuong) {
		this.phuong = phuong;
	}
	public String getQuan() {
		return quan;
	}
	public void setQuan(String quan) {
		this.quan = quan;
	}
	public String getTinhTP() {
		return tinhTP;
	}
	public void setTinhTP(String tinhTP) {
		this.tinhTP = tinhTP;
	}
	public String getDienThoai() {
		return dienThoai;
	}
	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLop() {
		return lop;
	}
	public void setLop(String lop) {
		this.lop = lop;
	}
	
}
