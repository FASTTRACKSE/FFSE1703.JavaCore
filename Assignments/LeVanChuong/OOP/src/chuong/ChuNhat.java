package chuong;

public class ChuNhat {
	private int rong;
	private int dai;
	public ChuNhat() {
		
	}
	public ChuNhat(int dai, int rong) {
		this.dai = dai;
		this.rong = rong;
	}
	public int getRong() {
		return rong;
	}
	public void setRong(int rong) {
		this.rong = rong;
	}
	public int getDai() {
		return dai;
	}
	public void setDai(int dai) {
		this.dai = dai;
	}
	double getChuvi() {
		return 2*(rong+dai);
	}
	double getDienTich() {
		return rong*dai;
	}
	
	void xuat() {
		System.out.println("Chieu dai: " +this.dai);
		System.out.println("Chieu rong: " +this.rong);
		System.out.println("Chu vi: " +this.getChuvi());
		System.out.println("Dien tich: " +this.getDienTich());
	}

}