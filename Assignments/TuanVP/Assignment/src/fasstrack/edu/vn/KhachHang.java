package fasstrack.edu.vn;

public class KhachHang {
	public String maKH;
	public String tenKH;
	public String diaChiKH;
	public String maCT;
	
	public KhachHang(String maKH,String tenKH,String diaChiKH,String maCT) {
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.diaChiKH = diaChiKH;
		this.maCT = maCT;
	}
	
	public KhachHang() {
		// TODO Auto-generated constructor stub
	}


	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public String getDiaChiKH() {
		return diaChiKH;
	}
	public void setDiaChiKH(String diaChiKH) {
		this.diaChiKH = diaChiKH;
	}
	public String getMaCT() {
		return maCT;
	}
	public void setMaCT(String maCT) {
		this.maCT = maCT;
	}
}
