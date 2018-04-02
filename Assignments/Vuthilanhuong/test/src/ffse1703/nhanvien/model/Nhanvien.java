package ffse1703.nhanvien.model;

public class Nhanvien {
	public String maSonv;
	public String tenNv;
	public String nSinh;
	public Double luongNv;
	
	public Nhanvien() {
		
	}
	public Nhanvien(String maSonv, String tenNv, String nSinh, Double luongNv) {
		this.maSonv = maSonv;
		this.tenNv = tenNv;
		this.nSinh = nSinh;
		this.luongNv = luongNv;
	}
	public String getMaSonv() {
		return maSonv;
	}
	public void setMaSonv(String maSonv) {
		this.maSonv = maSonv;
	}
	public String getTenNv() {
		return tenNv;
	}
	public void setTenNv(String tenNv) {
		this.tenNv = tenNv;
	}
	public String getnSinh() {
		return nSinh;
	}
	public void setnSinh(String nSinh) {
		this.nSinh = nSinh;
	}
	public Double getLuongNv() {
		return luongNv;
	}
	public void setLuongNv(Double luongNv) {
		this.luongNv = luongNv;
	}
	public Double getThue() {
		if(getLuongNv()>=5000000) {
			return (getLuongNv()-5000000)*0.1;
		}
		else {
			return 0.0;
		}
	}
	public String toString() {
        return   maSonv+"\t" + tenNv +"\t" + nSinh+"\t" +  getLuongNv() +"\t"+getThue();
    }
}

