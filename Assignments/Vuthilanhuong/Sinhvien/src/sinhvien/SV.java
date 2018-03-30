package sinhvien;

public class SV {
	 public String hoten;
	 public String ntnsinh;
	 public Double  lp1;
	 public Double  lp2;
	public SV() {
		
	}
	public SV(String hoten,String ntnsinh,Double lp1,Double lp2) {
		super();
		this.hoten= hoten;
		this.ntnsinh = ntnsinh;
		this.lp1 = lp1;
		this.lp2 = lp2;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getNtnsinh() {
		return ntnsinh;
	}
	public void setNtnsinh(String ntnsinh) {
		this.ntnsinh = ntnsinh;
	}
	public Double getLp1() {
		return lp1;
	}
	public void setLp1(Double lp1) {
		 this.lp1 = lp1;
	}
	public Double getLp2() {
		return lp2;
	}
	public void setLp2(Double lp2) {
		this.lp2 = lp2;
	}
	public Double getTb() {
		return (getLp1()+getLp2())/2;
	}

 
}
