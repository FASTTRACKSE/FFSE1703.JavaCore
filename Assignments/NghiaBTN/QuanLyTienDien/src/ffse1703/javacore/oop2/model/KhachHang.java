package ffse1703.javacore.oop2.model;

public class KhachHang {
	public String MaSoKH;
	public String TenKH;
	public String DiaChi;
	public String MaCongTo;
	public KhachHang() {
		
	}
	public KhachHang(String MaSoKH, String TenKH, String DiaChi, String MaCongTo) {
		this.MaSoKH = MaSoKH;
		this.TenKH = TenKH;
		this.DiaChi = DiaChi;
		this.MaCongTo = MaCongTo;
		}
	public String getMaSoKH() {
		return MaSoKH;
	}
	public void setMaSoKH(String MaSoKH) {
		this.MaSoKH = MaSoKH;
	}
	public String getTenKH() {
		return TenKH;
	}
	public void setTenKH(String TenKH) {
		this.TenKH = TenKH;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String DiaChi) {
		this.DiaChi = DiaChi;
	}
	public String getMaCongTo() {
		return MaCongTo;
	}
	public void setMaCongTo(String MaCongTo) {
		this.MaCongTo = MaCongTo;
	}
}
