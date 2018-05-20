package QuanLyTruongHoc.FFSE.Model;

public class NhapDiem {
	private String MaLop;
	private String MaMH;
	private String MaSV;
	private String Diem;
	public NhapDiem( String MaLop,String MaMH, String MaSV, String Diem) {
		this.MaLop = MaLop;
		this.MaMH = MaMH;
		this.MaSV = MaSV;
		this.Diem = Diem;
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
	public String getMaSV() {
		return MaSV;
	}
	public void setMaSV(String maSV) {
		MaSV = maSV;
	}
	public String getDiem() {
		return Diem;
	}
	public void setDiem(String diem) {
		Diem = diem;
	}
}
