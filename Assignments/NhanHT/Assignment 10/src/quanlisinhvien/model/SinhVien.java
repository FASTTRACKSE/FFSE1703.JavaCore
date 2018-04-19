package quanlisinhvien.model;

import java.io.Serializable;

public class SinhVien implements Serializable{
	private String lop, maSv, tenSv,tuoiSv;
	
	public SinhVien() {
		
	}
	public SinhVien(String maSv,String tenSv,String tuoiSv,String lop) {
		this.lop = lop;
		this.maSv = maSv;
		this.tenSv = tenSv;
		this.tuoiSv = tuoiSv;
	}
	public String getLop() {
		return lop;
	}
	public void setLop(String lop) {
		this.lop = lop;
	}
	public String getMaSv() {
		return maSv;
	}
	public void setMaSv(String maSv) {
		this.maSv = maSv;
	}
	public String getTenSv() {
		return tenSv;
	}
	public void setTenSv(String tenSv) {
		this.tenSv = tenSv;
	}
	public String getTuoiSv() {
		return tuoiSv;
	}
	public void setTuoiSv(String tuoiSv) {
		this.tuoiSv = tuoiSv;
	}
	
}
