package ffse20.project_lp4.model;

public class QuanLyDiemModel {
public String maLop,maMonHoc,sinhVien,diem;

public QuanLyDiemModel(String maLop, String maMonHoc, String sinhVien, String diem) {
	super();
	this.maLop = maLop;
	this.maMonHoc = maMonHoc;
	this.sinhVien = sinhVien;
	this.diem = diem;
}

public String getMaLop() {
	return maLop;
}

public void setMaLop(String maLop) {
	this.maLop = maLop;
}

public String getMaMonHoc() {
	return maMonHoc;
}

public void setMaMonHoc(String maMonHoc) {
	this.maMonHoc = maMonHoc;
}

public String getSinhVien() {
	return sinhVien;
}

public void setSinhVien(String sinhVien) {
	this.sinhVien = sinhVien;
}

public String getDiem() {
	return diem;
}

public void setDiem(String diem) {
	this.diem = diem;
}


}
