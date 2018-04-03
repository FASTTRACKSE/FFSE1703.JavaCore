package ffse1703.edu.vn.model;

public class HinhChuNhat extends HinhHoc{
	private int chieuDai;
	private int chieuRong;
	public HinhChuNhat() {
		
	}
	
	public HinhChuNhat(int chieuDai,int chieuRong) {
		this.chieuDai=chieuDai;
		this.chieuRong=chieuRong;
	}
	public int getChieuDai() {
		return chieuDai;
	}

	public void setChieuDai(int chieuDai) {
		this.chieuDai = chieuDai;
	}

	public int getChieuRong() {
		return chieuRong;
	}

	public void setChieuRong(int chieuRong) {
		this.chieuRong = chieuRong;
	}

	public double getChuVi() {		
		return (chieuDai + chieuRong)*2;
	}

	public double getDienTich() {
		return (chieuDai * chieuRong);
	}

}