package fasttrackse.edu.vn.project4.model;

public class MonHoc {
	private String malop;
	private String maMH;
	private String tenMH;
	private String soTC;
	private String thoiluonghoc;
	
	public MonHoc(String malop,String maMH, String tenMH, String soTC, String thoiluonghoc) {
		this.malop = malop;
		this.maMH = maMH;
		this.tenMH = tenMH;
		this.soTC = soTC;
		this.thoiluonghoc = thoiluonghoc;
		
	}

	public String getMalop() {
		return malop;
	}

	public void setMalop(String malop) {
		this.malop = malop;
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
