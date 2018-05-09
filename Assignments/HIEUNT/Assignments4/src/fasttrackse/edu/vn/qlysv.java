package fasttrackse.edu.vn;
public class qlysv {
	public String hoten;
	public String day;
	public Double lp1;
	public Double lp2;
	public Double dtb;
	public int n;
	static  int tongSV = 0;

	public qlysv() {
	}

	static public void tinhTongSV() {
		tongSV++;
	}

	public String getHoten() {
		return hoten;
	}

	public static int getTongSV() {
		return tongSV;
	}

	public static void setTongSV(int tongSV) {
		qlysv.tongSV = tongSV;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
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

	public double dtb() {
		return ((this.lp1) + (this.lp2)) / 2;
	}


}
