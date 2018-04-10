package ffse1703.Javacore.oop.model;

public class HinhVuong extends HinhHoc {
    double canh;
    public HinhVuong() {
    	
    }
    public HinhVuong(double canh) {
    	this.canh = canh;
    }
	public double getCanh() {
		return canh;
	}
	public void setCanh(double canh) {
		this.canh = canh;
	}
    public double getChuVi() {
    	return canh*4;
    }
    public double getDienTich() {
    	return canh*canh;
    }
}
