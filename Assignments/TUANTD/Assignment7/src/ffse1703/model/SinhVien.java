package ffse1703.model;
import java.io.Serializable;
public class SinhVien implements Serializable {
	private String nameSV;
	private String ngaySinh;
	private float Lp1;
	private float Lp2;
	private float Lp3;
	static int tongsv = 0;
	public int getTongsv() {
		return tongsv;
	}
	 static void setTongsv() {
		tongsv++;
	}
	 static void Tongsv() {
			tongsv--;
		}
	public SinhVien() {
		
	}
	public SinhVien(String nameSV,String ngaySinh,float Lp1,float Lp2,float Lp3) {
		super();
		this.nameSV=nameSV;
		this.ngaySinh=ngaySinh;
		this.Lp1= Lp1;
		this.Lp2= Lp2;
		this.Lp3= Lp3;		
	}
	
	public float getDiemTB() {
		return ((getLp1() + getLp2() + getLp3())/3);
	}
	public String getNameSV() {
		return nameSV;
	}
	public void setNameSV(String nameSV) {
		this.nameSV = nameSV;
	}
	public String getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public float getLp1() {
		return Lp1;
	}
	public void setLp1(float lp1) {
		Lp1 = lp1;
	}
	public float getLp2() {
		return Lp2;
	}
	public void setLp2(float lp2) {
		Lp2 = lp2;
	}
	public float getLp3() {
		return Lp3;
	}
	public void setLp3(float lp3) {
		Lp3 = lp3;
	}
	public static void setTongsv(int tongsv) {
		SinhVien.tongsv = tongsv;
	}
	public String getXepLoai() {		 
    	if(getDiemTB()<=4.9) {
    		return "Yếu";}
    	else if(getDiemTB()>=5.0 && getDiemTB()<=6.9) {
    		return "Trung Bình";}
    	else if(getDiemTB()>=7 && getDiemTB()<=8) {
    		return "Khá";}
    	else {
    		return "Giỏi";
    	}
    }	
}
