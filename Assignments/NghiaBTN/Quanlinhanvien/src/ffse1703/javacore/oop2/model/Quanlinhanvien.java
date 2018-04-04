package ffse1703.javacore.oop2.model;

public class Quanlinhanvien extends NhanVien{
		private double LuongTrachNhiem;

	public Quanlinhanvien(String MasoNV, String TenNV, String NamSinh, double Luong, double luongTrachNhiem) {
		super(MasoNV, TenNV, NamSinh, Luong);
		LuongTrachNhiem = luongTrachNhiem;
	}

	@Override
	public String toString() {
		return "Quanlinhanvien [LuongTrachNhiem=" + LuongTrachNhiem + "]";
	}

}
