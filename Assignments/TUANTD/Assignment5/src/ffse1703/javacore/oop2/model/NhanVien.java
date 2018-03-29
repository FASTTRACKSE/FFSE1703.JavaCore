package ffse1703.javacore.oop2.model;

public class NhanVien {
	private String msNhanVien;
	
	private String hoTenNV;
	private String ngaySinh;
	private double hsLuong;

	public String getMsNhanVien() {
		return msNhanVien;
	}

	public void setMsNhanVien(String msNhanVien) {
		this.msNhanVien = msNhanVien;
	}

	public String getHoTenNV() {
		return hoTenNV;
	}

	public void setHoTenNV(String hoTenNV) {
		this.hoTenNV = hoTenNV;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public double getHsLuong() {
		return hsLuong;
	}

	public void setHsLuong(double hsLuong) {
		this.hsLuong = hsLuong;
	}


	public NhanVien() {
		
	}
	
	public NhanVien(String msNhanVien, String hoTenNV, String ngaySinh, double hsLuong) {
		this.msNhanVien = msNhanVien;
		this.hoTenNV = hoTenNV;
		this.ngaySinh = ngaySinh;
		this.hsLuong = hsLuong;
	}
	
	public double tinhLuong() {
		return this.hsLuong * 1000000;
	}
	
	public double tinhThueThuNhap() {
		if (this.tinhLuong() > 5000000) {
			return (this.tinhLuong() - 5000000) * 0.1;
		}
		else {
			return 0.0;
		}
	}	

}
