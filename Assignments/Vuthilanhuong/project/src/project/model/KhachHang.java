package project.model;

public class KhachHang  extends GiaoDich{
private String maKhach;
private String tenKhach;
private String diaChiN;
private String chonQuan;
private String chonPhuong;
private String soDT;
private String emailK;
private String soThe;
private String matKhau;
private String soTien;

public KhachHang(){
	
}

public KhachHang(String maKhach,  String tenKhach,  String diaChiN, String chonQuan,  String chonPhuong, String soDT, String emailK, String soThe, String taiKhoan, String matKhau) {
	this.maKhach= maKhach;
	this.tenKhach= tenKhach;
	this.diaChiN= diaChiN;
	this.chonQuan = chonQuan;
	this.chonPhuong = chonPhuong;
	this.soDT = soDT;
	this.emailK = emailK;
	this.soThe= soThe;
	this.matKhau= matKhau;
	this.soTien=taiKhoan;
	
}


public String getMaKhach() {
	return maKhach;
}

public void setMaKhach(String maKhach) {
	this.maKhach = maKhach;
}

public String getTenKhach() {
	return tenKhach;
}

public void setTenKhach(String tenKhach) {
	this.tenKhach = tenKhach;
}

public String getDiaChiN() {
	return diaChiN;
}

public void setDiaChiN(String diaChiN) {
	this.diaChiN = diaChiN;
}

public String getChonQuan() {
	return chonQuan;
}

public void setChonQuan(String chonQuan) {
	this.chonQuan = chonQuan;
}

public String getChonPhuong() {
	return chonPhuong;
}

public void setChonPhuong(String chonPhuong) {
	this.chonPhuong = chonPhuong;
}

public String getSoDT() {
	return soDT;
}

public void setSoDT(String soDT) {
	this.soDT = soDT;
}

public String getEmailK() {
	return emailK;
}

public void setEmailK(String emailK) {
	this.emailK = emailK;
}

public String getSoThe() {
	return soThe;
}

public void setSoThe(String soThe) {
	this.soThe = soThe;
}

public String getSoTien() {
	return soTien;
}

public void setSoTien(String taiKhoan) {
	this.soTien = taiKhoan;
}

public void add(String maKh, String tenKh, String diaChiKh, String dienThoaiKh, String emailKh, String sotheKh,
		String taiKhoanKh, String quanKh, String phuongKh) {
	// TODO Auto-generated method stub
	this.maKhach= maKh;
	this.tenKhach= tenKh;
	this.diaChiN= diaChiKh;
	this.chonQuan = quanKh;
	this.chonPhuong = phuongKh;
	this.soDT = dienThoaiKh;
	this.emailK = emailKh;
	this.soThe= sotheKh;
	this.soTien=taiKhoanKh;
}
}
