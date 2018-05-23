 	package ffse1703002.model;

public class BienLai extends KhachHang {
	public float chiSoCu,chiSoMoi;
	public String maCT,ngayNhap,chuKy;
	
	public BienLai() {
		super();
	}
	
	
	public BienLai(String maCT, String ngayNhap, String chuKy,float chiSoCu, float chiSoMoi) {
		super();
		this.maCT = maCT;
		this.chiSoCu = chiSoCu;
		this.chiSoMoi = chiSoMoi;
		this.ngayNhap = ngayNhap;
		this.chuKy = chuKy;
	}

	public String getMaCT() {
		return maCT;
	}


	public void setMaCT(String maCT) {
		this.maCT = maCT;
	}


	public String getNgayNhap() {
		return ngayNhap;
	}
	public void setNgayNhap(String ngayNhap) {
		this.ngayNhap = ngayNhap;
	}
	public String getChuKy() {
		return chuKy;
	}
	public void setChuKy(String chuKy) {
		this.chuKy = chuKy;
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
				this.getNgayNhap(),this.getChuKy(), this.tienDien());
	}
}
