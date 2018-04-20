package assignment11.java.model;

import java.io.Serializable;

public class SinhVien implements Serializable{
 private String maSV,nameSv;
 private String age,lopSV;
 
 public SinhVien() {
	 
 }
 public SinhVien(String maSV,String nameSv,String age,String lopSV) {
	 this.maSV = maSV;
	 this.nameSv = nameSv;
	 this.age= age;
	 this.lopSV= lopSV;
 }
public String getLopSV() {
	return lopSV;
}
public void setLopSV(String lopSV) {
	this.lopSV = lopSV;
}
public String getMaSV() {
	return maSV;
}
public void setMaSV(String maSV) {
	this.maSV = maSV;
}
public String getNameSV() {
	return nameSv;
}
public void setNameSv(String nameSv) {
	this.nameSv = nameSv;
}
public String getAge() {
	return age;
}
public void setAge(String age) {
	this.age = age;
}
 
}
