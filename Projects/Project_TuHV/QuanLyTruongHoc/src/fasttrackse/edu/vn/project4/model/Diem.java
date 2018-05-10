package fasttrackse.edu.vn.project4.model;

public class Diem {
	
	private String maMH;
	private String maSV;
	private String diem;
	private String tenMH;
	
	public Diem(String maMH, String maSV, String diem, String tenMH) {
		this.maMH = maMH;
		this.maSV = maSV;
		this.diem = diem;
		this.tenMH = tenMH;
		
	}

	public String getMaMH() {
		return maMH;
	}

	public void setMaMH(String maMH) {
		this.maMH = maMH;
	}

	public String getMaSV() {
		return maSV;
	}

	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}

	public String getDiem() {
		return diem;
	}

	public void setDiem(String diem) {
		this.diem = diem;
	}

	public String getTenMH() {
		return tenMH;
	}

	public void setTenMH(String tenMH) {
		this.tenMH = tenMH;
	}
	

}
