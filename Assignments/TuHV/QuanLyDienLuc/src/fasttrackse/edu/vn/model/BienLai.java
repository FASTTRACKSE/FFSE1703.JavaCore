package fasttrackse.edu.vn.model;

public class BienLai extends KhachHang {
	private int chiSoMoi;
	private int chiSoCu;
	private int Thang;
	private int Nam;

	public int getThang() {
		return Thang;
	}

	public void setThang(int thang) {
		Thang = thang;
	}

	public int getNam() {
		return Nam;
	}

	public void setNam(int nam) {
		Nam = nam;
	}

	public double getchiSoMoi() {
		return chiSoMoi;
	}

	public void setchiSoMoi(int chiSoMoi) {
		this.chiSoMoi = chiSoMoi;
	}

	public double getchiSoCu() {
		return chiSoCu;
	}

	public void setchiSoCu(int chiSoCu) {
		this.chiSoCu = chiSoCu;
	}

	public BienLai(String MsKhachHang, String TenKhachHang, String DiaChi, int MsCongto, int chiSoMoi, int chiSoCu,
			int Thang, int Nam) {
		super(MsKhachHang, TenKhachHang, DiaChi, MsCongto);
		this.chiSoMoi = chiSoMoi;
		this.chiSoCu = chiSoCu;
		this.Thang = Thang;
		this.Nam = Nam;
	}

	public int gettienDien() {
		return ((chiSoMoi - chiSoCu) * 3000);
	}

}
