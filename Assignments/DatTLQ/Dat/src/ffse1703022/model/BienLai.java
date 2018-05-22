package ffse1703022.model;



public class BienLai extends KhachHang {
	public float chiSoCu,chiSoMoi;
	public int tienDien;
	public String maCT,ngayNhap,chuKy;
	
	public BienLai() {
		super();
	}
	
	
	public BienLai(String maCT, String ngayNhap, String chuKy,float chiSoCu, float chiSoMoi,int tienDien) {
		super();
		this.maCT = maCT;
		this.chiSoCu = chiSoCu;
		this.chiSoMoi = chiSoMoi;
		this.ngayNhap = ngayNhap;
		this.chuKy = chuKy;
		this.tienDien = tienDien;

	}

	public int getTienDien() {
		return tienDien;
	}


	public void setTienDien(int tienDien) {
		this.tienDien = tienDien;
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
