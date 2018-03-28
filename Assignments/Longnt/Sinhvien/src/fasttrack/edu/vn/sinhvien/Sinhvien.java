package fasttrack.edu.vn.sinhvien;

import java.util.Scanner;

public class Sinhvien {
	public String ten;
	public int namsinh;
	public float diemLP1;
	public float diemLP2;
	public float diemTB;
	
	public String getten() {
		return ten;
	}
	public void setten(String ten) {
		this.ten = ten;
	}
	public int getnamsinh() {
		return namsinh;
	}
	public void setnamsinh(int namsinh) {
		this.namsinh = namsinh;
	}
	public float getdiemLP1() {
		return diemLP1;
	}
	public void setdiemLP1(float diemLP1) {
		this.diemLP1 = diemLP1;
	}
	public float getdiemLP2() {
		return diemLP2;
	}
	public void setdiemLP2(float diemLP2) {
		this.diemLP2 = diemLP2;
	}
	
	public float getdiemTB() {
		return ((getdiemLP1() + getdiemLP2())/2);
	}
	public String getXepLoai() {		 
    	if(getdiemTB()<=4.9) {
    		return "Yếu";}
    	else if(getdiemTB()>=5.0 && getdiemTB()<=6.9) {
    		return "Trung Bình";}
    	else if(getdiemTB()>=7 && getdiemTB()<=8.4) {
    		return "Khá";}
    	else {
    		return "Giỏi";
    	}}
	
	
	
}
