package project.model;

public class LopHoc {
	private String MaLop;
	private String TenLop;
	private String NamHoc;
	
	public LopHoc(String malop, String tenlop, String namhoc) {
		this.MaLop = malop;
		this.TenLop = tenlop;
		this.NamHoc = namhoc;
	}

	public String getMaLop() {
		return MaLop;
	}

	public void setMaLop(String maLop) {
		MaLop = maLop;
	}

	public String getTenLop() {
		return TenLop;
	}

	public void setTenLop(String tenLop) {
		TenLop = tenLop;
	}

	public String getNamHoc() {
		return NamHoc;
	}

	public void setNamHoc(String namHoc) {
		NamHoc = namHoc;
	}
	
}
