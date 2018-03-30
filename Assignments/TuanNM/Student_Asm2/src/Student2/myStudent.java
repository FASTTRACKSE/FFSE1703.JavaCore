package Student2;

public class myStudent {
	private String nameSv;
	private String Birthday;
	private String xepLoai;
	private Double lp1;
	private Double lp2;
	private Double Dtb;
	public myStudent() {
		
	}
	public myStudent(String name,String birthday,Double lp1,Double lp2) {
		this.nameSv= name;
		this.Birthday = birthday;
		this.lp1 = lp1;
		this.lp2 = lp2;
	}
	public void setName(String name) {
		this.nameSv = name;
	}

	public String getName() {
		return this.nameSv;
	}

	public void setBirthday(String birthday) {
		this.Birthday = birthday;
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
		this.lp2 = lp2;
	}

	public Double getLp2() {
		return this.lp2;
	}

	public Double getDtb() {
		return Dtb = (this.lp1 + this.lp2) / 2;
	}

	public String getXepLoai() {
		if (Dtb >= 8.5&&Dtb<=10) {
			return xepLoai = "Giỏi";
		} else if (Dtb >= 6.5 && Dtb < 8.5) {
			return xepLoai = "khá";
		} else if (Dtb < 6.5 && Dtb >= 5) {
			return xepLoai = "Trung BÌnh";
		} else if(Dtb < 5&&Dtb > 0){
			return xepLoai = "Yếu";
		}else {
			return xepLoai = "Quá xuất xắc";
		}
	}
}
