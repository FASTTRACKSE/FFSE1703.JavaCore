package ffse1702.Javacore.oop2.model;

public class NhanVien {

	public String MasoNV;
	public String TenNV;
	public String Date;
	public double Luong;

	public NhanVien(String MasoSV, String TenNV, String Date, double Luong) {
		this.MasoNV = MasoSV;
		this.TenNV = TenNV;
		this.Date = Date;
		this.Luong = Luong;
	}

	public NhanVien() {

	}

	public void setMasoNV(int masoNV) {
		this.MasoNV = MasoNV;
	}

	public String getMasoNV() {
		return this.MasoNV;
	}

	public void setTenNV(String TenSV) {
		this.TenNV = TenNV;
	}

	public String getTenNV() {
		return this.TenNV;
	}

	public void setDate(String Date) {
		this.Date = Date;
	}

	public String getDate() {
		return this.Date;
	}

	
	public double getLuong() {
		return this.Luong *1000000;
	}

	public double thueThunhap() {
		if (this.getLuong() > 5000000) {
			return ((getLuong() - 5000000) * 0.1);
		} else {
			return (0.0);
		}
	}

}
