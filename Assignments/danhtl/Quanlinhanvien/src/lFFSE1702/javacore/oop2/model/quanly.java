package lFFSE1702.javacore.oop2.model;

public class quanly extends nhanvien  {
	public double luongtrachnhiem;
	
	public  quanly(String masonv, String tennv,String ngaysinh, double hsluong, double luongtrachnhiem) {
		super(masonv,tennv,ngaysinh,hsluong);
		this.luongtrachnhiem = luongtrachnhiem;
	}
	
		
	
	public double tinhluong() {
		return (this.luongtrachnhiem  )+(this.hsluong);
	}
	
	public double thuequanly() {
		return ((this.hsluong+(this.luongtrachnhiem) - 5000000)*0.1);
	}
	}

