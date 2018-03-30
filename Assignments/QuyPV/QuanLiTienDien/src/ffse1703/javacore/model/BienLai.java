package ffse1703.javacore.model;

public class BienLai extends KhachHang {
	private int chiSoCu, ChiSoMoi;
	
	public BienLai() {
		super();
	}
	
	public BienLai(String maKhachHang, String tenKhachHang, String diaChi, int maCongTo, int chiSoCu, int ChiSoMoi) {
		super(maKhachHang, tenKhachHang, diaChi, maCongTo);
		this.chiSoCu = chiSoCu;
		this.ChiSoMoi = ChiSoMoi;
		
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
		ChiSoMoi = chiSoMoi;
	}
	
	public double soTienTra() {
		return (this.ChiSoMoi - this.chiSoCu) * 3000;
	}
}
