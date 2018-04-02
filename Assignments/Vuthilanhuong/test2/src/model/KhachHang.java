package model;

public class KhachHang {
	private String tenKhach;
	private String diaChi;
	private String sdt;
	private String maCto;
	
	public KhachHang() {
		
	}
	public KhachHang(String tenKhach,String diaChi,String sdt,String maCto) {
		this.tenKhach = tenKhach;
		this.diaChi = diaChi;
		this.sdt = sdt;
		this.maCto = maCto;
	}
	public String getTenKhach() {
		return tenKhach;
	}
	public void setTenKhach(String tenKhach) {
		this.tenKhach = tenKhach;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getMaCto() {
		return maCto;
	}
	public void setMaCto(String maCto) {
		this.maCto = maCto;
	}
	
}
