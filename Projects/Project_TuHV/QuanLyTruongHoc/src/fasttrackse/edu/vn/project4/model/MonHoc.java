package fasttrackse.edu.vn.project4.model;

public class MonHoc {
	
	private String maMH;
	private String tenMH;
	
	private String soTC;
	private String thoiluonghoc;
	
	public MonHoc(String maMH, String tenMH, String soTC, String thoiluonghoc) {
		
		this.maMH = maMH;
		this.tenMH = tenMH;
		
		this.soTC = soTC;
		this.thoiluonghoc = thoiluonghoc;
		
	}

	

	


	public String getMaMH() {
		return maMH;
	}

	public void setMaMH(String maMH) {
		this.maMH = maMH;
	}

	public String getTenMH() {
		return tenMH;
	}

	public void setTenMH(String tenMH) {
		this.tenMH = tenMH;
	}

	public String getSoTC() {
		return soTC;
	}

	public void setSoTC(String soTC) {
		this.soTC = soTC;
	}

	public String getThoiluonghoc() {
		return thoiluonghoc;
	}

	public void setThoiluonghoc(String thoiluonghoc) {
		this.thoiluonghoc = thoiluonghoc;
	}
	
}
