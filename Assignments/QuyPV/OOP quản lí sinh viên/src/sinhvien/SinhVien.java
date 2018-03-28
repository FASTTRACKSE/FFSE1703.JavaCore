package sinhvien;

public class SinhVien {
	public String hoTen;
	public String ngaySinh;
	public double diemLp1, diemLp2, diemTB;
	
	public String getHoTen() {
		return this.hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	
	public String getNgaySinh() {
		return this.ngaySinh;
	}
	public void setNgaySinh( String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	
	public double getDiemLp1() {
		return this.diemLp1;
	}
	public void setDiemLp1(double diemLp1) {
		this.diemLp1 = diemLp1;
	}
	
	public double getDiemLp2() {
		return this.diemLp2;
	}
	public void setDiemLp2(double diemLp2) {
		this.diemLp2 = diemLp2;
	}
	
	public double getDiemTB() {
		return this.diemTB = (this.diemLp1 + this.diemLp2)/2;
	}
		
		
	}
