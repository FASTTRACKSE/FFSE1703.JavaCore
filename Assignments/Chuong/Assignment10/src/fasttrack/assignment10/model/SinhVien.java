package fasttrack.assignment10.model;

public class SinhVien {

	private String maSV;
	private String tenSV;
	private String tuoi;
	private String lopSV;

	public SinhVien(String maSV, String tenSV,  String tuoi, String lop) {
		this.maSV = maSV;
		this.tenSV = tenSV;
		this.tuoi = tuoi;
		this.lopSV = lop;
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

	public String getTuoi() {
		return tuoi;
	}

	public void setTuoi(String tuoi) {
		this.tuoi = tuoi;
	}

	public SinhVien() {
		
	}
}