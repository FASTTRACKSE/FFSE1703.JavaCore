package model;

import java.io.Serializable;

public class SinhVien implements Serializable {
	private String maSV, ten,lop;
	private String tuoi;
	
	public SinhVien() {
		//
	}
	
	public SinhVien(String maSV, String ten, String tuoi, String lop) {
		this.maSV = maSV;
		this.ten = ten;
		this.tuoi = tuoi;
		this.lop = lop;
	}

	public String getMaSV() {
		return maSV;
	}

	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}


	public String getTuoi() {
		return tuoi;
	}

	public void setTuoi(String tuoi) {
		this.tuoi = tuoi;
	}

	public String getLop() {
		return lop;
	}

	public void setLop(String lop) {
		this.lop = lop;
	}
	
	@Override
	public String toString() {
		return "SinhVien [maSV=" + maSV + ", ten=" + ten + ", lop=" + lop + ", tuoi=" + tuoi + "]";
	}
	
}
