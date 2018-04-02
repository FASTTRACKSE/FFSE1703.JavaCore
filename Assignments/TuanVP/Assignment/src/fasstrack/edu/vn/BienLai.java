package fasstrack.edu.vn;

public class BienLai extends KhachHang {
	
	private int chiSoCu;
	private int chiSoMoi;
	private String thang;
	private String nam;
	
	public BienLai() {
		super();
	}
	public BienLai(String maKH,String tenKH,String diaChiKH,String maCT, int chiSoCu,int chiSoMoi, String thang,String nam) {
		super(maKH,tenKH,diaChiKH,maCT);
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
	public String getThang() {
		return thang;
	}
	public void setThang(String thang) {
			this.thang = thang;
	}
	public String getNam() {
		return nam;
	}
	public void setNam(String nam) {
			this.nam = nam;
	}
	public int tinhTienDien() {
		return (this.chiSoMoi - this.chiSoCu)*3000;
	}
}
