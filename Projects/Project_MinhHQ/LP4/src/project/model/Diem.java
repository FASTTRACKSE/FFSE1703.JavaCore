package project.model;

public class Diem {
	private String MaMH;
	private String MaSV;
	private String Diem;
	private String Lop;
	
	public Diem(String lop, String maSv,String maMH,String diem) {
		this.Lop = lop;
		this.MaSV = maSv;
		this.MaMH = maMH;
		this.Diem = diem;
	}

	public String getMaMH() {
		return MaMH;
	}

	public void setMaMH(String maMH) {
		MaMH = maMH;
	}

	public String getMaSV() {
		return MaSV;
	}

	public void setMaSV(String maSV) {
		MaSV = maSV;
	}

	public String getDiem() {
		return Diem;
	}

	public void setDiem(String diem) {
		Diem = diem;
	}

	public String getLop() {
		return Lop;
	}

	public void setLop(String lop) {
		Lop = lop;
	}

}
