package ffse1703.javacore.model;

public class QuanLi extends NhanVien {
	private double luongTrachNhiem;

	public QuanLi() {
		super();
	}

	public QuanLi(int maNhanVien, String tenNhanVien, String namSinh, double luong, double luongTrachNhiem) {
		super(maNhanVien, tenNhanVien, namSinh, luong);
		this.luongTrachNhiem = luongTrachNhiem;
	}

	public double tinhLuongTN() {

		return super.tinhLuong() + this.luongTrachNhiem;
	}

	public double tinhThueThuNhap() {

		if (tinhLuongTN() > 5000000) {
			return (tinhLuongTN() - 5000000) * 0.1;
		}
		else {
			return 0;
		}
	}

}
