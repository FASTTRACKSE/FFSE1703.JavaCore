package model;

import com.mysql.jdbc.Connection;

import connector.GetConnect;

public class QuanLiMonHoc_Model {
	private String maMon, tenMon, soTinChi, thoiLuong;
	
	public QuanLiMonHoc_Model() {
		//
	}
	
	public QuanLiMonHoc_Model(String maMon, String tenMon, String soTinChi, String thoiLuong) {
		this.maMon = maMon;
		this.tenMon = tenMon;
		this.soTinChi = soTinChi;
		this.thoiLuong = thoiLuong;
	}
	
	public QuanLiMonHoc_Model(String tenMon, String maMon) {
		this.tenMon = tenMon;
		this.maMon = maMon;
		
	}

	public String getMaMon() {
		return maMon;
	}

	public void setMaMon(String maMon) {
		this.maMon = maMon;
	}

	public String getTenMon() {
		return tenMon;
	}

	public void setTenMon(String tenMon) {
		this.tenMon = tenMon;
	}

	public String getSoTinChi() {
		return soTinChi;
	}

	public void setSoTinChi(String soTinChi) {
		this.soTinChi = soTinChi;
	}

	public String getThoiLuong() {
		return thoiLuong;
	}

	public void setThoiLuong(String thoiLuong) {
		this.thoiLuong = thoiLuong;
	}

	@Override
	public String toString() {
		return this.tenMon;
	}
	
	
	
}
