package Fasttrack.edu.vn.tiendien;
public class KhachHang {
	public int maKh;
	public String tenKh;
	public String diachiKh;
	public int macongtoKh;
	public KhachHang(){
		
	}
	public KhachHang(int maKh, String tenKh, String diachiKh,int macongtoKh) {
	this.maKh=maKh;
	this.tenKh=tenKh;
	this.diachiKh=diachiKh;
	this.macongtoKh=macongtoKh;
	}
	public int getMaKh() {
		return maKh;
	}
	public void setMaKh(int maKh) {
		this.maKh = maKh;
	}
	public String getTenKh() {
		return tenKh;
	}
	public void setTenKh(String tenKh) {
		this.tenKh = tenKh;
	}
	public String getDiachiKh() {
		return diachiKh;
	}
	public void setDiachiKh(String diachiKh) {
		this.diachiKh = diachiKh;
	}
	public int getMacongtoKh() {
		return macongtoKh;
	}
	public void setMacongtoKh(int macongtoKh) {
		this.macongtoKh = macongtoKh;
	}
}
