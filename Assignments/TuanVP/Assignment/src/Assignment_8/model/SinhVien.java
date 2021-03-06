package Assignment_8.model;

import java.io.Serializable;

public class SinhVien implements Serializable {
	public static int tongSV = 0;
	public static int getTongSV() {
		return tongSV;
	}
	public static void setTongSV(int tongSV) {
		SinhVien.tongSV = tongSV;
	}
	private String Hoten;
	private int tuoiSV;
	private float DiemLP1;
	private float DiemLP2;
	public float DiemTB;
	public String Xeploai;
	static private void themSV() {
		tongSV++;
	}
	public SinhVien() {
		// TODO Auto-generated constructor stub
		themSV();
	}
	public SinhVien(String Hoten,int tuoiSV,float DiemLP1,float DiemLP2,float DiemTB,String Xeploai) {
		themSV();
		this.Hoten= Hoten;
		this.tuoiSV= tuoiSV;
		this.DiemLP1 = DiemLP1;
		this.DiemLP2 = DiemLP2;
		this.DiemTB = DiemTB;
		this.Xeploai = Xeploai;
	}
	public void setHoten(String Hoten) {
		this.Hoten = Hoten;
	}
	public String getHoten() {
		return Hoten;
	}
	public void setTuoiSV(int tuoiSV) {
		this.tuoiSV = tuoiSV;
	}
	public int getTuoiSV() {
		return tuoiSV;
	}
	public void setDiemLP1(float DiemLP1) {
		this.DiemLP1 = DiemLP1;
	}
	public float getDiemLP1() {
		return DiemLP1;
	}
	public void setDiemLP2(float DiemLP2) {
		this.DiemLP2 = DiemLP2;
	}
	public float getDiemLP2() {
		return DiemLP2;
	}
	public float getDiemTB() {
		return this.DiemTB = (float)((getDiemLP1()+getDiemLP2())/2.0);
	}
	public String getXeploai() {
		if(getDiemTB()<=4.9) {
    		return this.Xeploai = "Kem";
    	} else if(getDiemTB()>=5.0 && getDiemTB()<=6.9) {
    		return this.Xeploai = "Trung Binh";
    	} else if(getDiemTB()>=7 && getDiemTB()<=8.4) {
    		return this.Xeploai = "Kha";
    	} else {
    		return this.Xeploai = "Gioi";
    	}
	}
	
}
