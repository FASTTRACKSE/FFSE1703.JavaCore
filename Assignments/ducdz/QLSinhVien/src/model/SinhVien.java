package model;

public class SinhVien {
	String id;
	String tensv;
	String ngaysinh;
	String quequan;
	String gioitinh;
	String lop;
	String photo;

	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTensv() {
		return tensv;
	}
	public void setTensv(String tensv) {
		this.tensv = tensv;
	}
	public String getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public String getQuequan() {
		return quequan;
	}
	public void setQuequan(String quequan) {
		this.quequan = quequan;
	}
	public String getGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}
	public String getLop() {
		return lop;
	}
	public void setLop(String lop) {
		this.lop = lop;
	}
	public SinhVien(String id,String tensv, String ngaysinh, String quequan, String gioitinh, String lop,String photo) {
		super();
		this.id=id;
		this.tensv = tensv;
		this.ngaysinh = ngaysinh;
		this.quequan = quequan;
		this.gioitinh = gioitinh;
		this.lop = lop;
		this.photo = photo;
	}
	public SinhVien() {
	}
	public SinhVien(String id) {
		this.id=id;
	}
}
