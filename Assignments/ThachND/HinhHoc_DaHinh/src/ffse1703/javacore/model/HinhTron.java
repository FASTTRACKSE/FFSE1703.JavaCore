package ffse1703.javacore.model;

abstract public class HinhTron extends HinhHoc {
	private double r;
	public HinhTron(double r) {
		super();
		this.r = r;
    }
    public double getR() {
		return r;
	}
	public void setR(double r) {
		this.r = r;
	}
	
	
	public double getChuVi() {
        return this.r * 2 * 3.14 ;
	}
    public double getDienTich() {
        return (this.r * this.r)*3.14;
        }
    }	


