package ffse1703.dienluc.model;

public class BienLai extends KhachHang {
	public int ChiSoCu;
	public int ChiSoMoi;
	public String NgayThang;
	//
	public BienLai() {
		super();
	}
	//
	public BienLai(String MasoKH,String TenKH,String DiaChiKH,double MaCongTo,int ChiSoCu,int ChiSoMoi,String NgayThang) {
		super(MasoKH,TenKH,DiaChiKH,MaCongTo);
		this.ChiSoCu = ChiSoCu;
		this.ChiSoMoi = ChiSoMoi;
		this.NgayThang = NgayThang;
	}
	//
	public void setChiSoCu(int ChiSoCu) {
		this.ChiSoCu = ChiSoCu;
	}
	public int getChiSoCu() {
		return ChiSoCu;
	}
	//
	public void setNgayThang(String NgayThang) {
		this.NgayThang = NgayThang;
	}
	public String getNgayThang() {
		return NgayThang;
	}
	//
	public void setChiSoMoi(int ChiSoMoi) {
		this.ChiSoMoi = ChiSoMoi;
	}
	public int getChiSoMoi() {
		return ChiSoMoi;
	}
	//
	public int getTongTien() {
		return ((this.ChiSoMoi - this.ChiSoCu)*3000);
	}
}
