package asm5.model;


public class KhachHang {
	private String maK;
	private String tenK;
	private String diaChi;
	private String maCto;
	
	public KhachHang() {
		
	}
	
	public KhachHang(String maK,String tenK,String diaChi,String maCto ) {
		this.maK = maK;
		this.tenK=tenK;
		this.diaChi=diaChi;
		this.maCto=maCto;
	}
	
	public String getMaK() {
		return maK;
	}

	public void setMaK(String maK) {
		this.maK = maK;
	}

	public String getTenK() {
		return tenK;
	}

	public void setTenK(String tenK) {
		this.tenK = tenK;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getMaCto() {
		return maCto;
	}

	public void setMaCto(String maCto) {
		this.maCto = maCto;
	}
	
}
