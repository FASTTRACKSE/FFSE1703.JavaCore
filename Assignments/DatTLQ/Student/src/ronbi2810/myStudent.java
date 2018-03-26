package ronbi2810;

public class myStudent {
	public  String stuName;
	public  String stuDate;
	public double DLP1;
	public  double DLP2;
	
	
	
	
	public void setStuName(String name) {
		this.stuName = name;
	}
	public String getStuName() {
		return this.stuName;
	}
	public void setStuDate(String name) {
		this.stuDate = name;
	}
	public String getStuDate() {
		return this.stuDate;
	}
	public void setDLP1(double diem1) {
		this.DLP1 = diem1;
	}
	public double getDLP1() {
		return this.DLP1;
	}
	public void setDLP2(double diem2) {
		this.DLP2 = diem2;
	}
	public double getDLP2() {
		return this.DLP2;
	}
	public double DTB() {
		return ((this.DLP1)+(this.DLP2))/2;
	}
}
