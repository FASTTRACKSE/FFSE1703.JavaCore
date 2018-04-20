package quanlysinhvien.model;
import java.io.Serializable;
public class SinhVien implements Serializable{
	private String maSv;
	private String tenSv;
	private String tuoiSv;
	private String lopSv;
	public SinhVien() {
		
	}
	public SinhVien(String lopSv,String maSv,String tenSv,String tuoiSv) {
		this.maSv=maSv;
		this.tenSv=tenSv;
		this.tuoiSv=tuoiSv;
		this.lopSv=lopSv;
	}
	public String getLopSv() {
		return lopSv;
	}
	public void setLopSv(String lopSv) {
		this.lopSv = lopSv;
	}
	public String getMaSv() {
		return maSv;
	}
	public void setMaSv(String maSv) {
		this.maSv = maSv;
	}
	public String getTenSv() {
		return tenSv;
	}
	public void setTenSv(String tenSv) {
		this.tenSv = tenSv;
	}
	public String getTuoiSv() {
		return tuoiSv;
	}
	public void setTuoiSv(String tuoiSv) {
		this.tuoiSv = tuoiSv;
	}
	
}
