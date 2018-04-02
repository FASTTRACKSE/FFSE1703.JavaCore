package ffse1703002.model;

public class BienLai extends KhachHang {
	public float chiSoCu,chiSoMoi;
	public String thangChuKy,namChuKy;
	
	public BienLai() {
		super();
	}
	public BienLai(String tenKH, String maKH, String diaChi, String maCongTo,float chiSoCu,float chiSoMoi,String thangChuKy, String namChuKy) {
		super(tenKH, maKH, diaChi, maCongTo);
		this.chiSoCu=chiSoCu;
		this.chiSoMoi=chiSoMoi;
		this.thangChuKy=thangChuKy;
		this.namChuKy=namChuKy;
	}
	
	public String getThangChuKy() {
		return thangChuKy;
	}
	public void setThangChuKy(String thangChuKy) {
		this.thangChuKy = thangChuKy;
	}
	public String getNamChuKy() {
		return namChuKy;
	}
	public void setNamChuKy(String namChuKy) {
		this.namChuKy = namChuKy;
	}
	
	public float tienDien() {
		return(this.chiSoMoi-this.chiSoCu)*3000;
	}
	public float getChiSoCu() {
		return chiSoCu;
	}
	public void setChiSoCu(float chiSoCu) {
		this.chiSoCu = chiSoCu;
	}
	public float getChiSoMoi() {
		return chiSoMoi;
	}
	public void setChiSoMoi(float chiSoMoi) {
		this.chiSoMoi = chiSoMoi;
	}
	public String toString() {
		return String.format("| %-20s | %-20s | %-15s | %-15s | %-15s | %-15s | %-15s | %-10s |%-10s |",
				this.getTenKH(), this.getDiaChi(), this.getMaKH(),
				this.getMaCongTo(),this.getChiSoCu(), this.getChiSoMoi(),
				this.getThangChuKy(),this.getNamChuKy(), this.tienDien());
	}
}
