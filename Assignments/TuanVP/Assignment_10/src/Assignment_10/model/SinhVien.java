package Assignment_10.model;

public class SinhVien {
	private String maSV,tenSV,tuoiSV;
	public SinhVien() {
		
	}
	
	public SinhVien(String maSV,String tenSV,String tuoiSV) {
		this.maSV = maSV;
		this.tenSV= tenSV;
		this.tuoiSV= tuoiSV;
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
