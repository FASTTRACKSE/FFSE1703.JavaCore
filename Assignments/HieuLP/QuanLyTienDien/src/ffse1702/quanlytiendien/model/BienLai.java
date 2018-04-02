package ffse1702.quanlytiendien.model;

public class BienLai extends KhachHang {
	private int chisoCu;
	private int chisoMoi;
	private int ngayThang;
	private int nam;

	public BienLai(String masoKhachhang, String tenKhachhang, String diaChi, String maCongto, int chisoCu, int chisoMoi,
			int ngayThang, int nam) {
		super(masoKhachhang, tenKhachhang, diaChi, maCongto);
		this.chisoCu = chisoCu;
		this.chisoMoi = chisoMoi;
		this.ngayThang = ngayThang;
		this.nam = nam;
		// TODO Auto-generated constructor stub
	}

	public int getngayThang() {
		return ngayThang;
	}

	public void setngayThangnam(int ngayThang) {
		this.ngayThang = ngayThang;
	}

	public int getnam() {
		return nam;
	}

	public void setnam(int nam) {
		this.nam = nam;
	}

	public BienLai() {
		super();
	}

	public int getChisoCu() {
		return chisoCu;
	}

	public void setChisoCu(int chisoCu) {
		this.chisoCu = chisoCu;
	}

	public int getChisoMoi() {
		return chisoMoi;
	}

	public void setChisoMoi(int chisoMoi) {
		this.chisoMoi = chisoMoi;
	}

	public int getTienDien() {
		return (chisoMoi - chisoCu) * 3000;
	}

}
