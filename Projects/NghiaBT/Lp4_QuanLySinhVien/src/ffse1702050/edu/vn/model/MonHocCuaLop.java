package ffse1702050.edu.vn.model;

public class MonHocCuaLop {
	private String MaLop;
	private String MaMH;
	private String Ten;
	
	public MonHocCuaLop(String MaLop, String MaMH, String Ten) {
		this.MaLop = MaLop;
		this.MaMH = MaMH;
		this.Ten = Ten;
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
