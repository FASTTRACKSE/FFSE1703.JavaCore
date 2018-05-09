package ffse1702010.edu.vn.model;

public class ThongTinSinhVien {
	private String maSV;
	private String tenSV;
	private String ngaySinh;
	private String diaChi;
	private String email;
	private String sDT;
	private String lop;
	private String phuong;
	private String quan;
	private String tinh;
	public ThongTinSinhVien() {
		
	}
	public ThongTinSinhVien(String maSV, String tenSV,String ngaySinh,  String diaChi, String email, String sDT, String lop, String phuong, String quan, String tinh) {
	this.maSV=maSV;
	this.tenSV=tenSV;
	this.ngaySinh=ngaySinh;
	this.diaChi=diaChi;
	this.email=email;
	this.sDT=sDT;
	this.lop=lop;
	this.phuong=phuong;
	this.quan=quan;
	this.tinh=tinh;
	
	}
	public String getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
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


	public String getsDT() {
		return sDT;
	}
	public void setsDT(String sDT) {
		this.sDT = sDT;
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
	public String getTinh() {
		return tinh;
	}
	public void setTinh(String tinh) {
		this.tinh = tinh;
	}





}
