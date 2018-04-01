package ffse1702.quanlytiendien.model;

public class BienLai extends KhachHang {
	private int chisoCu;
	private int chisoMoi;

	public BienLai(String masoKhachhang, String tenKhachhang, String diaChi, String maCongto, int chisoCu,
			int chisoMoi) {
		super(masoKhachhang, tenKhachhang, diaChi, maCongto);
		this.chisoCu = chisoCu;
		this.chisoMoi = chisoMoi;
		// TODO Auto-generated constructor stub
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
