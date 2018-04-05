package sinhvien;
import java.util.Scanner;
public class SinhVien {
	public String hoTen;
	public String ngaySinh;
	public double diemLp1, diemLp2;
	static int tongSo = 0;
	
	public SinhVien() {
		//
	}
	
	public SinhVien(String ten, String ngSinh, double diemLP1, double diemLP2) {
		this.hoTen = ten;
		this.ngaySinh = ngSinh;
		this.diemLp1 = diemLP1;
		this.diemLp2 = diemLP2;
	}

	public String getHoTen() {
		return this.hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	
	public String getNgaySinh() {
		return this.ngaySinh;
	}
	public void setNgaySinh( String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	
	public double getDiemLp1() {
		return this.diemLp1;
	}
	public void setDiemLp1(double diemLp1) {
		this.diemLp1 = diemLp1;
	}
	
	public void setDiemLp2(double diemLp2) {
		this.diemLp2 = diemLp2;
	}
	public double getDiemLp2() {
		return this.diemLp2;
	}
//	public void setDiemLp2(double diemLp2) {
//		this.diemLp2 = diemLp2;
//	}
	
	public double getDiemTB() {
		return (this.diemLp1 + this.diemLp2)/2;
	}
	

	
	public String getXepLoai() {
//    	if(getDiemTB()<=4.9) {
//    		return "Yếu";}
//    	else if(getDiemTB()>=5.0 && getDiemTB()<=6.9) {
//    		return "Trung Bình";}
//    	else if(getDiemTB()>=7 && getDiemTB()<=8.4) {
//    		return "Khá";}
//    	else {
//    		return "Giỏi";
//    	}	
		
		if(getDiemTB() >= 8.5) {
			return "Giỏi";
		} else if(getDiemTB() >= 7 && getDiemTB() < 8.5 ) {
			return "Khá";
		} else if(getDiemTB() >= 5 && getDiemTB() < 7) {
			return "Trung bình";
		} else{
			return "Yếu";
		}
	}
	
	public static void setTongSo() {
		tongSo++;
	}
}
