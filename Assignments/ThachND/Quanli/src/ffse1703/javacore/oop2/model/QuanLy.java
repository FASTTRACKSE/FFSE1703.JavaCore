package ffse1703.javacore.oop2.model;

public class QuanLy extends NhanVien {
	private double luongTrachNhiem;
	
	public QuanLy() {
		super();
	this.luongTrachNhiem = luongTrachNhiem;
	}

	public double getLuongTrachNhiem() {
		return luongTrachNhiem;
	}

	public void setLuongTrachNhiem(double luongTrachNhiem) {
		this.luongTrachNhiem = luongTrachNhiem;
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

