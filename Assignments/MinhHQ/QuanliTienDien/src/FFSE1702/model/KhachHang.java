package FFSE1702.model;

public class KhachHang {

	public String MasoKH;
	public String TenKH;
	public String Address;
	public String MasoCT;
	public int soluongKH;
	
	
	public KhachHang() {
		
	}
	
	public KhachHang (String KH, String name, String address, String ct) {
		this.MasoKH = KH;
		this.TenKH = name;
		this.Address = address;
		this.MasoCT = ct;
	}
	
	public int getSoluongKH() {
		return soluongKH;
	}
	
	public void setSoluongKH(int soluongKH) {
		this.soluongKH = soluongKH;
	}
	
	
	public String getMasoKH() {
		return MasoKH;
	}
	
	public void setMasoKH(String masoKH) {
		MasoKH = masoKH;
	}
	
	public String getTenKH() {
		return TenKH;
	}
	
	public void setTenKH(String tenKH) {
		TenKH = tenKH;
	}
	
	public String getAddress() {
		return Address;
	}
	
	public void setAddress(String address) {
		Address = address;
	}
	
	public String getMasoCT() {
		return MasoCT;
	}
	
	public void setMasoCT(String masoCT) {
		MasoCT = masoCT;
	}
}
