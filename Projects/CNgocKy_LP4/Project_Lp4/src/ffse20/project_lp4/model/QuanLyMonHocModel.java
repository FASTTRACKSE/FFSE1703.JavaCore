package ffse20.project_lp4.model;

public class QuanLyMonHocModel {
public String maMHoc,tenMonHoc,soTinChi,gioHoc;

public QuanLyMonHocModel( String maMHoc, String tenMonHoc, String soTinChi, String gioHoc) {
	super();

	this.maMHoc = maMHoc;
	this.tenMonHoc = tenMonHoc;
	this.soTinChi = soTinChi;
	this.gioHoc = gioHoc;
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
