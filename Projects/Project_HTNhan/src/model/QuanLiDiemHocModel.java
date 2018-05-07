package model;

public class QuanLiDiemHocModel {
	private String maSv,maMH,diemMH;
	public QuanLiDiemHocModel() {
		// TODO Auto-generated constructor stub
	}
	public QuanLiDiemHocModel(String maSv ,String maMH,String diemMH) {
		this.maSv = maSv;
		this.maMH = maMH;
		this.diemMH = diemMH;
	}
	public String getMaSv() {
		return maSv;
	}
	public void setMaSv(String maSv) {
		this.maSv = maSv;
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
