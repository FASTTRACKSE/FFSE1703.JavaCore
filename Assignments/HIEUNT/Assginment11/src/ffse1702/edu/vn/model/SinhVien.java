package ffse1702.edu.vn.model;


public class SinhVien {
	private String maSV,tenSV,tuoiSV,lopSV;

	public SinhVien() {
		
		
	}
	public SinhVien(String maSV,String tenSV,String tuoiSV,String lopSV) {
		this.maSV=maSV;
		this.tenSV=tenSV;
		this.tuoiSV=tuoiSV;
		this.lopSV=lopSV;
	}

	public String getLopSV() {
		return lopSV;
	}
	public void setLopSV(String lopSV) {
		this.lopSV = lopSV;
	}
	public String getMaSV() {
		return maSV;
	}

	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}

	public String getTenSV() {
		return tenSV;
	}

	public void setTenSV(String tenSV) {
		this.tenSV = tenSV;
	}

	public String getTuoiSV() {
		return tuoiSV;
	}

	public void setTuoiSV(String tuoiSV) {
		this.tuoiSV = tuoiSV;
	}
	



}

