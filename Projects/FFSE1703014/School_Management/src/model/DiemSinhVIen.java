package model;

public class DiemSinhVIen {
	public String maMH, diemMH;
	public DiemSinhVIen() {
		
	}
	public DiemSinhVIen(String maMH, String diemMH) {
		this.maMH = maMH;
		this.diemMH = diemMH;
	}
	public String getMaMH() {
		return maMH;
	}
	public void setMaMH(String maMH) {
		this.maMH = maMH;
	}
	public String getDiemMH() {
		return diemMH;
	}
	public void setDiemMH(String diemMH) {
		this.diemMH = diemMH;
	}
}
