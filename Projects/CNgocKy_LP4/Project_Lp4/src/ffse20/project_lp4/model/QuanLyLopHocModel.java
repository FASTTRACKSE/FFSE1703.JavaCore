package ffse20.project_lp4.model;

public class QuanLyLopHocModel {
public String maLop,tenLop;
public String namHoc;
public QuanLyLopHocModel(String maLop, String tenLop, String namHoc) {
	super();
	this.maLop = maLop;
	this.tenLop = tenLop;
	this.namHoc = namHoc;
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
public String getNamHoc() {
	return namHoc;
}
public void setNamHoc(String namHoc) {
	this.namHoc = namHoc;
}

}
