package model;

public class LopHoc {
	public String maLop, moTa, namHoc;
	public LopHoc() {
		
	}
	public LopHoc(String maLop,String moTa, String namHoc) {
		this.maLop = maLop;
		this.moTa = moTa;
		this.namHoc = namHoc;
	}
	public String getMaLop() {
		return maLop;
	}
	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public String getNamHoc() {
		return namHoc;
	}
	public void setNamHoc(String namHoc) {
		this.namHoc = namHoc;
	}
}
