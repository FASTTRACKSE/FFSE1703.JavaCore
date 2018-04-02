package FFSE1702.model;

public class Bienlai extends KhachHang {

	public int ChisoDauKy;
	public int ChisoCuoiKy;
	public int Thang;
	public int Nam;
	
	public Bienlai () {
		
	}
	public Bienlai (String KH, String name, String address, String ct, int ago, int after, int thang, int nam) {
		super(KH,name,address,ct);
		this.Thang = thang;
		this.Nam = nam;
		this.ChisoDauKy = ago;
		this.ChisoCuoiKy = after;
	}
	
	public Bienlai (KhachHang kh, int ago, int after, int thang, int nam) {
		super(kh.getMasoKH(),kh.getTenKH(),kh.getAddress(),kh.getMasoCT());
		this.Thang = thang;
		this.Nam = nam;
		this.ChisoDauKy = ago;
		this.ChisoCuoiKy = after;
	}
	
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
	public int getChisoDauKy() {
		return ChisoDauKy;
	}
	public void setChisoDauKy(int ChisoDauKy) {
		ChisoDauKy = ChisoDauKy;
	}
	public int getChisoCuoiKy() {
		return ChisoCuoiKy;
	}
	public void setChisoCuoiKy(int ChisoCuoiKy) {
		ChisoCuoiKy = ChisoCuoiKy;
	}
	
	
	public int tienDien() {
		return (this.ChisoCuoiKy - this.ChisoDauKy)*3000;
	}
	
}
