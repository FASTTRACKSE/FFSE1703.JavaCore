package fasttrack.edu.vn.model;

public class SinhVienModel {
	private String maSV;
	private String tenSV;
	private String tuoiSV;
	private String lopSV;
	
	public SinhVienModel(String maSV, String tenSV, String tuoiSV, String lopSV) {
		this.maSV = maSV;
		this.tenSV = tenSV;
		this.tuoiSV = tuoiSV;
		this.lopSV = lopSV;
	}
	
	public String getMaSV() {
		return maSV;
	}
	
	public void setMaSV() {
		this.maSV = maSV;
	}

	public String getTenSV() {
		return tenSV;
	}
	
	public void setTenSV(String string) {
		this.tenSV = tenSV;
	}
	
	public String getTuoiSV() {
		return tuoiSV;
	}
	
	public void setTuoiSV(String string) {
		this.tuoiSV = tuoiSV;
	}
	
	public String getLopSV() {
		return lopSV;
	}
	
	public void setLopSV() {
		this.lopSV = lopSV;
	}
	
	public SinhVienModel() {
		
	}
}
