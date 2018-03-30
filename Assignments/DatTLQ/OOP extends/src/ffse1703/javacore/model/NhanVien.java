package ffse1703.javacore.model;

public class NhanVien {

	public NhanVien() {
		
	}
	private String maNhanVien;
	private	 String tenNhanVien;
	public String ngaySinh;
	public double luong;
	

	public NhanVien(String maNhanVien, String tenNhanVien, String ngaySinh, double luong) {
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.ngaySinh = ngaySinh;
		this.luong = luong;

	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}

	public String getTenNhanVien() {
		return tenNhanVien;
	}
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getNgaySinh(){
		return ngaySinh;
	}
	public double luong() {
		return luong;
	}

	public void setLuong(double luong) {
		this.luong = luong;
	}
	public double getThue() {
		if(this.luong>5000000) {
			return (this.luong-5000000)*0.1;
		}else {
			return 0.0;
		}
	}
}
