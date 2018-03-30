package fasttrackse.edu.vn.quanlynhanvien;

public class NhanVien {
	public String MasoNV;
	public String TenNV;
	public String NgaySinhNV;
	public double LuongNV;

	
	public NhanVien(String MasoNV, String TenNV, String NgaySinhNV, double LuongNV) {
		this.MasoNV = MasoNV;
		this.TenNV = TenNV;
		this.NgaySinhNV = NgaySinhNV;
		this.LuongNV = LuongNV;
	}
	


	public String getMasoNV() {
		return MasoNV;
	}


	public void setMasoNV(String masoNV) {
		MasoNV = masoNV;
	}


	public String getTenNV() {
		return TenNV;
	}


	public void setTenNV(String tenNV) {
		TenNV = tenNV;
	}


	public String getNgaySinhNV() {
		return NgaySinhNV;
	}


	public void setNgaySinhNV(String ngaySinhNV) {
		NgaySinhNV = ngaySinhNV;
	}


	public double getLuongNV() {
		return LuongNV;
	}


	public void setLuongNV(double luongNV) {
		LuongNV = luongNV;
	}
	public double tinhluong() {
		return this.LuongNV * 1000000;
	}
	public double getTinhThueThuNhap() {
		return((double) (this.LuongNV - 5000000)*0.1);
	}

}
