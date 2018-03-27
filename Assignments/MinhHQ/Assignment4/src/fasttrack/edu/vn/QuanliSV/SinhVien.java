package fasttrack.edu.vn.QuanliSV;

public class SinhVien {
	private  String Name;
	private  String Birthday;
	private  double Lp1;
	private  double Lp2;
	
	public SinhVien( ) {
		//
	}
	/*public void QLSV(String Name ,String Day , double Lp1 , double Lp2) {
		this.Name = Name;
		this.Birthday = Day;
		this.Lp1 = Lp1;
		this.Lp2 = Lp2;
	}*/

	public void setName(String name) {
		this.Name = name;
	}
	
	public String getName() {
		return this.Name;
	}
	
	public void setDay(String day) {
		this.Birthday = day;
	}
	
	public String getDay() {
		return this.Birthday;
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
	
	public double getDTB() {
		return ((this.Lp1 + this.Lp2)/2);
	}
	
	


}
