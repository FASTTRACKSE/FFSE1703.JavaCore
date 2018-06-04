package project.model;

import java.sql.Timestamp;

public class KhachHangGD extends GiaoDich {
	private String tenKhach;
	private String maK;
	public KhachHangGD(){
		
	}
	public KhachHangGD(String tenKhach, String maK, String maGiaoDich, String theKhachHang,Timestamp thoiGianGD, double tongTien, String  maATM) {
		super(maGiaoDich, theKhachHang, thoiGianGD, tongTien, maATM);
		this.tenKhach = tenKhach;
		this.maK = maK;
	}
	public String getTenKhach() {
		return tenKhach;
	}
	public void setTenKhach(String tenKhach) {
		this.tenKhach = tenKhach;
	}
	public String getMaK() {
		return maK;
	}
	public void setMaK(String maK) {
		this.maK = maK;
	}
	

}
