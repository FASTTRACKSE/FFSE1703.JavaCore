package javadestop.model;

public class SinhVien {

	private String Name;
	private String Date;
	private double Lp1;
	private double Lp2;

	public SinhVien(String name, String day, double Lp1, double Lp2) {
		this.Name = name;
		this.Date = day;
		this.Lp1 = Lp1;
		this.Lp2 = Lp2;
	}
	
	public SinhVien() {
		
	}


	public void setName(String name) {
		this.Name = name;
	}

	public String getName() {
		return this.Name;
	}

	public void setDate(String name) {
		this.Date = name;
	}

	public String getDate() {
		return this.Date;
	}

	public void setLp1(double Lp1) {
		this.Lp1 = Lp1;
	}

	public double getLp1() {
		return this.Lp1;
	}

	public void setLp2(double Lp2) {
		this.Lp2 = Lp2;
	}

	public double getLp2() {
		return this.Lp2;
	}

}
