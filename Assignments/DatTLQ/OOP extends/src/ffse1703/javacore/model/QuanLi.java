package ffse1703.javacore.model;

public class QuanLi extends NhanVien {
	public double luongTrachNhiem;
	
	public QuanLi() {
		super();
	}
	public QuanLi(String maNhanVien, String tenNhanVien, String ngaySinh, double luong,double luongTrachNhiem) {
		super(maNhanVien, tenNhanVien, ngaySinh, luong);
		this.luongTrachNhiem=luongTrachNhiem;
	}
	
	
	public double tinhLuongTN() {
		return super.luong()+this.luongTrachNhiem;
	}
	public double tinhThueThuNhap() {
		return(this.tinhLuongTN()-5000000)*0.1;
	}
}
