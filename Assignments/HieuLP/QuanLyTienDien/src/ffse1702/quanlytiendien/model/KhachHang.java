package ffse1702.quanlytiendien.model;

public class KhachHang {

	public String masoKhachhang;
	public String tenKhachhang;
	public String diaChi;
	public String maCongto;

	public KhachHang(String masoKhachhang, String tenKhachhang, String diaChi, String maCongto) {
		this.masoKhachhang = masoKhachhang;
		this.tenKhachhang = tenKhachhang;
		this.diaChi = diaChi;
		this.maCongto = maCongto;
	}

	public KhachHang() {

	}

	public String getMasoKhachhang() {
		return masoKhachhang;
	}

	public void setMasoKhachhang(String masoKhachhang) {
		this.masoKhachhang = masoKhachhang;
	}

	public String getTenKhachhang() {
		return tenKhachhang;
	}

	public void setTenKhachhang(String tenKhachhang) {
		this.tenKhachhang = tenKhachhang;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getMaCongto() {
		return maCongto;
	}

	public void setMaCongto(String maCongto) {
		this.maCongto = maCongto;
	}

}
