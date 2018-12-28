package ffse1703004.model;

public class KhachHangMD {
	private	String tenKhachHang,diaChi,email,maCongTo,maKhachHang,quan,phuong;
	private int soDienThoai;
		public KhachHangMD() {
			
		}
	    public KhachHangMD( String maKhachHang,String maCongTo,String tenKhachHang,String diaChi,String phuong,String quan,int soDienThoai,String email) {
	    	this.maKhachHang = maKhachHang;
	    	this.quan = quan;
	    	this.phuong = phuong;
	    	this.tenKhachHang = tenKhachHang;
	    	this.diaChi = diaChi;
	    	this.soDienThoai = soDienThoai;
	    	this.email = email;
	    	this.maCongTo = maCongTo;
	    	
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
		public String getMaKhachHang() {
			return maKhachHang;
		}
		
		public int getSoDienThoai() {
			return soDienThoai;
		}
		public void setSoDienThoai(int soDienThoai) {
			this.soDienThoai = soDienThoai;
		}
		public void setMaKhachHang(String maKhachHang) {
			this.maKhachHang = maKhachHang;
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
		
		
}