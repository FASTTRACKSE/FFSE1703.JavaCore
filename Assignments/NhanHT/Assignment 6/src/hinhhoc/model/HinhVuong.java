package hinhhoc.model;

public class HinhVuong extends HinhHoc {
	public double Canh;
	public HinhVuong() {
		
	}
	public HinhVuong(double Canh) {
		super();
		this.Canh = Canh;
	}
	public double getCanh() {
		return Canh;
	}
	public void setCanh(double canh) {
		Canh = canh;
	}
	public double getChuVi() {
		return this.Canh * 4;
	}
	public double getDienTich() {
		return this.Canh * this.Canh;
	}
	
}
