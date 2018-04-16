package assignment10.java.modle;

import java.io.Serializable;

public class ModleSinhVien implements Serializable{
 private String maSV,nameSv;
 private String age,lopSV;
 
 public ModleSinhVien() {
	 
 }
 public ModleSinhVien(String maSV,String nameSv,String age,String lopSV) {
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
