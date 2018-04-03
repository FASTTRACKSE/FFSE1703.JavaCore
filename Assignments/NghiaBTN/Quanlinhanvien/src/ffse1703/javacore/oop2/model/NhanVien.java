package ffse1703.javacore.oop2.model;

public class NhanVien {
	public String MasoNV;
	public String TenNV; 
	public String NamSinh;
	public double Luong;
	
	public NhanVien(String MasoNV, String TenNV, String NamSinh, double Luong) {
		this.MasoNV = MasoNV;
		this.TenNV = TenNV;
		this.NamSinh = NamSinh;
		this.Luong = Luong;
		}
	public void setMasoNV(String MasoNV) {
		this.MasoNV = MasoNV;
	}

	public String getMasoNV() {
		return this.MasoNV;
	}

	public void setTenNV(String name) {
		this.TenNV = name;
	}

	public String getTenNV() {
		return this.TenNV;
	}

	public void setNamSinh(String NamSinh) {
		this.NamSinh = NamSinh;
	}

	public String getNamSinh() {
		return this.NamSinh;
	}

	public void setLuong(double Luong) {
		this.Luong = Luong;
	}

	public double getLuong() {
		return this.Luong;
	}
	public double ThueThuNhap() {
		return ((this.Luong - 5000000)*0.1);
	}
	
	public void HienThi() {
		System.out.print(this.MasoNV);
	}
	@Override
	public String toString() {
		return "NhanVien [MasoNV=" + MasoNV + ", TenNV=" + TenNV + ", NamSinh=" + NamSinh + ", Luong=" + Luong + "]";
	}
}
