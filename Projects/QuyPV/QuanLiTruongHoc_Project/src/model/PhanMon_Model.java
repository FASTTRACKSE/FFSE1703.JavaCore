package model;

import com.mysql.jdbc.Connection;

import connector.GetConnect;

public class PhanMon_Model {
	private String maLop, maMon;
	final Connection conn= (new GetConnect()).getConnect("localhost", "Quan_li_truong_hoc", "phamquy481", "a0163763123");
	public PhanMon_Model() {
		 //
	 }
	 
	public PhanMon_Model(String maLop, String maMon) {
		 this.maLop = maLop;
		 this.maMon = maMon;
	 }

	public String getMaLop() {
		return maLop;
	}

	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}

	public String getMaMon() {
		return maMon;
	}

	public void setMaMon(String maMon) {
		this.maMon = maMon;
	}
	
	
}
