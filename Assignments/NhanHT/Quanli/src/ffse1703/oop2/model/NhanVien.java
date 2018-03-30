package ffse1703.oop2.model;

public class NhanVien {
	public String MasoNV ;
	public String TenNV;
	public String NgaySinh;
	public double Luong;

	public NhanVien() {
		//
	}
	//
	public NhanVien(String MasoNV,String TenNV, String NgaySinh,double Luong) {
		this.MasoNV = MasoNV;
		this.TenNV = TenNV;
		this.NgaySinh = NgaySinh;
		this.Luong = Luong;
	}
	//
	public void setMasoNV(String MasoNV) {
		this.MasoNV = MasoNV;
	}
	public String getMasoNV() {
		return this.MasoNV;
	}
	//
	public void setTenNV(String TenNV) {
		this.TenNV = TenNV;
	}
	public String getTenNV() {
		return this.TenNV;
	}
	//
	public void setNamSinh(String NgaySinh) {
		this.NgaySinh = NgaySinh;
	}
	public String getNamSinh() {
		return this.NgaySinh;
	}
	//
	public void setLuong(double Luong) {
		this.Luong = Luong;
	}
	public double getLuong() {
		return this.Luong;
	}
	public double tinhluong() {
		return this.Luong * 1000000;
	}
	public double getThueThuNhap() {
	 if((this.Luong < 5000000)) {
			return	0.0;
	}else{
		 return ((this.Luong)- 5000000)*0.1;
	}
	}
}
