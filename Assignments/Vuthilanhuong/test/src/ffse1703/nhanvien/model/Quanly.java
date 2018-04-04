package ffse1703.nhanvien.model;

public class Quanly extends Nhanvien {
	private Double tracNhiem;
	public Quanly() {
		
	}
	public Quanly(String maSonv, String tenNv, String nSinh, Double luongNv, Double trachNhiem) {
		super(maSonv,tenNv,nSinh,luongNv);
		this.tracNhiem = trachNhiem;
	}
	public Double getTrachNhiem() {
		return tracNhiem;
	}
	public void setTrachNhiem(Double tracNhiem) {
		this.tracNhiem = tracNhiem;
	}
	public Double getTongLuong() {
		return super.getLuongNv()+getTrachNhiem();
	}
	public Double getThue() {
		if(getTongLuong()>=5000000) {
			return (getTongLuong()-5000000)*0.1;
		}
		else {
			return 0.0;
		}
	}
	public String toString() {
        return   maSonv + tenNv  + nSinh +  getLuongNv() +getThue();
    }
}
