package ffse1703022.model;

public class KhachHang {
	private String maKH, tenKh, diaChi, phuong, quan, dienThoai, email, maCT;

	public KhachHang() {
		super();
	}

	public KhachHang(String maKh, String maCT, String tenKH, String diaChi, String quan, String phuong, String dienThoai,
			String email) {
		super();
		this.maKH = maKh;
		this.tenKh = tenKH;
		this.diaChi = diaChi;
		this.phuong = phuong;
		this.quan = quan;
		this.dienThoai = dienThoai;
		this.email = email;
		this.maCT = maCT;
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getTenKh() {
		return tenKh;
	}

	public void setTenKh(String tenKh) {
		this.tenKh = tenKh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
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

	public String getDienThoai() {
		return dienThoai;
	}

	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMaCT() {
		return maCT;
	}

	public void setMaCT(String maCT) {
		this.maCT = maCT;
	}

}
