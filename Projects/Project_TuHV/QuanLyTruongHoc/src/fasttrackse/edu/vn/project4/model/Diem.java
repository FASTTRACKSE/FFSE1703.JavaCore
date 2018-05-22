package fasttrackse.edu.vn.project4.model;

public class Diem {
	
	private String maMH;
	private String maSV;
	private String diem;
	private String malophoc;
	
	public Diem(String maMH, String maSV, String diem, String malophoc) {
		this.maMH = maMH;
		this.maSV = maSV;
		this.diem = diem;
		this.malophoc = malophoc;
		
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

	public String getMalophoc() {
		return malophoc;
	}

	public void setMalophoc(String malophoc) {
		this.malophoc = malophoc;
	}

	
	
	

}
