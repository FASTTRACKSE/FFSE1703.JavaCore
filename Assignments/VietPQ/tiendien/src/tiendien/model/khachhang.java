package tiendien.model;

import java.util.Scanner;

public class khachhang {
	private String makhachhang;
	private String tenkhachhang;
	private String soNha;
	private String maCongTo;
    
	public khachhang() {
	}

	public khachhang(String makhachhang, String tenkhachhang, String soNha, String maCongTo) {
		this.makhachhang = makhachhang;
		this.tenkhachhang = tenkhachhang;
		this.soNha = soNha;
		this.maCongTo = maCongTo;
	}

	public String getmakhachhang() {
		return makhachhang;
	}

	public void setmakhachhang(String makhachhang) {
		this.makhachhang = makhachhang;
	}

	public String gettenkhachhang() {
		return tenkhachhang;
	}

	public void settenkhachhang(String tenkhachhang) {
		this.tenkhachhang = tenkhachhang;
	}

	public String getSoNha() {
		return soNha;
	}

	public void setSoNha(String soNha) {
		this.soNha = soNha;
	}

	public String getMaCongTo() {
		return maCongTo;
	}

	public void setMaCongTo(String maCongTo) {
		this.maCongTo = maCongTo;
	}

}