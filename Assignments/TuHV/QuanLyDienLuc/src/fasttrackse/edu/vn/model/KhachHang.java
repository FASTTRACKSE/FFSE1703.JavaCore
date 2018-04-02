package fasttrackse.edu.vn.model;

public class KhachHang {
	public String MsKhachHang;
	public String TenKhachHang;
	public String DiaChi;
	public int MsCongTo;
	
	
	
	public KhachHang(String MsKhachHang, String TenKhachHang, String DiaChi, int MsCongTo) {
	this.MsKhachHang =  MsKhachHang;
	this.TenKhachHang = TenKhachHang;
	this.DiaChi = DiaChi;
	this.MsCongTo = MsCongTo;

	}
	


	public String getMsKhachHang() {
		return MsKhachHang;
	}

	public void setMsKhachHang(String msKhachHang) {
		MsKhachHang = msKhachHang;
	}

	public String getTenKhachHang() {
		return TenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		TenKhachHang = tenKhachHang;
	}

	public String getDiaChi() {
		return DiaChi;
	}

	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}

	public int getMsCongTo() {
		return MsCongTo;
	}

	public void setMsCongto(int msCongTo) {
		MsCongTo = msCongTo;
	}
	
}
