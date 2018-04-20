package quanlytiendien.model;

public class KhachHang {
	private String tenKH;
	private String maKH;
	private String sctKH;
	private String diaChiKH;

public KhachHang(String tenKH,String maKH,String sctKH,String diaChiKH ) {
		this.tenKH=tenKH;
		this.maKH=maKH;
		this.sctKH=sctKH;
		this.diaChiKH=diaChiKH;
	
	}

public String getTenKH() {
	return tenKH;
}

public void setTenKH(String tenKH) {
	this.tenKH = tenKH;
}

public String getMaKH() {
	return maKH;
}

public void setMaKH(String maKH) {
	this.maKH = maKH;
}

public String getSctKH() {
	return sctKH;
}

public void setSctKH(String sctKH) {
	this.sctKH = sctKH;
}

public String getDiaChiKH() {
	return diaChiKH;
}

public void setDiaChiKH(String diaChiKH) {
	this.diaChiKH = diaChiKH;
}

}