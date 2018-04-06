package fastrack.edu.vn.practices;

public class SinhVien {
	public static long tongSinhVien;
	public String SvName;
	public String SvDate;
	public Double SvDiemlp1;
	public Double SvDiemlp2;
	public Double SvDiemtb;
	public String SvXeploai;
	
	public SinhVien() {
		//
	}
	
	public SinhVien(String ten, String ngaySinh, double diemLP1, double diemLP2) {
		super();
		this.SvName = ten;
		this.SvDate = ngaySinh;
		this.SvDiemlp1 = diemLP1; 
		this.SvDiemlp2 = diemLP2;
	}
	
	public void setSvName(String name) {
		this.SvName = name;
	}
	public String getSvName() {
		return this.SvName;
	}
	public void setSvDate(String name) {
		this.SvDate = name;
	}
	public String getSvDate() {
		return this.SvDate;
	}
	public void setSvDiemlp1(Double name) {
		this.SvDiemlp1 = name;
	}
	public Double getSvDiemlp1() {
		return this.SvDiemlp1;
	}
	public void setSvDiemlp2(Double name) {
		this.SvDiemlp2 = name;
	}
	public Double getSvDiemlp2() {
		return this.SvDiemlp2;
	}
	public Double getSvDiemtb() {
		return ((this.SvDiemlp1) + (this.SvDiemlp2))/2;
	}
	public String getSvXeploai() {
		if (getSvDiemtb()<=4.9) {
			return "Yếu";}
		else if (getSvDiemtb()>=5.0) {
			return "Trung bình";}
		else if (getSvDiemtb()>=7.0) {
			return "Khá";}
		else if (getSvDiemtb()>=8.8) {
			return "Giỏi";}
		return SvDate;
		
	}
}

