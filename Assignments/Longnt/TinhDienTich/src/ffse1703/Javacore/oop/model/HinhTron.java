package ffse1703.Javacore.oop.model;

 public class HinhTron extends HinhHoc{
	double r;
	double pi=3.14;
   public HinhTron() {
	   
   }
   public HinhTron(double r) {
	   this.r =r;
   }
public double getR() {
	return r;
}
public void setR(double r) {
	this.r = r;
}
public double getChuVi() {
	return 2*pi*r;
}
public double getDienTich() {
	return pi*r*r;
}
}
