package project.model;

public class MonHoc {
	private String MaMH;
	private String TenMH;
	private String MaLH;
	private String TinChi;
	private String Time;
	
	public MonHoc(String maMH, String tenMH, String tinChi, String thoigian) {
		this.MaMH = maMH;
		this.TenMH = tenMH;
		this.TinChi = tinChi;
		this.Time = thoigian;
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

	public String getMaLH() {
		return MaLH;
	}

	public void setMaLH(String maLH) {
		MaLH = maLH;
	}

	public String getTinChi() {
		return TinChi;
	}

	public void setTinChi(String tinChi) {
		TinChi = tinChi;
	}

	public String getTime() {
		return Time;
	}

	public void setTime(String time) {
		Time = time;
	}
	
}
