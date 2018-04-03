package ffse1703.javacore.oop2.model;
 
public class BienLai extends KhachHang {
	private int Thang;
	private int Nam;
	private double ChiSoCu;
	private double ChiSoMoi;
	public BienLai() {
		super();
	}
	public  BienLai(String MaSoKH, String TenKH, String DiaChi, String MaCongTo, double ChiSoCu,double ChiSoMoi,int Thang, int Nam) {
		super(MaSoKH,TenKH,DiaChi,MaCongTo);
		this.Thang = Thang;
		this.Nam = Nam;
		this.ChiSoCu = ChiSoCu;
		this.ChiSoMoi = ChiSoMoi;
	}
	public int getThang() {
		return Thang;
	}
	public void setThang(int Thang) {
		this.Thang = Thang;
	}
	public int getNam() {
		return Nam;
	}
	public void setNam(int Nam) {
		this.Nam = Nam;
	}
	public double getChiSoCu() {
		return ChiSoCu;
	}
	public void setChiSoCu(double ChiSoCu) {
		this.ChiSoCu = ChiSoCu;
	}
	public double getChiSoMoi() {
		return ChiSoMoi;
	}
	public void setChiSoMoi(double ChiSoMoi) {
		this.ChiSoMoi = ChiSoMoi;
	}
	public double getTienDien() {
		return (ChiSoMoi-ChiSoCu)*3000;
	}
	

}
