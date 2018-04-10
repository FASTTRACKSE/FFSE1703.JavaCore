package ffse1703.dienluc.model;

public class BienLai extends SinhVien {
	public int ChiSoCu;
	public int ChiSoMoi;
	public String NgayThang;
	public int ThangChuKy;
	public int NamChuKy;
	//
	public BienLai() {
		super();
	}
	//
	public BienLai(String MasoKH,String TenKH,String DiaChiKH,double MaCongTo,
					int ChiSoCu,int ChiSoMoi,String NgayThang,int ThangChuKy,int NamChuKy) {
		//
		super(MasoKH,TenKH,DiaChiKH,MaCongTo);
		this.ChiSoCu = ChiSoCu;
		this.ChiSoMoi = ChiSoMoi;
		this.NgayThang = NgayThang;
		this.ThangChuKy = ThangChuKy;
		this.NamChuKy = NamChuKy;
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
	public void setThangChuKy(int ThangChuKy) {
		this.ThangChuKy = ThangChuKy;
	}
	public int getThangChuKy() {
		return ThangChuKy;
	}
	//
	public void setNamChuKy(int NamChuKy) {
		this.NamChuKy = NamChuKy;
	}
	public int getNamChuKy() {
		return NamChuKy;
	}
	//
	public int getTongTien() {
		return ((this.ChiSoMoi - this.ChiSoCu)*3000);
	}
}
