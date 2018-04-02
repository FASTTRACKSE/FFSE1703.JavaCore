package lFFSE1702.javacore.oop2.model;

public class nhanvien {
	public String masonv;
	public String tennv;
	public String ngaysinh;
	public double hsluong;
	
	
	public nhanvien(String masonv, String tennv,String ngaysinh, double hsluong ) {

		this.masonv =masonv;
		this.tennv =tennv;
		this.ngaysinh = ngaysinh;
		this.hsluong = hsluong;

}


	public String getMasonv() {
		return masonv;
	}


	public void setMasonv(String masonv) {
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


	public double getLuong() {
		return hsluong;
	}


	public void setLuong(double luong) {
		this.hsluong = hsluong;
	}
	public double luongnv() {
		return (this.hsluong*1000000);
	}

	public double thue() {
		return ((this.luongnv() - 5000000)*0.1);
	}
	
}