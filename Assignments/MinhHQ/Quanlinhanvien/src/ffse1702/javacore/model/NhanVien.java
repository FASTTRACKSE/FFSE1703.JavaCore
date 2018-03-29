package ffse1702.javacore.model;

public class NhanVien {
	
	public String MasoNV;
	public String TenNV;
	public String NS;
	public double Luong;

	public NhanVien(String MasoNV, String TenNV,String NS, double Luong ) {
		this.MasoNV = MasoNV;
		this.TenNV = TenNV;
		this.NS = NS;
		this.Luong = Luong*1000000;
	}
	
	public String getMS() {
		return this.MasoNV;
	}
	
	public String getTen() {
		return this.TenNV;
	}
	
	public String getNS() {
		return this.NS;
	}
	
	public double getLuong() {
		return this.Luong;
	}
	
	public double tinhThueThuNhap() {
		if (this.Luong >5000000) {
		return((this.Luong - 5000000)*0.1);
		}
		return 0;
	}
}
