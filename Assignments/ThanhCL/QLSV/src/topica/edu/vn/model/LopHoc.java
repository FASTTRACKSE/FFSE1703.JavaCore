package topica.edu.vn.model;

public class LopHoc {
	private String maLop;
	private String tenLop;
	public String getMaLop() {
		return maLop;
	}
	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}
	public String getTenLop() {
		return tenLop;
	}
	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.tenLop;
	}
}
