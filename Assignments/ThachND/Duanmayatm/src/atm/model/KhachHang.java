package atm.model;

public class KhachHang {
	private String maKh, tenKh, soNha, quan, phuong, sdt, email, soThe,soTk, soDu;
	public KhachHang() {
		
	}
	
	public KhachHang(String maKh, String tenKh, String soNha, String quan, String phuong, String sdt, String email, String soThe, String soTk, String soDu) {
		this.maKh = maKh;
		this.tenKh = tenKh;
		this.soNha = soNha;
		this.quan = quan;
		this.phuong = phuong;
		this.sdt = sdt;
		this.email = email;
		this.soThe = soThe;
		this.soTk = soTk;
		this.soDu = soDu;
		
	}

	public String getMaKh() {
		return maKh;
	}

	public void setMaKh(String maKh) {
		this.maKh = maKh;
	}

	public String getTenKh() {
		return tenKh;
	}

	public void setTenKh(String tenKh) {
		this.tenKh = tenKh;
	}

	public String getSoNha() {
		return soNha;
	}

	public void setSoNha(String soNha) {
		this.soNha = soNha;
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

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSoThe() {
		return soThe;
	}

	public void setSoThe(String soThe) {
		this.soThe = soThe;
	}

	public String getSoDu() {
		return soDu;
	}

	public String getSoTk() {
		return soTk;
	}

	public void setSoTk(String soTk) {
		this.soTk = soTk;
	}

	public void setSoDu(String soDu) {
		this.soDu = soDu;
	}
}
