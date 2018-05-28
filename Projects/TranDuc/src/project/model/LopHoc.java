package project.model;

public class LopHoc {
	String maLop;
	String tenLop;
	String motaLop;
	String namhocLop;
	public LopHoc(String maLop,String tenLop,String namhocLop,String motaLop) {
		this.maLop = maLop;
		this.tenLop = tenLop;
		this.motaLop = motaLop;
		this.namhocLop = namhocLop;
	}
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
	public String getMotaLop() {
		return motaLop;
	}
	public void setMotaLop(String motaLop) {
		this.motaLop = motaLop;
	}
	public String getNamhocLop() {
		return namhocLop;
	}
	public void setNamhocLop(String namhocLop) {
		this.namhocLop = namhocLop;
	}
}
