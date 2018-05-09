package model;

import com.mysql.jdbc.Connection;

import connector.GetConnect;

public class QuanLiDiem_Model {
	private String maSv, maMon, diem;
	final Connection conn= (new GetConnect()).getConnect("localhost", "Quan_li_truong_hoc", "phamquy481", "a0163763123");
	public QuanLiDiem_Model() {
		//
	}
	
	public QuanLiDiem_Model(String maSv, String maMon, String diem) {
		this.maSv = maSv;
		this.maMon = maMon;
		this.diem = diem;
	}

	public String getMaSv() {
		return maSv;
	}

	public void setMaSv(String maSv) {
		this.maSv = maSv;
	}

	public String getMaMon() {
		return maMon;
	}

	public void setMaMon(String maMon) {
		this.maMon = maMon;
	}

	public String getDiem() {
		return diem;
	}

	public void setDiem(String diem) {
		this.diem = diem;
	}
	
	
}
