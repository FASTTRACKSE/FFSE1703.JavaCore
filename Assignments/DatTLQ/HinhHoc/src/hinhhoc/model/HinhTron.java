package hinhhoc.model;

public class HinhTron extends HinhHoc {
double R;
public HinhTron(double R) {
	super();
	this.R=R;
	
	
}
public double getR() {
	return R;
}
public void setR(double r) {
	R = r;
}
public double getChuVi() {
	return (this.R*(this.R)*3.14);
}
public double getDienTich() {
	return (3.14*R*R);
}
}
