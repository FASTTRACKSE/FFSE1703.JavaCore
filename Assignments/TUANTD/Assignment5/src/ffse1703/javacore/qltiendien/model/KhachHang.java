package ffse1703.javacore.qltiendien.model;

import java.util.Scanner;

public class KhachHang {
	private String maKhachHang;
	private String tenKhachHang;
	private String soNha;
	private String maCongTo;
    
	public KhachHang() {
	}

	public KhachHang(String maKhachHang, String tenKhachHang, String soNha, String maCongTo) {
		this.maKhachHang = maKhachHang;
		this.tenKhachHang = tenKhachHang;
		this.soNha = soNha;
		this.maCongTo = maCongTo;
	}

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
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
