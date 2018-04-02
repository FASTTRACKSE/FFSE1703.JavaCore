package fasttrack.edu.vn.mycar;
public class Sinhvien {
	public String SvName;
	public String SvDate;
	public Double SvDiemlp1;
	public Double SvDiemlp2;
	public Double SvDiemtb;
	//
	public void setSvName(String name) {
		this.SvName = name;
	}
	public String getSvName() {
		return this.SvName;
	}
	//
	public void setSvDate(String name) {
		this.SvDate = name;
	}
	public String getSvDate() {
		return this.SvDate;
	}
	//
	public void setSvDiemlp1(Double name) {
		this.SvDiemlp1 = name;
	}
	public Double getSvDiemlp1() {
		return this.SvDiemlp1;
	}
	//
	public void setSvDiemlp2(Double name) {
		this.SvDiemlp2 = name;
	}
	public Double getSvDiemlp2() {
		return this.SvDiemlp2;
	}
	//
	public Double getSvDiemtb() {
		return ((this.SvDiemlp1) + (this.SvDiemlp2))/2;
	}
	
}
