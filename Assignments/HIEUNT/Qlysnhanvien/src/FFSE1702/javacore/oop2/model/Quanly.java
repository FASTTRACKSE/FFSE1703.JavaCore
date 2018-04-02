package FFSE1702.javacore.oop2.model;

public class Quanly extends Nhanvien {
	public Double luongg;
	public Quanly() {
		super();
	}
	public Quanly(int masonv,String tennv, String ngaysinh, Double luong, Double luonggg) {
		luongg=luonggg;
		
	}
	public Double getLuongg() {
		return luongg;
	}
	public void setLuongg(Double luongg) {
		this.luongg = luongg;
	}
	public double luong() {
		return (super.luong + this.luongg);
	}

	}



