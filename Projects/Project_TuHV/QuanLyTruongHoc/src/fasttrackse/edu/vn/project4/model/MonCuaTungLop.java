package fasttrackse.edu.vn.project4.model;

public class MonCuaTungLop {
	private String malop;
	private String maMH;
	private String ten;
	
	public MonCuaTungLop(String malop, String maMH, String ten) {
		this.malop = malop;
		this.maMH = maMH;
		this.ten = ten;
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

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}
	

}
