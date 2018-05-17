package model;

public class QuanLiSinhVienModel {

	private String maSv, hoTenSv, diaChiSv, xa, huyen, tinh, dienThoaiSv, email, maLop;


	public QuanLiSinhVienModel() {
		// TODO Auto-generated constructor stub
	}

	public QuanLiSinhVienModel(String maSv, String hoTenSv, String diaChiSv, String xa, String huyen, String tinh,
			String dienThoaiSv, String email, String maLop) {
		this.maSv = maSv;
		this.hoTenSv = hoTenSv;
		this.diaChiSv = diaChiSv;
		this.xa = xa;
		this.huyen = huyen;
		this.tinh = tinh;
		this.dienThoaiSv = dienThoaiSv;
		this.email = email;
		this.maLop = maLop;
	}

	public String getMaSv() {
		return maSv;
	}

	public void setMaSv(String maSv) {
		this.maSv = maSv;
	}

	public String getHoTenSv() {
		return hoTenSv;
	}

	public void setHoTenSv(String hoTenSv) {
		this.hoTenSv = hoTenSv;
	}

	public String getDiaChiSv() {
		return diaChiSv;
	}

	public void setDiaChiSv(String diaChiSv) {
		this.diaChiSv = diaChiSv;
	}

	public String getXa() {
		return xa;
	}

	public void setXa(String xa) {
		this.xa = xa;
	}

	public String getHuyen() {
		return huyen;
	}

	public void setHuyen(String huyen) {
		this.huyen = huyen;
	}

	public String getTinh() {
		return tinh;
	}

	public void setTinh(String tinh) {
		this.tinh = tinh;
	}

	public String getDienThoaiSv() {
		return dienThoaiSv;
	}

	public void setDienThoaiSv(String dienThoaiSv) {
		this.dienThoaiSv = dienThoaiSv;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMaLop() {
		return maLop;
	}

	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}

	
}
