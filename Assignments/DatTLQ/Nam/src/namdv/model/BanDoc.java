package namdv.model;

public class BanDoc {
	private int soSachDangMuon;
	private String id, hoTen, thanhPho, quan, phuong, diaChi, email, dienThoai;

	public BanDoc() {
		super();
	}

	public BanDoc(String hoTen, String thanhPho, String quan, String phuong, String diaChi, String email,
			String dienThoai) {
		super();
		this.dienThoai = dienThoai;
		this.hoTen = hoTen;
		this.thanhPho = thanhPho;
		this.quan = quan;
		this.phuong = phuong;
		this.diaChi = diaChi;
		this.email = email;
	}

	public BanDoc(String id, String hoTen, String thanhPho, String quan, String phuong, String diaChi, String email,
			String dienThoai) {
		super();
		this.id = id;
		this.dienThoai = dienThoai;
		this.hoTen = hoTen;
		this.thanhPho = thanhPho;
		this.quan = quan;
		this.phuong = phuong;
		this.diaChi = diaChi;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getThanhPho() {
		return thanhPho;
	}

	public void setThanhPho(String thanhPho) {
		this.thanhPho = thanhPho;
	}

	public String getQuan() {
		return quan;
	}

	public void setQuan(String quan) {
		this.quan = quan;
	}

	public String getPhuong() {
		return phuong;
	}

	public void setPhuong(String phuong) {
		this.phuong = phuong;
	}

	public String getDienThoai() {
		return dienThoai;
	}

	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getSoSachDangMuon() {
		return soSachDangMuon;
	}

	public void setSoSachDangMuon(int soSachDangMuon) {
		this.soSachDangMuon = soSachDangMuon;
	}

}