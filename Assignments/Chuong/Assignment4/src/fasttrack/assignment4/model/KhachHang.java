package fasttrackse.fileiosample.model;

import java.io.Serializable;

public class KhachHang implements Serializable{
	private String ma;
	private String ten;
	public String getMa() {
		return ma;
	}
	public void setMa(String ma) {
		this.ma = ma;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public KhachHang(String ma, String ten) {
		super();
		this.ma = ma;
		this.ten = ten;
	}
	public KhachHang() {
		super();
	}
	public String toString() {
		return this.ma+"  "+this.ten;
	}
}
