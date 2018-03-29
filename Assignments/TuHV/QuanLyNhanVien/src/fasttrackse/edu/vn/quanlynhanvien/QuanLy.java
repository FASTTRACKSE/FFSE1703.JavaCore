package fasttrackse.edu.vn.quanlynhanvien;

public class QuanLy extends NhanVien {
	public double luongTrachNhiem;
	public QuanLy() {
		super();
	}
	public QuanLy(String MasoNV, String TenNV, String NgaySinhNV, double LuongNV, double luongTrachNhiem) {
		super(MasoNV, TenNV, NgaySinhNV, LuongNV);
		this.luongTrachNhiem = luongTrachNhiem;
	}
	public double Luong() {
		return (this.LuongNV + this.luongTrachNhiem);
	}
	public double tinhThueThuNhap() {
		if ((this.getLuongNV > 5000000)*0.1);
		return ((getLuongNV() - 5000000) * 0.1);
	}


}
