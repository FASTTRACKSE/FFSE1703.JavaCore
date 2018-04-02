package ffse1703002.model;	

public class KhachHang {
	public String maKH,tenKH,diaChi;
	public String maCongTo;


public KhachHang() {
		super();
	}

public KhachHang(String tenKH,String maKH,String diaChi,String maCongTo) {
	this.maKH=maKH;
	this.tenKH=tenKH;
	this.maCongTo=maCongTo;
	this.diaChi=diaChi;
	
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
public String getDiaChi() {
	return diaChi;
}
public void setDiaChi(String diaChi) {
	this.diaChi = diaChi;
}
public String getMaCongTo() {
	return maCongTo;
}
public void setMaCongTo(String maCongTo) {
	this.maCongTo = maCongTo;
}

}
