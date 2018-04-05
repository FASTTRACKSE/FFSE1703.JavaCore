package sinhvien.model;

public class SinhVien {
	public String SvName;
	public String SvDate;
	public double SvDiemlp1;
	public double SvDiemlp2;
	public static int tongso= 0;
	//
	public SinhVien() {
		
	}
	public SinhVien( String SvName,String SvDate,double SvDiemlp1,double SvDiemlp2) {
		this.SvName = SvName;
		this.SvDate = SvDate;
		this.SvDiemlp1 = SvDiemlp1;
		this.SvDiemlp2 = SvDiemlp2;
	}
	//
	public static int TongSo() {
		 return tongso++;
	}
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
}
