package QuanLyTruongHoc.FFSE.Model;

public class MonCuaLop {
	private String MaLop;
	private String MaMH;
	private String Ten;
	
	
	public MonCuaLop( String MaLop, String MaMH, String Ten) {
		this.MaLop = MaLop;
		this.MaMH = MaMH;
		this.Ten = Ten;
		}
	public MonCuaLop() {

	}
	public String getMaLop() {
		return MaLop;
	}
	public void setMaLop(String maLop) {
		MaLop = maLop;
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

}
