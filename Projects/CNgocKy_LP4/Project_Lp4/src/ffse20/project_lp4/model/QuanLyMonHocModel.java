package ffse20.project_lp4.model;

public class QuanLyMonHocModel {
public String maLop,maMHoc,tenMonHoc,soTinChi,gioHoc;

public QuanLyMonHocModel(String maLop, String maMHoc, String tenMonHoc, String soTinChi, String gioHoc) {
	super();
	this.maLop = maLop;
	this.maMHoc = maMHoc;
	this.tenMonHoc = tenMonHoc;
	this.soTinChi = soTinChi;
	this.gioHoc = gioHoc;
}

public String getMaLop() {
	return maLop;
}

public void setMaLop(String maLop) {
	this.maLop = maLop;
}

public String getMaMonHoc() {
	return maMHoc;
}

public void setMaMonHoc(String maMonHoc) {
	this.maMHoc = maMonHoc;
}

public String getTenMonHoc() {
	return tenMonHoc;
}

public void setTenMonHoc(String tenMonHoc) {
	this.tenMonHoc = tenMonHoc;
}

public String getSoTinChi() {
	return soTinChi;
}

public void setSoTinChi(String soTinChi) {
	this.soTinChi = soTinChi;
}

public String getGioHoc() {
	return gioHoc;
}

public void setGioHoc(String gioHoc) {
	this.gioHoc = gioHoc;
}

}
