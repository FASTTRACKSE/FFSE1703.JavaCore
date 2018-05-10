package ffse20.project_lp4.model;

public class QuanLySinhVienModel {
public String maSV, tenSV, maLop, ngaySinh, phuong,quan,thanhPho,email;
public String phone;



public QuanLySinhVienModel(String maSV, String tenSV, String maLop, String ngaySinh, String phuong, String quan,
		String thanhPho, String email, String sdt) {
	super();
	this.maSV = maSV;
	this.tenSV = tenSV;
	this.maLop = maLop;
	this.ngaySinh = ngaySinh;
	this.phuong = phuong;
	this.quan = quan;
	this.thanhPho = thanhPho;
	this.email = email;
	this.phone = sdt;
}



public String getMaSV() {
	return maSV;
}



public void setMaSV(String maSV) {
	this.maSV = maSV;
}



public String getTenSV() {
	return tenSV;
}



public void setTenSV(String tenSV) {
	this.tenSV = tenSV;
}



public String getMaLop() {
	return maLop;
}



public void setMaLop(String maLop) {
	this.maLop = maLop;
}



public String getNgaySinh() {
	return ngaySinh;
}



public void setNgaySinh(String ngaySinh) {
	this.ngaySinh = ngaySinh;
}



public String getPhuong() {
	return phuong;
}



public void setPhuong(String phuong) {
	this.phuong = phuong;
}



public String getQuan() {
	return quan;
}



public void setQuan(String quan) {
	this.quan = quan;
}



public String getThanhPho() {
	return thanhPho;
}



public void setThanhPho(String thanhPho) {
	this.thanhPho = thanhPho;
}



public String getEmail() {
	return email;
}



public void setEmail(String email) {
	this.email = email;
}



public String getPhone() {
	return phone;
}



public void setPhone(String phone) {
	this.phone = phone;
}

}
