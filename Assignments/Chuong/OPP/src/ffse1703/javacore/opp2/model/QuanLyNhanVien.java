package ffse1703.javacore.opp2.model;

public class QuanLyNhanVien  {
	public int Maso;
	public String TenNV;
	public String Date;
	public double Luong;
	
	public QuanLyNhanVien(int Maso, String TenNV, String Date, double Luong) {
 		this.Maso=Maso;
 		this.TenNV=TenNV;
 		this.Date=Date;
 		this.Luong=Luong;		
 	}
 
 	public void setMaso(int Maso) {
 		this.Maso = Maso;
 	}
 	
 	public int getMaso() {
 		return this.Maso;
 	}
 	
 	public void setTenNV(String TenNV) {
 		this.TenNV = TenNV;
 	}
 	
 	public String getTenNV() {
 		return this.TenNV;
 	}
 	
 	public void setLuong(double Luong) {
 		this.Luong = Luong;
 	}
 	
 	public double getLuong() {
 		return this.Luong;
 	}
 	
 	public double getTinhThueThuNhap() {
 		return ((this.Luong - 5000000)*0.1);
 	}
	

}
