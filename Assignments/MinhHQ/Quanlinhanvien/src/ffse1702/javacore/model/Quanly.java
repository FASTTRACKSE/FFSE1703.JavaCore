package ffse1702.javacore.model;

public class Quanly extends NhanVien{
	public double LuongTrachNhiem;
	public Quanly(String MasoNV, String TenNV,String NS, double Luong, double LuongTrachNhiem) {
		super(MasoNV,TenNV,NS,Luong);
		this.LuongTrachNhiem = LuongTrachNhiem*1000000;
	}
	
	public String getMS() {
		return this.MasoNV;
	}
	
	public String getTen() {
		return this.TenNV;
	}
	
	public String getNS() {
		return this.NS;
	}
	
	public double getLuong() {
		return (this.Luong  + this.LuongTrachNhiem);
	}
	
	public double tinhThueThuNhap() {
		if (this.getLuong() >5000000) {
			return((getLuong() - 5000000)*0.1);
			}
			return 0;
	}

}
