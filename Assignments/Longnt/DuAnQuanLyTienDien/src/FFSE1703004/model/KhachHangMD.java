package FFSE1703004.model;

public class KhachHangMD {

	private int maKhachHang,quan,phuong;
	private	String tenKhachHang,diaChi,soDienThoai,email,maCongTo;
		public KhachHangMD() {
			super();
		}
	    public KhachHangMD(int maKhachHang,int quan, int phuong, String tenKhachHang,String diaChi, String soDienThoai, String email, String maCongTo) {
	    	super();
	    	this.maKhachHang = maKhachHang;
	    	this.quan = quan;
	    	this.phuong = phuong;
	    	this.tenKhachHang = tenKhachHang;
	    	this.diaChi = diaChi;
	    	this.soDienThoai = soDienThoai;
	    	this.email = email;
	    	this.maCongTo = maCongTo;
	    	
	    }
		public int getMaKhachHang() {
			return maKhachHang;
		}
		public void setMaKhachHang(int maKhachHang) {
			this.maKhachHang = maKhachHang;
		}
		public int getQuan() {
			return quan;
		}
		public void setQuan(int quan) {
			this.quan = quan;
		}
		public int getPhuong() {
			return phuong;
		}
		public void setPhuong(int phuong) {
			this.phuong = phuong;
		}
		public String getTenKhachHang() {
			return tenKhachHang;
		}
		public void setTenKhachHang(String tenKhachHang) {
			this.tenKhachHang = tenKhachHang;
		}
		public String getDiaChi() {
			return diaChi;
		}
		public void setDiaChi(String diaChi) {
			this.diaChi = diaChi;
		}
		public String getSoDienThoai() {
			return soDienThoai;
		}
		public void setSoDienThoai(String soDienThoai) {
			this.soDienThoai = soDienThoai;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getMaCongTo() {
			return maCongTo;
		}
		public void setMaCongTo(String maCongTo) {
			this.maCongTo = maCongTo;
		}

}
