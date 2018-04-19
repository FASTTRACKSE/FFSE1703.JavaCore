package sv.model;
import java.io.Serializable;
public class sinhvien implements Serializable {
	private String tenSV;
	private String ngaySinh;
	private float LP1;
	private float LP2;
	private float LP3;
	static int tongSV = 0;
	public int getTongsv() {
		return tongSV;
	}
	 static void setTongsv() {
		tongSV++;
	}
	 static void Tongsv() {
			tongSV--;
		}
	public sinhvien() {
		
	}
	public sinhvien(String tenSV,String ngaySinh,float LP1,float LP2,float LP3) {
		super();
		this.tenSV=tenSV;
		this.ngaySinh=ngaySinh;
		this.LP1= LP1;
		this.LP2= LP2;
		this.LP3= LP3;		
	}
	
	public float getDiemTB() {
		return ((getLp1() + getLp2() + getLP3())/3);
	}
	public String getTenSV() {
		return tenSV;
	}
	public void setTenSV(String nameSV) {
		this.tenSV = nameSV;
	}
	public String getNgaysinh() {
		return ngaySinh;
	}
	public void setNgaysinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public float getLp1() {
		return LP1;
	}
	public void setLp1(float lp1) {
		LP1 = lp1;
	}
	public float getLp2() {
		return LP2;
	}
	public void setLp2(float lp2) {
		LP2 = lp2;
	}
	public float getLP3() {
		return LP3;
	}
	public void setLp3(float lp3) {
		LP3 = lp3;
	}
	public static void setTongsv(int tongSV) {
		sinhvien.tongSV = tongSV;
	}
	public String getXepLoai() {		 
    	if(getDiemTB()<=4.9) {
    		return "Yeu";}
    	else if(getDiemTB()>=5.0 && getDiemTB()<=6.9) {
    		return "Trung Binh";}
    	else if(getDiemTB()>=7 && getDiemTB()<=8) {
    		return "Kha";}
    	else {
    		return "Gioi";
    	}
    }	
}