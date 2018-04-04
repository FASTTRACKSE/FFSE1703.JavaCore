package HinhHoc_model;

abstract public class HinhHoc {
	public double chuvi;
	public double dientich;
	public HinhHoc() {
		
	}
	public HinhHoc(double chuvi,double dientich) {
		this.chuvi=chuvi;
		this.dientich=dientich;
	}
	public void setChuvi (double chuvi) {
		this.chuvi=chuvi;
	}
	public double getChuvi() {
		return this.chuvi;
	}
	public void setDientich(double dientich) {
		this.dientich=dientich;
	}
	public double getDientich() {
		return this.dientich;
	}
}
