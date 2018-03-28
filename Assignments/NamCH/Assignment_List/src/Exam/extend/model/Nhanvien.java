package Exam.extend.model;

public class Nhanvien {
	private int maSoNv;
	private String tenNv;
	private String ngaySinh;
	private Double luong;
	public Nhanvien() {
		
	}
	public Nhanvien(int maSoNv,String tenNv,String ngaySinh,Double luong) {
		this.maSoNv=maSoNv;
		this.tenNv=tenNv;
		this.ngaySinh=ngaySinh;
		this.luong=luong;	
	}
	public int getMaSoNv() {
		return maSoNv;
	}
	public void setMaSoNv(int maSoNv) {
		this.maSoNv = maSoNv;
	}
	public String getTenNv() {
		return tenNv;
	}
	public void setTenNv(String tenNv) {
		this.tenNv = tenNv;
	}
	public String getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public Double getLuong() {
		return luong;
	}
	public void setLuong(Double luong) {
		this.luong = luong;
	}
	public Double getThue() {
		if (getLuong()>=5000000) {
			return ((getLuong()-5000000)*0.1);
		}else {
			return 0.0;
		}
	}
}
