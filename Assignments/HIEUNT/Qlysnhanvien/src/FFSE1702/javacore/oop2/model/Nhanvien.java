package FFSE1702.javacore.oop2.model;

public class Nhanvien {
	public int masonv;
	public String tennv;
	public String ngaysinh;
	public Double luong;
	public Double thue;
    public Nhanvien() {}
	public Nhanvien(int masonvv, String tennvv, String ngaysinhv, Double luongv) {
		this.masonv =masonvv;
		this.tennv=tennvv;
		this.ngaysinh=ngaysinhv;
		this.luong=luongv;
	}

	public int getMasonv() {
		return masonv;
	}

	public void setMasonv(int masonv) {
		this.masonv = masonv;
	}

	public String getTennv() {
		return tennv;
	}

	public void setTennv(String tennv) {
		this.tennv = tennv;
	}

	public String getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public Double getLuong() {
		return luong;
	}

	public void setLuong(Double luong) {
		this.luong = luong;
	}

	public double thue() {
		return ((this.luong) - (5000000.0)) * 0.1;
	}
}
