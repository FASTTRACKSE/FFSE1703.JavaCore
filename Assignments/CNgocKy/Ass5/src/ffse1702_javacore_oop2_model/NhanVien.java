package ffse1702_javacore_oop2_model;
import java.util.Scanner;
public class NhanVien {
public  String maSo ;
public String tenNV;
public String ngaySinh;
public int luong;

public NhanVien(String maSo, String tenNV, String ngaySinh, int luong) {
	super();
	this.maSo = maSo;
	this.tenNV = tenNV;
	this.ngaySinh = ngaySinh;
	this.luong = luong;
}
public String getMaSo() {
	return maSo;
}
public void setMaSo(String maSo) {
	this.maSo = maSo;
}
public String getTenNV() {
	return tenNV;
}
public void setTenNV(String tenNV) {
	this.tenNV = tenNV;
}
public String getNgaySinh() {
	return ngaySinh;
}
public void setNgaySinh(String ngaySinh) {
	this.ngaySinh = ngaySinh;
}
public int getLuong() {
	return luong;
}
public void setLuong(int luong) {
	this.luong = luong;
}
public double getthueLTN() {
return((getLuong() - 5000000) * 0.1);
}


}
