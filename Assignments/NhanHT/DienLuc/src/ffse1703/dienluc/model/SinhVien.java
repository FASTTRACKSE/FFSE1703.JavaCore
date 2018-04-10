package ffse1703.dienluc.model;

public class SinhVien {
	public String MasoKH ;
	public String TenKH;
	public String DiaChiKH;
	public double MaCongTo;
	//
	public SinhVien() {
		
	}
	public SinhVien(String MasoKH,String TenKH,String DiaChiKH,double MaCongTo) {
		this.MasoKH = MasoKH;
		this.TenKH = TenKH;
		this.DiaChiKH = DiaChiKH;
		this.MaCongTo = MaCongTo;
	}
	public void setMasoKH(String MasoKH) {
		this.MasoKH = MasoKH;
	}
	public String getMasoKH() {
		return this.MasoKH;
	}
	//
	public void setTenKH(String TenKH) {
		this.TenKH = TenKH;
	}
	public String getTenKH() {
		return this.TenKH;
	}
	//
	public void setDiaChiKH(String DiaChiKH) {
		this.DiaChiKH = DiaChiKH;
	}
	public String getDiaChiKH() {
		return this.DiaChiKH;
	}
	//
	public void setMaCongTo(double MaCongTo) {
		this.MaCongTo = MaCongTo;
	}
	public double getMaCongTo() {
		return this.MaCongTo;
	}
}
