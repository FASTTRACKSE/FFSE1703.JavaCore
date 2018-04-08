package ffse1702010.edu.vn.model;

public class SinhVien {
	private  String ten;
	private  String ngaySinh;
	private  int lp1;
	private  int lp2;
	public double dtb;	
	public static int tongSV = 0;

	public SinhVien() {

	}
	public SinhVien(String name, String day, int Lp1, int Lp2) {
		this.ten=name;
		this.ngaySinh=day;
		this.lp1=Lp1;
		this.lp2=Lp2;
	}
	

	static public void tongSV() {
		tongSV++;
	}

	public static int getTongSV() {
		return tongSV;
	}

	public static void setTongSV(int tongSV) {
		SinhVien.tongSV = tongSV;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public int getLp1() {
		return lp1;
	}

	public void setLp1(int lp1) {
		this.lp1 = lp1;
	}

	public int getLp2() {
		return lp2;
	}

	public void setLp2(int lp2) {
		this.lp2 = lp2;
	}

	public double dtb() {
		return ((this.lp1) + (this.lp2)) / 2;
	}

}
