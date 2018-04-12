package test.io.model;
import java.io.Serializable;
public class KhachHang implements Serializable{
	private String maKh;
	private String tenKh;
	public String getMaKh() {
		return maKh;
	}
	public String getTenKh() {
		return tenKh;
	}
	public void setMaKh(String maKh) {
		this.maKh=maKh;
	}
	public void setTenKh(String tenKh) {
		this.tenKh=tenKh;
	}
	public KhachHang() {
		super();
	}
	public KhachHang(String maKh,String tenKh) {
	super();
	this.maKh=maKh;
	this.tenKh=tenKh;
	}
}
