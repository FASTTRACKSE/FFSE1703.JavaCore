package ffse1702050.edu.vn.model;

public class MonHoc {
	private String MaMH;
	private String Ten;
	private String SoTinhChi;
	private String ThoiLuongHoc;
	public MonHoc( String MaMH, String Ten, String SoTinhChi, String ThoiLuongHoc) {
		this.MaMH = MaMH;
		this.Ten = Ten;
		this.SoTinhChi = SoTinhChi;
		this.ThoiLuongHoc = ThoiLuongHoc;
		
	}
	public String getMaMH() {
		return MaMH;
	}
	public void setMaMH(String maMH) {
		MaMH = maMH;
	}
	public String getTen() {
		return Ten;
	}
	public void setTen(String ten) {
		Ten = ten;
	}
	
	public String getSoTinhChi() {
		return SoTinhChi;
	}
	public void setSoTinhChi(String soTinhChi) {
		SoTinhChi = soTinhChi;
	}
	public String getThoiLuongHoc() {
		return ThoiLuongHoc;
	}
	public void setThoiLuongHoc(String thoiLuongHoc) {
		ThoiLuongHoc = thoiLuongHoc;
	}
}
