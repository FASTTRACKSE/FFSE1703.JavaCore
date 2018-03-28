package Exam.extend.model;

public class Quanly extends Nhanvien {	
	private Double luongTrachNhiem;
	public Quanly() {
		super();
	}
	public Quanly(int maSoNv,String tenNv,String ngaySinh,Double luong,Double luongTrachNhiem) {
		super(maSoNv,tenNv,ngaySinh,luong);
		this.luongTrachNhiem=luongTrachNhiem;
	}
	public Double getLuongTrachNhiem() {
		return luongTrachNhiem;
	}
	public void setLuongTrachNhiem(Double luongTrachNhiem) {
		this.luongTrachNhiem = luongTrachNhiem;
	}
	public Double getTongLuong() {
		return (super.getLuong()+getLuongTrachNhiem());
	}
	public Double getThue() {
		if(getTongLuong()>=5000000) {
			return (getTongLuong()-5000000)*0.1;
		}else {
			return 0.0;
		}
	}
}
