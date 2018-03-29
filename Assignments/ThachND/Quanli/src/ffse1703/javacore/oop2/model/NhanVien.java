package ffse1703.javacore.oop2.model;

import java.util.Scanner;

public class NhanVien {
    private String MasoNv, TenNv, NamsinhSv ;
    private double LuongNv;
    public NhanVien(String MasoNv, String TenNv, String NamsinhSv, double LuongNv) {
    	super();
        this.MasoNv = MasoNv;
        this.TenNv = TenNv;
        this.NamsinhSv =  NamsinhSv;
        this.LuongNv = LuongNv;
         
    }
	public String getMasoNv() {
		return MasoNv;
	}
	public void setMasoNv(String masoNv) {
		MasoNv = masoNv;
	}
	public String getTenNv() {
		return TenNv;
	}
	public void setTenNv(String tenNv) {
		TenNv = tenNv;
	}
	public String getNamsinhSv() {
		return NamsinhSv;
	}
	public void setNamsinhSv(String namsinhSv) {
		NamsinhSv = namsinhSv;
	}
	public double getLuongNv() {
		return LuongNv;
	}
	public void setLuongNv(double luongNv) {
		LuongNv = luongNv;
	}
     public double tinhLuong() {
    	 return this.LuongNv * 1000000;
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
       