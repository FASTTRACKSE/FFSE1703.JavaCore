package project.model;

import java.sql.Timestamp;

public class ATMGD extends GiaoDich {
	private String quan;
	private String phuong;
	private String duong;
	
	public ATMGD() {
		
	}
	
	public ATMGD( String quan, String phuong, String duong, String maGiaoDich, String theKhachHang,Timestamp thoiGianGD, double tongTien, String  maATM) {
		super(maGiaoDich, theKhachHang, thoiGianGD, tongTien, maATM);
		this.quan = quan;
		this.phuong = phuong;
		this.duong = duong;
	}
	public String getQuan() {
		return quan;
	}
	public void setQuan(String quan) {
		this.quan = quan;
	}
	public String getPhuong() {
		return phuong;
	}
	public void setPhuong(String phuong) {
		this.phuong = phuong;
	}
	public String getDuong() {
		return duong;
	}
	public void setDuong(String duong) {
		this.duong = duong;
	}
}
