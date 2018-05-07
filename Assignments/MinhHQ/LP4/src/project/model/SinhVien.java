package project.model;

public class SinhVien {
	private String maSV;
	private String tenSV;
	private String Lop;
	private String Adress;
	private String phuong;
	private String quan;
	private String tp;
	private String email;
	private String sdt;

	public SinhVien(String maSV, String tenSV, String lop, String diachi, String phuong, String quan, String tp,
			String email, String sdt) {
		this.maSV = maSV;
		this.tenSV = tenSV;
		this.Lop = lop;
		this.Adress = diachi;
		this.phuong = phuong;
		this.quan = quan;
		this.tp = tp;
		this.email = email;
		this.sdt = sdt;
	}

	public String getMaSV() {
		return maSV;
	}

	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}

	public String getTenSV() {
		return tenSV;
	}

	public void setTenSV(String tenSV) {
		this.tenSV = tenSV;
	}

	public String getLop() {
		return Lop;
	}

	public void setLop(String lop) {
		Lop = lop;
	}

	public String getAdress() {
		return Adress;
	}

	public void setAdress(String adress) {
		Adress = adress;
	}

	public String getPhuong() {
		return phuong;
	}

	public void setPhuong(String phuong) {
		this.phuong = phuong;
	}

	public String getQuan() {
		return quan;
	}

	public void setQuan(String quan) {
		this.quan = quan;
	}

	public String getTp() {
		return tp;
	}

	public void setTp(String tp) {
		this.tp = tp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public SinhVien() {

	}
}
