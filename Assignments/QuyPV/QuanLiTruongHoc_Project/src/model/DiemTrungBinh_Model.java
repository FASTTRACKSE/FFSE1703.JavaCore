package model;

import com.mysql.jdbc.Connection;

import connector.GetConnect;

public class DiemTrungBinh_Model {
	private String maSv, diemTb, xepLoai;
	final Connection conn= (new GetConnect()).getConnect("localhost", "Quan_li_truong_hoc", "phamquy481", "a0163763123");
	public DiemTrungBinh_Model() {
		//
	}
	
	public DiemTrungBinh_Model(String maSv, String diemTb, String xepLoai ) {
		this.maSv = maSv;
		this.diemTb = diemTb;
		this.xepLoai = xepLoai;
	}

	public String getMaSv() {
		return maSv;
	}

	public void setMaSv(String maSv) {
		this.maSv = maSv;
	}

	public String getDiemTb() {
		return diemTb;
	}

	public void setDiemTb(String diemTb) {
		this.diemTb = diemTb;
	}

	public String getXepLoai() {
		return xepLoai;
	}

	public void setXepLoai(String xepLoai) {
		this.xepLoai = xepLoai;
	}
	
	
}
