package ffse1703.javacore.oop2.model;

public class QuanLy extends NhanVien {
	private double luongTrachNhiem;
	
	public double getLuongTrachNhiem() {
		return luongTrachNhiem;
	}

	public void setLuongTrachNhiem(double luongTrachNhiem) {
		this.luongTrachNhiem = luongTrachNhiem;
	}

	public QuanLy() {
		super();
	}
	
	public QuanLy(String msNhanVien, String hoTenNV, String ngaySinh, double hsLuong, double luongTrachNhiem) {
		super(msNhanVien, hoTenNV, ngaySinh, hsLuong);
		this.luongTrachNhiem = luongTrachNhiem;
	}
	
	public double tinhLuong() {
		return super.tinhLuong() + this.luongTrachNhiem;
	}
	
	public double tinhThueThuNhap() {
		if (this.tinhLuong() > 5000000) {
			return (this.tinhLuong() - 5000000) * 0.1;
		}
		else {
			return 0.0;
		}
	}
}
