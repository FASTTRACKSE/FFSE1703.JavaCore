package Assignment_list;

public class Sinhvien {
	private String hoTen;
	private String ngaySinh;
	private float diemLp1;
	private float diemLp2;
	public Sinhvien() {
		
	}
	public Sinhvien(String hoten,String ngaySinh,float diemLp1,float diemLp2) {
		super();
		this.hoTen=hoten;
		this.ngaySinh=ngaySinh;
		this.diemLp1=diemLp1;
		this.diemLp2=diemLp2;		
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen=hoTen;
	}
	public String getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh=ngaySinh;
	}
	public float getDiemLp1() {
		return diemLp1;
	}
	public void setDiemLp1(float diemLp1) {
		this.diemLp1=diemLp1;		
	}
	public float getDiemLp2() {
		return diemLp2;
	}
	public void setDiemLp2(float diemLp2) {
		this.diemLp2=diemLp2;
	}
	public float getDiemTB() {
		return ((getDiemLp1() + getDiemLp2())/2);
	}
	public String getXepLoai() {		 
    	if(getDiemTB()<=4.9) {
    		return "Yếu";}
    	else if(getDiemTB()>=5.0 && getDiemTB()<=6.9) {
    		return "Trung Bình";}
    	else if(getDiemTB()>=7 && getDiemTB()<=8.4) {
    		return "Khá";}
    	else {
    		return "Giỏi";
    	}
    }	
}
