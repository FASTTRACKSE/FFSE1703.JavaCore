package fasttrackse.edu.vn.project4.model;

public class SinhVien {
	private String maSV;
	private String tenSV;
	private String lop;
	private String diaChi;
	private String phuong;
	private String quan;
	private String tp;
	private String email;
	private String sdt;
	private String tuoi;

	

	public SinhVien(String lop,String maSV, String tenSV,  String tp,  String phuong, String quan,String diachi,
			String email, String sdt, String tuoi) {
		this.maSV = maSV;
		this.tenSV = tenSV;
		this.lop = lop;
		this.diaChi = diachi;
		this.phuong = phuong;
		this.quan = quan;
		this.tp = tp;
		this.email = email;
		this.sdt = sdt;
		this.tuoi= tuoi;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
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
		return lop;
	}

	public void setLop(String lop) {
		this.lop = lop;
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
	public String getTuoi() {
		return tuoi;
	}

	public void setTuoi(String tuoi) {
		this.tuoi = tuoi;
	}

	public SinhVien() {

	}

}
