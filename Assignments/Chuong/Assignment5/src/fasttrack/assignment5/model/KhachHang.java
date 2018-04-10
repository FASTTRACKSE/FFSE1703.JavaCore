package fasttrack.assignment5.model;

public class KhachHang {
public int maKH;
public String tenKH;
public String diaChi;
public int maCongTo;

public KhachHang() {
	
}

public KhachHang(int maKH, String tenKH, String diaChi, int maCongTo) {
	super();
	this.maKH = maKH;
	this.tenKH = tenKH;
	this.diaChi = diaChi;
	this.maCongTo = maCongTo;
}
public int getMaKH() {
	return maKH;
}
public void setMaKH(int maKH) {
	this.maKH = maKH;
}
public String getTenKH() {
	return tenKH;
}
public void setTenKH(String tenKH) {
	this.tenKH = tenKH;
}
public String getDiaChi() {
	return diaChi;
}
public void setDiaChi(String diaChi) {
	this.diaChi = diaChi;
}
public int getMaCongTo() {
	return maCongTo;
}
public void setMaCongTo(int maCongTo) {
	this.maCongTo = maCongTo;
}


}