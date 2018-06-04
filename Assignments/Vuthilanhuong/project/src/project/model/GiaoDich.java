package project.model;

import java.sql.Timestamp;

public class GiaoDich {
	String theKhachHang,  maATM, maGiaoDich;
	Timestamp thoiGianGD;
	double tongTien;
	
	
	
	public GiaoDich() {
		
	}
	public GiaoDich( String maGiaoDich, String theKhachHang,Timestamp thoiGianGD, double tongTien, String  maATM) {
		this.maATM = maATM;
		this.theKhachHang = theKhachHang;
		this.maGiaoDich =maGiaoDich;
		this.thoiGianGD= thoiGianGD;
		this.tongTien= tongTien;
		
	}
	public String getTheKhachHang() {
		return theKhachHang;
	}

	public void setTheKhachHang(String theKhachHang) {
		this.theKhachHang = theKhachHang;
	}
	
	public String getMaATM() {
		return maATM;
	}
	public void setMaATM(String maATM) {
		this.maATM = maATM;
	}
	public String getMaGiaoDich() {
		return maGiaoDich;
	}
	public void setMaGiaoDich(String maGiaoDich) {
		this.maGiaoDich = maGiaoDich;
	}
	public Timestamp getThoiGianGD() {
		return thoiGianGD;
	}
	public void setThoiGianGD(Timestamp thoiGianGD) {
		this.thoiGianGD = thoiGianGD;
	}
	public double getTongTien() {
		return tongTien;
	}
	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}

}
