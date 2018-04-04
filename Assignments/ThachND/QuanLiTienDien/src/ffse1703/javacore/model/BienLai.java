package ffse1703.javacore.model;

public class BienLai extends KhachHang {
	private int chiSoCu, ChiSoMoi;
	private String ngayThang, nam;

	public BienLai() {
		super();
	}

	public BienLai(String maKhachHang, String tenKhachHang, String diaChi, int maCongTo, int chiSoCu, int ChiSoMoi,
			String thang, String nam) {
		super(maKhachHang, tenKhachHang, diaChi, maCongTo);
		this.chiSoCu = chiSoCu;
		this.ChiSoMoi = ChiSoMoi;
		this.ngayThang = thang;
		this.nam = nam;

	}

	public int getChiSoCu() {
		return chiSoCu;
	}

	public void setChiSoCu(int chiSoCu) {
		this.chiSoCu = chiSoCu;
	}

	public int getChiSoMoi() {
		return ChiSoMoi;
	}

	public void setChiSoMoi(int chiSoMoi) {
		this.ChiSoMoi = chiSoMoi;
	}
	
	public String getNgayThang() {
		return ngayThang;
	}

	public void setNgayThang(String ngayThang) {
		this.ngayThang = ngayThang;
	}
	
	public String getNam() {
		return nam;
	}

	public void setNam(String nam) {
		this.nam = nam;
	}

	public double soTienTra() {
		return (this.ChiSoMoi - this.chiSoCu) * 3000;
	}
}