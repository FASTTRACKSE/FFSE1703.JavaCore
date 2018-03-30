package ffse1703.oop2.model;

public class QuanLy extends NhanVien {
	public double LuongTrachNhiem;
	public QuanLy() {
		//
		super();
	}
	
	public QuanLy(String MasoNV,String TenNV, String NgaySinh,double Luong, double LuongTrachNhiem){
		super (MasoNV,TenNV,NgaySinh,Luong);
		this.LuongTrachNhiem = LuongTrachNhiem;
	}
	public double tinhluongTN() {
		return super.getLuong()+ this.LuongTrachNhiem;
	}
	public double tinhthuethunhap() {
		return (this.tinhluongTN()-5000000)*0.1;
	}
	
}
