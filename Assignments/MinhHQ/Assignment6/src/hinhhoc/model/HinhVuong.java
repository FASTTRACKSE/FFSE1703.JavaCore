package hinhhoc.model;

public class HinhVuong extends HinhHoc {

	public double canhHV;
	
	public HinhVuong(double a) {
		canhHV = a;
	}
	public HinhVuong() {
		
	}
	
	public double getCanhHV() {
		return canhHV;
	}

	public void setCanhHV(double canhHV) {
		this.canhHV = canhHV;
	}

	public double getChuVi() {
		return canhHV*4;
	}

	public double getDienTich() {
		return canhHV*canhHV;
	}

}
