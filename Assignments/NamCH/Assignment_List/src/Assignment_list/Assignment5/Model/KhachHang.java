package Assignment_list.Assignment5.Model;

public class KhachHang {
	private String maKhachHang;
	private String tenKhachHang;
	private String diaChi;
	private String maCongTo;
	public KhachHang() {
		
	}
	public KhachHang(String maKhachHang,String tenKhachHang,String diaChi,String maCongTo) {
		this.maKhachHang=maKhachHang;
		this.tenKhachHang=tenKhachHang;
		this.diaChi=diaChi;
		this.maCongTo=maCongTo;
	}
	public String getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
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
	public String getMaCongTo() {
		return maCongTo;
	}
	public void setMaCongTo(String maCongTo) {
		this.maCongTo = maCongTo;
	}
	public String toString() {
		return "  || "+ maKhachHang +"\t     " +tenKhachHang +"\t\t    " +diaChi +"\t    " +maCongTo;
	}
}
