package assignment11.java.model;

public class KhachHang {
	private String maKH,tenKH,diaChiNha,phuong,quan,dienThoai,email,soThe,soTK;
	public KhachHang() {
		
	}
	public KhachHang(String maKH,String tenKH,String diaChiNha,String phuong,String quan,String dienThoai,String email,String soThe,String soTK) {
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.diaChiNha= diaChiNha;
		this.phuong = phuong;
		this.quan=quan;
		this.dienThoai= dienThoai;
		this.email= email;
		this.soThe =soThe;
		this.soTK= soTK;
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public String getDiaChiNha() {
		return diaChiNha;
	}
	public void setDiaChiNha(String diaChiNha) {
		this.diaChiNha = diaChiNha;
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
	public String getSoThe() {
		return soThe;
	}
	public void setSoThe(String soThe) {
		this.soThe = soThe;
	}
	public String getSoTK() {
		return soTK;
	}
	public void setSoTK(String soTK) {
		this.soTK = soTK;
	}
	
}
