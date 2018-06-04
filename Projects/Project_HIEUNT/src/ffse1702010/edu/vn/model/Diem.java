package ffse1702010.edu.vn.model;

public class Diem {
	private String maLop;
	private String maSinhVien;
	private String maMonHoc;
	private String diem;

	public Diem() {

	}

	public Diem(String maLop, String maSinhVien, String maMonHoc, String diem) {

		this.maLop = maLop;
		this.maSinhVien = maSinhVien;
		this.maMonHoc = maMonHoc;
		this.diem = diem;

	}

	public String getMaLop() {
		return maLop;
	}

	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}

	public String getMaSinhVien() {
		return maSinhVien;
	}

	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}

	public String getMaMonHoc() {
		return maMonHoc;
	}

	public void setMaMonHoc(String maMonHoc) {
		this.maMonHoc = maMonHoc;
	}

	public String getDiem() {
		return diem;
	}

	public void setDiem(String diem) {
		this.diem = diem;
	}

}
