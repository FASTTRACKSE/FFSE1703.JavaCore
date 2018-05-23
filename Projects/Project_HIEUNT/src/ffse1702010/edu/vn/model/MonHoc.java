package ffse1702010.edu.vn.model;

public class MonHoc {
	private String maMonHoc;
	private String tenMonHoc;
	private int tinChi;
	private String thoiGian;
	
	public MonHoc() {

	}
	public MonHoc(String maMonHoc,int tinChi,String tenMonHoc,String thoiGian) {
		this.maMonHoc=maMonHoc;
		this.tenMonHoc=tenMonHoc;
		this.tinChi=tinChi;
		this.thoiGian=thoiGian;
	
		}
	public String getMaMonHoc() {
		return maMonHoc;
	}
	public void setMaMonHoc(String maMonHoc) {
		this.maMonHoc = maMonHoc;
	}
	public String getTenMonHoc() {
		return tenMonHoc;
	}
	public void setTenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
	}
	public int getTinChi() {
		return tinChi;
	}
	public void setTinChi(int tinChi) {
		this.tinChi = tinChi;
	}
	public String getThoiGian() {
		return thoiGian;
	}
	public void setThoiGian(String thoiGian) {
		this.thoiGian = thoiGian;
	}




}
