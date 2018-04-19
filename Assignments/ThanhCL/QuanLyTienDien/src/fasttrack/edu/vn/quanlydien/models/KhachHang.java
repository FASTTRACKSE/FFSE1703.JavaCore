package fasttrack.edu.vn.quanlydien.models;

public class KhachHang {
	private String maKhachHang;
	private String tenKhachHang;
	private String dcKhachHang;
	private String maCongToDien;
	
	public KhachHang() {
		//
	}

	public KhachHang(String maKhachHang, String tenKhachHang, String dcKhachHang, String maCongToDien) {
		this.maKhachHang = maKhachHang;
		this.tenKhachHang = tenKhachHang;
		this.dcKhachHang = dcKhachHang;
		this.maCongToDien = maCongToDien;
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

	public String getDcKhachHang() {
		return dcKhachHang;
	}

	public void setDcKhachHang(String dcKhachHang) {
		this.dcKhachHang = dcKhachHang;
	}

	public String getMaCongToDien() {
		return maCongToDien;
	}

	public void setMaCongToDien(String maCongToDien) {
		this.maCongToDien = maCongToDien;
	}

}
