package ffse1702.edu.vn.model;

public class KhachHang {
	public String makhachhang;
	public String tenkhachhang;
	public String diachi;
	public Double macongto;
	public KhachHang() {
		
	}
	public KhachHang(String makhachhang , String tenkhachhang,String diachi, Double macongto) {
		this.makhachhang=makhachhang;
		this.tenkhachhang=tenkhachhang;
		this.diachi=diachi;
		this.macongto=macongto;
		
	}
	public String getMakhachhang() {
		return makhachhang;
	}
	public void setMakhachhang(String makhachhang) {
		this.makhachhang = makhachhang;
	}
	public String getTenkhachhang() {
		return tenkhachhang;
	}
	public void setTenkhachhang(String tenkhachhang) {
		this.tenkhachhang = tenkhachhang;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public Double getMacongto() {
		return macongto;
	}
	public void setMacongto(Double macongto) {
		this.macongto = macongto;
	}

}
