package project.model;

public class MonHocLop {
	private String MaMH;
	private String TenMH;
	private String TenLop;
	private String SoTC;
	private String Thoigian;

	public MonHocLop(String maMH, String tenMH, String tenLop, String soTC, String thoigian) {
		this.MaMH = maMH;
		this.TenMH = tenMH;
		this.TenLop = tenLop;
		this.SoTC = soTC;
		this.Thoigian = thoigian;
	}

	public String getMaMH() {
		return MaMH;
	}

	public void setMaMH(String maMH) {
		MaMH = maMH;
	}

	public String getTenMH() {
		return TenMH;
	}

	public void setTenMH(String tenMH) {
		TenMH = tenMH;
	}

	public String getTenLop() {
		return TenLop;
	}

	public void setTenLop(String tenLop) {
		TenLop = tenLop;
	}

	public String getSoTC() {
		return SoTC;
	}

	public void setSoTC(String soTC) {
		SoTC = soTC;
	}

	public String getThoigian() {
		return Thoigian;
	}

	public void setThoigian(String thoigian) {
		Thoigian = thoigian;
	}

}
