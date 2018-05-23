package fasttrack.edu.vn.Project4.model;

public class SinhVien  {
	private String lop;
	private String tinh;
	private String huyen;
	private String xa;
	private String masv;
	private String tensv;
	private String diachi;
	private String email;
	private String sdt;
	public  SinhVien() {
		 
	}
public 	SinhVien (String lop,String  masv ,String tensv,String diachi,String xa,String huyen,String tinh,String sdt,String email) {
	this.lop = lop;
	this.tinh = tinh;
	this.huyen = huyen;
	this.xa = xa;
	this.masv = masv;
	this.tensv = tensv;
	this.diachi = diachi;
	this.email = email;
	this.sdt = sdt;
	
	
}
public String getLop() {
	return lop;
}
public void setLop(String lop) {
	this.lop = lop;
}
public String getTinh() {
	return tinh;
}
public void setTinh(String tinh) {
	this.tinh = tinh;
}
public String getHuyen() {
	return huyen;
}
public void setHuyen(String huyen) {
	this.huyen = huyen;
}
public String getXa() {
	return xa;
}
public void setXa(String xa) {
	this.xa = xa;
}
public String getMasv() {
	return masv;
}
public void setMasv(String masv) {
	this.masv = masv;
}
public String getTensv() {
	return tensv;
}
public void setTensv(String tensv) {
	this.tensv = tensv;
}
public String getDiachi() {
	return diachi;
}
public void setDiachi(String diachi) {
	this.diachi = diachi;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getSdt() {
	return sdt;
}
public void setSdt(String sdt) {
	this.sdt = sdt;
}

}
