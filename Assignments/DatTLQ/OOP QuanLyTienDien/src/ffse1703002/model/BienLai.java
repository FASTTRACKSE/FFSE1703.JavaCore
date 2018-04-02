package ffse1703002.model;

public class BienLai extends KhachHang {
	public float chiSoCu,chiSoMoi;
	public String Date;
	public BienLai() {
		super();
	}
	public BienLai(KhachHang kh,float chiSoCu,float chiSoMoi,String Date) {
		super();
		this.chiSoCu=chiSoCu;
		this.chiSoMoi=chiSoMoi;
		this.Date=Date;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
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
}
