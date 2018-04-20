package Assignment_list.assignment10.model;

import java.util.ArrayList;
import java.io.Serializable;

public class SinhVien implements Serializable{
	private String maSv,tenSv,lopSv,tuoiSv;
	public SinhVien() {
		
	}
	public SinhVien(String maSv,String tenSv,String tuoiSv,String lopSv) {
		this.maSv=maSv;
		this.tenSv=tenSv;
		this.tuoiSv=tuoiSv;
		this.lopSv=lopSv;
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
	public String getLopSv() {
		return lopSv;
	}
	public void setLopSv(String lopSv) {
		this.lopSv = lopSv;
	}
	public String getTuoiSv() {
		return tuoiSv;
	}
	public void setTuoiSv(String tuoiSv) {
		this.tuoiSv = tuoiSv;
	}	
	
}
