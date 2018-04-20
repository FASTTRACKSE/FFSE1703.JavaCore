package fasttrack.edu.vn.ass11.model;

import java.io.Serializable;

public class SinhVien implements Serializable {
 private String maSV, tenSV, lopSV, tuoiSV;
 public SinhVien(){
	 
 }
 public SinhVien(String maSV, String tenSV, String tuoiSV, String lopSV) {
	 this.maSV = maSV;
	 this.tenSV =tenSV;
	 this.lopSV = lopSV;
	 this.tuoiSV = tuoiSV;
 }
public String getMaSV() {
	return maSV;
}
public void setMaSV(String maSV) {
	this.maSV = maSV;
}
public String getTenSV() {
	return tenSV;
}
public void setTenSV(String tenSV) {
	this.tenSV = tenSV;
}
public String getLopSV() {
	return lopSV;
}
public void setLopSV(String lopSV) {
	this.lopSV = lopSV;
}
public String getTuoiSV() {
	return tuoiSV;
}
public void setTuoiSV(String tuoiSV) {
	this.tuoiSV = tuoiSV;
}
 
 
 
 
 }
