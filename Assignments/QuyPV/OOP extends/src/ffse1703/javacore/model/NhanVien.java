package ffse1703.javacore.model;

public class NhanVien {
	private int maNhanVien;
	private String tenNhanVien, namSinh;
	private double hsluong, thue;
	
	public NhanVien() {
		//
	}
	
	public NhanVien(int maNhanVien, String tenNhanVien, String namSinh, double hsluong) {
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.namSinh = namSinh;
		this.hsluong = hsluong;
		
	}
	
	public int getMaNhanVien() {
		return this.maNhanVien;
	}
	public void setMaNhanVien(int maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	
	public String gettenNhanVien() {
		return this.tenNhanVien;
	}
	public void settenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}
	
	public String getNamSinh() {
		return this.namSinh;
	}
	public void setMaNhanVien(String namSinh) {
		this.namSinh = namSinh;
	}
	
	public double getHsLuong() {
		return this.hsluong;
	}
	public void setHsLuong(double hsluong) {
		this.hsluong = hsluong;
	}
	
	public double tinhLuong() {
		return this.hsluong * 1000000;
	}
	
	public double getThue() {
		if(tinhLuong() > 5000000) {
			return this.thue = (tinhLuong() - 5000000) * 0.1;
		}else {
			return 0.0;
			}
	}
	
	
	
}
