package Assignment_11.model;

public class SinhVien {
	private String lopSV,maSV,tenSV,tuoiSV;
	public SinhVien() {
		
	}
	
	public SinhVien(String lopSV, String maSV,String tenSV,String tuoiSV) {
		this.lopSV = lopSV;
		this.maSV = maSV;
		this.tenSV= tenSV;
		this.tuoiSV= tuoiSV;
	}
	public void setLopSV(String lopSV) {
		this.lopSV = lopSV;
	}
	public String getLopSV() {
		return lopSV;
	}
	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}
	public String getMaSV() {
		return maSV;
	}
	public void setTenSV(String tenSV) {
		this.tenSV = tenSV;
	}
	public String getTenSV() {
		return tenSV;
	}
	public void setTuoiSV(String tuoiSV) {
		this.tuoiSV = tuoiSV;
	}
	public String getTuoiSV() {
		return tuoiSV;
	}
}
