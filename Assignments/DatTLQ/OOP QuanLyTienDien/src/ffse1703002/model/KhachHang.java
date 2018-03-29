package ffse1703002.model;	

public class KhachHang {
	public String maKH,tenKH,diaChi;
	public int maCongTo;
	
public KhachHang() {
		
	}
public KhachHang(String maKH,String tenKH,String diaChi,int maCongTo) {
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
public int getMaCongTo() {
	return maCongTo;
}
public void setMaCongTo(int maCongTo) {
	this.maCongTo = maCongTo;
}

}
