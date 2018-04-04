package HinhHoc_model;

public class HinhTamGiac extends HinhHoc{
	public double canhA;
	public double canhB;
	public double canhC;
	public HinhTamGiac() {
		super();
	}
	public HinhTamGiac(double chuvi,double dientich,double canhA,double canhB,double canhC) {
		super();
		this.canhA=canhA;
		this.canhB=canhB;
		this.canhC=canhC;
	}
	public void setCanhA(double canhA) {
		this.canhA=canhA;
	}
	public double getCanhA() {
		return this.canhA;
	}
	public void setCanhB(double canhB) {
		this.canhB=canhB;
	}
	public double getCanhB() {
		return this.canhB;
	}
	public void setCanhC(double canhC) {
		this.canhC=canhC;
	}
	public double getCanhC() {
		return this.canhC;
	}
	public void tinhChuviHTG(double canhA,double canhB,double canhC) {
		chuvi=canhA+canhB+canhC;
	}
	public void tinhDientichHTG(double canhA,double canhB,double canhC) {
		dientich=Math.sqrt((chuvi/2)*(chuvi/2-canhA)*(chuvi/2-canhB)*chuvi/2-canhC);
	}
	public double getChuviHTG() {
		return this.chuvi;
	}
	public double getDientichHTG() {
		return this.dientich;
	}
}
