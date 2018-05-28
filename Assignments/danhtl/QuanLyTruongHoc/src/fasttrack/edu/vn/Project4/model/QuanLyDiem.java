package fasttrack.edu.vn.Project4.model;



public class QuanLyDiem  {
	private String lop;
	private String MaMon;
	private String MaSV;
	private String Diem;
	
	public QuanLyDiem (String lop,String MaMon,String MaSV,String Diem) {
		this.lop = lop;
		this.MaMon = MaMon;
		this.MaSV = MaSV;
		this.Diem = Diem;
}
	public QuanLyDiem() {
		
	}
	public String getLop() {
		return lop;
	}

	public void setLop(String lop) {
		this.lop = lop;
	}

	public String getMaMon() {
		return MaMon;
	}

	public void setMaMon(String maMon) {
		MaMon = maMon;
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