package QuanLyTienDien;

import java.util.Scanner;

public class KhachHang {
	private String maKH;
	private String tenKH;
	private String diaChi;
	private String maCT;
	public KhachHang() {	
	}
	public KhachHang(String maKH,String tenKH,String diaChi,String maCT) {
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.diaChi = diaChi;
		this.maCT = maCT;
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getMaCT() {
		return maCT;
	}
	public void setMaCT(String maCT) {
		this.maCT = maCT;
	}

}