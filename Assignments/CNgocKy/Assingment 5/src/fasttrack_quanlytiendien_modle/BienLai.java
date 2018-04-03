package fasttrack_quanlytiendien_modle;

public class BienLai extends KhachHang {
	public int chiSoCu, chiSoMoi, thang, nam;
	
	public BienLai() {
		super();
	}
	public BienLai(int maKH, String tenKH, String diaChi, int maCongTo, int chiSoCu, int chiSoMoi ,int thang, int nam) {
		super(maKH, tenKH, diaChi, maCongTo);
		this.chiSoCu = chiSoCu;
		this.chiSoMoi = chiSoMoi;
		this.thang = thang;
		this.nam = nam;
	}
	

	public BienLai(BienLai bl, int chiSoCu, int chiSoMoi, int thanhToan, int thang, int nam) {
		this.chiSoCu = chiSoCu;
		this.chiSoMoi = chiSoMoi;
		this.thang = thang;
		this.nam = nam;
	}
	public int getChiSoCu() {
		return chiSoCu;
	}

	public void setChiSoCu(int chiSoCu) {
		this.chiSoCu = chiSoCu;
	}

	public int getChiSoMoi() {
		return chiSoMoi;
	}

	public void setChiSoMoi(int chiSoMoi) {
		this.chiSoMoi = chiSoMoi;
	}


	public int tinhTien() {
		return ((this.chiSoMoi - this.chiSoCu) * 3000);
	}

}
