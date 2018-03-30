package ffse1702.Javacore.oop2.model;

public class QuanLy extends NhanVien {
	private double luongTrachNhiem;

	public QuanLy() {
		super();
	}

	public QuanLy(String MasoSV, String TenNV, String Date, double Luong, double luongTrachNhiem) {
		super(MasoSV, TenNV, Date, Luong);
		this.luongTrachNhiem = luongTrachNhiem;
		// TODO Auto-generated constructor stub
	}

	public double getLuong() {
		return (super.Luong + this.luongTrachNhiem)*1000000;

	}
	public double thueThunhap() {
		if (this.getLuong() > 5000000) {
			return (getLuong() - 5000000) * 0.1;
		} else {
			return (0.0);
		}

	}
}
