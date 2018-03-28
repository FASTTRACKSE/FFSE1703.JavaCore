package Student;

public class myStudent {
	private String nameSv;
	private String Birthday;
	private Double lp1;
	private Double lp2;
	private Double Dtb;

	public void setName(String name) {
		this.nameSv = name;
	}
	public String getNameStudent() {
		return this.nameSv;
	}
	public void setBirthday(String birthday) {
		this.Birthday =birthday;
	}
	public String getBirthday() {
		return this.Birthday;
	}
	public void setLp1(Double lp1) {
		this.lp1 = lp1;
	}
	public Double getLp1() {
		return this.lp1;
	}
	public void setLp2(Double lp2) {
		this.lp2 =lp2; 
	}	
	public Double getLp2() {
		return this.lp2;
	}
	public Double getDtb() {
		return ((this.lp2)+(this.lp2))/2;
	}
	
}
